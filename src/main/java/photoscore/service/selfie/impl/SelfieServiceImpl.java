package photoscore.service.selfie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import photoscore.common.constants.Constants;
import photoscore.common.utils.DateUtils;
import photoscore.common.utils.ReturnType;
import photoscore.common.utils.StringUtils;
import photoscore.dao.mapper.selfie.SelfieMapper;
import photoscore.model.selfie.Selfie;
import photoscore.service.selfie.SelfieService;

import java.io.File;
import java.io.IOException;

/**
 * Created by lanegg on 16/4/10.
 */
@Service(value = "selfieService")
public class SelfieServiceImpl implements SelfieService {

    @Autowired
    private SelfieMapper selfieMapper;


    /**
     * 保存上传的selfie图片
     * @return
     */
    public ReturnType saveSelfieFile(MultipartFile file) {

        ReturnType returnType = new ReturnType();

        try {

            //按月份分图片path
            String datePath = DateUtils.getCurrentDate("yyyyMM");
            //保存路径  如果不存在则创建
            String savePath = Constants.IMAGE_REPO_PATH + "/selfie/" + datePath;
            File savePathFile = new File(savePath);
            if (false == savePathFile.exists()) {
                savePathFile.mkdir();
            }

            //文件名 时间+随机数
            String nameArr[] = file.getOriginalFilename().split("\\.");
            String saveFileType = nameArr[nameArr.length - 1];
            String saveFileName = DateUtils.getCurrentDate("yyyyMMddHHmmss") + StringUtils.getRandomString(6) + "." + saveFileType;

            //保存图片
            File selfieRepo = new File(savePath + "/" + saveFileName);
            FileCopyUtils.copy(file.getBytes(), selfieRepo);

            returnType.setResult(true);
            returnType.setData("/selfie/" + datePath + "/" + saveFileName);

        } catch (IOException e) {
            e.printStackTrace();
            returnType.setResult(false);
        } catch (Exception e) {
            e.printStackTrace();
            returnType.setResult(false);
        }

        return returnType;
    }

    /**
     * 保存selfie到db
     * @param photoPath
     * @return
     */
    public boolean saveSelfie(String photoPath) {

        try {

            Selfie selfie = new Selfie();
            //照片路径
            selfie.setPhotoPath(photoPath);
            //状态为 照片上传
            selfie.setStatus(Selfie.STATUS_UPLOAD);
            //未删除
            selfie.setIsDelete(0);
            //设置创建时间
            String currentTime = DateUtils.getCurrentDateTime();
            selfie.setCreateTime(currentTime);
            selfie.setUpdateTime(currentTime);
            //设置创建人 @TODO 需要修改为登陆用户
            selfie.setCreator(0);

            selfieMapper.saveSelfie(selfie);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 获取用户最后一次上传
     * @param creator
     * @return
     */
    public Selfie loadLastUpload(final int creator) {

        try {
            Selfie selfie = this.selfieMapper.loadLastUpload(creator);
            return selfie;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * load by Id
     * @return
     */
    public Selfie loadById(final long id) {

        try {
            Selfie selfie = this.selfieMapper.loadById(id);
            return selfie;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 发布照片
     * @param id
     * @param photoDescribe
     * @return
     */
    public boolean publishSelfie(long id, String photoDescribe) {

        try {

            Selfie selfie = this.loadById(id);

            //获取当前登陆用户 @TODO
            int currentUserId = 0;
            //是用户自己的照片 并且状态是上传
            if (null != selfie && currentUserId == selfie.getCreator() && Selfie.STATUS_UPLOAD.equals(selfie.getStatus())) {

                String currentTime = DateUtils.getCurrentDateTime();
                this.selfieMapper.publish(id, photoDescribe, Selfie.STATUS_ONLINE, currentTime);

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
