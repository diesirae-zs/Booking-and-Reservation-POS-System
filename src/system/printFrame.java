  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package system;

import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import static system.mainPage.cashTxtFld;
import static system.mainPage.jLabel9;

public class printFrame extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(printFrame.class.getName());
    public printFrame() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        formatTable();
    }
    java.sql.Connection con;
    ResultSet rs;
    PreparedStatement pst;
    java.sql.Statement st;
    public void formatTable(){
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        JTableHeader headerTable=jTable1.getTableHeader();
        headerTable.setVisible(false);
        DefaultTableCellRenderer columnToCenter=new DefaultTableCellRenderer();
        columnToCenter.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(columnToCenter);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(columnToCenter);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(columnToCenter);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(columnToCenter);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(columnToCenter);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(columnToCenter);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(columnToCenter);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(columnToCenter);
        jTable1.setShowGrid(false);
        jScrollPane5.getColumnHeader().setVisible(false);
        jScrollPane5.getViewport().setBackground(Color.WHITE);
    }
    public void tableData() throws IOException{

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/dbforct","root","");
            st=con.createStatement();
            String query ="select * from dbtable";
            rs=st.executeQuery(query);
            while(rs.next()){
                String cdb2=rs.getString("clientDB");
                String tosdb2=rs.getString("tosDB");
                String servicedb2=rs.getString("serviceDB");
                String catdb2=rs.getString("catDB");
                String scheddb2=rs.getString("schedDB");
                String amountdb2=Double.toString(rs.getDouble("amountDB"));
                String psdb2=rs.getString("stylistDB");
                String contactdb2=rs.getString("contactDB");
                
                String tableData[]={cdb2,contactdb2,tosdb2,servicedb2,catdb2,psdb2,scheddb2,amountdb2};
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.addRow(tableData); 
                tableData.toString();
                
                int numrow = jTable1.getRowCount();
                double total = 0;
                for (int i = 0; i < numrow; i++) {
                    double value = Double.valueOf(jTable1.getValueAt(i, 7).toString());
                    total+=value;
                }
                totalAmount.setText(Double.toString(total));
                String cashTxt=String.valueOf(cashTxtFld.getText());
                String changeTxt=String.valueOf(jLabel9.getText());
                cashPrint.setText(cashTxt);
                changePrint.setText(changeTxt);
            }
        } catch (ClassNotFoundException ex) {
            System.getLogger(printFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(printFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        this.revalidate();
                /*BufferedImage receipt = new BufferedImage(printPanel.getWidth(), printPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                printPanel.paint(receipt.getGraphics());
                String path = "/home/r--d/Downloads/image.jpg";
                ImageIO.write(receipt, "jpg", new File(path));
                Desktop.getDesktop().print(new File(path));*/
                PrinterJob job = PrinterJob.getPrinterJob();
    
    job.setPrintable(new Printable() {
        @Override
        public int print(Graphics g, PageFormat pf, int pageIndex) {
            if (pageIndex > 0) return Printable.NO_SUCH_PAGE;
            
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(pf.getImageableX(), pf.getImageableY());
            
            // Scale panel to fit the page
            double scaleX = pf.getImageableWidth() / printPanel.getWidth();
            double scaleY = pf.getImageableHeight() / printPanel.getHeight();
            double scale = Math.min(scaleX, scaleY);
            g2d.scale(scale, scale);
            
            printPanel.printAll(g);
            return Printable.PAGE_EXISTS;
        }
    });
    
    // Show print dialog
    if (job.printDialog()) {
        try {
            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cashPrint = new javax.swing.JLabel();
        changePrint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printPanel.setBackground(new java.awt.Color(255, 255, 255));
        printPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("----------------------------------------------------------------------------------------------------------------------------------------------------");
        jTextArea3.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTextArea3);

        printPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 910, 20));

        jScrollPane3.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("        CLIENT         CONTACT NO.    TYPE OF SERVICE        SERVICE     CATEGORY  STYLIST    RESERVED SCHEDULE     AMOUNT");
        jTextArea4.setAutoscrolls(false);
        jTextArea4.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(jTextArea4);

        printPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 910, 30));

        jScrollPane4.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setText("----------------------------------------------------------------------------------------------------------------------------------------------------");
        jTextArea5.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(jTextArea5);

        printPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 910, 20));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        jTable1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLIENT", "CONTACT NO.", "TYPE OF SERVICE", "SERVICE", "CATEGORY", "PREFERRED STYLIST", "BOOK SCHEDULE", "AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(155);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(117);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(55);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(155);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(107);
        }

        printPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 870, 170));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("                                                                 \n                                                                                          Color Touch Salon Studio\n                                                                                                      Makati City\n                                                                                             example@gmail.com\n                                                                                                  09-000-000-000");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(null);
        jTextArea1.setSelectionColor(new java.awt.Color(0, 0, 0));
        printPanel.add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 900, 220));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("Change:");
        printPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 110, 20));

        totalAmount.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        printPanel.add(totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 140, 30));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel4.setText("Total Amount:");
        printPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 110, 20));

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel5.setText("Cash:");
        printPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 110, 20));

        cashPrint.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        printPanel.add(cashPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 140, 30));

        changePrint.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        printPanel.add(changePrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 140, 30));

        getContentPane().add(printPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.setVisible(false);
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        this.setVisible(false);
        
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            tableData();
        } catch (IOException ex) {
            System.getLogger(printFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new printFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cashPrint;
    private javax.swing.JLabel changePrint;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    public static final javax.swing.JPanel printPanel = new javax.swing.JPanel();
    private javax.swing.JLabel totalAmount;
    // End of variables declaration//GEN-END:variables
}
