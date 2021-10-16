package model.entity;

import java.util.Map;

/**
 * @author Luiza
 * @date 12/09/2021
 */
public class Question {

    private String id;
    private String question;
    private Map<String, String> answers;
    private String correctAnswer;
    private QuestionLevel level;
    private int points;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public QuestionLevel getLevel() {
        return level;
    }

    public void setLevel(QuestionLevel level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Question{"
                + "id='" + id + '\''
                + ", question='" + question + '\''
                + ", answers=" + answers
                + ", correctAnswer='" + correctAnswer + '\''
                + '}';
    }
}
