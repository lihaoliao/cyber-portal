package pri.llh.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.demo.excel
 * @since 1.0
 */
public class ExcelListener extends AnalysisEventListener<DemoData> {
    //read
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("&&&&&&&&&&&&"+demoData);
    }

    //read table head
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("!!!!!!!!"+headMap);
    }

    //after read
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
