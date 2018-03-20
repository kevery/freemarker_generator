package consts;

/**
 * Created by kever
 * 2018/3/19.
 */
public enum FileTypeEnum {
    JAVA(".java"),
    XML(".xml");

    /**
     * 文件名后缀
     */
    private String suffix;

    FileTypeEnum(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
