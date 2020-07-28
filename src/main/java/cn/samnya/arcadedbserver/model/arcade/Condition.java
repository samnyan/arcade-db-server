package cn.samnya.arcadedbserver.model.arcade;

/**
 * @author sam_nya (samnya@outlook.com)
 */
public enum Condition {

    PERFECT("完美"),
    NORMAL("正常"),
    ABNORMAL("勉强能玩"),
    BROKEN("坏机"),
    REMOVED("已撤机");

    private String displayName;

    Condition(String displayName) {
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
