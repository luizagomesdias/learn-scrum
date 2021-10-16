package model.entity;

/**
 * @author Luiza
 * @date 15/10/2021
 */
public class HardQuestion extends Question {
    
    public HardQuestion() {
        super.setLevel(QuestionLevel.HARD);
    }
    
    @Override
    public void setPoints(int points) {
        super.setPoints(points * 2);
    }
}
