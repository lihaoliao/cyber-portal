package pri.llh.eduservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * course level
 * </p>
 *
 * @author testjava
 * @since 2023-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduLevel对象", description="course level")
public class EduLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "courses ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "courses level")
    private String level;

    @ApiModelProperty(value = "parent ID,二级分类")
    private String parentId;

    @ApiModelProperty(value = "sort")
    private Integer sort;

    @ApiModelProperty(value = "create time")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "update time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
