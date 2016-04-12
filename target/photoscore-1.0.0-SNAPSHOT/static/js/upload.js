/**
 * Created by lanegg on 16/4/10.
 */


function uploadPhoto(photo) {

    //判断文件是否存在
    if (null == photo || '' == photo || photo.files == null || photo.files.length < 1) {
        return;
    }

    var allowExt = ".jpg .bmp,.png";
    var maxSize = 1024 * 1024 * 5;

    console.info(photo.files);
    console.info(photo.value);
    console.info(photo.files[0].size);

    var file = photo.files[0];

    //文件类型过滤
    var fileType = file.name.substr(file.name.lastIndexOf(".")).toLowerCase();
    if(allowExt != 0 && allowExt.indexOf(fileType) == -1){
        $("#errorInfo").text("请上传 "+allowExt+" 类型的图片，当前图片类型为"+fileType);
        $("#errorInfo").show();
        return;
    }

    //文件大小过滤
    if (file.size > maxSize) {
        $("#errorInfo").text("文件过大~  请上传小于5M的照片");
        $("#errorInfo").show();
        return;
    }

    //上传
    $("#photoUploadForm").submit();

}
