package test;

import com.google.common.base.CaseFormat;
import org.junit.Test;

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
}
