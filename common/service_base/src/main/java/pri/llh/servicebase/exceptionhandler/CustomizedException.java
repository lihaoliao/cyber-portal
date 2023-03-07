package pri.llh.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.servicebase.exceptionhandler
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomizedException extends RuntimeException{

    private Integer code;
    private String msg;

}


