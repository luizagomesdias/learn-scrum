package scrum;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.dao.QuestionDao;
import model.entity.Question;

/**
 *
 * @author Luiza
 */
public class FrmQuiz extends javax.swing.JInternalFrame {

    private List<Question> questions = new ArrayList<>();
    private final QuestionDao questionDao = new QuestionDao();
    private int index;
    private int correctGuesses;
    private int totalQuestions;
    private int timeWindow = 10;
    private final Timer timer;
    private Timer pause;
    private int totalPoints;

    public FrmQuiz() {
        //Carrega as questões do arquivo
        loadQuestions();

        //Inicializa os componentes
        initComponents();

        //Cria o atualizador de tempo e resposta
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeWindow--;
                lblTimer.setText(String.valueOf(timeWindow));
                if (timeWindow <= 0) {
                    displayAnswer("");
                }
            }
        });

        //Carrega a primeira questão
        loadQuestionOnQuiz();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnA = new java.awt.Button();
        btnB = new java.awt.Button();
        btnC = new java.awt.Button();
        btnD = new java.awt.Button();
        lblQuestion = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        lblQuestionNumber = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 50, 50));
        setClosable(true);
        setIconifiable(true);
        setTitle("Scrum Quiz");
        setPreferredSize(new java.awt.Dimension(750, 500));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        btnA.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnA.setLabel("A");
        btnA.setMaximumSize(new java.awt.Dimension(29, 32));
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnB.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnB.setLabel("B");
        btnB.setMaximumSize(new java.awt.Dimension(29, 32));
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        btnC.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnC.setLabel("C");
        btnC.setMaximumSize(new java.awt.Dimension(29, 32));
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        btnD.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnD.setLabel("D");
        btnD.setMaximumSize(new java.awt.Dimension(29, 32));
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });

        lblQuestion.setBackground(new java.awt.Color(85, 85, 85));
        lblQuestion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQuestion.setForeground(new java.awt.Color(185, 185, 185));
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("Question");
        lblQuestion.setOpaque(true);

        lblA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblA.setForeground(new java.awt.Color(185, 185, 185));
        lblA.setText("Answer A");
        lblA.setMaximumSize(new java.awt.Dimension(58, 15));
        lblA.setMinimumSize(new java.awt.Dimension(58, 15));
        lblA.setPreferredSize(new java.awt.Dimension(58, 15));

        lblC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblC.setForeground(new java.awt.Color(185, 185, 185));
        lblC.setText("Answer C");

        lblD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblD.setForeground(new java.awt.Color(185, 185, 185));
        lblD.setText("Answer D");

        lblB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblB.setForeground(new java.awt.Color(185, 185, 185));
        lblB.setText("Answer B");

        lblTimer.setBackground(new java.awt.Color(85, 85, 85));
        lblTimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 153, 51));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblQuestionNumber.setBackground(new java.awt.Color(85, 85, 85));
        lblQuestionNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQuestionNumber.setForeground(new java.awt.Color(255, 153, 51));
        lblQuestionNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQuestionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblA, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuestionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblC, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        disableAnswerButtons();

        Question question = questions.get(index);
        if ("A".equals(question.getCorrectAnswer())) {
            correctGuesses++;
            totalPoints += question.getPoints();
        }
        displayAnswer(question.getCorrectAnswer());
    }//GEN-LAST:event_btnAActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        disableAnswerButtons();

        Question question = questions.get(index);
        if ("B".equals(question.getCorrectAnswer())) {
            correctGuesses++;
            totalPoints += question.getPoints();
        }
        displayAnswer(question.getCorrectAnswer());
    }//GEN-LAST:event_btnBActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        disableAnswerButtons();

        Question question = questions.get(index);
        if ("C".equals(question.getCorrectAnswer())) {
            correctGuesses++;
            totalPoints += question.getPoints();
        }
        displayAnswer(question.getCorrectAnswer());
    }//GEN-LAST:event_btnCActionPerformed

    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDActionPerformed
        disableAnswerButtons();

        Question question = questions.get(index);
        if ("D".equals(question.getCorrectAnswer())) {
            correctGuesses++;
            totalPoints += question.getPoints();
        }
        displayAnswer(question.getCorrectAnswer());
    }//GEN-LAST:event_btnDActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        timer.stop();
        pause.stop();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnA;
    private java.awt.Button btnB;
    private java.awt.Button btnC;
    private java.awt.Button btnD;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblQuestionNumber;
    private javax.swing.JLabel lblTimer;
    // End of variables declaration//GEN-END:variables

    private void loadQuestions() {
        questions = questionDao.readAll();
        totalQuestions = questions.size();
    }

    private void loadQuestionOnQuiz() {
        if (index >= totalQuestions) {
            results();
        } else {
            //Mostra qual questão de N questões
            String questionNumber = "Questão " + (index + 1) + " de " + totalQuestions;
            lblQuestionNumber.setText(questionNumber);

            //Seta a questão na tela
            Question question = questions.get(index);
            lblQuestion.setText(question.getQuestion());
            lblA.setText(question.getAnswers().get("A"));
            lblB.setText(question.getAnswers().get("B"));
            lblC.setText(question.getAnswers().get("C"));
            lblD.setText(question.getAnswers().get("D"));
            timer.start();
        }
    }

    public void displayAnswer(String correctAnswer) {
        timer.stop();
        disableAnswerButtons();

        Color lblColorCorrect = new Color(179, 235, 79);
        Color lblColorWrong = new Color(244, 93, 38);

        if ("A".equals(correctAnswer)) {
            lblA.setForeground(lblColorCorrect);
        } else {
            lblA.setForeground(lblColorWrong);
        }
        if ("B".equals(correctAnswer)) {
            lblB.setForeground(lblColorCorrect);
        } else {
            lblB.setForeground(lblColorWrong);
        }
        if ("C".equals(correctAnswer)) {
            lblC.setForeground(lblColorCorrect);
        } else {
            lblC.setForeground(lblColorWrong);
        }
        if ("D".equals(correctAnswer)) {
            lblD.setForeground(lblColorCorrect);
        } else {
            lblD.setForeground(lblColorWrong);
        }

        pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color lblColor = new Color(185, 185, 185);

                lblA.setForeground(lblColor);
                lblB.setForeground(lblColor);
                lblC.setForeground(lblColor);
                lblD.setForeground(lblColor);

                timeWindow = 10;
                lblTimer.setText(String.valueOf(timeWindow));
                enableAnswerButtons();
                index++;
                loadQuestionOnQuiz();
            }

        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {
        String message = "Corretas: " + correctGuesses
                + "\nTotal de questões: " + totalQuestions;
        message = message.concat("\n\nSua pontuação foi de " + totalPoints + " pontos\n\n");

        if (totalPoints == 0) {
            message = message.concat("Não foi dessa vez. Tudo bem, "
                    + "você pode voltar aqui após estudar mais um pouquinho :)\n\n");
        }

        if (correctGuesses == totalQuestions) {
            message = message.concat("Parabéns. Você é um expert :)\n\n");
        }

        JOptionPane.showMessageDialog(rootPane,
                message,
                "Pontuação", EXIT_ON_CLOSE);

        FrmQuiz.this.dispose();
    }

    private void disableAnswerButtons() {
        //Desabilita os botões de resposta
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
    }

    private void enableAnswerButtons() {
        //Habilita botões de resposta
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
    }
}
