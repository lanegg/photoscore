package photoscore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import photoscore.common.utils.DateUtils;
import photoscore.model.user.User;
import photoscore.sdk.weibo4j.model.WeiboException;
import photoscore.service.user.LoginService;
import photoscore.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lanegg on 16/4/11.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;


    /**
     * 通过新浪微博登陆验证
     * @return
     */
    @RequestMapping(value = "/login/loginToWeibo")
    public String loginToWeibo(HttpServletRequest request, HttpSession session) {

        try {

            session.setAttribute("current_url", request.getHeader("refer"));

            photoscore.sdk.weibo4j.Oauth oauth = new photoscore.sdk.weibo4j.Oauth();
            String url = oauth.authorize("code");

            return "redirect:" + url;

        } catch (WeiboException e) {
            e.printStackTrace();
            return "redirect:/home";
        }

    }


    /**
     * 新浪微博登陆验证回调
     * @param code
     * @param session
     * @return
     */
    @RequestMapping(value = "/login/loginFromWeibo")
    public String loginFromWeibo(@RequestParam("code") String code, HttpSession session) {

        String current_url = session.getAttribute("current_url") + "";

        try {

            photoscore.sdk.weibo4j.Oauth oauth = new photoscore.sdk.weibo4j.Oauth();
            photoscore.sdk.weibo4j.http.AccessToken accessToken = oauth.getAccessTokenByCode(code);

            String accessTokenValue = accessToken.getAccessToken();
            String openIdValue = accessToken.getUid();

            //根据openId获取用户
            User sourceUser = null;
            //如果用户已有帐号
            if (null != sourceUser) {

                //登陆

                //返回之前的浏览地址
                return "redirect:" + current_url;
            } else {    //如果用户没有帐号

                //获取微博用户信息
                photoscore.sdk.weibo4j.Users weiboUsers = new photoscore.sdk.weibo4j.Users(accessTokenValue);
                photoscore.sdk.weibo4j.model.User weiboUser = weiboUsers.showUserById(openIdValue);

                if (null == weiboUser) {
                    return "redirect:" + current_url;
                }

                /*
                    创建用户
                 */
                User user = new User();

                //用户名
                String userName = userService.buildUserName(weiboUser.getScreenName());
                if (null == userName) {
                    userName = userService.buildUserName(weiboUser.getUserDomain());
                }
                user.setUserName(userName);
                //用户性别
                String gender = weiboUser.getGender();
                user.setGender(gender);
                //用户头像地址
                String profileImageUrl = weiboUser.getProfileImageUrl();
                user.setProfileImageUrl(profileImageUrl);
                //accessToken
                user.setWeiboAccessTocken(accessTokenValue);
                user.setWeiboOpenId(openIdValue);

                user.setStatus(User.STATUS_CREATE);
                user.setIsDelete(0);
                String currentTime = DateUtils.getCurrentDateTime();
                user.setCreateTime(currentTime);
                user.setUpdateTime(currentTime);

                //save to db
                boolean result = this.userService.saveUser(user);

                /*
                       登陆
                */
                if (true == result) {

                    //用户信息保存到session
                    loginService.loginToSession(user);
                    //跳转到用户名设置页面 @TODO
                    return "redirect:/set/";

                }




            }

        } catch (WeiboException e) {
            e.printStackTrace();
        }


        return current_url;

    }





}
