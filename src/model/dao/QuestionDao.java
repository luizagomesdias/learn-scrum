package model.dao;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.entity.Question;

/**
 * @author Luiza
 * @date 12/09/2021
 */
public class QuestionDao {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String DATA_FILE = "data.txt";
    private static final String DATA_FILE_TMP = "data-tmp.txt";

    public QuestionDao() {
        checkFile();
    }

    private void checkFile() {
        File dataFile = new File(DATA_FILE);
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
                System.out.println("Data file created with success");
            } catch (IOException e) {
                System.out.println("Exception creating data file. Exception: " + e);
            }
        }
    }

    public String create(Question question) {
        question.setId(generateId());
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE, true));
            bw.write(this.parseQuestionToData(question));
            bw.flush();
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Exception creating object. Exception: " + e);
        }
        return question.getId();
    }

    public Question read(String id) {
        Question question = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(DATA_FILE));
            String data;
            while ((data = br.readLine()) != null) {
                if (!id.isEmpty() && data.contains(id)) {
                    question = parseDataToQuestion(data);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Exception reading object. Exception: " + e);
        }
        return question;
    }

    public List<Question> readAll() {
        List<Question> questions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(DATA_FILE));
            String data;
            while ((data = br.readLine()) != null) {
                questions.add(parseDataToQuestion(data));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Exception reading objects. Exception: " + e);
        }
        return questions;
    }

    public List<Question> readAllByFilter(String filter) {
        List<Question> questions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(DATA_FILE));
            String data;
            while ((data = br.readLine()) != null) {
                if (data.contains(filter)) {
                    questions.add(parseDataToQuestion(data));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Exception reading objects. Exception: " + e);
        }
        return questions;
    }

    public void update(Question question) {
        try {
            File db = new File(DATA_FILE);
            File tempDB = new File(DATA_FILE_TMP);

            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            String data;
            while ((data = br.readLine()) != null) {
                if (!question.getId().isEmpty() && data.contains(question.getId())) {
                    bw.write(parseQuestionToData(question));
                } else {
                    bw.write(data);
                }
                bw.flush();
                bw.newLine();
            }

            br.close();
            bw.close();
            db.delete();

            boolean status = tempDB.renameTo(db);
            System.out.println("Update status: " + status);
        } catch (IOException e) {
            System.out.println("Exception updating object. Exception: " + e);
        }
    }

    public void delete(String id) {
        try {
            File db = new File(DATA_FILE);
            File tempDB = new File(DATA_FILE_TMP);

            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            String data;
            while ((data = br.readLine()) != null) {
                if (!id.isEmpty() && data.contains(id)) {
                    continue;
                }
                bw.write(data);
                bw.flush();
                bw.newLine();
            }

            br.close();
            bw.close();
            db.delete();

            boolean status = tempDB.renameTo(db);
            System.out.println("Delete status: " + status);
        } catch (IOException e) {
            System.out.println("Exception removing object. Exception: " + e);
        }
    }

    private static String generateId() {
        return UUID.randomUUID().toString();
    }

    private String parseQuestionToData(Question question) throws IOException {
        return objectMapper.writeValueAsString(question);
    }

    private Question parseDataToQuestion(String data) throws IOException {
        return objectMapper.readValue(data, Question.class);
    }
}
