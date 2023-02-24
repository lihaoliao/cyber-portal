package pri.llh.eduservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pri.llh.eduservice.entity.EduTeacher;
import pri.llh.eduservice.service.EduTeacherService;
import pri.llh.utils.Result;

import java.util.List;

/**
 * <p>
 * Educator controller
 * access:http://http://localhost:8080/eduservice/teacher/"Method Mapping path"
 * </p>
 *
 * @author testjava
 * @since 2023-02-23
 */
@Api(tags = "edu_teacher database management operation")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {



    @Autowired
    private EduTeacherService teacherService;

    /**
     * select all teacher data
     * @return
     */
    @ApiOperation("find all teacher and return a list")
    @GetMapping("/findAllTeacher")
    public Result findAllTeacher(){
        //invoke service object method
        List<EduTeacher> teacherList = teacherService.list(null);
        return Result.success().setData("items",teacherList);
    }

    @ApiOperation("logic delete teacher by id")
    @DeleteMapping("/removeTeacher/{id}")
    public Result removeTeacher(@ApiParam(name = "id",value = "teacher id",required = true) @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        return flag ? Result.success() : Result.error();
    }


}

