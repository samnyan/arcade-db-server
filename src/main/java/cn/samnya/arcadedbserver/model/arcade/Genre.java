package cn.samnya.arcadedbserver.model.arcade;

/**
 * @author sam_nya (samnya@outlook.com)
 */
public enum Genre {
    MUSIC_GAME("音乐类"),
    RACING_GAME("竞速类"),
    SHOOTING_GAME("射击类");


    private String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override public String toString() { return displayName; }
}
