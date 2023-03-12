package pri.llh.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.multipart.MultipartFile;
import pri.llh.eduservice.entity.EduLevel;
import pri.llh.eduservice.entity.excel.LevelData;
import pri.llh.eduservice.listener.LevelExcelListener;
import pri.llh.eduservice.mapper.EduLevelMapper;
import pri.llh.eduservice.service.EduLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * <p>
 * course level 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2023-03-12
 */
@Service
public class EduLevelServiceImpl extends ServiceImpl<EduLevelMapper, EduLevel> implements EduLevelService {

    @Override
    public void saveLevel(MultipartFile file, EduLevelService levelService) {
        try {
            InputStream is = file.getInputStream();
            EasyExcel.read(is, LevelData.class,new LevelExcelListener(levelService)).sheet().doRead();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
