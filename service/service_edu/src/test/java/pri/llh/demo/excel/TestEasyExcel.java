package pri.llh.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.demo.excel
 * @since 1.0
 */
public class TestEasyExcel {
    public static void main(String[] args) {
        //writing operation
        //set up the path and excel file name
        String file = "D:\\write.xlsx";

        //invoke method
        //EasyExcel.write(file,DemoData.class).sheet("student").doWrite(getData());
        EasyExcel.read(file,DemoData.class,new ExcelListener()).sheet().doRead();
    }

    public static List<DemoData> getData(){
        List<DemoData> demoData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("test"+i);
            demoData.add(data);
        }
        return demoData;
    }
}
