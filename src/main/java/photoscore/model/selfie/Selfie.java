package photoscore.model.selfie;

import java.io.Serializable;

/**
 * Created by lanegg on 16/4/10.
 */
public class Selfie implements Serializable {

    public final static String STATUS_UPLOAD = "upload";
    public final static String STATUS_ONLINE = "online";
    public final static String STATUS_OFFLINE = "offline";

    //id
    private long id;
    //照片存储路径
    private String photoPath;
    //照片描述
    private String photoDescribe;
    //状态
    private String status;
    //创建人
    private int creator;
    private int isDelete;
    private String createTime;
    private String updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoDescribe() {
        return photoDescribe;
    }

    public void setPhotoDescribe(String photoDescribe) {
        this.photoDescribe = photoDescribe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
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
