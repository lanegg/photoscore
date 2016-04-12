package photoscore.model.user;

import java.io.Serializable;

/**
 * Created by lanegg on 16/4/11.
 */
public class User implements Serializable {

    public static final String STATUS_LOCK = "lock";
    public static final String STATUS_NORMAL = "normal";
    public static final String STATUS_CREATE = "create";

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWeiboAccessTocken() {
        return weiboAccessTocken;
    }

    public void setWeiboAccessTocken(String weiboAccessTocken) {
        this.weiboAccessTocken = weiboAccessTocken;
    }

    public String getWeiboOpenId() {
        return weiboOpenId;
    }

    public void setWeiboOpenId(String weiboOpenId) {
        this.weiboOpenId = weiboOpenId;
    }

    public String getQqAccessTocken() {
        return qqAccessTocken;
    }

    public void setQqAccessTocken(String qqAccessTocken) {
        this.qqAccessTocken = qqAccessTocken;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
