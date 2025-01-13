package game;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SinglePlayer extends javax.swing.JFrame {
    
    private GameMode gm;
    private String playername;
    private boolean isPlayerTurn;
    private JButton[] buttons;
    private int playerScore = 0, compScore = 0;
    private boolean lastWinnerPlayer;
    
    public SinglePlayer(String playername, boolean lastWinnerPlayer, GameMode gm) {
        this.playername = playername;
        this.lastWinnerPlayer = lastWinnerPlayer; 
        this.gm = gm;
        initComponents();
        Name.setText(playername);
        buttons = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        updateTurnDisplay(lastWinnerPlayer);
    }
    private void playerMove(JButton button) {
        if (button.getText().isEmpty()) {
            button.setText("X");
            PlayerTurn.setVisible(false);
            ComputerTurn.setVisible(true);
            isPlayerTurn = false;
            checkGameStatus();
            SwingUtilities.invokeLater(() -> {
                try {
                    Thread.sleep(1000);
                    computerMove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    private void computerMove() {
        if (!isPlayerTurn) {
            JButton bestMove = getBestMove();
            if (bestMove != null) {
                bestMove.setText("O");
                isPlayerTurn = true;
                checkGameStatus();
                PlayerTurn.setVisible(true);
                ComputerTurn.setVisible(false);
            }
        }
    }
    private JButton getBestMove() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                button.setText("O");
                if (isWinningMove("O")) {
                    button.setText("");
                    return button;
                }
                button.setText("");
            }
        }
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                button.setText("X");
                if (isWinningMove("X")) {
                    button.setText("");
                    return button;
                }
                button.setText("");
            }
        }
        List<JButton> availableButtons = new ArrayList<>();
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                availableButtons.add(button);
            }
        }
        return availableButtons.isEmpty() ? null : availableButtons.get(new Random().nextInt(availableButtons.size()));
    }
    private boolean isWinningMove(String mark) {
        String[][] winningCombinations = {
            {btn1.getText(), btn2.getText(), btn3.getText()},
            {btn4.getText(), btn5.getText(), btn6.getText()},
            {btn7.getText(), btn8.getText(), btn9.getText()},
            {btn1.getText(), btn4.getText(), btn7.getText()},
            {btn2.getText(), btn5.getText(), btn8.getText()},
            {btn3.getText(), btn6.getText(), btn9.getText()},
            {btn1.getText(), btn5.getText(), btn9.getText()},
            {btn3.getText(), btn5.getText(), btn7.getText()}
        };

        for (String[] combination : winningCombinations) {
            if (combination[0].equals(mark) && combination[1].equals(mark) && combination[2].equals(mark)) {
                return true;
            }
        }
        return false;
    }
    private void checkGameStatus() {
        String[][] winningCombinations = {
            {btn1.getText(), btn2.getText(), btn3.getText()},
            {btn4.getText(), btn5.getText(), btn6.getText()},
            {btn7.getText(), btn8.getText(), btn9.getText()},
            {btn1.getText(), btn4.getText(), btn7.getText()},
            {btn2.getText(), btn5.getText(), btn8.getText()},
            {btn3.getText(), btn6.getText(), btn9.getText()},
            {btn1.getText(), btn5.getText(), btn9.getText()},
            {btn3.getText(), btn5.getText(), btn7.getText()}
        };

        for (String[] combination : winningCombinations) {
            if (combination[0].equals("X") && combination[1].equals("X") && combination[2].equals("X")) {
                JOptionPane.showMessageDialog(this, playername + " wins!");
                playerScore++;
                PlayerScore.setText(String.valueOf(playerScore));
                gm.updateWinner(true);
                lastWinnerPlayer = true; 
                resetGame();
                return;
            } else if (combination[0].equals("O") && combination[1].equals("O") && combination[2].equals("O")) {
                JOptionPane.showMessageDialog(this, "Computer wins!");
                compScore++;
                ComputerScore.setText(String.valueOf(compScore));
                gm.updateWinner(false);
                lastWinnerPlayer = false; 
                resetGame();
                return;
            }
        }
        boolean allFilled = true;
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                allFilled = false;
                break;
            }
        }
        if (allFilled) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetGame();
        }
    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
        }
        updateTurnDisplay(lastWinnerPlayer);
    }

    private void updateTurnDisplay(boolean playerStarts) {
        isPlayerTurn = playerStarts;
        PlayerTurn.setVisible(playerStarts);
        ComputerTurn.setVisible(!playerStarts);

        if (!playerStarts) {
            SwingUtilities.invokeLater(() -> {
                try {
                    Thread.sleep(1000);
                    computerMove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        BtnExit = new javax.swing.JLabel();
        PlayerTurn = new javax.swing.JLabel();
        ComputerTurn = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        PlayerScore = new javax.swing.JLabel();
        ComputerScore = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(60, 3, 132));
        kGradientPanel1.setkStartColor(new java.awt.Color(88, 1, 198));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 217, 103));
        jLabel1.setText("TIC");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 60, 30));

        jLabel3.setFont(new java.awt.Font("Eras Bold ITC", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(79, 250, 255));
        jLabel3.setText("TOE");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 530, 70, 30));

        jLabel5.setFont(new java.awt.Font("Eras Bold ITC", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(231, 115, 255));
        jLabel5.setText("TAC");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 70, 30));

        Name.setFont(new java.awt.Font("Ebrima", 1, 30)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        kGradientPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 180, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/robot.png"))); // NOI18N
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 160, 110));

        jSeparator1.setBackground(new java.awt.Color(60, 3, 132));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 160, 10));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Computer");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 170, 70));

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("-");
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 20, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/player.png"))); // NOI18N
        kGradientPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 120, 110));

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Player 1");
        kGradientPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 140, 70));

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("O");
        kGradientPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 30, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn1.setBackground(new java.awt.Color(60, 3, 132));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn1.setForeground(new java.awt.Color(245, 44, 23));
        btn1.setBorder(null);
        btn1.setFocusable(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(60, 3, 132));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn2.setForeground(new java.awt.Color(245, 44, 23));
        btn2.setBorder(null);
        btn2.setFocusable(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(60, 3, 132));
        btn3.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn3.setForeground(new java.awt.Color(245, 44, 23));
        btn3.setBorder(null);
        btn3.setFocusable(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(60, 3, 132));
        btn4.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn4.setForeground(new java.awt.Color(245, 44, 23));
        btn4.setBorder(null);
        btn4.setFocusable(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(60, 3, 132));
        btn5.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn5.setForeground(new java.awt.Color(245, 44, 23));
        btn5.setFocusable(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(60, 3, 132));
        btn6.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn6.setForeground(new java.awt.Color(245, 44, 23));
        btn6.setFocusable(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(60, 3, 132));
        btn7.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn7.setForeground(new java.awt.Color(245, 44, 23));
        btn7.setBorder(null);
        btn7.setFocusable(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(60, 3, 132));
        btn8.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn8.setForeground(new java.awt.Color(245, 44, 23));
        btn8.setFocusable(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(60, 3, 132));
        btn9.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        btn9.setForeground(new java.awt.Color(245, 44, 23));
        btn9.setFocusable(false);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 490, 400));

        BtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/exit button.png"))); // NOI18N
        BtnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnExitMousePressed(evt);
            }
        });
        kGradientPanel1.add(BtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, -1, -1));

        PlayerTurn.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        PlayerTurn.setForeground(new java.awt.Color(255, 255, 255));
        PlayerTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerTurn.setText("Player's turn");
        kGradientPanel1.add(PlayerTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 160, -1));

        ComputerTurn.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        ComputerTurn.setForeground(new java.awt.Color(255, 255, 255));
        ComputerTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ComputerTurn.setText("Computer's turn");
        kGradientPanel1.add(ComputerTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 160, -1));

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("X");
        kGradientPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 30, 70));

        PlayerScore.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        PlayerScore.setForeground(new java.awt.Color(51, 228, 82));
        PlayerScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(PlayerScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 90, 100));

        ComputerScore.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        ComputerScore.setForeground(new java.awt.Color(245, 44, 23));
        ComputerScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(ComputerScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 90, 100));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        playerMove(btn1);
    }//GEN-LAST:event_btn1ActionPerformed

    private void BtnExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnExitMousePressed
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "EXIT", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            GameMode gm = new GameMode();
            gm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtnExitMousePressed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        playerMove(btn2);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        playerMove(btn3);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        playerMove(btn4);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        playerMove(btn5);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        playerMove(btn6);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        playerMove(btn7);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        playerMove(btn8);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        playerMove(btn9);
    }//GEN-LAST:event_btn9ActionPerformed
    public static void main(String args[]) {
        boolean lastWinnerPlayer = false;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinglePlayer("", lastWinnerPlayer, new GameMode()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnExit;
    private javax.swing.JLabel ComputerScore;
    private javax.swing.JLabel ComputerTurn;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel PlayerScore;
    private javax.swing.JLabel PlayerTurn;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}