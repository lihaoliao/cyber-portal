package pri.llh.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.eduservice.entity.excel
 * @since 1.0
 */
@Data
public class LevelData {

    @ExcelProperty(value = "levelone",index = 0)
    private String levelOne;
    @ExcelProperty(value = "leveltwo",index = 1)
    private String levelTwo;
}
