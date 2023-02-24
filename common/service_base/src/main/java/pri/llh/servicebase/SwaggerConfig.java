package pri.llh.servicebase;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.servicebase.config
 * @since 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("portalApi")
                .apiInfo(portalApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();

    }

    private ApiInfo portalApiInfo(){

        return new ApiInfoBuilder()
                .title("Portal-Course Central API Doc")
                .description("This document describes the Course Center microservices interface definition")
                .version("1.0")
                .contact(new Contact("Lihao Liao", "http://localhost:8080/swagger-ui.html", "liaol1@cardiff.ac.uk"))
                .build();
    }
}
