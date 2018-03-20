package generate;

import com.google.common.base.CaseFormat;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import uitl.FreeMarkerUtil;
import uitl.Properate;

import java.io.*;
import java.util.Map;

/**
 * 抽象生成类
 * <p>
 * 2018/3/20
 */
public abstract class Generator {

    public static final String FTL_DIR = "mod/";


    /**
     * 模板参数
     */
    protected Map<String, Object> map;

    /**
     * 输出文件流
     *
     * @return
     * @throws IOException
     */
    protected FileOutputStream fileOutputStream;


    /**
     * 表名
     *
     * @return
     * @throws IOException
     */
    protected String tableName;


    /**
     * 输出目录
     *
     * @param tableName
     * @return
     */
    protected String fileOutDirStr;

    public Template getTemplate() throws IOException {
        if (getTableName() == null) {
            throw new RuntimeException("templateName不能为空");
        }
        if (getTemplateName() == null) {
            throw new RuntimeException("模板名称不能为空,子类必须实现getTemplateName()方法");
        }
        return FreeMarkerUtil.getTemplate(FTL_DIR + getTemplateName());
    }

    public abstract void setFileOutDir();

    public abstract String buildOutFileName(String tableName);

    public abstract void initTemplateParam();

    public abstract String getTemplateName();



    public void setFileOutputStream() throws FileNotFoundException {
        setFileOutDir();

        File fileOutDir = new File("ftl/" + tableName + fileOutDirStr);


        if (!fileOutDir.exists()) {
            fileOutDir.mkdirs();
        }
        if (map == null) {
            System.out.println("skip" + this.getClass().getName());
        } else {
            fileOutputStream = new FileOutputStream(new File(fileOutDir + "/" + buildOutFileName(tableName)));
        }
    }

    public void process() throws IOException, TemplateException {
        initTemplateParam();
        setFileOutputStream();
        this.getTemplate().process(getMap(), new BufferedWriter(new OutputStreamWriter(fileOutputStream)));
        fileOutputStream.close();
    }


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 带下划线字符串转小驼峰
     */
    public String convertLowCanmal(String string) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, string);
    }

    /**
     * 带下划线字符串转大驼峰
     */
    public String convertUpCanmal(String string) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, string);
    }

    public String getModal_desc() {
        Properate properate = new Properate();
        return properate.stringObjectMap.get(getTableName());
    }
}
