package pri.llh.eduservice.service.impl;

import com.baomidou.mybatisplus.core.toolkit.sql.SqlHelper;
import pri.llh.eduservice.entity.EduTeacher;
import pri.llh.eduservice.mapper.EduTeacherMapper;
import pri.llh.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * Educator Interface Impl Class
 * </p>
 *
 * @author testjava
 * @since 2023-02-23
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    /**
     * Because The original method is considered successful
     * Overriding it makes deleting non-existent data a failure
     * @param id
     * @return
     */
    @Override
    public boolean removeById(Serializable id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }
}
