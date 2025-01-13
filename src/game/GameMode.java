package game;

import javax.swing.JOptionPane;

public class GameMode extends javax.swing.JFrame {
    private boolean lastWinnerPlayer = false; 
    
    public GameMode() {
        initComponents();
    }
    public boolean getLastWinnerPlayer() {
        return lastWinnerPlayer;
    }

    public void setLastWinnerPlayer(boolean lastWinnerPlayer) {
        this.lastWinnerPlayer = lastWinnerPlayer;
    }
    public void updateWinner(boolean isPlayer) {
        lastWinnerPlayer = isPlayer;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BtnExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SPlayer = new javax.swing.JButton();
        Multiplayer = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setkEndColor(new java.awt.Color(60, 3, 132));
        kGradientPanel1.setkStartColor(new java.awt.Color(88, 1, 198));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/ai.png"))); // NOI18N
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Game Mode");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 310, 70));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 0));
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 200, 10));

        BtnExit.setBackground(new java.awt.Color(146, 130, 156));
        BtnExit.setFont(new java.awt.Font("Ebrima", 1, 22)); // NOI18N
        BtnExit.setForeground(new java.awt.Color(255, 255, 255));
        BtnExit.setText("Exit");
        BtnExit.setBorder(new javax.swing.border.MatteBorder(null));
        BtnExit.setFocusable(false);
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });
        kGradientPanel1.add(BtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 230, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/2p.png"))); // NOI18N
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/player.png"))); // NOI18N
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, 110));

        SPlayer.setBackground(new java.awt.Color(79, 250, 255));
        SPlayer.setFont(new java.awt.Font("Ebrima", 1, 22)); // NOI18N
        SPlayer.setForeground(new java.awt.Color(255, 255, 255));
        SPlayer.setText("Single Player");
        SPlayer.setBorder(new javax.swing.border.MatteBorder(null));
        SPlayer.setFocusable(false);
        SPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPlayerActionPerformed(evt);
            }
        });
        kGradientPanel1.add(SPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 230, 50));

        Multiplayer.setBackground(new java.awt.Color(238, 12, 37));
        Multiplayer.setFont(new java.awt.Font("Ebrima", 1, 22)); // NOI18N
        Multiplayer.setForeground(new java.awt.Color(255, 255, 255));
        Multiplayer.setText("Multiplayer");
        Multiplayer.setBorder(new javax.swing.border.MatteBorder(null));
        Multiplayer.setFocusable(false);
        Multiplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultiplayerActionPerformed(evt);
            }
        });
        kGradientPanel1.add(Multiplayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 230, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/pp2.png"))); // NOI18N
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 230, 420));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/icons/pp1.png"))); // NOI18N
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "EXIT", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
           GameFrame gf = new GameFrame();
           gf.setVisible(true);
           this.dispose();
        }       
    }//GEN-LAST:event_BtnExitActionPerformed

    private void SPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPlayerActionPerformed
        PlayerName name = new PlayerName(this);
        name.setVisible(true);
    }//GEN-LAST:event_SPlayerActionPerformed

    private void MultiplayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultiplayerActionPerformed
        FirstPlayer name = new FirstPlayer(this);
        name.setVisible(true);
    }//GEN-LAST:event_MultiplayerActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameMode().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton Multiplayer;
    private javax.swing.JButton SPlayer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}