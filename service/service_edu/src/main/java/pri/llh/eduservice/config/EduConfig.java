package pri.llh.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.eduservice.config
 * @since 1.0
 */
@Configuration
@MapperScan("pri.llh.eduservice.mapper")
public class EduConfig {
}
