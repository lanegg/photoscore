package photoscore.service.user;

import photoscore.model.user.User;

/**
 * Created by lanegg on 16-4-12.
 */
public interface LoginService {

    /**
     *  保存登陆状态
     * @return
     */
    public boolean loginToSession(User user);

    /**
     * 退出登陆
     * @return
     */
    public boolean logout();

    /**
     * 获取当前登陆用户
     * @return
     */
    public User getCurrentLoginUser();

}
