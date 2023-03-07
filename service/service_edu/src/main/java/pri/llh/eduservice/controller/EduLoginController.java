package pri.llh.eduservice.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.*;
import pri.llh.utils.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.eduservice.controller
 * @since 1.0
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {

    /**
     * base on the vue-admin-template
     * @return
     */
    @PostMapping("/login")
    public Result login(){
        return Result.success().setData("token","admin");
    }

    /**
     * base on the vue-admin-template
     * @return
     */
    @GetMapping("/info")
    public Result info(){
        Map<String,Object> data = new HashMap<>(3);
        //one user can be multiple role
        data.put("roles","[admin]");
        data.put("name","admin");
        data.put("avatar","https://cdn-icons-png.flaticon.com/512/6386/6386976.png");
        return Result.success().setData(data);
    }


}
