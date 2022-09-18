package my.tetris.Utils;

public enum IDs {
    FALLING("Falling"),
    BOTTOM("Bottom");

    private String code;

    IDs(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
