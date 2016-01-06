/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Readers.CSVFileReader;
import Server_Manager.HTTPReciever;
import java.awt.event.MouseListener;
import java.io.File;
import javafx.stage.FileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;

/**
 *
 * @author Elize
 */
public class User_Interface extends javax.swing.JFrame {
    
    String path = null;
    String[] types = {"Positions", "Events", "Monitoring", "Connections" };

    /**
     * Creates new form User_Interface
     */
    public User_Interface() {
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addFileBtn = new javax.swing.JButton();
        pathLabel = new javax.swing.JLabel();
        insertingLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sendSignalBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addFileBtn.setText("Add file");
        addFileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addFileBtnMouseClicked(evt);
            }
        });

        pathLabel.setText("your file path");

        insertingLabel.setText("false");

        jLabel1.setText("Inserting:");

        sendSignalBtn.setText("Send Signal");
        sendSignalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendSignalBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertingLabel)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendSignalBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addFileBtn)
                        .addGap(18, 18, 18)
                        .addComponent(pathLabel)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertingLabel)
                    .addComponent(jLabel1))
                .addGap(7, 7, 7)
                .addComponent(sendSignalBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFileBtn)
                    .addComponent(pathLabel))
                .addGap(93, 93, 93))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFileBtnMouseClicked
                                
                JPanel panel = new JPanel();
                panel.add(new JLabel("Please select a file"));
                JButton selectFileBtn = new JButton();
                selectFileBtn.setText("Browse");
                selectFileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new java.io.File("."));
                    chooser.setDialogTitle("Select a csv file:");
                    //chooser.setAcceptAllFileFilterUsed(false);
                        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                         pathLabel.setText(chooser.getSelectedFile().getAbsolutePath());
                         path = chooser.getSelectedFile().getAbsolutePath();
                         System.out.println(path);
                        }else{
                            pathLabel.setText("No Selection");
                          path = null;
                        }
                    }
                });
                panel.add(selectFileBtn);
                
                panel.add(new JLabel("Please select a type"));
                DefaultComboBoxModel model = new DefaultComboBoxModel();             
                for(int i = 0; i < types.length; i++){
                    model.addElement(types[i]);
                }
                
                JComboBox comboBox = new JComboBox(model);
                panel.add(comboBox);
                int result = JOptionPane.showConfirmDialog(null, panel, "Insert new file:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if(result == JOptionPane.OK_OPTION){
                    CSVFileReader.readFileByType((String) comboBox.getSelectedItem(), path);
                }   
    }//GEN-LAST:event_addFileBtnMouseClicked

    private void sendSignalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendSignalBtnMouseClicked
        HTTPReciever.sentSignal();
    }//GEN-LAST:event_sendSignalBtnMouseClicked

    public void setInsertingLabelText(String text){
        insertingLabel.setText(text);
    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFileBtn;
    private javax.swing.JLabel insertingLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JButton sendSignalBtn;
    // End of variables declaration//GEN-END:variables
}
