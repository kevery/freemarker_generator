package generate.impl;

import consts.FileTypeEnum;
import generate.Generator;

import java.util.HashMap;
import java.util.Map;

/**
 * 2018/3/20
 */
public class DomainGenerator extends Generator {

    @Override
    public String buildOutFileName(String tableName) {
        return convertUpCanmal(convertUpCanmal(tableName)  + FileTypeEnum.JAVA.getSuffix());

    }

    @Override
    public void setFileOutDir() {
        fileOutDirStr = "/";
    }

    @Override
    public void initTemplateParam() {
        Map<String, Object> map = new HashMap<>();
        map.put("domain", getModal_desc());//备注
        setMap(map);
    }

    @Override
    public String getTemplateName() {
        return "domain.ftl";
    }
}
