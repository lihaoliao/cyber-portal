package pri.llh.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.servicebase.handler
 * @since 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * Using mp to implement the add operation, this method performs
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    /**
     * Using mp to implement a modification operation, this method performs
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

}
