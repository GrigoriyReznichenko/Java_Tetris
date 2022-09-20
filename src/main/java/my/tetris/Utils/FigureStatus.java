package my.tetris.utils;

public enum FigureStatus {
    FALLING("Falling"),
    BOTTOM("Bottom");


    private final String id;


    FigureStatus(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

}
