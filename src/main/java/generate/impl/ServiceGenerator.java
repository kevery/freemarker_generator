package generate.impl;

import consts.FileTypeEnum;
import generate.Generator;
import org.apache.commons.lang3.StringUtils;
import uitl.DBUtils;

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
    public void initTemplateParam() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("domain", convertUpCanmal(getTableName()));

        String modalDesc = DBUtils.getCommentByTableName("fb_"+getTableName());
        if (StringUtils.isBlank(modalDesc)) {
            throw new RuntimeException(String.format("表%s未添加注解,请修改数据库", "fb_" + getTableName()));
        }
        map.put("comment", modalDesc);//备注
        setMap(map);

    }

    @Override
    public String getTemplateName() {
        return "service.ftl";
    }
}
