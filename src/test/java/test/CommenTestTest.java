package test;

import com.github.abel533.database.*;
import com.github.abel533.utils.DBMetadataUtils;
import com.google.common.base.CaseFormat;
import domain.Column;
import org.junit.Test;
import uitl.DBUtils;

import java.util.List;

/**
 * CommenTest Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 19, 2018</pre>
 */
public class CommenTestTest {

    @Test
    public void name() {
        String tableName = "business_order";
        String tableName1 = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
        String tableName2 = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName);
        System.out.println(tableName1);
        System.out.println(tableName2);
    }

    @Test
    public void tableName() throws Exception{
        SimpleDataSource dataSource = new SimpleDataSource(
                Dialect.MYSQL,
                "jdbc:mysql://rm-2ze402770n42sz2w8no.mysql.rds.aliyuncs.com:3306/fb_shop",
                "root",
                "1qaZ2wsX3edC"
        );

        DBMetadataUtils dbMetadataUtils = new DBMetadataUtils(dataSource);

        DatabaseConfig config = new DatabaseConfig("fb_shop", "fb_shop","order_setting");
        List<IntrospectedTable> list = dbMetadataUtils.introspectTables(config);
    }


    @Test
    public void name1() throws Exception {
        List<Column> order_setting = DBUtils.getCoumnsByTableName("fb_order_setting");


    }
}
