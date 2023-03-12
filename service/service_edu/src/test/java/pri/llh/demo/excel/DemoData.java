package pri.llh.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.demo.excel
 * @since 1.0
 */
@Data
public class DemoData {
    //set up the table head name
    @ExcelProperty(value = "studentId",index = 0)
    private Integer sno;
    @ExcelProperty(value = "studentName",index = 1)
    private String sname;
}
