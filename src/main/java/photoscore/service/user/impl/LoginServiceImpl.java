package photoscore.service.user.impl;

import photoscore.common.utils.WebUtil;
import photoscore.model.user.User;
import photoscore.service.user.LoginService;

import javax.servlet.http.HttpSession;

/**
 * Created by lanegg on 16-4-12.
 */
public class LoginServiceImpl implements LoginService {


    /**
     *  保存登陆状态
     * @return
     */
    public boolean loginToSession(User user) {

        try {
            HttpSession session = WebUtil.getSession();
            session.setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    /**
     * 退出登陆
     * @return
     */
    public boolean logout() {

        try {
            HttpSession session = WebUtil.getSession();
            session.removeAttribute("user");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 获取当前登陆用户
     * @return
     */
    public User getCurrentLoginUser() {

        try {

            HttpSession session = WebUtil.getSession();
            User user = (User) session.getAttribute("user");

            return user;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
