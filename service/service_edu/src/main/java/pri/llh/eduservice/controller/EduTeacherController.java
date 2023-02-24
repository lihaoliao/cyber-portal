package pri.llh.eduservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pri.llh.eduservice.entity.EduTeacher;
import pri.llh.eduservice.service.EduTeacherService;

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
    public List<EduTeacher> findAllTeacher(){
        //invoke service object method
        List<EduTeacher> teacherList = teacherService.list(null);
        return teacherList;
    }

    @ApiOperation("logic delete teacher by id")
    @DeleteMapping("/removeTeacher/{id}")
    public boolean removeTeacher(@ApiParam(name = "id",value = "teacher id",required = true) @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        return flag;
    }


}

