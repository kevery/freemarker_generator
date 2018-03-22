package domain;

/**
 * 表字段
 * 2018/3/21
 */
public class Column {

    private String name;//字段名

    private String jdbcType;//数据库类型

    private String javaType;//java类型

    private String javaName;//JAVA属性名

    private String comment;//注解

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaName() {
        return javaName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }
}
