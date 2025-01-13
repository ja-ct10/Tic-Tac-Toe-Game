package game;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MultiPlayer extends javax.swing.JFrame {
    
    private String fname;
    private String sname;
    private boolean isPlayerTurn = true; 
    private JButton[] buttons;
    private int pScore = 0;
    private int p2Score = 0;
    private String lastWinner = "Player1";
    
    public MultiPlayer(String fname, String sname) {
        this.fname = fname;
        this.sname = sname;
        initComponents();
        FirstName.setText(fname);
        SecondName.setText(sname);
        buttons = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        Player1Turn.setVisible(true);
        Player2Turn.setVisible(false);
    }
    private void player1Move(JButton button) {
        if (button.getText().isEmpty()) {
            button.setText("X");
            Player1Turn.setVisible(false);
            Player2Turn.setVisible(true);
            isPlayerTurn = false;
            checkGameStatus();
        }
    }
    private void player2Move(JButton button) {
        if (button.getText().isEmpty() && !isPlayerTurn) {
            button.setText("O");
            Player1Turn.setVisible(true);
            Player2Turn.setVisible(false);
            isPlayerTurn = true;
            checkGameStatus();
        }
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
                JOptionPane.showMessageDialog(this, fname + " wins!");
                pScore++;
                Player1Score.setText(String.valueOf(pScore));
                lastWinner = "Player1";
                resetGame();
                return;
            } else if (combination[0].equals("O") && combination[1].equals("O") && combination[2].equals("O")) {
                JOptionPane.showMessageDialog(this, sname + " wins!");
                p2Score++;
                Player2Score.setText(String.valueOf(p2Score));
                lastWinner = "Player2";
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
        if (lastWinner.equals("Player1")) {
            isPlayerTurn = true;
            Player1Turn.setVisible(true);
            Player2Turn.setVisible(false);
        } else if (lastWinner.equals("Player2")) {
            isPlayerTurn = false;
            Player1Turn.setVisible(false);
            Player2Turn.setVisible(true);
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
        FirstName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
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
        Player1Turn = new javax.swing.JLabel();
        Player2Turn = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Player1Score = new javax.swing.JLabel();
        Player2Score = new javax.swing.JLabel();
        SecondName = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

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

        FirstName.setFont(new java.awt.Font("Ebrima", 1, 30)); // NOI18N
        FirstName.setForeground(new java.awt.Color(255, 255, 255));
        FirstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirstName.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        kGradientPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 180, 50));

        jSeparator1.setBackground(new java.awt.Color(60, 3, 132));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 160, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/p2.png"))); // NOI18N
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 120, 110));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Player 2");
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

        Player1Turn.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        Player1Turn.setForeground(new java.awt.Color(255, 255, 255));
        Player1Turn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player1Turn.setText("Player 1 turn");
        kGradientPanel1.add(Player1Turn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 160, -1));

        Player2Turn.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        Player2Turn.setForeground(new java.awt.Color(255, 255, 255));
        Player2Turn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player2Turn.setText("Player 2's turn");
        kGradientPanel1.add(Player2Turn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, 160, -1));

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("X");
        kGradientPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 30, 70));

        Player1Score.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        Player1Score.setForeground(new java.awt.Color(51, 228, 82));
        Player1Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(Player1Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 90, 100));

        Player2Score.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        Player2Score.setForeground(new java.awt.Color(245, 44, 23));
        Player2Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(Player2Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 90, 100));

        SecondName.setFont(new java.awt.Font("Ebrima", 1, 30)); // NOI18N
        SecondName.setForeground(new java.awt.Color(255, 255, 255));
        SecondName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SecondName.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        kGradientPanel1.add(SecondName, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 180, 50));

        jSeparator2.setBackground(new java.awt.Color(60, 3, 132));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, 160, 10));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (isPlayerTurn) {
            player1Move(btn1);
        } else {
            player2Move(btn1);
        }
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
        if (isPlayerTurn) {
            player1Move(btn2);
        } else {
            player2Move(btn2);
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (isPlayerTurn) {
            player1Move(btn3);
        } else {
            player2Move(btn3);
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (isPlayerTurn) {
            player1Move(btn4);
        } else {
            player2Move(btn4);
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (isPlayerTurn) {
            player1Move(btn5);
        } else {
            player2Move(btn5);
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if (isPlayerTurn) {
            player1Move(btn6);
        } else {
            player2Move(btn6);
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (isPlayerTurn) {
            player1Move(btn7);
        } else {
            player2Move(btn7);
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (isPlayerTurn) {
            player1Move(btn8);
        } else {
            player2Move(btn8);
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (isPlayerTurn) {
            player1Move(btn9);
        } else {
            player2Move(btn9);
        }
    }//GEN-LAST:event_btn9ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultiPlayer("Player 1", "Player 2").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnExit;
    private javax.swing.JLabel FirstName;
    private javax.swing.JLabel Player1Score;
    private javax.swing.JLabel Player1Turn;
    private javax.swing.JLabel Player2Score;
    private javax.swing.JLabel Player2Turn;
    private javax.swing.JLabel SecondName;
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
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}