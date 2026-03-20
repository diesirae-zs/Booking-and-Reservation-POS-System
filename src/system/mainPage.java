
package system;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import system.adminPage;
import system.printFrame;
import static system.printFrame.printPanel;
import static system.printFrame.jTable1;

public class mainPage extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(mainPage.class.getName());
    public mainPage() {
        initComponents();
        this.setResizable(false);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        try {
            File firs =new File("/home/r--d/red/programming/java/images-for-system/1.jpg");
            File secon =new File("/home/r--d/red/programming/java/images-for-system/2.jpg");
            BufferedImage firstImage = ImageIO.read(firs);
            BufferedImage secondImage = ImageIO.read(secon);
            int width=470; int height=650;
            Image resizedFirstImage = firstImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            Image resizedSecondImage = secondImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon iconFirst=new ImageIcon(resizedFirstImage);
            ImageIcon iconSecond=new ImageIcon(resizedSecondImage);
            jLabel73.setIcon(iconFirst);
            jLabel77.setIcon(iconSecond);

        } catch (IOException ex) {
            System.getLogger(mainPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        try {
            File log = new File("/home/r--d/red/programming/java/images-for-system/logo.jpg");
            BufferedImage logoImage = ImageIO.read(log);
            int width=400; int height=400;
            Image resizedLogoImage = logoImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon logoFinal=new ImageIcon(resizedLogoImage);
            jLabel2.setIcon(logoFinal);
        } catch (IOException ex) {
            System.getLogger(mainPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    Statement st;
    
//========================================CLASSES=============================================  
    public void calculateTotal(){
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
        int numrow = jTable2.getRowCount();
        double total = 0;
        for (int g = 0; g < numrow; g++) {
            double val = Double.valueOf(jTable2.getValueAt(g, 6).toString());
            total+=val;
        }
        totalText.setText(Double.toString(total));
    }
    public void ItemCost()
    {
        double sum = 0;
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
        sum = Double.parseDouble(tableModel2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        String total = String.valueOf(sum);
        totalText.setText(total);
    }
    public void Change(){
        double amount = 0;
        double cash = Double.parseDouble(cashTxtFld.getText()); 
        amount = Double.parseDouble(totalText.getText());
        double change = cash - amount;
        String changeTextField = String.format("%.1f", change);
        jLabel9.setText(changeTextField);
    } 
    public void fWO(){
            //===============================TABLE FWO==========================================//
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st=con.createStatement();
            String query="select * from dbstylistadmin";
            rs=st.executeQuery(query);
            while(rs.next()){
                String stylistdb=rs.getString("stylistDB");
                jComboBox1.addItem(stylistdb);
                jComboBox2.addItem(stylistdb);
                jComboBox3.addItem(stylistdb);
                jComboBox4.addItem(stylistdb);
                jComboBox5.addItem(stylistdb);
                jComboBox6.addItem(stylistdb);
                jComboBox7.addItem(stylistdb);
            }
            /*Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            String query = "select * from dbtable";
            rs=st.executeQuery(query);
            while(rs.next()){
                String iddb= String.valueOf(rs.getInt("idDB"));
                String cdb=rs.getString("clientDB");
                String tosdb=rs.getString("tosDB");
                String servicedb=rs.getString("serviceDB");
                String catdb=rs.getString("catDB");
                String scheddb=rs.getString("schedDB");
                String amountdb=Double.toString(rs.getDouble("amountDB"));
                String psdb=rs.getString("stylistDB");
                String contactdb=rs.getString("contactDB");
                
                String tableData[]={iddb,cdb,tosdb,servicedb,catdb,scheddb,amountdb,psdb,contactdb};
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.addRow(tableData);    
            }*/
            
            String queryCredentialDisplay="select * from acctable";
            rs=st.executeQuery(queryCredentialDisplay);
            while (rs.next()){
                String signindb=rs.getString("signinidDB");
                String userdb=rs.getString("usernameDB");
                String passdb=rs.getString("passwordDB");
                jLabel79.setText(signindb);
                jLabel80.setText(userdb);
                /*jPasswordField1.setText(passdb);
                jPasswordField1.setEditable(false);*/
            }
            
            //=============RESERVED CLIENT TABLE==============================//
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root","");
            st=con.createStatement();
            String query2="select * from dbtable2";
            rs=st.executeQuery(query2);
            while (rs.next()){
                String iddb3=String.valueOf(rs.getInt("idDB"));
                String cdb3=rs.getString("clientDB");
                String tosdb3=rs.getString("tosDB");
                String servicedb3=rs.getString("serviceDB");
                String catdb3=rs.getString("catDB");
                String scheddb3=rs.getString("schedDB");
                String amountdb3=Double.toString(rs.getDouble("amountDB"));
                String psdb3=rs.getString("stylistDB");
                String contactdb3=rs.getString("contactDB");
                
                String tableData3[]={iddb3,cdb3,tosdb3,servicedb3,catdb3,scheddb3,amountdb3,psdb3,contactdb3};
                DefaultTableModel tableModel3 = (DefaultTableModel) reservedTable.getModel();
                reservedTable.setShowGrid(false);
                tableModel3.addRow(tableData3);    
            }
            
            //================================================================//
            
            //=========================================================================//
            //================================AMOUNT TOTAL TEXT===================//
           calculateTotal();
            //====================================================================//
            //==============================EDITABLE & UNEDTIABLE================================//
            DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
            int emptyTable = jTable2.getRowCount();
            if(emptyTable<0){
                uneditableField();
            }
            else if(emptyTable>=0){
                editableField();
            }
            //-----------------------------------------------------------------------------------//
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
}
        //=====================================SET FIELD UNEDITABLE==================================================//
        public void uneditableField(){
            cashTxtFld.setEditable(false);
        }
        //===========================================================================================================//
        
        //=====================================SET FIELD UNEDITABLE==================================================//
        public void editableField(){
            cashTxtFld.setEditable(true);
        }
        //===========================================================================================================//
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        reservedTable = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        haircutPane = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        purchaseAddBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel83 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton30 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        colorPane = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        purchaseAddBtn1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        traditionalhighlightsPane = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel42 = new javax.swing.JLabel();
        jCheckBox21 = new javax.swing.JCheckBox();
        jLabel43 = new javax.swing.JLabel();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        purchaseAddBtn3 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        treatmentPane = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel60 = new javax.swing.JLabel();
        jCheckBox38 = new javax.swing.JCheckBox();
        jLabel61 = new javax.swing.JLabel();
        jCheckBox39 = new javax.swing.JCheckBox();
        jCheckBox40 = new javax.swing.JCheckBox();
        purchaseAddBtn5 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jCheckBox41 = new javax.swing.JCheckBox();
        jCheckBox42 = new javax.swing.JCheckBox();
        jCheckBox43 = new javax.swing.JCheckBox();
        jCheckBox44 = new javax.swing.JCheckBox();
        jCheckBox45 = new javax.swing.JCheckBox();
        jCheckBox46 = new javax.swing.JCheckBox();
        jCheckBox47 = new javax.swing.JCheckBox();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel90 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        basicstylingPane = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        purchaseAddBtn2 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel91 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        formandtexturePane = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel51 = new javax.swing.JLabel();
        jCheckBox29 = new javax.swing.JCheckBox();
        jLabel52 = new javax.swing.JLabel();
        jCheckBox30 = new javax.swing.JCheckBox();
        jCheckBox31 = new javax.swing.JCheckBox();
        purchaseAddBtn4 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jCheckBox32 = new javax.swing.JCheckBox();
        jCheckBox33 = new javax.swing.JCheckBox();
        jCheckBox34 = new javax.swing.JCheckBox();
        jCheckBox35 = new javax.swing.JCheckBox();
        jCheckBox36 = new javax.swing.JCheckBox();
        jCheckBox37 = new javax.swing.JCheckBox();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel92 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        nailcarePane = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jLabel69 = new javax.swing.JLabel();
        jCheckBox48 = new javax.swing.JCheckBox();
        jCheckBox49 = new javax.swing.JCheckBox();
        purchaseAddBtn6 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jCheckBox51 = new javax.swing.JCheckBox();
        jCheckBox52 = new javax.swing.JCheckBox();
        jCheckBox55 = new javax.swing.JCheckBox();
        jCheckBox56 = new javax.swing.JCheckBox();
        jCheckBox57 = new javax.swing.JCheckBox();
        jCheckBox58 = new javax.swing.JCheckBox();
        jCheckBox59 = new javax.swing.JCheckBox();
        jCheckBox60 = new javax.swing.JCheckBox();
        jCheckBox61 = new javax.swing.JCheckBox();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel93 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        accountPane = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel85 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setVerticalScrollBar(jScrollBar1);

        jPanel1.setBackground(new java.awt.Color(36, 36, 36));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Services");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 220, 30));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("Nail Care");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 180, 140));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Basic Styling");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 180, 90));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Form & Texture");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, 40));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Treatment");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 180, 90));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Haircut");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 140));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Color");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 180, 140));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Traditional Highlights");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 280, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 810, 230));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cash:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 60));

        cashTxtFld.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cashTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashTxtFldActionPerformed(evt);
            }
        });
        jPanel3.add(cashTxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 260, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Change:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 80));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 260, 30));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Clear");
        jLabel70.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel70MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel70MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel70MouseExited(evt);
            }
        });
        jPanel9.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 100, 50));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pay");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 500, 140));

        jScrollPane3.setBorder(null);
        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Client Name", "Type of Service", "Service", "Category", "Book Schedule", "Amount", "Preferred Stylist", "Contact No."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTable2HierarchyChanged(evt);
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(55);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(125);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(73);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(106);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(79);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(95);
            jTable2.getColumnModel().getColumn(8).setPreferredWidth(119);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 810, 140));

        reservedTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reservedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Client Name", "Type of Service", "Service", "Category", "Book Schedule", "Amount", "Preferred Stylist", "Contact No."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reservedTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservedTable.setShowGrid(true);
        reservedTable.getTableHeader().setReorderingAllowed(false);
        reservedTable.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                reservedTableHierarchyChanged(evt);
            }
        });
        reservedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservedTableMouseClicked(evt);
            }
        });
        reservedTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reservedTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(reservedTable);
        if (reservedTable.getColumnModel().getColumnCount() > 0) {
            reservedTable.getColumnModel().getColumn(0).setPreferredWidth(55);
            reservedTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            reservedTable.getColumnModel().getColumn(2).setPreferredWidth(125);
            reservedTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            reservedTable.getColumnModel().getColumn(4).setPreferredWidth(73);
            reservedTable.getColumnModel().getColumn(5).setPreferredWidth(106);
            reservedTable.getColumnModel().getColumn(6).setPreferredWidth(79);
            reservedTable.getColumnModel().getColumn(7).setPreferredWidth(95);
            reservedTable.getColumnModel().getColumn(8).setPreferredWidth(119);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 900, 1320, 240));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Reserved clients");
        jPanel1.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 860, -1, -1));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("Delete row");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 700, 150, 50));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("Clear table");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 700, 150, 50));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("total:");
        jPanel1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, 60, 30));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("P");
        jPanel1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 660, -1, 40));

        totalText.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        totalText.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(totalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, 240, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Extra service amount:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, 30));

        jTabbedPane2.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel5.setDoubleBuffered(false);

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel73);

        jTabbedPane2.addTab("Page 1", jPanel5);

        jPanel7.add(jLabel77);

        jTabbedPane2.addTab("Page 2", jPanel7);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 490, 690));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, -50, 430, 380));

        jPanel8.setBackground(new java.awt.Color(36, 36, 36));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Admin account");
        jLabel72.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel72MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel72MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel72MouseExited(evt);
            }
        });
        jPanel8.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, 140, 40));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 650, 150, 40));

        jPanel6.setBackground(new java.awt.Color(36, 36, 36));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Confirm");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 650, 80, 40));

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setText("Confirm transaction");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 750, 300, 50));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Client reservation");
        jPanel1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jScrollBar1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollBar1.setBlockIncrement(100);
        jScrollBar1.setUnitIncrement(100);
        jScrollBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 10, 2200));

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton11.setText("Delete data");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1150, 200, 40));

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton14.setText("Clear data");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 1150, 280, 40));

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("tab1", jScrollPane1);

        haircutPane.setBackground(new java.awt.Color(102, 102, 102));
        haircutPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Haircut");
        haircutPane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));
        haircutPane.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 1120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Client Information");
        haircutPane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Full Name:");
        haircutPane.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 40));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        haircutPane.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 250, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contact:");
        haircutPane.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 60));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Stylist price:");
        haircutPane.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, 60));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haircutPane.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 250, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Appointment:");
        haircutPane.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 70));

        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haircutPane.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 250, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Haircut");
        haircutPane.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Senior Stylist");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        haircutPane.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Creative Director");
        jCheckBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        haircutPane.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Category");
        haircutPane.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        buttonGroup2.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Men");
        jCheckBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        haircutPane.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, -1, -1));

        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Women");
        jCheckBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        haircutPane.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, -1, -1));

        purchaseAddBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        purchaseAddBtn.setText("Add");
        purchaseAddBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseAddBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseAddBtnActionPerformed(evt);
            }
        });
        haircutPane.add(purchaseAddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 690, 610, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("<");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        haircutPane.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        haircutPane.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, 40));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Stylist:");
        haircutPane.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 140, 60));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        haircutPane.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, 30));

        jButton30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton30.setText("Clear");
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        haircutPane.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 150, 40));

        jButton54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton54.setText("Set to all services");
        jButton54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        haircutPane.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 260, 40));

        jTabbedPane1.addTab("tab2", haircutPane);

        colorPane.setBackground(new java.awt.Color(102, 102, 102));
        colorPane.setForeground(new java.awt.Color(255, 255, 255));
        colorPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorPaneMouseClicked(evt);
            }
        });
        colorPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 0));
        jLabel18.setText("Color");
        colorPane.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));
        colorPane.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 1140, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Client Information");
        colorPane.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Full Name:");
        colorPane.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 40));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorPane.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 250, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Contact:");
        colorPane.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 60));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Stylist:");
        colorPane.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 210, 60));

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorPane.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 250, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Appointment:");
        colorPane.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 70));

        jDateChooser2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorPane.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 250, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Color");
        colorPane.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("L Oreal");
        jCheckBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorPane.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Category");
        colorPane.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setText("Short");
        jCheckBox7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorPane.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, -1, -1));

        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setText("Long");
        jCheckBox8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorPane.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, -1, -1));

        purchaseAddBtn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        purchaseAddBtn1.setText("Add");
        purchaseAddBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseAddBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseAddBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseAddBtn1ActionPerformed(evt);
            }
        });
        colorPane.add(purchaseAddBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 693, 610, 40));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 153, 153));
        jLabel26.setText("<");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        colorPane.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        buttonGroup1.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox10.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setText("Matrix");
        jCheckBox10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });
        colorPane.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        buttonGroup1.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox11.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox11.setText("Davines");
        jCheckBox11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorPane.add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        buttonGroup2.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setText("Extra");
        jCheckBox9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorPane.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, -1, -1));

        buttonGroup2.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox12.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox12.setText("Medium");
        jCheckBox12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorPane.add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorPane.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, 40));

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Stylist price:");
        colorPane.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, 60));
        colorPane.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, 30));

        jButton29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton29.setText("Clear");
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        colorPane.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 150, 40));

        jButton53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton53.setText("Set to all services");
        jButton53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        colorPane.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 260, 40));

        jTabbedPane1.addTab("tab2", colorPane);

        traditionalhighlightsPane.setBackground(new java.awt.Color(102, 102, 102));
        traditionalhighlightsPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        traditionalhighlightsPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(153, 0, 0));
        jLabel36.setText("Traditional Highlights");
        traditionalhighlightsPane.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));
        traditionalhighlightsPane.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 960, 30));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Client Information");
        traditionalhighlightsPane.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Full Name:");
        traditionalhighlightsPane.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 40));
        traditionalhighlightsPane.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 250, 40));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Contact:");
        traditionalhighlightsPane.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 60));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Stylist:");
        traditionalhighlightsPane.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 210, 60));
        traditionalhighlightsPane.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 250, 40));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Appointment:");
        traditionalhighlightsPane.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 70));
        traditionalhighlightsPane.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 250, 40));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("Highlights");
        traditionalhighlightsPane.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        buttonGroup1.add(jCheckBox21);
        jCheckBox21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox21.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox21.setText("Balayage");
        jCheckBox21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        traditionalhighlightsPane.add(jCheckBox21, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setText("Category");
        traditionalhighlightsPane.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        buttonGroup2.add(jCheckBox22);
        jCheckBox22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox22.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox22.setText("Short");
        jCheckBox22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        traditionalhighlightsPane.add(jCheckBox22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, -1, -1));

        buttonGroup2.add(jCheckBox23);
        jCheckBox23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox23.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox23.setText("Long");
        jCheckBox23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        traditionalhighlightsPane.add(jCheckBox23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, -1, -1));

        purchaseAddBtn3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        purchaseAddBtn3.setText("Add");
        purchaseAddBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseAddBtn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseAddBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseAddBtn3ActionPerformed(evt);
            }
        });
        traditionalhighlightsPane.add(purchaseAddBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 690, 610, 40));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(153, 153, 153));
        jLabel44.setText("<");
        jLabel44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        traditionalhighlightsPane.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        buttonGroup1.add(jCheckBox24);
        jCheckBox24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox24.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox24.setText("Fashion Color");
        jCheckBox24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox24ActionPerformed(evt);
            }
        });
        traditionalhighlightsPane.add(jCheckBox24, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        buttonGroup1.add(jCheckBox25);
        jCheckBox25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox25.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox25.setText("Balayage Ombre");
        jCheckBox25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        traditionalhighlightsPane.add(jCheckBox25, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        buttonGroup2.add(jCheckBox26);
        jCheckBox26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox26.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox26.setText("Extra");
        jCheckBox26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        traditionalhighlightsPane.add(jCheckBox26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, -1, -1));

        buttonGroup2.add(jCheckBox27);
        jCheckBox27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox27.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox27.setText("Medium");
        jCheckBox27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        traditionalhighlightsPane.add(jCheckBox27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, -1, -1));

        buttonGroup1.add(jCheckBox28);
        jCheckBox28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox28.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox28.setText("Metallic Color");
        jCheckBox28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox28ActionPerformed(evt);
            }
        });
        traditionalhighlightsPane.add(jCheckBox28, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        traditionalhighlightsPane.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, 40));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Stylist price:");
        traditionalhighlightsPane.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, 60));
        traditionalhighlightsPane.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, 30));

        jButton28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton28.setText("Clear");
        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        traditionalhighlightsPane.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 150, 40));

        jButton52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton52.setText("Set to all services");
        jButton52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        traditionalhighlightsPane.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 260, 40));

        jTabbedPane1.addTab("tab2", traditionalhighlightsPane);

        treatmentPane.setBackground(new java.awt.Color(102, 102, 102));
        treatmentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(153, 0, 0));
        jLabel54.setText("Treatment");
        treatmentPane.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));
        treatmentPane.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 1090, 30));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setText("Client Information");
        treatmentPane.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Full Name:");
        treatmentPane.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 40));

        jTextField17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        treatmentPane.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 250, 40));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Contact:");
        treatmentPane.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 60));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Stylist:");
        treatmentPane.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 210, 60));

        jTextField18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        treatmentPane.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 250, 40));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Appointment:");
        treatmentPane.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 70));

        jDateChooser6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        treatmentPane.add(jDateChooser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 250, 40));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setText("Treatment");
        treatmentPane.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        buttonGroup1.add(jCheckBox38);
        jCheckBox38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox38.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox38.setText("Collagen Keratin Treatment");
        jCheckBox38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treatmentPane.add(jCheckBox38, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setText("Category");
        treatmentPane.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        buttonGroup2.add(jCheckBox39);
        jCheckBox39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox39.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox39.setText("Short");
        jCheckBox39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treatmentPane.add(jCheckBox39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, -1, -1));

        buttonGroup2.add(jCheckBox40);
        jCheckBox40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox40.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox40.setText("Long");
        jCheckBox40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treatmentPane.add(jCheckBox40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, -1, -1));

        purchaseAddBtn5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        purchaseAddBtn5.setText("Add");
        purchaseAddBtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseAddBtn5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseAddBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseAddBtn5ActionPerformed(evt);
            }
        });
        treatmentPane.add(purchaseAddBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 690, 610, 40));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(153, 153, 153));
        jLabel62.setText("<");
        jLabel62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel62MouseClicked(evt);
            }
        });
        treatmentPane.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        buttonGroup1.add(jCheckBox41);
        jCheckBox41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox41.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox41.setText("Nou-Nou Organic");
        jCheckBox41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox41ActionPerformed(evt);
            }
        });
        treatmentPane.add(jCheckBox41, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, -1, -1));

        buttonGroup1.add(jCheckBox42);
        jCheckBox42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox42.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox42.setText("Hair Spa L Oreal");
        jCheckBox42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treatmentPane.add(jCheckBox42, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        buttonGroup2.add(jCheckBox43);
        jCheckBox43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox43.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox43.setText("Extra");
        jCheckBox43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treatmentPane.add(jCheckBox43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, -1, -1));

        buttonGroup2.add(jCheckBox44);
        jCheckBox44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox44.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox44.setText("Medium");
        jCheckBox44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treatmentPane.add(jCheckBox44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, -1, -1));

        buttonGroup1.add(jCheckBox45);
        jCheckBox45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox45.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox45.setText("Brazilian Treatment");
        jCheckBox45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox45ActionPerformed(evt);
            }
        });
        treatmentPane.add(jCheckBox45, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        buttonGroup1.add(jCheckBox46);
        jCheckBox46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox46.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox46.setText("Color Mask Treatment");
        jCheckBox46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox46ActionPerformed(evt);
            }
        });
        treatmentPane.add(jCheckBox46, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        buttonGroup1.add(jCheckBox47);
        jCheckBox47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox47.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox47.setText("Olapex Treatment");
        jCheckBox47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treatmentPane.add(jCheckBox47, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treatmentPane.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, 40));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Stylist price:");
        treatmentPane.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, 60));
        treatmentPane.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, 30));

        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton19.setText("Clear");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        treatmentPane.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 150, 40));

        jButton51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton51.setText("Set to all services");
        jButton51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        treatmentPane.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 260, 40));

        jTabbedPane1.addTab("tab2", treatmentPane);

        basicstylingPane.setBackground(new java.awt.Color(102, 102, 102));
        basicstylingPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 0, 0));
        jLabel27.setText("Basic Styling");
        basicstylingPane.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));
        basicstylingPane.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 1060, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Client Information");
        basicstylingPane.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Full Name:");
        basicstylingPane.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 40));

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basicstylingPane.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 250, 40));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Contact:");
        basicstylingPane.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 60));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Stylist:");
        basicstylingPane.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 210, 60));

        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basicstylingPane.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 250, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Appointment:");
        basicstylingPane.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, 50));

        jDateChooser3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basicstylingPane.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 250, 40));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Basic Styling");
        basicstylingPane.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        buttonGroup1.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox13.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox13.setText("Shampoo Blowdry");
        jCheckBox13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        basicstylingPane.add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Category");
        basicstylingPane.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        buttonGroup2.add(jCheckBox14);
        jCheckBox14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox14.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox14.setText("Short");
        jCheckBox14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        basicstylingPane.add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, -1, -1));

        buttonGroup2.add(jCheckBox15);
        jCheckBox15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox15.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox15.setText("Long");
        jCheckBox15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        basicstylingPane.add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, -1, -1));

        purchaseAddBtn2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        purchaseAddBtn2.setText("Add");
        purchaseAddBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseAddBtn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseAddBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseAddBtn2ActionPerformed(evt);
            }
        });
        basicstylingPane.add(purchaseAddBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 690, 610, 40));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("<");
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });
        basicstylingPane.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        buttonGroup1.add(jCheckBox16);
        jCheckBox16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox16.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox16.setText("Shampoo Upstyle");
        jCheckBox16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });
        basicstylingPane.add(jCheckBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        buttonGroup1.add(jCheckBox17);
        jCheckBox17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox17.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox17.setText("Shampoo & Iron");
        jCheckBox17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });
        basicstylingPane.add(jCheckBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        buttonGroup2.add(jCheckBox18);
        jCheckBox18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox18.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox18.setText("Extra");
        jCheckBox18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        basicstylingPane.add(jCheckBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, -1, -1));

        buttonGroup2.add(jCheckBox19);
        jCheckBox19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox19.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox19.setText("Medium");
        jCheckBox19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        basicstylingPane.add(jCheckBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, -1, -1));

        buttonGroup1.add(jCheckBox20);
        jCheckBox20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox20.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox20.setText("Shampoo & Settings");
        jCheckBox20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox20ActionPerformed(evt);
            }
        });
        basicstylingPane.add(jCheckBox20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        jComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        basicstylingPane.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, 40));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("Stylist price:");
        basicstylingPane.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, 60));
        basicstylingPane.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, 30));

        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton18.setText("Clear");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        basicstylingPane.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 150, 40));

        jButton49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton49.setText("Set to all services");
        jButton49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        basicstylingPane.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 260, 40));

        jTabbedPane1.addTab("tab2", basicstylingPane);

        formandtexturePane.setBackground(new java.awt.Color(102, 102, 102));
        formandtexturePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(153, 0, 0));
        jLabel45.setText("Form & Texture");
        formandtexturePane.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));
        formandtexturePane.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1030, 30));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setText("Client Information");
        formandtexturePane.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Full Name:");
        formandtexturePane.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 40));

        jTextField14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        formandtexturePane.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 250, 40));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Contact:");
        formandtexturePane.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 60));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Stylist:");
        formandtexturePane.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 210, 60));

        jTextField15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 250, 40));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Appointment:");
        formandtexturePane.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 70));

        jDateChooser5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        formandtexturePane.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 250, 40));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setText("Form & Texture");
        formandtexturePane.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        buttonGroup1.add(jCheckBox29);
        jCheckBox29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox29.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox29.setText("Spot Relax");
        jCheckBox29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox29ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox29, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setText("Category");
        formandtexturePane.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        buttonGroup2.add(jCheckBox30);
        jCheckBox30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox30.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox30.setText("Short");
        jCheckBox30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox30ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, -1, -1));

        buttonGroup2.add(jCheckBox31);
        jCheckBox31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox31.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox31.setText("Long");
        jCheckBox31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox31ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, -1, -1));

        purchaseAddBtn4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        purchaseAddBtn4.setText("Add");
        purchaseAddBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseAddBtn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseAddBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseAddBtn4ActionPerformed(evt);
            }
        });
        formandtexturePane.add(purchaseAddBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 690, 610, 40));

        jLabel53.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(153, 153, 153));
        jLabel53.setText("<");
        jLabel53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        formandtexturePane.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        buttonGroup1.add(jCheckBox32);
        jCheckBox32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox32.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox32.setText("Coldwave");
        jCheckBox32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox32ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox32, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        buttonGroup1.add(jCheckBox33);
        jCheckBox33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox33.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox33.setText("Power Relax");
        jCheckBox33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox33ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox33, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        buttonGroup2.add(jCheckBox34);
        jCheckBox34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox34.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox34.setText("Extra");
        jCheckBox34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox34ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 230, -1, -1));

        buttonGroup2.add(jCheckBox35);
        jCheckBox35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox35.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox35.setText("Medium");
        jCheckBox35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox35ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, -1, -1));

        buttonGroup1.add(jCheckBox36);
        jCheckBox36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox36.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox36.setText("Steambond L Oreal Extenso");
        jCheckBox36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox36ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox36, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        buttonGroup1.add(jCheckBox37);
        jCheckBox37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox37.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox37.setText("Rebond");
        jCheckBox37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox37ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jCheckBox37, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        jComboBox6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBox6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        formandtexturePane.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, 40));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Stylist price:");
        formandtexturePane.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, 60));

        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, 30));

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton13.setText("Clear");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 150, 40));

        jButton48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton48.setText("Set to all services");
        jButton48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        formandtexturePane.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 260, 40));

        jTabbedPane1.addTab("tab2", formandtexturePane);

        nailcarePane.setBackground(new java.awt.Color(102, 102, 102));
        nailcarePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(153, 0, 0));
        jLabel63.setText("Nailcare");
        nailcarePane.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));
        nailcarePane.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 1090, 30));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setText("Client Information");
        nailcarePane.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Full Name:");
        nailcarePane.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 40));

        jTextField20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        nailcarePane.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 250, 40));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Contact:");
        nailcarePane.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 60));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Stylist:");
        nailcarePane.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 210, 60));

        jTextField21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nailcarePane.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 250, 40));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Appointment:");
        nailcarePane.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 70));

        jDateChooser7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nailcarePane.add(jDateChooser7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 250, 40));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setText("Nailcare");
        nailcarePane.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        buttonGroup1.add(jCheckBox48);
        jCheckBox48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox48.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox48.setText("Foot Spa");
        jCheckBox48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nailcarePane.add(jCheckBox48, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        buttonGroup1.add(jCheckBox49);
        jCheckBox49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox49.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox49.setText("Change Polish (Class C)");
        jCheckBox49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nailcarePane.add(jCheckBox49, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, -1, -1));

        purchaseAddBtn6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        purchaseAddBtn6.setText("Add");
        purchaseAddBtn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseAddBtn6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseAddBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseAddBtn6ActionPerformed(evt);
            }
        });
        nailcarePane.add(purchaseAddBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 690, 610, 40));

        jLabel71.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(153, 153, 153));
        jLabel71.setText("<");
        jLabel71.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel71MouseClicked(evt);
            }
        });
        jLabel71.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel71KeyPressed(evt);
            }
        });
        nailcarePane.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        buttonGroup1.add(jCheckBox51);
        jCheckBox51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox51.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox51.setText("Nail Extension");
        jCheckBox51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox51ActionPerformed(evt);
            }
        });
        nailcarePane.add(jCheckBox51, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, -1, -1));

        buttonGroup1.add(jCheckBox52);
        jCheckBox52.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox52.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox52.setText("Manicure");
        jCheckBox52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nailcarePane.add(jCheckBox52, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        buttonGroup1.add(jCheckBox55);
        jCheckBox55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox55.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox55.setText("Gel Manicure");
        jCheckBox55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox55ActionPerformed(evt);
            }
        });
        nailcarePane.add(jCheckBox55, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        buttonGroup1.add(jCheckBox56);
        jCheckBox56.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox56.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox56.setText("Pedicure");
        jCheckBox56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox56ActionPerformed(evt);
            }
        });
        nailcarePane.add(jCheckBox56, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        buttonGroup1.add(jCheckBox57);
        jCheckBox57.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox57.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox57.setText("Gel Pedicure");
        jCheckBox57.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox57ActionPerformed(evt);
            }
        });
        nailcarePane.add(jCheckBox57, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        buttonGroup1.add(jCheckBox58);
        jCheckBox58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox58.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox58.setText("Change Polish (Gel)");
        jCheckBox58.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox58ActionPerformed(evt);
            }
        });
        nailcarePane.add(jCheckBox58, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, -1, -1));

        buttonGroup1.add(jCheckBox59);
        jCheckBox59.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox59.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox59.setText("Gel Polish Removal");
        jCheckBox59.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox59ActionPerformed(evt);
            }
        });
        nailcarePane.add(jCheckBox59, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, -1, -1));

        buttonGroup1.add(jCheckBox60);
        jCheckBox60.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox60.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox60.setText("Gel Polish w/Nail art");
        jCheckBox60.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox60ActionPerformed(evt);
            }
        });
        nailcarePane.add(jCheckBox60, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 200, -1, -1));

        buttonGroup1.add(jCheckBox61);
        jCheckBox61.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBox61.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox61.setText("Soft Gel w/Nail art");
        jCheckBox61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox61ActionPerformed(evt);
            }
        });
        nailcarePane.add(jCheckBox61, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, -1, -1));

        jComboBox7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBox7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        nailcarePane.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, 40));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("Stylist price:");
        nailcarePane.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, 60));
        nailcarePane.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, 30));

        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton17.setText("Clear");
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        nailcarePane.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 150, 40));

        jButton50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton50.setText("Set to all services");
        jButton50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        nailcarePane.add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 260, 40));

        jTabbedPane1.addTab("tab2", nailcarePane);

        accountPane.setBackground(new java.awt.Color(102, 102, 102));
        accountPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(153, 0, 0));
        jLabel78.setText("Account");
        accountPane.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));
        accountPane.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 1110, 30));

        jLabel85.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(153, 153, 153));
        jLabel85.setText("<");
        jLabel85.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel85MouseClicked(evt);
            }
        });
        jLabel85.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel85KeyPressed(evt);
            }
        });
        accountPane.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        accountPane.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 350, 30));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        accountPane.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 350, 30));

        jPanel30.setBackground(new java.awt.Color(102, 102, 102));
        jPanel30.setForeground(new java.awt.Color(102, 102, 102));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Switch account");
        jLabel82.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel82MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel82MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel82MouseExited(evt);
            }
        });
        jPanel30.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 40));

        accountPane.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 570, -1));

        jTabbedPane1.addTab("tab2", accountPane);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1400, 1750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseAddBtnActionPerformed
        Random generateReservationID=new Random();
        int aib = generateReservationID.nextInt(1,500);
        String a = Integer.toString(aib);
        String cName = jTextField2.getText();
        String tos = jLabel6.getText();
        String ps = (String) jComboBox1.getSelectedItem();
        String no = jTextField3.getText();
        String stylistAmountString = jTextField4.getText().trim();
        int length = no.length();
        if(cName.isEmpty() || cName.isBlank()){
            JOptionPane.showMessageDialog(null, "Must input the client's name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(length != 11) {
            JOptionPane.showMessageDialog(null, "Input a valid contact number", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(stylistAmountString.isBlank() || stylistAmountString.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input the value of the stylist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(jDateChooser1.getDate()==null){
            JOptionPane.showMessageDialog(null, "Select the client's appointment date", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
//==================VARIABLES==========================//
        String service = null;
        String cat=null;
        double amount = 0;
//======================================================//

//==========SELECTION FUNCTION=============================45-//
        if(jCheckBox1.isSelected()){
            service = jCheckBox1.getText();
            if(jCheckBox1.isSelected() && jCheckBox3.isSelected()){
                amount = 350;
                
            }
            else if(jCheckBox1.isSelected() && jCheckBox4.isSelected()){
                amount = 500;
                
            }
        }
        
        else if (jCheckBox2.isSelected()){
            service = jCheckBox2.getText();
            if(jCheckBox2.isSelected() && jCheckBox3.isSelected()){
                amount = 400;
                
            }
            else if (jCheckBox2.isSelected() && jCheckBox4.isSelected()){
                amount = 600;
                
            }
        }
        if(jCheckBox3.isSelected()){
            cat = jCheckBox3.getText();
        }
        else if(jCheckBox4.isSelected()){
            cat = jCheckBox4.getText();
        }
        if(buttonGroup1.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Select the client's desired service", "Error", JOptionPane.ERROR_MESSAGE);
            }
        else if(buttonGroup2.getSelection()==null){
                    JOptionPane.showMessageDialog(null, "Select the client's desired category of the service", "Error", JOptionPane.ERROR_MESSAGE);
                }
        else{
            String sched = jDateChooser1.getDate().toString();
        double stylistAmount=Double.parseDouble(jTextField4.getText());
        double totalAmount=stylistAmount+amount;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                    st = con.createStatement();
                    boolean tt=st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+a+"','"+jTextField2.getText()+"','"+tos+"','"+service+"','"+cat+"','"+sched+"','"+amount+"', '"+ps+"', '"+no+"')");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
          //    tableModel.addRow(new Object[]{a, cName, tos, service, cat, sched, amount,ps,no});
                tableModel2.addRow(new Object[]{aib, cName, tos, service, cat, sched, totalAmount,ps,no});
                JOptionPane.showMessageDialog(null, "Added to the table");
                jTabbedPane1.setSelectedIndex(0);
                int pane = jTabbedPane1.getSelectedIndex();
                if(pane==0){    
                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                }
                calculateTotal();
        }
        }
//==========================================================================//
    }//GEN-LAST:event_purchaseAddBtnActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fWO();
    }//GEN-LAST:event_formWindowOpened

    private void purchaseAddBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseAddBtn2ActionPerformed
//=====================VARIABLE VALUES TO TABLE===========================//
        Random generateReservationID=new Random();
        int aib = generateReservationID.nextInt(1,500);
        String a = Integer.toString(aib);
        String cName = jTextField8.getText();
        String tos = jLabel27.getText();
        String ps = (String) jComboBox5.getSelectedItem();
        String no = jTextField9.getText();
        String stylistAmountString = jTextField16.getText().trim();
        int length = no.length();
        if(cName.isEmpty() || cName.isBlank()){
            JOptionPane.showMessageDialog(null, "Must input the client's name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(length != 11) {
                JOptionPane.showMessageDialog(null, "Please input a valid contact number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        else if(stylistAmountString.isBlank() || stylistAmountString.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input the value of the stylist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(jDateChooser3.getDate()==null){
            JOptionPane.showMessageDialog(null, "Select the client's appointment date", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
//==================VARIABLES==========================//
        String service = null;
        String cat=null;
        double amount = 0;
//======================================================//

//==========SELECTION FUNCTION=============================//
        if(jCheckBox13.isSelected()){
            service = jCheckBox13.getText();
            if(jCheckBox13.isSelected() && jCheckBox14.isSelected()){
                amount = 250;
                
            }
            else if(jCheckBox13.isSelected() && jCheckBox19.isSelected()){
                amount = 350;
                
            }
            else if(jCheckBox13.isSelected() && jCheckBox15.isSelected()){
                amount = 500;
                
            }
            else if(jCheckBox13.isSelected() && jCheckBox18.isSelected()){
                amount = 100;
                
            }
        }
        else if (jCheckBox17.isSelected()){
            service = jCheckBox17.getText();
            if(jCheckBox17.isSelected() && jCheckBox14.isSelected()){
                amount = 300;
                
            }
            else if (jCheckBox17.isSelected() && jCheckBox19.isSelected()){
                amount = 450;
                
            }
            else if (jCheckBox17.isSelected() && jCheckBox15.isSelected()){
                amount = 500;
                
            }
            else if (jCheckBox17.isSelected() && jCheckBox18.isSelected()){
                amount = 150;
                
            }
        }
        else if (jCheckBox20.isSelected()){
            service = jCheckBox20.getText();
            if(jCheckBox20.isSelected() && jCheckBox14.isSelected()){
                amount = 300;
                
            }
            else if (jCheckBox20.isSelected() && jCheckBox19.isSelected()){
                amount = 450;
                
            }
            else if (jCheckBox20.isSelected() && jCheckBox15.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox20.isSelected() && jCheckBox18.isSelected()){
                amount = 150;
                
            }
        }
        else if (jCheckBox16.isSelected()){
            service = jCheckBox16.getText();
            if(jCheckBox16.isSelected() && jCheckBox14.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox16.isSelected() && jCheckBox19.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox16.isSelected() && jCheckBox15.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox16.isSelected() && jCheckBox18.isSelected()){
                amount = 600;
                
            }
        }
        
        if(jCheckBox14.isSelected()){
            cat = jCheckBox14.getText();
        }
        else if(jCheckBox19.isSelected()){
            cat = jCheckBox19.getText();
        }
        else if(jCheckBox15.isSelected()){
            cat = jCheckBox15.getText();
        }
        else if(jCheckBox18.isSelected()){
            cat = jCheckBox18.getText();
        }
        
        
        if(buttonGroup1.getSelection()==null){
            JOptionPane.showMessageDialog(null, "Select the client's desired service", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(buttonGroup2.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Select the client's desired category of the service", "Error", JOptionPane.ERROR_MESSAGE);
            }
        else{
            String sched = jDateChooser3.getDate().toString();
        double stylistAmount=Double.parseDouble(jTextField16.getText());
        double totalAmount=stylistAmount+amount;
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            
            boolean tt=st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+a+"','"+jTextField2.getText()+"','"+tos+"','"+service+"','"+cat+"','"+sched+"','"+amount+"', '"+ps+"', '"+no+"')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
//                tableModel.addRow(new Object[]{a, cName, tos, service, cat, sched, amount,ps,no});
                tableModel2.addRow(new Object[]{aib, cName, tos, service, cat, sched, totalAmount,ps,no});
                JOptionPane.showMessageDialog(null, "Added to the table");
                jTabbedPane1.setSelectedIndex(0);
                int pane = jTabbedPane1.getSelectedIndex();
                if(pane==0){
                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                }
                calculateTotal();
        }
        }
//==========================================================================//
    }//GEN-LAST:event_purchaseAddBtn2ActionPerformed

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        jTabbedPane1.setSelectedIndex(0);        
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jCheckBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox20ActionPerformed

    private void purchaseAddBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseAddBtn3ActionPerformed
        Random generateReservationID=new Random();
        int aib = generateReservationID.nextInt(1,500);
        String a = Integer.toString(aib);
        String cName = jTextField11.getText();
        String tos = jLabel36.getText();
        String ps = (String) jComboBox3.getSelectedItem();
        String no = jTextField12.getText();
        String stylistAmountString = jTextField10.getText().trim();
        int length = no.length();
        if(cName.isEmpty() || cName.isBlank()){
            JOptionPane.showMessageDialog(null, "Must input the client's name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(length != 11) {
            JOptionPane.showMessageDialog(null, "Input a valid contact number", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(stylistAmountString.isBlank() || stylistAmountString.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input the value of the stylist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(jDateChooser4.getDate()==null){
            JOptionPane.showMessageDialog(null, "Select the client's appointment date", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
//==================VARIABLES==========================//
        String service = null;
        String cat=null;
        double amount = 0;
//======================================================//

//==========SELECTION FUNCTION=============================//
        if(jCheckBox21.isSelected()){
            service = jCheckBox21.getText();
            if(jCheckBox21.isSelected() && jCheckBox22.isSelected()){
                amount = 5000;
                
            }
            else if(jCheckBox21.isSelected() && jCheckBox27.isSelected()){
                amount = 7000;
                
            }
            else if(jCheckBox21.isSelected() && jCheckBox23.isSelected()){
                amount = 8500;
                
            }
            else if(jCheckBox21.isSelected() && jCheckBox26.isSelected()){
                amount = 1000;
                
            }
        }
        else if (jCheckBox25.isSelected()){
            service = jCheckBox25.getText();
            if(jCheckBox25.isSelected() && jCheckBox22.isSelected()){
                amount = 5500;
                
            }
            else if (jCheckBox25.isSelected() && jCheckBox27.isSelected()){
                amount = 8000;
                
            }
            else if (jCheckBox25.isSelected() && jCheckBox23.isSelected()){
                amount = 9500;
                
            }
            else if (jCheckBox25.isSelected() && jCheckBox26.isSelected()){
                amount = 1000;
                
            }
        }
        else if (jCheckBox28.isSelected()){
            service = jCheckBox28.getText();
            if(jCheckBox28.isSelected() && jCheckBox22.isSelected()){
                amount = 5000;
            }
            else if (jCheckBox28.isSelected() && jCheckBox27.isSelected()){
                amount = 8000;
            }
            else if (jCheckBox28.isSelected() && jCheckBox23.isSelected()){
                amount = 10000;
            }
            else if (jCheckBox28.isSelected() && jCheckBox26.isSelected()){
                amount = 1000;
                
            }
        }
        else if (jCheckBox24.isSelected()){
            service = jCheckBox24.getText();
            if(jCheckBox24.isSelected() && jCheckBox22.isSelected()){
                amount = 5000;
                
            }
            else if (jCheckBox24.isSelected() && jCheckBox27.isSelected()){
                amount = 7500;
                
            }
            else if (jCheckBox24.isSelected() && jCheckBox23.isSelected()){
                amount = 9500;
                
            }
            else if (jCheckBox24.isSelected() && jCheckBox26.isSelected()){
                amount = 1000;
                
            }
        }
        
        if(jCheckBox22.isSelected()){
            cat = jCheckBox22.getText();
        }
        else if(jCheckBox27.isSelected()){
            cat = jCheckBox27.getText();
        }
        else if(jCheckBox23.isSelected()){
            cat = jCheckBox23.getText();
        }
        else if(jCheckBox26.isSelected()){
            cat = jCheckBox26.getText();
        }
        
        if(buttonGroup1.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Select the client's desired service", "Error", JOptionPane.ERROR_MESSAGE);
            }
        else if(buttonGroup2.getSelection()==null){
                    JOptionPane.showMessageDialog(null, "Select the client's desired category of the service", "Error", JOptionPane.ERROR_MESSAGE);
                }
        else{
            String sched = jDateChooser4.getDate().toString();
            double stylistAmount=Double.parseDouble(jTextField4.getText());
            double totalAmount=stylistAmount+amount;
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();

            boolean tt=st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+a+"','"+jTextField2.getText()+"','"+tos+"','"+service+"','"+cat+"','"+sched+"','"+amount+"', '"+ps+"', '"+no+"')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
//                tableModel.addRow(new Object[]{a, cName, tos, service, cat, sched, amount,ps,no});
                tableModel2.addRow(new Object[]{aib, cName, tos, service, cat, sched, totalAmount,ps,no});
                JOptionPane.showMessageDialog(null, "Added to the table");
                jTabbedPane1.setSelectedIndex(0);
                int pane = jTabbedPane1.getSelectedIndex();
                if(pane==0){    

                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                }
                calculateTotal();
        }
        }
//==========================================================================//
    }//GEN-LAST:event_purchaseAddBtn3ActionPerformed

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        jTabbedPane1.setSelectedIndex(0);
        int pane = jTabbedPane1.getSelectedIndex();
                if(pane==0){    
                    jTextField11.setText("");
                    jTextField12.setText("");
                    
                    jDateChooser4.setDate(null);
                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                }
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jCheckBox24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox24ActionPerformed

    private void jCheckBox28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox28ActionPerformed

    private void purchaseAddBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseAddBtn5ActionPerformed
        Random generateReservationID=new Random();
        int aib = generateReservationID.nextInt(1,500);
        String a = Integer.toString(aib);
        String cName = jTextField17.getText();
        String tos = jLabel54.getText();
        String ps = (String) jComboBox4.getSelectedItem();
        String no = jTextField18.getText();
        String stylistAmountString = jTextField13.getText().trim();
        int length = no.length();
        if(cName.isEmpty() || cName.isBlank()){
            JOptionPane.showMessageDialog(null, "Must input the client's name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(stylistAmountString.isBlank() || stylistAmountString.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input the value of the stylist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(length != 11) {
                JOptionPane.showMessageDialog(null, "Please input a valid contact number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        else if(jDateChooser6.getDate()==null){
            JOptionPane.showMessageDialog(null, "Select the client's appointment date", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
//==================VARIABLES==========================//
        String service = null;
        String cat=null;
        double amount = 0;
//======================================================//

//==========SELECTION FUNCTION=============================//
        if(jCheckBox38.isSelected()){
            service = jCheckBox38.getText();
            if(jCheckBox38.isSelected() && jCheckBox30.isSelected()){
                amount = 300;
            }
            else if (jCheckBox38.isSelected() && jCheckBox35.isSelected()){
                amount = 450;
            }
            else if (jCheckBox38.isSelected() && jCheckBox31.isSelected()){
                amount = 500;
                
            }
            else if (jCheckBox38.isSelected() && jCheckBox34.isSelected()){
                amount = 150;
                
            }
        }
        else if (jCheckBox42.isSelected()){
            service = jCheckBox42.getText();
            if(jCheckBox42.isSelected() && jCheckBox30.isSelected()){
                amount = 300;
                
            }
            else if (jCheckBox42.isSelected() && jCheckBox35.isSelected()){
                amount = 450;
                
            }
            else if (jCheckBox42.isSelected() && jCheckBox31.isSelected()){
                amount = 500;
                
            }
            else if (jCheckBox42.isSelected() && jCheckBox34.isSelected()){
                amount = 150;
                
            }
        }
        else if (jCheckBox45.isSelected()){
            service = jCheckBox45.getText();
            if(jCheckBox45.isSelected() && jCheckBox39.isSelected()){
                amount = 300;
                
            }
            else if (jCheckBox45.isSelected() && jCheckBox44.isSelected()){
                amount = 450;
                
            }
            else if (jCheckBox45.isSelected() && jCheckBox40.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox45.isSelected() && jCheckBox43.isSelected()){
                amount = 150;
                
            }
        }
        else if (jCheckBox46.isSelected()){
            service = jCheckBox46.getText();
            if(jCheckBox46.isSelected() && jCheckBox39.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox46.isSelected() && jCheckBox44.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox46.isSelected() && jCheckBox40.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox46.isSelected() && jCheckBox43.isSelected()){
                amount = 600;
                
            }
        }
        
        else if (jCheckBox47.isSelected()){
            service = jCheckBox47.getText();
            if(jCheckBox47.isSelected() && jCheckBox39.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox47.isSelected() && jCheckBox44.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox47.isSelected() && jCheckBox40.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox47.isSelected() && jCheckBox43.isSelected()){
                amount = 600;
                
            }
        }
        
        else if (jCheckBox41.isSelected()){
            service = jCheckBox41.getText();
            if(jCheckBox41.isSelected() && jCheckBox39.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox41.isSelected() && jCheckBox44.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox41.isSelected() && jCheckBox40.isSelected()){
                amount = 600;
                
            }
            else if (jCheckBox41.isSelected() && jCheckBox43.isSelected()){
                amount = 600;
                
            }
        }
        
        if(jCheckBox39.isSelected()){
            cat = jCheckBox39.getText();
        }
        else if(jCheckBox44.isSelected()){
            cat = jCheckBox44.getText();
        }
        else if(jCheckBox40.isSelected()){
            cat = jCheckBox40.getText();
        }
        else if(jCheckBox43.isSelected()){
            cat = jCheckBox43.getText();
        }
        
        if(buttonGroup1.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Select the client's desired service", "Error", JOptionPane.ERROR_MESSAGE);
            }
        else if(buttonGroup2.getSelection()==null){
                    JOptionPane.showMessageDialog(null, "Select the client's desired category of the service", "Error", JOptionPane.ERROR_MESSAGE);
                }
        else{
            String sched = jDateChooser6.getDate().toString();
            double stylistAmount=Double.parseDouble(jTextField4.getText());
            double totalAmount=stylistAmount+amount;
            try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            
            boolean tt=st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+a+"','"+jTextField2.getText()+"','"+tos+"','"+service+"','"+cat+"','"+sched+"','"+amount+"', '"+ps+"', '"+no+"')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
               // tableModel.addRow(new Object[]{a, cName, tos, service, cat, sched, amount,ps,no});
                tableModel2.addRow(new Object[]{aib, cName, tos, service, cat, sched, totalAmount,ps,no});
                JOptionPane.showMessageDialog(null, "Added to the table");
                jTabbedPane1.setSelectedIndex(0);
                int pane = jTabbedPane1.getSelectedIndex();
                if(pane==0){    
                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                }
                calculateTotal();
        }
        }
//==========================================================================//
    }//GEN-LAST:event_purchaseAddBtn5ActionPerformed

    private void jLabel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel62MouseClicked

    private void jCheckBox41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox41ActionPerformed

    private void jCheckBox45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox45ActionPerformed

    private void jCheckBox46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox46ActionPerformed

    private void purchaseAddBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseAddBtn6ActionPerformed
//=====================VARIABLE VALUES TO TABLE===========================//
        Random generateReservationID=new Random();
        int aib = generateReservationID.nextInt(1,500);
        String a = Integer.toString(aib);
        String cName = jTextField20.getText();
        String tos = jLabel63.getText();
        String ps = (String) jComboBox7.getSelectedItem();
        String no = jTextField21.getText();
        String stylistAmountString =jTextField22.getText();
        int length=no.length();
        /*double stylistAmount=Double.parseDouble(jTextField4.getText());
        double totalAmount=stylistAmount+amount;*/
        if(cName.isEmpty() || cName.isBlank()){
            JOptionPane.showMessageDialog(null, "Must input the client's name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(length != 11) {
                JOptionPane.showMessageDialog(null, "Please input a valid contact number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        else if(stylistAmountString.isBlank() || stylistAmountString.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input the value of the stylist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(jDateChooser7.getDate()==null){
            JOptionPane.showMessageDialog(null, "Select the client's appointment date", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
//==================VARIABLES==========================//
        String service = null;
        String cat="N/A";
        double amount = 0;
//======================================================//

//==========SELECTION FUNCTION=============================//
        if(jCheckBox48.isSelected()){
            service = jCheckBox48.getText();
            amount = 300;
            
        }
        else if (jCheckBox52.isSelected()){
            service = jCheckBox52.getText();
            amount = 300;
            
        }
        else if (jCheckBox55.isSelected()){
            service = jCheckBox55.getText();
            amount = 300;
            
        }
        else if (jCheckBox56.isSelected()){
            service = jCheckBox52.getText();
            amount = 300;
            
        }
        else if (jCheckBox57.isSelected()){
            service = jCheckBox57.getText();
            amount = 300;
            
        }
        else if (jCheckBox51.isSelected()){
            service = jCheckBox1.getText();
            amount = 300;
            
        }
        else if (jCheckBox49.isSelected()){
            service = jCheckBox49.getText();
            amount = 300;
            
        }
        else if (jCheckBox58.isSelected()){
            service = jCheckBox58.getText();
            amount = 300;
            
        }
        else if (jCheckBox59.isSelected()){
            service = jCheckBox59.getText();
            amount = 300;
            
        }
        else if (jCheckBox60.isSelected()){
            service = jCheckBox60.getText();
            amount = 300;
            
        }
        else if (jCheckBox61.isSelected()){
            service = jCheckBox61.getText();
            amount = 300;

        }
            if(buttonGroup1.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Select the client's desired services", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String sched = jDateChooser7.getDate().toString();
            double stylistAmount=Double.parseDouble(jTextField22.getText());
            double totalAmount=stylistAmount+amount;
                try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            boolean tt=st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+a+"','"+jTextField2.getText()+"','"+tos+"','"+service+"','"+cat+"','"+sched+"','"+amount+"', '"+ps+"', '"+no+"')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
//                tableModel.addRow(new Object[]{a, cName, tos, service, "None", sched, amount,ps,no});
                tableModel2.addRow(new Object[]{aib, cName, tos, service, "N/A", sched, totalAmount,ps,no});
                JOptionPane.showMessageDialog(null, "Added to the table");
                jTabbedPane1.setSelectedIndex(0);
                int pane = jTabbedPane1.getSelectedIndex();
                if(pane==0){   
                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                }
                calculateTotal();
            }
        }
//==========================================================================//
    }//GEN-LAST:event_purchaseAddBtn6ActionPerformed

    private void jLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel71MouseClicked

    private void jCheckBox51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox51ActionPerformed

    private void jCheckBox55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox55ActionPerformed

    private void jCheckBox56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox56ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox56ActionPerformed

    private void jCheckBox58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox58ActionPerformed

    private void jCheckBox59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox59ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox59ActionPerformed

    private void jCheckBox60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox60ActionPerformed

    private void jCheckBox61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox61ActionPerformed

    private void jLabel71KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel71KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel71KeyPressed

    private void jCheckBox57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox57ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox57ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel85MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel85MouseClicked

    private void jLabel85KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel85KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel85KeyPressed

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
      /*  int panelr = 70;
        int panelg =70;
        int panelb=70;
        //label//
        int labelr=220;
        int labelg=220;
        int labelb=220;
        jPanel30.setBackground(new Color(panelr,panelg,panelb));
        jLabel82.setForeground(new Color(labelr,labelg,labelb));
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
       int emptyTable=jTable2.getRowCount();
       if(emptyTable<=0){
           new login().setVisible(true);
           this.dispose();
       }
       else{
           int switchAccount=JOptionPane.showConfirmDialog(null, "Are you sure to leave your incomplete transaction?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           if(switchAccount==JOptionPane.YES_OPTION){
               try{
                       if(!st.execute("TRUNCATE TABLE dbtable2")){
                       jTextField1.setText("");
                       totalText.setText("");
                       jLabel9.setText("");
                       cashTxtFld.setText("");
                       tableModel2.setRowCount(0);
                   }
                   }
               catch(SQLException ex){
                   System.getLogger(mainPage.class.getName()).log(System.Logger.Level.ERROR, ex);
               }
               new login().setVisible(true);
               this.setVisible(false);
           }
           else if(switchAccount==JOptionPane.NO_OPTION){
           }
       }*/

    }//GEN-LAST:event_jLabel82MouseClicked

    private void jLabel82MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseEntered
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel30.setBackground(new Color(panelr,panelg,panelb));
        jLabel82.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel82MouseEntered

    private void jLabel82MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseExited
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel30.setBackground(new Color(panelr,panelg,panelb));
        jLabel82.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel82MouseExited

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jCheckBox37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox37ActionPerformed
        if(jCheckBox37.isSelected()){
            jCheckBox30.setEnabled(true);
            jCheckBox31.setEnabled(true);
            jCheckBox35.setEnabled(true);
            jCheckBox34.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox37ActionPerformed

    private void jCheckBox36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox36ActionPerformed
        if(jCheckBox36.isSelected()){
            jCheckBox30.setEnabled(true);
            jCheckBox31.setEnabled(true);
            jCheckBox35.setEnabled(true);
            jCheckBox34.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox36ActionPerformed

    private void jCheckBox35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox35ActionPerformed
        if(jCheckBox29.isSelected()){
            if(jCheckBox29.isSelected() && jCheckBox30.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox30.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox35.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox35.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox31.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox31.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox34.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox34.setEnabled(false);
            }
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox35ActionPerformed

    private void jCheckBox34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox34ActionPerformed
        if(jCheckBox29.isSelected()){
            if(jCheckBox29.isSelected() && jCheckBox30.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox30.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox35.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox35.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox31.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox31.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox34.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox34.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCheckBox34ActionPerformed

    private void jCheckBox33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox33ActionPerformed
        if(jCheckBox33.isSelected()){
            jCheckBox30.setEnabled(true);
            jCheckBox31.setEnabled(true);
            jCheckBox35.setEnabled(true);
            jCheckBox34.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox33ActionPerformed

    private void jCheckBox32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox32ActionPerformed
        if(jCheckBox32.isSelected()){
            jCheckBox30.setEnabled(true);
            jCheckBox31.setEnabled(true);
            jCheckBox35.setEnabled(true);
            jCheckBox34.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox32ActionPerformed

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel53MouseClicked

    private void purchaseAddBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseAddBtn4ActionPerformed
        //=====================VARIABLE VALUES TO TABLE===========================//
        Random generateReservationID=new Random();
        int aib = generateReservationID.nextInt(1,500);
        String a = Integer.toString(aib);
        String cName = jTextField14.getText();
        String tos = jLabel45.getText();
        String ps = (String) jComboBox6.getSelectedItem();
        String no = jTextField15.getText();
        String stylistAmountString = jTextField19.getText().trim();
        int length = no.length();
        if(cName.isEmpty() || cName.isBlank()){
            JOptionPane.showMessageDialog(null, "Must input the client's name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(length != 11) {
            JOptionPane.showMessageDialog(null, "Input a valid contact number", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(stylistAmountString.isBlank() || stylistAmountString.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input the value of the stylist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(jDateChooser5.getDate()==null){
            JOptionPane.showMessageDialog(null, "Select the client's appointment date", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
        //==================VARIABLES==========================//
        String service = null;
        String cat=null;
        double amount = 0;
        //======================================================//

        //==========SELECTION FUNCTION=============================//
        
        if (jCheckBox33.isSelected()){
            service = jCheckBox33.getText();
            if(jCheckBox33.isSelected() && jCheckBox30.isSelected()){
                amount = 1200;

            }
            else if (jCheckBox33.isSelected() && jCheckBox35.isSelected()){
                amount = 2000;

            }
            else if (jCheckBox33.isSelected() && jCheckBox31.isSelected()){
                amount = 2500;

            }
            else if (jCheckBox33.isSelected() && jCheckBox34.isSelected()){
                amount = 500;

            }
        }
        else if (jCheckBox36.isSelected()){
            service = jCheckBox36.getText();
            if(jCheckBox36.isSelected() && jCheckBox30.isSelected()){
                amount = 2000;

            }
            else if (jCheckBox36.isSelected() && jCheckBox35.isSelected()){
                amount = 3500;

            }
            else if (jCheckBox36.isSelected() && jCheckBox31.isSelected()){
                amount = 4500;

            }
            else if (jCheckBox36.isSelected() && jCheckBox34.isSelected()){
                amount = 600;

            }
        }
        else if (jCheckBox37.isSelected()){
            service = jCheckBox37.getText();
            if(jCheckBox37.isSelected() && jCheckBox30.isSelected()){
                amount = 1500;

            }
            else if (jCheckBox37.isSelected() && jCheckBox35.isSelected()){
                amount = 2500;

            }
            else if (jCheckBox37.isSelected() && jCheckBox31.isSelected()){
                amount = 3500;

            }
            else if (jCheckBox37.isSelected() && jCheckBox34.isSelected()){
                amount = 500;

            }
        }

        else if (jCheckBox32.isSelected()){
            service = jCheckBox32.getText();
            if(jCheckBox32.isSelected() && jCheckBox30.isSelected()){
                amount = 2000;

            }
            else if (jCheckBox32.isSelected() && jCheckBox35.isSelected()){
                amount = 3000;

            }
            else if (jCheckBox32.isSelected() && jCheckBox31.isSelected()){
                amount = 3500;

            }
            else if (jCheckBox32.isSelected() && jCheckBox34.isSelected()){
                amount = 500;

            }
        }
        if(jCheckBox30.isSelected()){
            cat = jCheckBox30.getText();
        }
        else if(jCheckBox35.isSelected()){
            cat = jCheckBox35.getText();
        }
        else if(jCheckBox31.isSelected()){
            cat = jCheckBox31.getText();
        }
        else if(jCheckBox34.isSelected()){
            cat = jCheckBox34.getText();
        }
            String sched = jDateChooser5.getDate().toString();
            double stylistAmount=Double.parseDouble(jTextField19.getText());
            double totalAmount=stylistAmount+amount;
            if(jCheckBox29.isSelected()){
                        service = jCheckBox29.getText();
                        amount = 700;
                        stylistAmount=Double.parseDouble(jTextField19.getText());
                        totalAmount=stylistAmount+amount;
                        cat = "N/A";
                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                            st = con.createStatement();
                            boolean tt=st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+a+"','"+jTextField2.getText()+"','"+tos+"','"+service+"','"+cat+"','"+sched+"','"+amount+"', '"+ps+"', '"+no+"')");
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
            //              tableModel.addRow(new Object[]{a, cName, tos, service, cat, sched, amount,ps,no});
            tableModel2.addRow(new Object[]{aib, cName, tos, service, cat, sched, totalAmount,ps,no});
            JOptionPane.showMessageDialog(null, "Added to the table");
            jTabbedPane1.setSelectedIndex(0);
            int pane = jTabbedPane1.getSelectedIndex();
            if(pane==0){
                buttonGroup1.clearSelection();
                buttonGroup2.clearSelection();
            }
            calculateTotal();
                    }
            else if(buttonGroup1.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Select the client's desired service", "Error", JOptionPane.ERROR_MESSAGE); 
            }
            else if(buttonGroup2.getSelection()==null){
                    JOptionPane.showMessageDialog(null, "Select the client's desired category of the service", "Error", JOptionPane.ERROR_MESSAGE);
                }
            else{
                try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                st = con.createStatement();
                boolean tt=st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+a+"','"+jTextField2.getText()+"','"+tos+"','"+service+"','"+cat+"','"+sched+"','"+amount+"', '"+ps+"', '"+no+"')");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            //              tableModel.addRow(new Object[]{a, cName, tos, service, cat, sched, amount,ps,no});
            tableModel2.addRow(new Object[]{aib, cName, tos, service, cat, sched, totalAmount,ps,no});
            JOptionPane.showMessageDialog(null, "Added to the table");
            jTabbedPane1.setSelectedIndex(0);
            int pane = jTabbedPane1.getSelectedIndex();
            if(pane==0){
                buttonGroup1.clearSelection();
                buttonGroup2.clearSelection();
            }
            calculateTotal();
            }
        }
        //==========================================================================//
    }//GEN-LAST:event_purchaseAddBtn4ActionPerformed

    private void jCheckBox31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox31ActionPerformed
        if(jCheckBox29.isSelected()){
            if(jCheckBox29.isSelected() && jCheckBox30.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox30.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox35.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox35.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox31.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox31.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox34.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox34.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCheckBox31ActionPerformed

    private void jCheckBox30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox30ActionPerformed
        if(jCheckBox29.isSelected()){
            if(jCheckBox29.isSelected() && jCheckBox30.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox30.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox35.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox35.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox31.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox31.setEnabled(false);
            }
            else if(jCheckBox29.isSelected()&&jCheckBox34.isSelected()){
                JOptionPane.showMessageDialog(null, "Not available for this service", "Notice", JOptionPane.PLAIN_MESSAGE);
                jCheckBox34.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCheckBox30ActionPerformed

    private void jCheckBox29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox29ActionPerformed
        if(jCheckBox29.isSelected()){

            jCheckBox30.setEnabled(false);jCheckBox30.setSelected(false);
            jCheckBox31.setEnabled(false);jCheckBox31.setSelected(false);
            jCheckBox35.setEnabled(false);jCheckBox35.setSelected(false);
            jCheckBox34.setEnabled(false);jCheckBox34.setSelected(false);
            buttonGroup2.clearSelection();
        }
    }//GEN-LAST:event_jCheckBox29ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        jTextField5.setText(jTextField14.getText());
        jTextField14.setText(jTextField14.getText());
        jTextField11.setText(jTextField14.getText());
        jTextField17.setText(jTextField14.getText());
        jTextField2.setText(jTextField14.getText());
        jTextField8.setText(jTextField14.getText());
        jTextField20.setText(jTextField14.getText());

jTextField21.setText(jTextField15.getText());
        jTextField15.setText(jTextField15.getText());
        jTextField6.setText(jTextField15.getText());
        jTextField12.setText(jTextField15.getText());
        jTextField18.setText(jTextField15.getText());
        jTextField9.setText(jTextField15.getText());
        jTextField3.setText(jTextField15.getText());

jComboBox2.setModel(jComboBox6.getModel());
        jComboBox6.setModel(jComboBox6.getModel());
        jComboBox3.setModel(jComboBox6.getModel());
        jComboBox4.setModel(jComboBox6.getModel());
        jComboBox5.setModel(jComboBox6.getModel());
        jComboBox1.setModel(jComboBox6.getModel());
        jComboBox7.setModel(jComboBox6.getModel());

jTextField4.setText(jTextField19.getText());
        jTextField7.setText(jTextField19.getText());
        jTextField10.setText(jTextField19.getText());
        jTextField13.setText(jTextField19.getText());
        jTextField16.setText(jTextField19.getText());
        jTextField19.setText(jTextField19.getText());
        jTextField22.setText(jTextField19.getText());


jDateChooser2.setDate(jDateChooser5.getDate());
        jDateChooser5.setDate(jDateChooser5.getDate());
        jDateChooser1.setDate(jDateChooser5.getDate());
        jDateChooser4.setDate(jDateChooser5.getDate());
        jDateChooser3.setDate(jDateChooser5.getDate());
        jDateChooser6.setDate(jDateChooser5.getDate());
        jDateChooser7.setDate(jDateChooser5.getDate());
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jTextField14.setText("");
        jTextField15.setText("");
        jComboBox6.setSelectedIndex(0);
        jTextField19.setText("");
        jDateChooser5.setDate(null);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        jTextField8.setText("");
        jTextField5.setText("");
        jComboBox5.setSelectedIndex(0);
        jTextField16.setText("");
        jDateChooser3.setDate(null);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        jTextField5.setText(jTextField8.getText());
        jTextField8.setText(jTextField8.getText());
        jTextField11.setText(jTextField8.getText());
        jTextField17.setText(jTextField8.getText());
        jTextField2.setText(jTextField8.getText());
        jTextField14.setText(jTextField8.getText());
        jTextField20.setText(jTextField8.getText());

jTextField21.setText(jTextField9.getText());
        jTextField9.setText(jTextField9.getText());
        jTextField6.setText(jTextField9.getText());
        jTextField12.setText(jTextField9.getText());
        jTextField18.setText(jTextField9.getText());
        jTextField3.setText(jTextField9.getText());
        jTextField15.setText(jTextField9.getText());

jComboBox2.setModel(jComboBox5.getModel());
        jComboBox3.setModel(jComboBox5.getModel());
        jComboBox5.setModel(jComboBox5.getModel());
        jComboBox4.setModel(jComboBox5.getModel());
        jComboBox1.setModel(jComboBox5.getModel());
        jComboBox6.setModel(jComboBox5.getModel());
        jComboBox7.setModel(jComboBox5.getModel());

jTextField4.setText(jTextField16.getText());
        jTextField7.setText(jTextField16.getText());
        jTextField10.setText(jTextField16.getText());
        jTextField13.setText(jTextField16.getText());
        jTextField16.setText(jTextField16.getText());
        jTextField19.setText(jTextField16.getText());
        jTextField22.setText(jTextField16.getText());

jDateChooser2.setDate(jDateChooser3.getDate());
        jDateChooser3.setDate(jDateChooser3.getDate());
        jDateChooser1.setDate(jDateChooser3.getDate());
        jDateChooser4.setDate(jDateChooser3.getDate());
        jDateChooser5.setDate(jDateChooser3.getDate());
        jDateChooser6.setDate(jDateChooser3.getDate());
        jDateChooser7.setDate(jDateChooser3.getDate());
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jTextField20.setText("");
        jTextField21.setText("");
        jComboBox7.setSelectedIndex(0);
        jTextField22.setText("");
        jDateChooser7.setDate(null);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        


jTextField5.setText(jTextField20.getText());
        jTextField20.setText(jTextField20.getText());
        jTextField11.setText(jTextField20.getText());
        jTextField17.setText(jTextField20.getText());
        jTextField8.setText(jTextField20.getText());
        jTextField14.setText(jTextField20.getText());
        jTextField2.setText(jTextField20.getText());

jTextField3.setText(jTextField21.getText());
        jTextField21.setText(jTextField21.getText());
        jTextField6.setText(jTextField21.getText());
        jTextField12.setText(jTextField21.getText());
        jTextField18.setText(jTextField21.getText());
        jTextField9.setText(jTextField21.getText());
        jTextField15.setText(jTextField21.getText());

jComboBox2.setModel(jComboBox7.getModel());
        jComboBox7.setModel(jComboBox7.getModel());
        jComboBox3.setModel(jComboBox7.getModel());
        jComboBox4.setModel(jComboBox7.getModel());
        jComboBox5.setModel(jComboBox7.getModel());
        jComboBox6.setModel(jComboBox7.getModel());
        jComboBox1.setModel(jComboBox7.getModel());

jTextField4.setText(jTextField22.getText());
        jTextField7.setText(jTextField22.getText());
        jTextField10.setText(jTextField22.getText());
        jTextField13.setText(jTextField22.getText());
        jTextField16.setText(jTextField22.getText());
        jTextField19.setText(jTextField22.getText());
        jTextField22.setText(jTextField22.getText());

jDateChooser2.setDate(jDateChooser7.getDate());
        jDateChooser7.setDate(jDateChooser7.getDate());
        jDateChooser3.setDate(jDateChooser7.getDate());
        jDateChooser4.setDate(jDateChooser7.getDate());
        jDateChooser5.setDate(jDateChooser7.getDate());
        jDateChooser6.setDate(jDateChooser7.getDate());
        jDateChooser1.setDate(jDateChooser7.getDate());
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        jTextField17.setText("");
        jTextField18.setText("");
        jComboBox4.setSelectedIndex(0);
        jTextField13.setText("");
        jDateChooser6.setDate(null);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        jTextField5.setText(jTextField17.getText());
        jTextField17.setText(jTextField17.getText());
        jTextField11.setText(jTextField17.getText());
        jTextField2.setText(jTextField17.getText());
        jTextField8.setText(jTextField17.getText());
        jTextField14.setText(jTextField17.getText());
        jTextField20.setText(jTextField17.getText());

jTextField21.setText(jTextField18.getText());
        jTextField8.setText(jTextField18.getText());
        jTextField6.setText(jTextField18.getText());
        jTextField12.setText(jTextField18.getText());
        jTextField3.setText(jTextField18.getText());
        jTextField9.setText(jTextField18.getText());
        jTextField15.setText(jTextField18.getText());

jComboBox1.setModel(jComboBox4.getModel());
        jComboBox4.setModel(jComboBox4.getModel());
        jComboBox2.setModel(jComboBox4.getModel());
        jComboBox3.setModel(jComboBox4.getModel());
        jComboBox5.setModel(jComboBox4.getModel());
        jComboBox6.setModel(jComboBox4.getModel());
        jComboBox7.setModel(jComboBox4.getModel());

jTextField4.setText(jTextField13.getText());
        jTextField7.setText(jTextField13.getText());
        jTextField10.setText(jTextField13.getText());
        jTextField13.setText(jTextField13.getText());
        jTextField16.setText(jTextField13.getText());
        jTextField19.setText(jTextField13.getText());
        jTextField22.setText(jTextField13.getText());

jDateChooser2.setDate(jDateChooser6.getDate());
        jDateChooser6.setDate(jDateChooser6.getDate());
        jDateChooser1.setDate(jDateChooser6.getDate());
        jDateChooser4.setDate(jDateChooser6.getDate());
        jDateChooser5.setDate(jDateChooser6.getDate());
        jDateChooser3.setDate(jDateChooser6.getDate());
        jDateChooser7.setDate(jDateChooser6.getDate());
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        jTextField11.setText("");
        jTextField12.setText("");
        jComboBox3.setSelectedIndex(0);
        jTextField10.setText("");
        jDateChooser4.setDate(null);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        jTextField5.setText(jTextField11.getText());
        jTextField11.setText(jTextField11.getText());
        jTextField2.setText(jTextField11.getText());
        jTextField17.setText(jTextField11.getText());
        jTextField8.setText(jTextField11.getText());
        jTextField14.setText(jTextField11.getText());
        jTextField20.setText(jTextField11.getText());


jTextField21.setText(jTextField12.getText());
        jTextField12.setText(jTextField12.getText());
        jTextField6.setText(jTextField12.getText());
        jTextField3.setText(jTextField12.getText());
        jTextField18.setText(jTextField12.getText());
        jTextField9.setText(jTextField12.getText());
        jTextField15.setText(jTextField12.getText());


jComboBox1.setModel(jComboBox3.getModel());
        jComboBox3.setModel(jComboBox3.getModel());
        jComboBox2.setModel(jComboBox3.getModel());
        jComboBox4.setModel(jComboBox3.getModel());
        jComboBox5.setModel(jComboBox3.getModel());
        jComboBox6.setModel(jComboBox3.getModel());
        jComboBox7.setModel(jComboBox3.getModel());


jTextField4.setText(jTextField10.getText());
        jTextField7.setText(jTextField10.getText());
        jTextField10.setText(jTextField10.getText());
        jTextField13.setText(jTextField10.getText());
        jTextField16.setText(jTextField10.getText());
        jTextField19.setText(jTextField10.getText());
        jTextField22.setText(jTextField10.getText());

jDateChooser2.setDate(jDateChooser4.getDate());
        jDateChooser4.setDate(jDateChooser4.getDate());
        jDateChooser3.setDate(jDateChooser4.getDate());
        jDateChooser1.setDate(jDateChooser4.getDate());
        jDateChooser5.setDate(jDateChooser4.getDate());
        jDateChooser6.setDate(jDateChooser4.getDate());
        jDateChooser7.setDate(jDateChooser4.getDate());
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField4.setText("");
        jDateChooser1.setDate(null);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        jTextField2.setText(jTextField2.getText());
        jTextField5.setText(jTextField2.getText());
        jTextField11.setText(jTextField2.getText());
        jTextField17.setText(jTextField2.getText());
        jTextField8.setText(jTextField2.getText());
        jTextField14.setText(jTextField2.getText());
        jTextField20.setText(jTextField2.getText());

jTextField3.setText(jTextField3.getText());
        jTextField21.setText(jTextField3.getText());
        jTextField6.setText(jTextField3.getText());
        jTextField12.setText(jTextField3.getText());
        jTextField18.setText(jTextField3.getText());
        jTextField9.setText(jTextField3.getText());
        jTextField15.setText(jTextField3.getText());

jComboBox1.setModel(jComboBox1.getModel());
        jComboBox2.setModel(jComboBox1.getModel());
        jComboBox3.setModel(jComboBox1.getModel());
        jComboBox4.setModel(jComboBox1.getModel());
        jComboBox5.setModel(jComboBox1.getModel());
        jComboBox6.setModel(jComboBox1.getModel());
        jComboBox7.setModel(jComboBox1.getModel());

jTextField4.setText(jTextField4.getText());
        jTextField7.setText(jTextField4.getText());
        jTextField10.setText(jTextField4.getText());
        jTextField13.setText(jTextField4.getText());
        jTextField16.setText(jTextField4.getText());
        jTextField19.setText(jTextField4.getText());
        jTextField22.setText(jTextField4.getText());

jDateChooser2.setDate(jDateChooser1.getDate());
    jDateChooser1.setDate(jDateChooser1.getDate());
    jDateChooser3.setDate(jDateChooser1.getDate());
    jDateChooser4.setDate(jDateChooser1.getDate());
    jDateChooser5.setDate(jDateChooser1.getDate());
    jDateChooser6.setDate(jDateChooser1.getDate());
    jDateChooser7.setDate(jDateChooser1.getDate());
    }//GEN-LAST:event_jButton54ActionPerformed

    private void colorPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_colorPaneMouseClicked

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        jTextField5.setText(jTextField5.getText());
        jTextField2.setText(jTextField5.getText());
        jTextField11.setText(jTextField5.getText());
        jTextField17.setText(jTextField5.getText());
        jTextField8.setText(jTextField5.getText());
        jTextField14.setText(jTextField5.getText());
        jTextField20.setText(jTextField5.getText());

        jTextField6.setText(jTextField6.getText());
        jTextField21.setText(jTextField6.getText());
        jTextField3.setText(jTextField6.getText());
        jTextField12.setText(jTextField6.getText());
        jTextField18.setText(jTextField6.getText());
        jTextField9.setText(jTextField6.getText());
        jTextField15.setText(jTextField6.getText());

        jComboBox2.setModel(jComboBox2.getModel());
        jComboBox1.setModel(jComboBox2.getModel());
        jComboBox3.setModel(jComboBox2.getModel());
        jComboBox4.setModel(jComboBox2.getModel());
        jComboBox5.setModel(jComboBox2.getModel());
        jComboBox6.setModel(jComboBox2.getModel());
        jComboBox7.setModel(jComboBox2.getModel());

        jTextField4.setText(jTextField7.getText());
        jTextField7.setText(jTextField7.getText());
        jTextField10.setText(jTextField7.getText());
        jTextField13.setText(jTextField7.getText());
        jTextField16.setText(jTextField7.getText());
        jTextField19.setText(jTextField7.getText());
        jTextField22.setText(jTextField7.getText());

        jDateChooser1.setDate(jDateChooser2.getDate());
        jDateChooser2.setDate(jDateChooser2.getDate());
        jDateChooser3.setDate(jDateChooser2.getDate());
        jDateChooser4.setDate(jDateChooser2.getDate());
        jDateChooser5.setDate(jDateChooser2.getDate());
        jDateChooser6.setDate(jDateChooser2.getDate());
        jDateChooser7.setDate(jDateChooser2.getDate());
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        jTextField5.setText("");
        jTextField6.setText("");
        jComboBox2.setSelectedIndex(0);
        jTextField7.setText("");
        jDateChooser2.setDate(null);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void purchaseAddBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseAddBtn1ActionPerformed
        Random generateReservationID=new Random();
        int aib = generateReservationID.nextInt(1,500);
        String a = Integer.toString(aib);
        String cName = jTextField5.getText();
        String tos = jLabel18.getText();
        String ps = (String) jComboBox2.getSelectedItem();
        String no = jTextField6.getText();
        String stylistAmountString = jTextField7.getText().trim();
        int length = no.length();
        if(cName.isEmpty() || cName.isBlank()){
            JOptionPane.showMessageDialog(null, "Must input the client's name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(length != 11) {
            JOptionPane.showMessageDialog(null, "Input a valid contact number", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(stylistAmountString.isBlank() || stylistAmountString.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input the value of the stylist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(jDateChooser2.getDate()==null){
            JOptionPane.showMessageDialog(null, "Select the client's appointment date", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
            //==================VARIABLES==========================//
            String service = null;
            String cat=null;
            double amount = 0;
            //======================================================//

            //==========SELECTION FUNCTION=============================//
            if(jCheckBox5.isSelected()){
                service = jCheckBox5.getText();
                if(jCheckBox5.isSelected() && jCheckBox7.isSelected()){
                    amount = 2000;

                }
                else if(jCheckBox5.isSelected() && jCheckBox12.isSelected()){
                    amount = 2500;

                }
                else if(jCheckBox5.isSelected() && jCheckBox8.isSelected()){
                    amount = 3500;

                }
                else if(jCheckBox5.isSelected() && jCheckBox9.isSelected()){
                    amount = 500;

                }
            }
            else if (jCheckBox11.isSelected()){
                service = jCheckBox11.getText();
                if(jCheckBox11.isSelected() && jCheckBox7.isSelected()){
                    amount = 1500;

                }
                else if (jCheckBox11.isSelected() && jCheckBox12.isSelected()){
                    amount = 2000;

                }
                else if (jCheckBox11.isSelected() && jCheckBox8.isSelected()){
                    amount = 3000;

                }
                else if (jCheckBox11.isSelected() && jCheckBox9.isSelected()){
                    amount = 500;

                }
            }
            else if (jCheckBox10.isSelected()){
                service = jCheckBox10.getText();
                if(jCheckBox10.isSelected() && jCheckBox7.isSelected()){
                    amount = 1200;

                }
                else if (jCheckBox10.isSelected() && jCheckBox12.isSelected()){
                    amount = 2300;

                }
                else if (jCheckBox10.isSelected() && jCheckBox8.isSelected()){
                    amount = 2800;

                }
                else if (jCheckBox10.isSelected() && jCheckBox9.isSelected()){
                    amount = 400;

                }
            }

            if(jCheckBox7.isSelected()){
                cat = jCheckBox7.getText();
            }
            else if(jCheckBox12.isSelected()){
                cat = jCheckBox12.getText();
            }
            else if(jCheckBox8.isSelected()){
                cat = jCheckBox8.getText();
            }
            else if(jCheckBox9.isSelected()){
                cat = jCheckBox9.getText();
            }
            if(buttonGroup1.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Select the client's desired service", "Error", JOptionPane.ERROR_MESSAGE);
            }
                else if(buttonGroup2.getSelection()==null){
                    JOptionPane.showMessageDialog(null, "Select the client's desired category of the service", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String sched = jDateChooser2.getDate().toString();
                double stylistAmount=Double.parseDouble(jTextField7.getText());
                double totalAmount=stylistAmount+amount;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                    st = con.createStatement();
                    boolean tt=st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+a+"','"+jTextField2.getText()+"','"+tos+"','"+service+"','"+cat+"','"+sched+"','"+amount+"', '"+ps+"', '"+no+"')");

                }
                catch(Exception e){
                    e.printStackTrace();
                }
                //                tableModel.addRow(new Object[]{a, cName, tos, service, cat, sched, amount,ps,no});
                tableModel2.addRow(new Object[]{aib, cName, tos, service, cat, sched, totalAmount,ps,no});
                JOptionPane.showMessageDialog(null, "Added to the table");
                jTabbedPane1.setSelectedIndex(0);
                int pane = jTabbedPane1.getSelectedIndex();
                if(pane==0){

                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                }
                calculateTotal();
            }
        }
        //==========================================================================//
    }//GEN-LAST:event_purchaseAddBtn1ActionPerformed

    private void reservedTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reservedTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_reservedTableKeyPressed

    private void reservedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservedTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_reservedTableMouseClicked

    private void reservedTableHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_reservedTableHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_reservedTableHierarchyChanged

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel tableModel3 =(DefaultTableModel) reservedTable.getModel();
        String blankCashField=cashTxtFld.getText();
        int emptyTable = jTable2.getRowCount();
        if(emptyTable <=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(blankCashField.isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter the cash", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(jLabel9.getText() == ""){
            JOptionPane.showMessageDialog(null, "Please calculate the total", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else{
            
                
                    
                    //TO ADMIN================================================================
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                        String toAdmin="select * from dbtable2";
                        st=con.createStatement();
                        rs=st.executeQuery(toAdmin);
                        while (rs.next()){
                            String iddb2=String.valueOf(rs.getInt("idDB"));
                            String cdb2=rs.getString("clientDB");
                            String tosdb2=rs.getString("tosDB");
                            String servicedb2=rs.getString("serviceDB");
                            String catdb2=rs.getString("catDB");
                            String scheddb2=rs.getString("schedDB");
                            
                            String psdb2=rs.getString("stylistDB");
                            String contactdb2=rs.getString("contactDB");
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                            st=con.createStatement();
                            st.execute("insert into dbtable(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+iddb2+"','"+cdb2+"','"+tosdb2+"','"+servicedb2+"','"+catdb2+"','"+scheddb2+"','"+totalText.getText()+"', '"+psdb2+"', '"+contactdb2+"')");
                            tableModel3.addRow(new Object[]{iddb2, cdb2, tosdb2, servicedb2, catdb2, scheddb2, totalText.getText(),psdb2,contactdb2});
                            st.execute("TRUNCATE TABLE dbtable2");
                            st.execute("insert into dbtable2(idDB,clientDB,tosDB,serviceDB,catDB,schedDB,amountDB,stylistDB,contactDB)value('"+iddb2+"','"+cdb2+"','"+tosdb2+"','"+servicedb2+"','"+catdb2+"','"+scheddb2+"','"+totalText.getText()+"', '"+psdb2+"', '"+contactdb2+"')");
                            
                        }
                        JOptionPane.showMessageDialog(null, "Transaction confirmed", "Notice", JOptionPane.INFORMATION_MESSAGE);
                        
                    } catch (SQLException | ClassNotFoundException ex) {
                        System.getLogger(mainPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                    
                    //==================================================================================
                    
                    //FOR FWO OF 3RD TABLE==============================================================
                    
                    
                    //==================================================================================
                
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        int panelr = 36;
        int panelg =36;
        int panelb=36;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel6.setBackground(new Color(panelr,panelg,panelb));
        jLabel5.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=36;
        int labelg=36;
        int labelb=36;
        jPanel6.setBackground(new Color(panelr,panelg,panelb));
        jLabel5.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        int emptyTable=tableModel.getRowCount();
        if(emptyTable<=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String textFieldExtra = String.valueOf(jTextField1.getText());
            double totalAmount=Double.parseDouble(totalText.getText());
            double extraAmount=Double.parseDouble(textFieldExtra);
            double totalWithAdditional=extraAmount+totalAmount;
            String displayTotalText =String.valueOf(totalWithAdditional);
            totalText.setText(displayTotalText);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel72MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseExited
        int panelr=36;
        int panelg =36;
        int panelb=36;

        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel8.setBackground(new Color(panelr,panelg,panelb));
        jLabel72.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel72MouseExited

    private void jLabel72MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseEntered
        /*int panelr = 255;
                int panelg =255;
                int panelb=255;
                //label//
                int labelr=102;
                int labelg=102;
                int labelb=102;
                jPanel8.setBackground(new Color(panelr,panelg,panelb));
                jLabel72.setForeground(new Color(labelr,labelg,labelb));*/

        int panelr=255;
        int panelg =255;
        int panelb=255;

        int labelr=36;
        int labelg=36;
        int labelb=36;
        jPanel8.setBackground(new Color(panelr,panelg,panelb));
        jLabel72.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel72MouseEntered

    private void jLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseClicked
        int panelr = 70;
        int panelg =70;
        int panelb=70;
        //label//
        int labelr=220;
        int labelg=220;
        int labelb=220;
        jPanel30.setBackground(new Color(panelr,panelg,panelb));
        jLabel82.setForeground(new Color(labelr,labelg,labelb));
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
       int emptyTable=jTable2.getRowCount();
       if(emptyTable<=0){
           new loginForAdmin().setVisible(true);
           this.dispose();
       }
       else{
           int switchAccount=JOptionPane.showConfirmDialog(null, "Are you sure to leave your incomplete transaction?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           if(switchAccount==JOptionPane.YES_OPTION){
               try{
                       if(!st.execute("TRUNCATE TABLE dbtable2")){
                       jTextField1.setText("");
                       totalText.setText("");
                       jLabel9.setText("");
                       cashTxtFld.setText("");
                       tableModel2.setRowCount(0);
                   }
                   }
               catch(SQLException ex){
                   System.getLogger(mainPage.class.getName()).log(System.Logger.Level.ERROR, ex);
               }
               new loginForAdmin().setVisible(true);
               this.setVisible(false);
           }
           else if(switchAccount==JOptionPane.NO_OPTION){
           }
       }
    }//GEN-LAST:event_jLabel72MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
        int emptyTable = jTable2.getRowCount();
        if(emptyTable <=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(emptyTable>=0){
            int prompt=JOptionPane.showConfirmDialog(null, "Are you sure to clear the table?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(prompt==JOptionPane.YES_OPTION){
                            JOptionPane.showMessageDialog(null, "Cleared successfully");
                            jTextField1.setText("");
                            totalText.setText("");
                            jLabel9.setText("");
                            cashTxtFld.setText("");
                            tableModel2.setRowCount(0);
                        
                    }
                    else if(prompt==JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(null, "Table deletion is cancelled by the user");
                    }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
        int emptyTable = jTable2.getRowCount();
        if(emptyTable <=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(emptyTable >=0){
            int id=jTable2.getSelectedRow();
            int selectedRow=(int) tableModel2.getValueAt(jTable2.getSelectedRow(), 0);
            if(id<0){
                JOptionPane.showMessageDialog(null, "Select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(id>-1){
                try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                st = con.createStatement();
                int prompt=JOptionPane.showConfirmDialog(null, "Are you sure to delete this row?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(prompt==JOptionPane.YES_OPTION){
                    if(!st.execute("delete from dbtable2 where idDB="+selectedRow)){
                        JOptionPane.showMessageDialog(null, "Deleted successfully");
                        jTextField1.setText("");
                        tableModel2.removeRow(id);
                        calculateTotal();
                    }
                }
                else if(prompt==JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null, "Row deletion is cancelled by the user");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked

    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2KeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();

        jLabel9.setText("");
        cashTxtFld.setText("");
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTable2HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2HierarchyChanged

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        int panelr = 51;
        int panelg =51;
        int panelb=51;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel4.setBackground(new Color(panelr,panelg,panelb));
        jLabel1.setForeground(new Color(labelr,labelg,labelb));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=51;
        int labelg=51;
        int labelb=51;
        jPanel4.setBackground(new Color(panelr,panelg,panelb));
        jLabel1.setForeground(new Color(labelr,labelg,labelb));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int emptyTable = jTable2.getRowCount();
        if(emptyTable<=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Error", JOptionPane.ERROR_MESSAGE);
            cashTxtFld.setText("");
        }
        else{
            String blankCashField=cashTxtFld.getText().trim();
            if(blankCashField.isBlank()){
                JOptionPane.showMessageDialog(null, "Please enter the cash to calculate total", "Notice", JOptionPane.ERROR_MESSAGE);
            }
            /*else if(cashTf<label){
                JOptionPane.showMessageDialog(null, "Not enough cash", "Notice", JOptionPane.ERROR_MESSAGE);
            }*/
            else{
                double cashTf = Double.parseDouble(blankCashField);
                double label = Double.parseDouble(totalText.getText());
                if(cashTf<label){
                    JOptionPane.showMessageDialog(null, "Not enough cash", "Notice", JOptionPane.ERROR_MESSAGE);
                }
                else{

                    Change();
                }
                //
            }
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel70MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseExited
        int panelr = 51;
        int panelg =51;
        int panelb=51;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel9.setBackground(new Color(panelr,panelg,panelb));
        jLabel70.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel70MouseExited

    private void jLabel70MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseEntered
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=51;
        int labelg=51;
        int labelb=51;
        jPanel9.setBackground(new Color(panelr,panelg,panelb));
        jLabel70.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel70MouseEntered

    private void jLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseClicked
        cashTxtFld.setText("");
        jLabel9.setText("");
    }//GEN-LAST:event_jLabel70MouseClicked

    private void cashTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashTxtFldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        DefaultTableModel tableModel2 = (DefaultTableModel) reservedTable.getModel();
        int emptyTable = reservedTable.getRowCount();
        int id=reservedTable.getSelectedRow();
        if(emptyTable <=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(id < 0){
            JOptionPane.showMessageDialog(null, "Select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(emptyTable >= 0){
                String selectedRow =(String) tableModel2.getValueAt(reservedTable.getSelectedRow(), 0);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                    int prompt=JOptionPane.showConfirmDialog(null, "Are you sure to delete this row?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(prompt==JOptionPane.YES_OPTION){
                        st.execute("DELETE FROM dbtable2 WHERE idDB="+selectedRow);
                            JOptionPane.showMessageDialog(null, "Deleted successfully");
                            tableModel2.removeRow(id);
                        
                    }
                    else if(prompt==JOptionPane.NO_OPTION){  
                    JOptionPane.showMessageDialog(null, "Row deletion is cancelled by the user");
                }
                } catch (ClassNotFoundException | SQLException ex) {
                System.getLogger(mainPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        DefaultTableModel tableModel2 = (DefaultTableModel) reservedTable.getModel();
        int selectedRow =reservedTable.getSelectedRow();
        int emptyTable=reservedTable.getRowCount();
        if(emptyTable<=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int prompt=JOptionPane.showConfirmDialog(null, "Are you sure to clear the table?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(prompt==JOptionPane.YES_OPTION){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con =DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                    String clearFromDatabase="TRUNCATE TABLE dbtable2";
                    st.execute(clearFromDatabase);
                    JOptionPane.showMessageDialog(null, "Cleared successfully");
                    tableModel2.setRowCount(0);
            
                } catch (ClassNotFoundException | SQLException ex) {
                    System.getLogger(mainPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
            } 
            
            else if(prompt==JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(null, "Table deletion is cancelled by the user");
                    }
            }
    }//GEN-LAST:event_jButton14ActionPerformed
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
        java.awt.EventQueue.invokeLater(() -> new mainPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPane;
    private javax.swing.JPanel basicstylingPane;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public static final javax.swing.JTextField cashTxtFld = new javax.swing.JTextField();
    private javax.swing.JPanel colorPane;
    private javax.swing.JPanel formandtexturePane;
    private javax.swing.JPanel haircutPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox47;
    private javax.swing.JCheckBox jCheckBox48;
    private javax.swing.JCheckBox jCheckBox49;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox51;
    private javax.swing.JCheckBox jCheckBox52;
    private javax.swing.JCheckBox jCheckBox55;
    private javax.swing.JCheckBox jCheckBox56;
    private javax.swing.JCheckBox jCheckBox57;
    private javax.swing.JCheckBox jCheckBox58;
    private javax.swing.JCheckBox jCheckBox59;
    private javax.swing.JCheckBox jCheckBox60;
    private javax.swing.JCheckBox jCheckBox61;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private static javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private static javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel89;
    public static final javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollBar jScrollBar1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel nailcarePane;
    private javax.swing.JButton purchaseAddBtn;
    private javax.swing.JButton purchaseAddBtn1;
    private javax.swing.JButton purchaseAddBtn2;
    private javax.swing.JButton purchaseAddBtn3;
    private javax.swing.JButton purchaseAddBtn4;
    private javax.swing.JButton purchaseAddBtn5;
    private javax.swing.JButton purchaseAddBtn6;
    public javax.swing.JTable reservedTable;
    public static final javax.swing.JLabel totalText = new javax.swing.JLabel();
    private javax.swing.JPanel traditionalhighlightsPane;
    private javax.swing.JPanel treatmentPane;
    // End of variables declaration//GEN-END:variables

}



