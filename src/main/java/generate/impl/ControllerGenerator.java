package generate.impl;

import consts.FileTypeEnum;
import generate.Generator;
import uitl.Properate;

import java.util.HashMap;
import java.util.Map;

/**
 * 2018/3/20
 */
public class ControllerGenerator extends Generator {

    private static final String SUFFIX = "controller";

    @Override
    public String buildOutFileName(String tableName) {
        return convertUpCanmal(tableName + "_" + SUFFIX + "_" + FileTypeEnum.JAVA.getSuffix());
    }

    @Override
    public void setFileOutDir() {
        fileOutDirStr = "/";
    }

    @Override
    public void initTemplateParam() {
        Map<String, Object> map = new HashMap<>();
        map.put("comment", getModal_desc());//备注
        map.put("mapper_name", convertLowCanmal(getTableName()));//映射路径
        map.put("classname", buildOutFileName(getTableName()).split("/.")[0]);//类文件class名

        setMap(map);
    }

    @Override
    public String getTemplateName() {
        return "controller.ftl";
    }


    public static void main(String[] args) {
        Properate properate = new Properate();
        String order_setting = properate.stringObjectMap.get("order_setting");
        System.out.println(order_setting);
    }
}
