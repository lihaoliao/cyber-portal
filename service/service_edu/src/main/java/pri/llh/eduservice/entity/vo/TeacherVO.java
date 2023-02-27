package pri.llh.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.eduservice.entity.vo
 * @since 1.0
 */
@Data
public class TeacherVO {

    @ApiModelProperty(value = "teacher's name,fuzzy search",example = "wang")
    private String name;

    @ApiModelProperty(value = "title:1 or 2",example = "1")
    private Integer level;

    @ApiModelProperty(value = "begin time",example = "2023-01-01 01:00:01")
    private String begin;

    @ApiModelProperty(value = "end time",example = "2023-02-01 01:00:01")
    private String end;

}
