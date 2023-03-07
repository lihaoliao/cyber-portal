package pri.llh.oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pri.llh.oss.service.impl.OssService;
import pri.llh.utils.Result;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.oss.controller
 * @since 1.0
 */
@RestController
@RequestMapping("/eduservice/oss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    /**
     * upload the file
     * @param file
     * @return
     */
    @PostMapping
    public Result uploadOssFile(MultipartFile file){
        String url = ossService.uploadFileAvatar(file);
        return Result.success().setData("url",url);
    }
}
