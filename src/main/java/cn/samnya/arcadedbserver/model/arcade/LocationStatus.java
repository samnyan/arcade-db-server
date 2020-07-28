package cn.samnya.arcadedbserver.model.arcade;

/**
 * @author sam_nya (samnya@outlook.com)
 */
public enum LocationStatus {
    CLOSED("已关闭"),
    OPEN("正常开放"),
    TEMPORARY_CLOSED("临时关闭"),
    CONSTRUCTING("施工中");

    private String displayName;

    LocationStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
