package pri.llh.utils;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * Uniform result return class
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.utils
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class Result {

    @ApiModelProperty("success or not")
    private Boolean success;

    @ApiModelProperty("return status code")
    private Integer code;

    @ApiModelProperty("return messgae")
    private String messgae;

    @ApiModelProperty("return data")
    private Map<String,Object> data = new HashMap<>();

    /**
     * private construct
     */
    private Result(){}

    /**
     * static method if success
     */
    public static Result success(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessgae(ResultCodeEnum.SUCCESS.getMsg());
        return result;
    }

    /**
     * static method if fail
     */
    public static Result error(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.ERROR.getCode());
        result.setMessgae(ResultCodeEnum.ERROR.getMsg());
        return result;
    }

    public Result setData(String key,Object value){
        this.data.put(key,value);
        return this;
    }

}
