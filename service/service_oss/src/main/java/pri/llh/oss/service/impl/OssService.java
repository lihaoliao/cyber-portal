package pri.llh.oss.service.impl;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.oss.service.impl
 * @since 1.0
 */
public interface OssService {
    /**
     * upload file for avatar
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
