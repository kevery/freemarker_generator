package uitl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kever
 * 2018/3/21.
 */
public class DBUtilsTest {

    @Test
    public void getCoumnsByTableName() {
    }

    @Test
    public void getCommentByTableName()throws Exception {
        String fb_order_setting = DBUtils.getCommentByTableName("fb_order_setting");
        System.out.println(fb_order_setting);
    }
}