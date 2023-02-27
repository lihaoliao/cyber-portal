package pri.llh.utils;

import lombok.Getter;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.utils
 * @since 1.0
 */
@Getter
public enum ResultCodeEnum {
    /**
     *  ResultCode
     */
    SUCCESS(20000, "operation success"),
    ERROR(40000, "operation fail");

    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
