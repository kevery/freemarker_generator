package uitl;

import com.google.common.base.CaseFormat;

/**
 * 2018/3/21
 */
public class CommanUtils {

    /**
     * 带下划线字符串转小驼峰
     */
    public static String convertLowCanmal(String string) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, string);
    }

    /**
     * 带下划线字符串转大驼峰
     */
    public static String convertUpCanmal(String string) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, string);
    }
}
