package photoscore.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photoscore.dao.mapper.user.UserMapper;
import photoscore.model.user.User;
import photoscore.service.user.UserService;

/**
 * Created by lanegg on 16-4-12.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public boolean saveUser(User user) {

        try {

            this.userMapper.saveUser(user);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 检查用户名是否可用
     *
     * 返回值对应码:
     * 0:成功
     * 1:用户名为空或长度受限 或不合规则
     * 2.用户名重复
     * @return
     *
     */
    public int checkUserName(final String userName) {

        //1.判断用户是否合法
        if (null == userName || userName.length() < 4) {
            return 1;
        }

        //2.判断用户名是否已存在@TODO

        return 0;
    }

    /**
     * 生成用户名
     *
     * 根据入参用户名 检测用户名是否可用
     * 不可用则生成一个建议用户名
     *
     * @param userName
     * @return
     */
    public String buildUserName(String userName) {

        int result = this.checkUserName(userName);

        //用户名check成功 直接返回
        if (0 == result) {
            return userName;
        } else if (1 == result) {
            //用户名不合法，没有建议值，直接回返
            return null;
        } else if (2 == result) {
            //用户名重复，添加数字方式
            userName = userName + "1";
            //递归生成
            return this.buildUserName(userName);
        } else {
            return null;
        }


    }







}
