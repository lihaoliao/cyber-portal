package pri.llh.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import pri.llh.eduservice.entity.EduLevel;
import pri.llh.eduservice.entity.excel.LevelData;
import pri.llh.eduservice.service.EduLevelService;
import pri.llh.servicebase.exceptionhandler.CustomizedException;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.eduservice.listener
 * @since 1.0
 */
public class LevelExcelListener extends AnalysisEventListener<LevelData> {


    public EduLevelService levelService;

    public LevelExcelListener() {
    }
    public LevelExcelListener(EduLevelService levelService) {
        this.levelService = levelService;
    }

    /**
     * read the Excel data row by row
     * @param data
     * @param analysisContext
     */
    @Override
    public void invoke(LevelData data, AnalysisContext analysisContext) {
        if (data == null) {
            throw new CustomizedException(20001,"file data is empty");
        }
        EduLevel levelOne = this.levelOneIsExist(levelService, data.getLevelOne());
        if(levelOne==null){
            levelOne = new EduLevel();
            levelOne.setParentId("0");
            levelOne.setLevel(data.getLevelOne());
            levelService.save(levelOne);
        }

        String parentId = levelOne.getId();
        EduLevel levelTwo = this.levelTwoIsExist(levelService, data.getLevelTwo(),parentId);
        if(levelTwo==null){
            levelTwo = new EduLevel();
            levelTwo.setParentId(parentId);
            levelTwo.setLevel(data.getLevelTwo());
            levelService.save(levelTwo);
        }
    }

    /**
     * LevelOne can only exist once
     * @param levelService
     * @param levelName
     * @return
     */
    private EduLevel levelOneIsExist(EduLevelService levelService,String levelName){
        QueryWrapper<EduLevel> wrapper = new QueryWrapper<>();
        wrapper.eq("level",levelName);
        wrapper.eq("parent_id",0);
        EduLevel level = levelService.getOne(wrapper);
        return level;
    }

    /**
     * LevelTwo can only exist once
     * @param levelService
     * @param levelName
     * @param parentId
     * @return
     */
    private EduLevel levelTwoIsExist(EduLevelService levelService,String levelName,String parentId){
        QueryWrapper<EduLevel> wrapper = new QueryWrapper<>();
        wrapper.eq("level",levelName);
        wrapper.eq("parent_id",parentId);
        EduLevel level = levelService.getOne(wrapper);
        return level;
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
