package model.entity;

/**
 * @author Luiza
 * @date 15/10/2021
 */
public enum QuestionLevel {

    EASY("Fácil"),
    HARD("Difícil");

    private String level;

    QuestionLevel(String level) {
        this.level = level;
    }

    public String getLevelUI() {
        return level;
    }

    public static QuestionLevel fromUI(String level) {
        for (QuestionLevel ql : QuestionLevel.values()) {
            if (level.equals(ql.getLevelUI())) {
                return ql;
            }
        }
        return null;
    }

}
