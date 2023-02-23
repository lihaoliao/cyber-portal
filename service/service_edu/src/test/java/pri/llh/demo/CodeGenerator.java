package pri.llh.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;


public class CodeGenerator {

    @Test
    public void run() {

        // 1、Create code generator object
        AutoGenerator mpg = new AutoGenerator();

        // 2、configuration
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("F:\\IDEA\\portal_parent\\service\\service_edu" + "/src/main/java");
        gc.setAuthor("testjava");
        gc.setOpen(false); //Whether to open Explorer after the build
        gc.setFileOverride(false); //Whether the file is overwritten on rebuild
        gc.setServiceName("%sService");	//Remove the initial I from the Service interface
        gc.setIdType(IdType.ID_WORKER_STR); //Primary key policy
        gc.setDateType(DateType.ONLY_DATE);//Defines the date type in the generated entity class
        gc.setSwagger2(true);//Turn on Swagger2 mode

        mpg.setGlobalConfig(gc);

        // 3、data source configuration
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/portal?serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、package configuration
        PackageConfig pc = new PackageConfig();

        // pri.llh.eduservice
        pc.setParent("pri.llh"); //package name
        pc.setModuleName("eduservice"); //module name


        //package pri.llh.eduservice.xxxx
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、Policy configuration
        StrategyConfig strategy = new StrategyConfig();

        strategy.setInclude("edu_teacher");

        strategy.setNaming(NamingStrategy.underline_to_camel);// camel
        strategy.setTablePrefix(pc.getModuleName() + "_"); //Remove the table prefix when generating the entity

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//camel
        strategy.setEntityLombokModel(true); // lombok model @Accessors(chain = true)

        strategy.setRestControllerStyle(true); //restful api
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);


        // 6、execute
        mpg.execute();
    }
}
