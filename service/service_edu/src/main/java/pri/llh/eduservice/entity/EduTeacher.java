package pri.llh.eduservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * Educator
 * </p>
 *
 * @author testjava
 * @since 2023-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduTeacher对象", description="Educator")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Educator ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "Educator name")
    private String name;

    @ApiModelProperty(value = "Educator Introduction")
    private String intro;

    @ApiModelProperty(value = "Educator background")
    private String career;

    @ApiModelProperty(value = "title 1-lecturer 2-senior lecturer")
    private Integer level;

    @ApiModelProperty(value = "Educator avatar")
    private String avatar;

    @ApiModelProperty(value = "sort")
    private Integer sort;

    @ApiModelProperty(value = "logic delete 1（true）deleted， 0（false）not delete")
    private Integer isDeleted;

    @ApiModelProperty(value = "create time")
    private Date gmtCreate;

    @ApiModelProperty(value = "update time")
    private Date gmtModified;


}
