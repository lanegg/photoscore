package photoscore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import photoscore.common.constants.Constants;
import photoscore.common.utils.ReturnType;
import photoscore.model.selfie.Selfie;
import photoscore.service.selfie.SelfieService;

/**
 * Created by lanegg on 16/4/10.
 */
@Controller
public class SelfieController {

    @Autowired
    private SelfieService selfieService;

    /**
     * 跳转到上传界面
     * @return
     */
    @RequestMapping(value = "/selfie/toUpload")
    public String toUploadSelfie(Model model) {

        model.addAttribute("nav_value", "nav_upload");

        return "/selfie/upload";


    }

    /**
     * 上传selfie 照片原图
     * @param selfie
     * @param model
     * @return
     */
    @RequestMapping(value = "/selfie/upload", method = RequestMethod.POST, headers = "Accept=text/plain")
    public String uploadSelfie(MultipartFile selfie, Model model) {

        try {

            //保存上传的照片
            ReturnType returnType = selfieService.saveSelfieFile(selfie);

            //上传成功 ==> 保存selfile
            if (true == returnType.getResult()) {

                String photoPath = returnType.getData() + "";
                this.selfieService.saveSelfie(photoPath);

                return "redirect:/selfie/toPublish";
            } else {

                //上传失败则返回上传界面
                model.addAttribute("errorInfo", "Sorry, 照片上传失败~~");

                model.addAttribute("nav_value", "nav_upload");

                return "/selfie/upload";

            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorInfo", "Sorry, 照片上传失败~~");
            model.addAttribute("nav_value", "nav_upload");
            return "/selfie/upload";
        }

    }

    @RequestMapping(value = "/selfie/toPublish")
    public String toPublishSelfie(Model model) {

        //获取当前登陆用户 @TODO
        int currentUserId = 0;
        Selfie selfie = this.selfieService.loadLastUpload(currentUserId);
        if (null != selfie) {
            model.addAttribute("selfie", selfie);
            model.addAttribute("IMAGE_SERVER", Constants.IMAGE_SERVER);
            model.addAttribute("nav_value", "nav_upload");
            return "/selfie/publish";
        } else {
            return "redirect:/selfie/toUpload";
        }

    }

    @RequestMapping(value = "/selfie/publish/{selfieId}")
    public String publishSelfie(@PathVariable("selfieId") long selfieId, String photoDescribe) {

        boolean result = this.selfieService.publishSelfie(selfieId, photoDescribe);
        if (true == result) {
            return "redirect:/selfie/view/" + selfieId;
        } else {
            return "redirect:/selfie/toPublish";
        }

    }

}
