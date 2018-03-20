package generate.impl;

import consts.FileTypeEnum;
import generate.Generator;

import java.util.HashMap;
import java.util.Map;

/**
 * 2018/3/20
 */
public class ServiceImplGenerator extends Generator {
    @Override
    public String buildOutFileName(String tableName) {
        return convertUpCanmal(tableName + "_service_impl" + FileTypeEnum.JAVA.getSuffix());

    }

    @Override
    public void setFileOutDir() {
        fileOutDirStr = "/";
    }

    @Override
    public void initTemplateParam() {
        Map<String, Object> stringObjectMap = new HashMap<>();

        stringObjectMap.put("domain", convertUpCanmal(getTableName()));
        stringObjectMap.put("domain_low", convertLowCanmal(getTableName()));
        setMap(stringObjectMap);
        setMap(stringObjectMap);
    }

    @Override
    public String getTemplateName() {
        return "serviceImpl.ftl";
    }
}
