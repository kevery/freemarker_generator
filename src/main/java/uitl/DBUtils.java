package uitl;

import com.github.abel533.database.*;
import com.github.abel533.utils.DBMetadataUtils;
import domain.Column;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 2018/3/21
 */
public class DBUtils {
    private static PropertyLoadUtil propertyLoadUtil = new PropertyLoadUtil();

    private static SimpleDataSource dataSource;

    static {
        try {
            dataSource = new SimpleDataSource(
                    Dialect.MYSQL,
                    propertyLoadUtil.loadDBURL(),
                    propertyLoadUtil.loadDBUser(),
                    propertyLoadUtil.loadDBPassWord()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static DBMetadataUtils dbMetadataUtils = new DBMetadataUtils(dataSource);


    /**
     * 表名获取字段信息
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    public static List<Column> getCoumnsByTableName(String tableName) throws Exception {
        DatabaseConfig config = new DatabaseConfig("fb_shop", "fb_shop", tableName);
        List<IntrospectedTable> list = dbMetadataUtils.introspectTables(config);
        if (list.size() < 1) {
            throw new RuntimeException("表 " + tableName + " 不存在,请检查数据库");
        }
        IntrospectedTable introspectedTable = list.get(0);

        List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();

        List<Column> columns = new ArrayList<>();
        for (IntrospectedColumn column : allColumns) {
            System.out.println(column.getName() + " - " +
                    column.getJdbcTypeName() + " - " +
                    column.getJavaProperty() + " - " +
                    column.getJavaProperty() + " - " +
                    column.getFullyQualifiedJavaType().getFullyQualifiedName() + " - " +
                    column.getRemarks());
            Column columnDomain = new Column();
            columnDomain.setJdbcType(column.getJdbcTypeName());
            columnDomain.setJavaType(column.getFullyQualifiedJavaType().getShortName());
            columnDomain.setName(column.getName());
            columnDomain.setJavaName(CommanUtils.convertLowCanmal(column.getName()));
            columnDomain.setComment(column.getRemarks());

            columns.add(columnDomain);
        }
        return columns;
    }

    /**
     * 表名获取表备注
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    public static String getCommentByTableName(String tableName) throws Exception {
        DatabaseConfig config = new DatabaseConfig("fb_shop", "fb_shop", tableName);
        List<IntrospectedTable> list = dbMetadataUtils.introspectTables(config);
        if (list.size() < 1) {
            throw new RuntimeException("表 " + tableName + " 不存在,请检查数据库");
        }
        IntrospectedTable introspectedTable = list.get(0);

        return introspectedTable.getRemarks();
    }


}
