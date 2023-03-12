package pri.llh.eduservice.service;

import org.springframework.web.multipart.MultipartFile;
import pri.llh.eduservice.entity.EduLevel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * course level 服务类
 * </p>
 *
 * @author testjava
 * @since 2023-03-12
 */
public interface EduLevelService extends IService<EduLevel> {

    void saveLevel(MultipartFile file, EduLevelService levelService);
}
