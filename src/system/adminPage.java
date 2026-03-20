package system;

import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static system.mainPage.cashTxtFld;
import static system.mainPage.jLabel9;  
import static system.mainPage.totalText;
public class adminPage extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminPage.class.getName());
    public adminPage() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    java.sql.Connection con;
    ResultSet rs;
    PreparedStatement pst;
    Statement st;
    //================================WINDOWS OPENED DATA FROM MAINPAGE TO APPOINTMENT PAGE FROM ADMINPAGE===========================//
    public void fWO1(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                DefaultTableModel tableModel = (DefaultTableModel) salesTable.getModel();
                tableModel.addRow(tableData);   
                
                
                int numrow = salesTable.getRowCount();
                double total = 0;
                for (int g = 0; g < numrow; g++) {
                    double val = Double.parseDouble(salesTable.getValueAt(g, 6).toString());
                    total+=val;
                }
                jLabel3.setText(Double.toString(total));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.getLogger(adminPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        DefaultTableCellRenderer columnToCenter=new DefaultTableCellRenderer();
        columnToCenter.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(columnToCenter);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(columnToCenter);
    }
    //----------------------------------------------------------------------------------------//
    //================================WINDOWS OPENED IN ACCOUNT PAGE FROM ADMINPAGE==========================//
    public void fWO2(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            String query = "select * from acctableadmin";
            rs=st.executeQuery(query);
            while(rs.next()){
                String signindb=rs.getString("signinidDB");
                String userdb=rs.getString("usernameDB");
                String passdb=rs.getString("passwordDB");
                jLabel12.setText(signindb);
                jLabel23.setText(userdb);
                jPasswordField1.setText(passdb);
                uneditableFields();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
}
    //----------------------------------------------------------------------------------------//
    //============WINDOWS OPENED IN STAFF MANAGEMENT PAGE IN ADMINPAGE========================//
    public void fWO3(){
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st=con.createStatement();
            String query="select * from dbstylistadmin";
            rs=st.executeQuery(query);
            while(rs.next()){
                String iddb=String.valueOf(rs.getInt("idDB"));
                String stylistdb=rs.getString("stylistDB");
                String tableData[]={iddb,stylistdb};
                tableModel.addRow(tableData);
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            System.getLogger(adminPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(adminPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    //----------------------------------------------------------------------------------------//

    
    //==============================DELETE DATABASE FROM TABLE==============================//
    
    public void deleteDataFromDB(int id){
        String query = "delete from dbstylistadmin where idDB=?";
        try(java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", ""); PreparedStatement pst = con.prepareStatement(query)){
            pst.setInt(1, id);
            int rowAffected= pst.executeUpdate();
            
            if(rowAffected>0){
                JOptionPane.showMessageDialog(null, "Removed successfully");
            }
        } catch (SQLException ex) {
            System.getLogger(adminPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    //--------------------------------------------------------------------------------------//
    
    
    
    //===============================CLASS FOR UNEDITABLE FIELDS==============================//
    public void uneditableFields(){
        jPasswordField1.setEditable(false);
    }
    //----------------------------------------------------------------------------------------//
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        staffmanagement = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        accounts = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointments.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Administration Page");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 880, 50));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sales and Appointments");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 430, 50));

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Manage Stylist");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 270, 50));

        jPanel11.setBackground(new java.awt.Color(102, 102, 102));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Accounts");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 50));

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 210, 50));

        appointments.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 160));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Client Name", "Type of Service", "Service", "Category", "Book Schedule", "Amount", "Preferred Stylist", "Contact No."
            }
        ));
        salesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(salesTable);

        jPanel12.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 850, 180));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Reserved clients");
        jPanel12.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 850, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Total:");
        jPanel12.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("P");
        jPanel12.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 260, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Clear");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel12.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Delete");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jPanel12.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 130, 50));

        appointments.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 910, 380));

        jTabbedPane1.addTab("tab1", appointments);

        staffmanagement.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(102, 102, 102));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Administration Page");
        jPanel13.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 880, 50));

        jPanel15.setBackground(new java.awt.Color(102, 102, 102));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sales and Appointments");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel15.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 430, 50));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Manage Stylist");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 270, 50));

        jPanel17.setBackground(new java.awt.Color(102, 102, 102));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Accounts");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel17.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 210, 50));

        jPanel13.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 180, 50));

        staffmanagement.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 160));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("Add Stylist");
        jPanel18.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel18.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 440, 50));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Confirm");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        jPanel26.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jPanel18.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 100, 50));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Stylists");
        jPanel18.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Delete");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });
        jPanel27.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jPanel18.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 100, 50));

        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Stylist"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jPanel18.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 440, 180));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Clear");
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
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jPanel18.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 100, 50));

        staffmanagement.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 910, 380));

        jTabbedPane1.addTab("tab1", staffmanagement);

        accounts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(102, 102, 102));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Administration Page");
        jPanel19.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 880, 50));

        jPanel21.setBackground(new java.awt.Color(102, 102, 102));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Sales and Appointments");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel21.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));

        jPanel19.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 430, 50));

        jPanel22.setBackground(new java.awt.Color(102, 102, 102));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Manage Stylist");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel22.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        jPanel19.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 270, 50));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Accounts");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel23.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 50));

        jPanel19.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 210, 50));

        accounts.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 160));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Password:");
        jPanel24.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Username:");
        jPanel24.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel24.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 440, 40));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel24.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 440, 40));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1.setText("Show");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel24.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 30));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setForeground(new java.awt.Color(102, 102, 102));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Receptionist");
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
        });
        jPanel28.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 40));

        jPanel24.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 570, 40));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setForeground(new java.awt.Color(102, 102, 102));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Delete account");
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel31MouseExited(evt);
            }
        });
        jPanel29.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 40));

        jPanel24.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 570, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Account ID:");
        jPanel24.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText(" ");
        jPanel24.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 335, 130, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Sign up & Log in");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 40));

        jPanel24.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 570, 40));

        accounts.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 910, 380));

        jTabbedPane1.addTab("tab1", accounts);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 910, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        jTabbedPane1.setSelectedIndex(0);
        
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
jTabbedPane1.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        jTabbedPane1.setSelectedIndex(1);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        jTabbedPane1.setSelectedIndex(2);       
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        //=========================ACCOUNTS PAGE UPDATES==========================================//
        jTabbedPane1.setSelectedIndex(0);
        jPasswordField1.setEchoChar('*');
        jRadioButton1.setSelected(false);
        //=======================================================================================//
        
        
        
         
        
        
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        jTabbedPane1.setSelectedIndex(1);        // TODO add your handling code here:
        jPasswordField1.setEchoChar('*');
        jRadioButton1.setSelected(false);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        jTabbedPane1.setSelectedIndex(2);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fWO1();
        fWO2();
        fWO3();
    }//GEN-LAST:event_formWindowOpened

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       if(jRadioButton1.isSelected()){
            jPasswordField1.setEchoChar((char)0);
        }
        else{
            jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        //============================VARIABLES==========================//
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        String textField = jTextField1.getText();
        int textFieldLength=textField.length();
        int ai1;
        for(ai1=0;ai1<tableModel.getRowCount();ai1++){
        }
        //--------------------------------------------------------------//
        
        
        
        
        //============================FUNCTION==========================//
        if(textField.isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter the stylist's name", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(textFieldLength <=2){
            JOptionPane.showMessageDialog(null, "The name must be greater than 3 characters", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(textFieldLength >=25){
            JOptionPane.showMessageDialog(null, "Characters exceeded. Name must be 3-15 characters", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                st=con.createStatement();
                st.execute("insert into dbstylistadmin(idDB,stylistDB) value('"+ai1+"','"+jTextField1.getText()+"')");
            } catch (ClassNotFoundException ex) {
                System.getLogger(adminPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (SQLException ex) {
                System.getLogger(adminPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            tableModel.addRow(new Object[]{ai1, jTextField1.getText()});
            JOptionPane.showMessageDialog(null, "Added successfully");
            jTextField1.setText(null);
        }
        //--------------------------------------------------------------//
        
        
        
        
        
        
        
        //=================================INSERT TO DATABASE================================//
        
        //-----------------------------------------------------------------------------------//
        
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel26.setBackground(new Color(panelr,panelg,panelb));
        jLabel27.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel26.setBackground(new Color(panelr,panelg,panelb));
        jLabel27.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel27MouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel1.setBackground(new Color(panelr,panelg,panelb));
        jLabel4.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel1.setBackground(new Color(panelr,panelg,panelb));
        jLabel4.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        DefaultTableModel tableModel2 = (DefaultTableModel) salesTable.getModel(); 
        int emptyTable = salesTable.getRowCount();
        if(emptyTable <=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int selectedrow = salesTable.getRowCount();
        {
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            int prompt=JOptionPane.showConfirmDialog(null, "Are you sure to clear the table?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(prompt==JOptionPane.YES_OPTION){
                if(!st.execute("TRUNCATE TABLE dbtable")){
                JOptionPane.showMessageDialog(null, "Cleared successfully");
                jLabel3.setText("")                ;
                tableModel2.setRowCount(0);
            }
            }
            else if(prompt==JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Table deletion is cancelled by the user");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel27.setBackground(new Color(panelr,panelg,panelb));
        jLabel29.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel27.setBackground(new Color(panelr,panelg,panelb));
        jLabel29.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        //======================VARIABLES===============================//
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        int stylistCount=jTable1.getSelectedRow();
        /*int stylistResetCount=jTable1.getRowCount();
        Object stylistValue=jTable1.getValueAt(jTable1.getRowCount(), 0).toString();*/

        //-------------------------------------------------------------//

        //=================================FUNCTION==================================//
        if(stylistCount<=-1){
            JOptionPane.showMessageDialog(null, "Please select the stylist you want to remove", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else{

            int id=(int) tableModel.getValueAt(salesTable.getRowCount(), 0);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                st=con.createStatement();
                int prompt=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this selected stylist?");
                if(prompt==0){
                    if(!st.execute("delete from dbstylistadmin where idDB="+id)){
                        JOptionPane.showMessageDialog(null, "Deleted successfully.");
                        tableModel.removeRow(stylistCount);
                        //tableModel.addRow(new Object[]{stylistResetCount, stylistValue});//
                    }
                }
                else if(prompt==1){
                    JOptionPane.showMessageDialog(null, "Selected stylist is not remove.");
                }
                else if(prompt==2){
                    JOptionPane.showMessageDialog(null, "Stylist deletion is cancelled by the user");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                System.getLogger(adminPage.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        //---------------------------------------------------------------------------//
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel2.setBackground(new Color(panelr,panelg,panelb));
        jLabel5.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel2.setBackground(new Color(panelr,panelg,panelb));
        jLabel5.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel(); 
        int emptyTable = jTable1.getRowCount();
        if(emptyTable <=0){
            JOptionPane.showMessageDialog(null, "Table is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int selectedrow = jTable1.getRowCount();
        {
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            int prompt=JOptionPane.showConfirmDialog(null, "Are you sure to clear the table?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(prompt==JOptionPane.YES_OPTION){
                if(!st.execute("TRUNCATE TABLE dbstylistadmin")){
                JOptionPane.showMessageDialog(null, "Cleared successfully.");
                jLabel3.setText("")                ;
                tableModel.setRowCount(0);
            }
            }
            else if(prompt==JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Table deletion is cancelled by the user");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        /*int panelr = 70;
        int panelg =70;
        int panelb=70;
        //label//
        int labelr=220;
        int labelg=220;
        int labelb=220;
        jPanel28.setBackground(new Color(panelr,panelg,panelb));
        jLabel30.setForeground(new Color(labelr,labelg,labelb));
        
        this.setVisible(false);
        new loginForAdmin().setVisible(true);*/
        new mainPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel28.setBackground(new Color(panelr,panelg,panelb));
        jLabel30.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel28.setBackground(new Color(panelr,panelg,panelb));
        jLabel30.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
            String signinidLabel = jLabel12.getText();
            int deleteAccountRowCount=jTable1.getRowCount();
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            int prompt=JOptionPane.showConfirmDialog(null, "Are you sure to delete this account?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(prompt==JOptionPane.YES_OPTION){
                if(deleteAccountRowCount<=0){
                    if(!st.execute("delete from acctableadmin where signinidDB="+signinidLabel)){
                        JOptionPane.showMessageDialog(null, "Account deleted successfully");
                        new loginForAdmin().setVisible(true);
                        this.setVisible(false);
                    }
                }
                else{
                    if(!st.execute("delete from acctableadmin where signinidDB="+signinidLabel)){
                    JOptionPane.showMessageDialog(null, "Account deleted successfully");
                    st = con.createStatement();
                    if(!st.execute("TRUNCATE TABLE dbtable")){
                        DefaultTableModel adminTable;
                        adminTable = (DefaultTableModel) jTable1.getModel();
                        adminTable.setRowCount(0);
                    }
                    if(!st.execute("TRUNCATE TABLE dbstylistadmin")){
                    }
                new loginForAdmin().setVisible(true);
                this.setVisible(false);
                    }
                }
            }
            }catch(HeadlessException | ClassNotFoundException | SQLException e){
                
            }
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseEntered
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel29.setBackground(new Color(panelr,panelg,panelb));
        jLabel31.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel31MouseEntered

    private void jLabel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel29.setBackground(new Color(panelr,panelg,panelb));
        jLabel31.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel31MouseExited

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) salesTable.getModel();
        int emptyTable = salesTable.getRowCount();
        if(emptyTable <=0){
            JOptionPane.showMessageDialog(null, "Select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(emptyTable == salesTable.getRowCount()){
            String id=(String) tableModel.getValueAt(salesTable.getSelectedRow(), 0);
            int idInt=salesTable.getSelectedRow();
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
            st = con.createStatement();
            int prompt=JOptionPane.showConfirmDialog(null, "Are you sure to delete this row?", "Notice", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(prompt==JOptionPane.YES_OPTION){
                if(!st.execute("delete from dbtable where idDB="+id)){
                JOptionPane.showMessageDialog(null, "Deleted successfully");
                jTextField1.setText("");
                tableModel.removeRow(idInt);
                new mainPage().calculateTotal();
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
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel3.setBackground(new Color(panelr,panelg,panelb));
        jLabel17.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel3.setBackground(new Color(panelr,panelg,panelb));
        jLabel17.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        int panelr = 70;
        int panelg =70;
        int panelb=70;
        //label//
        int labelr=220;
        int labelg=220;
        int labelb=220;
        jPanel4.setBackground(new Color(panelr,panelg,panelb));
        jLabel24.setForeground(new Color(labelr,labelg,labelb));
        
        this.setVisible(false);
        new loginForAdmin().setVisible(true);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        int panelr = 102;
        int panelg =102;
        int panelb=102;
        //label//
        int labelr=255;
        int labelg=255;
        int labelb=255;
        jPanel4.setBackground(new Color(panelr,panelg,panelb));
        jLabel24.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        jPanel4.setBackground(new Color(panelr,panelg,panelb));
        jLabel24.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel24MouseExited

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new adminPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accounts;
    public static final javax.swing.JPanel appointments = new javax.swing.JPanel();
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public final javax.swing.JTable jTable1 = new javax.swing.JTable();
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTable salesTable;
    private javax.swing.JPanel staffmanagement;
    // End of variables declaration//GEN-END:variables
}
