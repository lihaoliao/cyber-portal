package pri.llh.eduservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.eduservice
 * @since 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"pri.llh"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
