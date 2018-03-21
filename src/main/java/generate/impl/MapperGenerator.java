package generate.impl;

import consts.FileTypeEnum;
import domain.Column;
import generate.Generator;
import uitl.DBUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2018/3/20
 */
public class MapperGenerator extends Generator {
    @Override
    public void setFileOutDir() {
        fileOutDirStr = "/";
    }

    @Override
    public String buildOutFileName(String tableName) {
        return convertUpCanmal(tableName + "_mapper_" + FileTypeEnum.XML.getSuffix());
    }

    @Override
    public void initTemplateParam() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("domain", convertUpCanmal(getTableName()));
        map.put("table_name", getTableName());

        List<Column> coumnsByTableName = DBUtils.getCoumnsByTableName("fb_" + getTableName());
        map.put("columns", coumnsByTableName);


        setMap(map);
    }

    @Override
    public String getTemplateName() {
        return "mapper.ftl";
    }
}
