package game;

import javax.swing.JOptionPane;

public class Game {

    public static void main(String[] args) {
  
        LoadingFrame load = new LoadingFrame();
        load.setVisible(true);
        GameFrame gf = new GameFrame();
        gf.setVisible(false);
    
        try {
            for(int i = 0; i <= 100; i++) {
                Thread.sleep(100);
                load.jLabel1.setText(i + "%");
                load.LoadingBar.setValue(i);
            
                if(i == 10) {
                    load.jLabel2.setText("Preparing Game...");
                }
                if(i == 20) {
                    load.jLabel2.setText("Loading Modules...");
                }
                if(i == 50) {
                    load.jLabel2.setText("Connecting to Server...");
                }
                if(i == 70) {
                    load.jLabel2.setText("Connection Successfully...");
                }
                if(i == 80) {
                    load.jLabel2.setText("Waiting to Launch...");
                }
                if(i == 100) {
                    load.setVisible(false);
                    gf.setVisible(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}