package photoscore.service.selfie;

import org.springframework.web.multipart.MultipartFile;
import photoscore.common.utils.ReturnType;
import photoscore.model.selfie.Selfie;

/**
 * Created by lanegg on 16/4/10.
 */
public interface SelfieService {

    /**
     * 保存上传的selfie图片
     * @return
     */
    public ReturnType saveSelfieFile(MultipartFile file);

    /**
     * 保存selfie到db
     * @param photoPath
     * @return
     */
    public boolean saveSelfie(String photoPath);

    /**
     * 获取用户最后一次上传
     * @param creator
     * @return
     */
    public Selfie loadLastUpload(final int creator);

    /**
     * load by Id
     * @return
     */
    public Selfie loadById(final long id);

    /**
     * 发布照片
     * @param id
     * @param photoDescribe
     * @return
     */
    public boolean publishSelfie(long id, String photoDescribe);

}
