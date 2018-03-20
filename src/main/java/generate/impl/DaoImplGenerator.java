package generate.impl;

import consts.FileTypeEnum;
import generate.Generator;

import java.util.HashMap;
import java.util.Map;

/**
 * 2018/3/20
 */
public class DaoImplGenerator extends Generator {
    @Override
    public String buildOutFileName(String tableName) {
        return convertUpCanmal(tableName + "_dao_impl" + FileTypeEnum.JAVA.getSuffix());
    }

    @Override
    public void setFileOutDir() {
        fileOutDirStr = "/";
    }

    @Override
    public void initTemplateParam() {
        Map<String, Object> map = new HashMap<>();

        map.put("domain", convertUpCanmal(getTableName()));
        map.put("domain_low", convertLowCanmal(getTableName()));
        setMap(map);
    }

    @Override
    public String getTemplateName() {
        return "daoImpl.ftl";
    }
}
