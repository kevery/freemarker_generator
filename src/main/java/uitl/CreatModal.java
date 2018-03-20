package uitl;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import consts.FileTypeEnum;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建类
 * <p>
 * 2018/3/19
 */
public class CreatModal {
    public static final String TARGET_DIR = "ftl/";


    public void generateController(String name,String desc) throws Exception {
        Template command = FreeMarkerUtil.getTemplate("mod/controller.ftl");

        String className = buildControllerClassName(name);


        String fileName = className + FileTypeEnum.JAVA.getSuffix();

        String generateDir = TARGET_DIR + "/" + name + "/controller";
        File file = new File(generateDir);

        if (!file.exists()) {
            file.mkdirs();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File(generateDir+"/"+fileName));

        Map<String, Object> map = new HashMap<>();
        map.put("modal_name", buildControllerMapper(name));
        map.put("modal_desc", buildModalDesc(name,desc));
        map.put("modal_classname", className);

        command.process(map, new BufferedWriter(new OutputStreamWriter(fileOutputStream)));
        fileOutputStream.close();
    }

    //// TODO: 2018/3/19 计划改为由表名查询数据库备注动态获取
    private Object buildModalDesc(String modalName,String desc) {
        return desc;
    }

    private String buildControllerClassName(String modalName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, modalName + "_controller");

    }

    private String buildControllerMapper(String name) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name);
    }


    public static void main(String[] args) throws Exception {
        CreatModal creatModal = new CreatModal();

        ArrayList<Map> objects = Lists.newArrayList();

        HashMap<Object, Object> objectObjectHashMap1 = Maps.newHashMap();
        objectObjectHashMap1.put("name", "order_setting");
        objectObjectHashMap1.put("desc", "订单设置 ");

        HashMap<Object, Object> objectObjectHashMap2 = Maps.newHashMap();
        objectObjectHashMap2.put("name", "sales_refund_apply");
        objectObjectHashMap2.put("desc", "退款申请单");

        HashMap<Object, Object> objectObjectHashMap3 = Maps.newHashMap();
        objectObjectHashMap3.put("name", "sales_returns_apply");
        objectObjectHashMap3.put("desc", "退货申请单");

        HashMap<Object, Object> objectObjectHashMap4 = Maps.newHashMap();
        objectObjectHashMap4.put("name", "sales_replace_apply");
        objectObjectHashMap4.put("desc", "换货申请单");

        HashMap<Object, Object> objectObjectHashMap5 = Maps.newHashMap();
        objectObjectHashMap5.put("name", "order_sales_list");
        objectObjectHashMap5.put("desc", "订单售后");

        HashMap<Object, Object> objectObjectHashMap6 = Maps.newHashMap();
        objectObjectHashMap6.put("name", "order_sales_topic");
        objectObjectHashMap6.put("desc", "售后主题");

        objects.add(objectObjectHashMap1);
        objects.add(objectObjectHashMap2);
        objects.add(objectObjectHashMap3);
        objects.add(objectObjectHashMap4);
        objects.add(objectObjectHashMap5);
        objects.add(objectObjectHashMap6);

        for (Map object : objects) {
            String name = object.get("name").toString();
            String desc = object.get("desc").toString();
            creatModal.generateController(name,desc);
        }

    }
}
