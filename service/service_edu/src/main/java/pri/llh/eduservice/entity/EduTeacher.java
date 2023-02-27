package pri.llh.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

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
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "create time")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "update time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
