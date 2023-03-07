package pri.llh.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import pri.llh.eduservice.entity.EduTeacher;
import pri.llh.eduservice.entity.vo.TeacherVO;
import pri.llh.eduservice.service.EduTeacherService;
import pri.llh.utils.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    /**
     * select all teacher data
     * @return Result object with data
     */
    @ApiOperation("find all teacher and return a list")
    @GetMapping("/findAllTeacher")
    public Result findAllTeacher(){
        //invoke service object method
        List<EduTeacher> teacherList = teacherService.list(null);
        //int a = 10/0;
        return Result.success().setData("items",teacherList);
    }

    /**
     * Logic remove teacher
     * @param id
     * @return Result object with remove success or not
     */
    @ApiOperation("logic delete teacher by id")
    @DeleteMapping("/removeTeacher/{id}")
    public Result removeTeacher(@ApiParam(name = "id",value = "teacher id",required = true) @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        return flag ? Result.success() : Result.error();
    }

    /**
     * pagination Select Teacher
     * @param cur
     * @param size
     * @return Result object with total numbers and current page data
     */
    @GetMapping("/paginationSelectTeacher/{cur}/{size}")
    public Result paginationSelectTeacher(@PathVariable long cur, @PathVariable long size){
        //create Page object
        Page<EduTeacher> teacherPage = new Page<>(cur,size);

        teacherService.page(teacherPage,null);
        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",records);
        return Result.success().setData(map);

        //return Result.success().setData("result",teacherPage);
    }

    /**
     * conditional Pagination Select Teacher
     * @param cur
     * @param size
     * @param teacherVO
     * @return
     */
    @PostMapping("/conditionalPaginationSelect/{cur}/{size}")
    public Result conditionalPaginationSelect(@PathVariable long cur, @PathVariable long size,
                                              @RequestBody(required = false) TeacherVO teacherVO){
        //create Page object
        Page<EduTeacher> teacherPage = new Page<>(cur,size);
        //create wrapper object
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();

        //wrapper condition
        //Coding in controller for now translate to service later
        String name = teacherVO.getName();
        Integer level = teacherVO.getLevel();
        String begin = teacherVO.getBegin();
        String end = teacherVO.getEnd();
        if (!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            queryWrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            queryWrapper.le("gmt_create",end);
        }

        //sort
        queryWrapper.orderByDesc("gmt_modified");

        teacherService.page(teacherPage,queryWrapper);
        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();
        Map<String,Object> map = new HashMap<>(2);
        map.put("total",total);
        map.put("rows",records);
        return Result.success().setData(map);
    }

    /**
     * add teacher method
     * @param eduTeacher
     * @return
     */
    @PostMapping("/addTeacher")
    public Result addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.save(eduTeacher);
        return flag ? Result.success() : Result.error();
    }

    /**
     * select teacher by id
     * @param id
     * @return
     */
    @GetMapping("/findTeacherById/{id}")
    public Result findTeacherById(@PathVariable String id){
        EduTeacher teacher = teacherService.getById(id);
        if (teacher!=null) {
            return Result.success().setData("teacher", teacher);
        }
        return Result.error().setMessgae("can not find teacher");
    }


    /**
     * update teacher by id
     * @param eduTeacher
     * @return
     */
    @PostMapping("/updateTeacher")
    public Result updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.updateById(eduTeacher);
        return flag ? Result.success() : Result.error();
    }

}

