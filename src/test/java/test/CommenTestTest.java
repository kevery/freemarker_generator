package test;

import com.github.abel533.database.*;
import com.github.abel533.utils.DBMetadataUtils;
import com.google.common.base.CaseFormat;
import domain.Column;
import org.joda.time.DateTime;
import org.junit.Test;
import uitl.DBUtils;

import java.sql.Time;
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
    public void name1() throws Exception {
        List<Column> order_setting = DBUtils.getCoumnsByTableName("fb_order_setting");


    }

    @Test
    public void timetest() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
