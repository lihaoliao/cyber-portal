package pri.llh.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pri.llh.eduservice.service.EduLevelService;
import pri.llh.utils.Result;

/**
 * <p>
 * course level 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2023-03-12
 */
@RestController
@RequestMapping("/eduservice/level")
@CrossOrigin
public class EduLevelController {
    @Autowired
    private EduLevelService levelService;

    /**
     * add course level
     * @param file
     * @return
     */
    @PostMapping("/addLevel")
    public Result addLevel(MultipartFile file){
        levelService.saveLevel(file,levelService);
        return Result.success();
    }
}

