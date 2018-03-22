package uitl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 2018/3/20
 */
public class PropertyLoadUtil {

    Properties properties = new Properties();//获取Properties实例
    InputStream inStream = getClass().getResourceAsStream("/db/dbconfig.properties");//获取配置文件输入流

    public String loadDBURL() throws IOException {
        properties.load(inStream);
        return properties.getProperty("jdbc_url");
    }

    public String loadDBPassWord() throws IOException {
        properties.load(inStream);
        return properties.getProperty("password");
    }


    public String loadDBUser() throws IOException {
        properties.load(inStream);
        return properties.getProperty("user");
    }
}
