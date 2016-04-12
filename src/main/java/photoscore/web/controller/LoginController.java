package photoscore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import photoscore.sdk.weibo4j.Oauth;
import photoscore.sdk.weibo4j.model.WeiboException;
import photoscore.sdk.weibo4j.util.BareBonesBrowserLaunch;

/**
 * Created by lanegg on 16/4/11.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login/loginToWeibo")
    public String loginToWeibo() {

        try {

            Oauth oauth = new Oauth();
            String url = oauth.authorize("code");

            return "redirect:" + url;

        } catch (WeiboException e) {
            e.printStackTrace();
            return "redirect:/home";
        }

    }

   


}
