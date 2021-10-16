package model.entity;

/**
 * @author Luiza
 * @date 15/10/2021
 */
public class EasyQuestion extends Question {

    public EasyQuestion() {
        super.setLevel(QuestionLevel.EASY);
    }

    @Override
    public void setPoints(int points) {
        super.setPoints(points);
    }
}
