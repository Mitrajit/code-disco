
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mitrajit
 */
public class Mark extends javax.swing.JFrame {

    /**
     * Creates new form Mark
     */
    Connection con = null;
    Statement stm = null;
    Statement stmt =null;
    ResultSet rs = null,rs2=null;
    String na="";
    java.util.Date date=new java.util.Date();
    java.sql.Date dt=new java.sql.Date(date.getTime());
    int i = 0,max=0; 
    public Mark() {
        con = DatabaseConnection.Connect("root", "work159");
        initComponents();
        try {
            stm = con.createStatement();    
            rs2=stm.executeQuery("SELECT Max(id) FROM `employee`");
                if(rs2.next()){
                    max=rs2.getInt(1);}
                         do{
                rs = stm.executeQuery("SELECT * FROM `employee` WHERE ID='" + (i+1) + "'");
                i++;
            }
            while (!rs.next());
             na=rs.getString("Name");
             name.setText(na);
             //System.out.println(dt);
             stm.executeUpdate("INSERT INTO `REGISTER` (Date) VALUES ('"+dt+"')"); 
             //rs2.close();
             
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.exit(1);
        }
        
        backb.setEnabled(false);
        exitb.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        nextb = new javax.swing.JButton();
        backb = new javax.swing.JButton();
        exitb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mark Attendence");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Mark Attendence of");

        name.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        name.setText("<Name>");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Present", "Absent", "Half Day" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name)
                .addGap(18, 18, 18)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        nextb.setText("Next>");
        nextb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbActionPerformed(evt);
            }
        });

        backb.setText("<Back");
        backb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbActionPerformed(evt);
            }
        });

        exitb.setText("exit");
        exitb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(exitb)
                        .addGap(59, 59, 59)
                        .addComponent(backb)
                        .addGap(56, 56, 56)
                        .addComponent(nextb)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backb)
                    .addComponent(exitb)
                    .addComponent(nextb))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_statusActionPerformed

    private void nextbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbActionPerformed
        // TODO add your handling code here:
        backb.setEnabled(true);
        if (status.getSelectedItem() != null) {
            String st = status.getSelectedItem().toString();
            int a = -1;
            if (st.equalsIgnoreCase("Present")) {
                a = 1;
            } else if (st.equalsIgnoreCase("Absent")) {
                a = 0;
            } else {
                a = 3;
            }
            try {
                stm = con.createStatement();          
                    String sql="UPDATE `register` SET "+na.substring(0,na.indexOf(' ')+1)+"="+a+" WHERE Date='"+dt+"'";
                    stm.executeUpdate(sql);
                if(i<max){
                    do{
                    rs = stm.executeQuery("SELECT * FROM `employee` WHERE ID='" + (i+1) + "'");
                    i++;               
            } while ((!rs.next()));
             na=rs.getString("Name");
             name.setText(na);
             }
                else
                {   nextb.setEnabled(false);
                    exitb.setEnabled(true);
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_nextbActionPerformed

    
    
    private void exitbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbActionPerformed
        // TODO add your handling code here:
        
        try {
                    stm=con.createStatement(rs2.TYPE_SCROLL_INSENSITIVE,rs2.CONCUR_UPDATABLE);
                    int counter=1;
                    rs2=stm.executeQuery("SELECT * FROM `employee`");
                    while(rs2.next()){
                    double dp=rs2.getDouble("Days_Present"); 
                    int st=Secondrs.Grab(counter+2);
                    //System.out.println("yes");
                   if(st==3)
                   {rs2.updateDouble("Days_Present", (dp+0.5));
                    rs2.updateRow();
                   }
                    else
                   { rs2.updateDouble("Days_Present" , (dp+st));
                      rs2.updateRow();}
                    counter++;
                    }
                    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        System.exit(0);
    }//GEN-LAST:event_exitbActionPerformed

    private void backbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbActionPerformed
        // TODO add your handling code here:
        nextb.setEnabled(true);
        try {
                stm = con.createStatement();                
                do{
                    rs = stm.executeQuery("SELECT * FROM `employee` WHERE ID='" + (i-1) + "'");
                    i--;
                
            } while ((!rs.next()));
            na=rs.getString("Name");
             name.setText(na);
             }
    catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_backbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mark().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backb;
    private javax.swing.JButton exitb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    private javax.swing.JButton nextb;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}