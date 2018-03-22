package generate.impl;

import consts.FileTypeEnum;
import domain.Column;
import generate.Generator;
import org.apache.commons.lang3.StringUtils;
import uitl.DBUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2018/3/20
 */
public class DomainGenerator extends Generator {

    @Override
    public String buildOutFileName(String tableName) {
        return convertUpCanmal(tableName  + FileTypeEnum.JAVA.getSuffix());

    }

    @Override
    public void setFileOutDir() {
        fileOutDirStr = "/";
    }

    @Override
    public void initTemplateParam() throws Exception {
        Map<String, Object> map = new HashMap<>();
        String modalDesc = DBUtils.getCommentByTableName("fb_"+getTableName());
        if (StringUtils.isBlank(modalDesc)) {
            throw new RuntimeException(String.format("表%s未添加注解,请修改数据库", "fb_" + getTableName()));
        }
        map.put("comment", modalDesc);//备注
        map.put("domain",convertUpCanmal(getTableName()));//类名

        List<Column> coumnsByTableName = DBUtils.getCoumnsByTableName("fb_" + getTableName());
        map.put("columns", coumnsByTableName);


        setMap(map);
    }

    @Override
    public String getTemplateName() {
        return "domain.ftl";
    }
}
