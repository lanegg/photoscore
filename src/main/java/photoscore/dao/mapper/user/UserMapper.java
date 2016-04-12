package photoscore.dao.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import photoscore.model.user.User;

/**
 * Created by lanegg on 16-4-12.
 */
@Repository(value = "userMapper")
public interface UserMapper {

    /*
    //id
    private int id;
    //用户名
    private String userName;
    //头像地址
    private String profileImageUrl;
    //性别
    private String gender;
    //密码
    private String password;
    //状态
    private String status;
    //新浪微博 oauth2 access tocken
    private String weiboAccessTocken;
    //新浪微博 oauth2 open id
    private String weiboOpenId;
    //qq oauth2 access tocken
    private String qqAccessTocken;
    //qq oauth2 open id
    private String qqOpenId;
    //是否删除
    private int isDelete;
    //创建时间
    private String createTime;
    //更新时间
    private String updateTime;
     */

    @Insert("insert into user(id, userName, profileImageUrl, gender, password, status, weiboAccessTocken, weiboOpenId)")
    public int saveUser(@Param("user") User user);

}
