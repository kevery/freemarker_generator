package generate.impl;

import consts.FileTypeEnum;
import generate.Generator;

import java.util.HashMap;
import java.util.Map;

/**
 * 2018/3/20
 */
public class ServiceGenerator extends Generator {

    private static final String SUFFIX = "service";

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
        map.put("domain", convertUpCanmal(getTableName()));
        map.put("comment", getModal_desc());
        setMap(map);

    }

    @Override
    public String getTemplateName() {
        return "service.ftl";
    }
}
