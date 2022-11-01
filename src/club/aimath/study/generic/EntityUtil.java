package club.aimath.study.generic;

import java.util.ArrayList;
import java.util.List;

/**
 *  实体转换工具类
 *
 *  TODO 说明该工具类不能直接用于生产，因为为了代码看去清爽点，我少了一些必要检验，所以如果直接拿来使用可以会在某些场景下会报错。
 */
public class EntityUtil {


    /**
     * 集合实体转换
     *
     * @param target 目标实体类
     * @param list   源集合
     * @return 装有目标实体的集合
     */
    public static <T> List<T> changeEntityList(Class<T> target, List<?> list) throws Exception {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<T> resultList = new ArrayList<T>();
        //用Object接收
        for (Object obj : list) {
            resultList.add(changeEntity(target, obj));
        }
        return resultList;
    }

    /**
     * 实体转换
     *
     * @param target 目标实体class对象
     * @param baseTO 源实体
     * @return 目标实体
     */
    public static <T> T changeEntity(Class<T> target, Object baseTO) throws Exception{
        T obj = target.getConstructor().newInstance();
        if (baseTO == null) {
            return null;
        }
        // 复制属性等
//        BeanUtils.copyProperties(baseTO, obj);
        return obj;
    }
}
