package pri.llh.servicebase.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pri.llh.utils.Result;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.servicebase.exceptionhandler
 * @since 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception ex){
        ex.printStackTrace();
        return Result.error().setMessgae("global exception executed");
    }
}
