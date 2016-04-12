package photoscore.service.user;

import photoscore.model.user.User;

/**
 * Created by lanegg on 16-4-12.
 */
public interface UserService {

    /**
     * 检查用户名是否可用
     *
     * 返回值对应码:
     * 0:成功
     * 1:用户名为空或长度受限 或不合规则
     * 2.
     * @return
     *
     */
    public int checkUserName(final String userName);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public boolean saveUser(User user);

    /**
     * 生成用户名
     *
     * 根据入参用户名 检测用户名是否可用
     * 不可用则生成一个建议用户名
     *
     * @param userName
     * @return
     */
    public String buildUserName(String userName);

}
