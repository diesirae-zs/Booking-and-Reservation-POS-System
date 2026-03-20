
package system;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;


public class loginForAdmin extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(loginForAdmin.class.getName());
    public loginForAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
        jTextField5.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String id = jTextField5.getText();
                    if(id.isBlank()){
                        JOptionPane.showMessageDialog(null, "ID must not be blank", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        jTextField1.requestFocus();
                    }
                }
            }
        });
        
        
        jTextField1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String user_field = jTextField1.getText();
                    if(user_field.isBlank()){
                        JOptionPane.showMessageDialog(null, "Username must not be blank", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        jPasswordField1.requestFocus();
                    }
                }
            }
        });
        
        
        jPasswordField1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String password_field = jPasswordField1.getText();
                    if(password_field.isBlank()){
                        JOptionPane.showMessageDialog(null, "Password must not be blank", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        
                    }
                }
            }
        });
        
        
        jTextField3.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String user_field_signup = jTextField3.getText();
                    if(user_field_signup.isBlank()){
                        JOptionPane.showMessageDialog(null, "Username must not be blank", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        jPasswordField2.requestFocus();
                    }
                }
            }
        });
        
        
        jPasswordField2.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String password_field_signup = jPasswordField2.getText();
                    if(password_field_signup.isBlank()){
                        JOptionPane.showMessageDialog(null, "Password must not be blank", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        
                    }
                }
            }
        });
        
        
    }
    
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    Statement st;
    
    //==================CLASSES===================================================================================//
    
    public void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/acc", "root", "");
            } catch(Exception ex){
                JOptionPane.showMessageDialog(this, "No data");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No Driver");
        }
    }

    
    //============================================================================================================//
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        loginReceptionist = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jRadioButton1 = new javax.swing.JRadioButton();
        signinReceptionist = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPasswordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginReceptionist.setBackground(new java.awt.Color(102, 102, 102));
        loginReceptionist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Log in");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sign in");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 50));

        loginReceptionist.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 460));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Log in to proceed");
        loginReceptionist.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 430, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        loginReceptionist.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 230, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Confirm");
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        loginReceptionist.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 230, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID");
        loginReceptionist.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        loginReceptionist.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        loginReceptionist.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 230, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Username");
        loginReceptionist.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginReceptionist.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 230, 40));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Show password");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        loginReceptionist.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        jTabbedPane1.addTab("tab1", loginReceptionist);

        signinReceptionist.setBackground(new java.awt.Color(102, 102, 102));
        signinReceptionist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Log in");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 50));

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sign in");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 50));

        signinReceptionist.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 460));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sign in to proceed");
        signinReceptionist.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 430, -1));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        signinReceptionist.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 230, 40));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Confirm");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        signinReceptionist.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 230, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Username");
        signinReceptionist.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Password");
        signinReceptionist.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Show password");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        signinReceptionist.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        jPasswordField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signinReceptionist.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 230, 40));

        jTabbedPane1.addTab("tab1", signinReceptionist);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 570, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        
        jPanel6.setBackground(new Color(panelr,panelg,panelb));
        jLabel4.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        //=====================DESIGN===========================================================//
        int panelr = 220;
        int panelg =220;
        int panelb=220;
        //label//
        int labelr=70;
        int labelg=70;
        int labelb=70;
        jPanel6.setBackground(new Color(panelr,panelg,panelb));
        jLabel4.setForeground(new Color(labelr,labelg,labelb));
        //==============================================================//
        
        
        
        
        //==========================FUNCTION========================================================//
        
        String signinIDText=jTextField5.getText();
        String userText = jTextField1.getText();
        char[] passChar=jPasswordField1.getPassword();
        String passText =String.valueOf(passChar);
        int userLength = userText.length();
        int passLength = passText.length();
        
        if(userText.isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter your username", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(passText.isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter your password", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(userLength > 25){
            JOptionPane.showMessageDialog(null, "Username character exceeded", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(userLength <=4){
            JOptionPane.showMessageDialog(null, "Username must be at least 10 characters long", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(passLength>40){
            JOptionPane.showMessageDialog(null, "Password character exceeded", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(passLength<=10){
            JOptionPane.showMessageDialog(null, "Password must be at least 15 characters long", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(passText.contains(" ")){
            JOptionPane.showMessageDialog(null, "Password must not have spaces", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(userText.contains(" ")){
            JOptionPane.showMessageDialog(null, "Username must not have spaces", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String query=("select * from `acctableadmin` where signinidDB=? and usernameDB=? and passwordDB=?");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                st = con.createStatement();
                pst=con.prepareStatement(query);
                pst.setString(1, jTextField5.getText());
                pst.setString(2, jTextField1.getText());
                pst.setString(3, passText);
                rs=pst.executeQuery();
                /*
        jLabel1.setText(getPasswordToString);*/
                if(rs.next()){
                    this.dispose();
                    new adminPage().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome back!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "No account found", "Notice", JOptionPane.ERROR_MESSAGE);
                    this.setVisible(true);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                System.getLogger(loginForAdmin.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
                    
        }
        //==========================================================================================//
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        //=====================DESIGN===========================================================//
        //==============================================================//
        
        
        
        
        //==========================FUNCTION========================================================//
        jTabbedPane1.setSelectedIndex(1);
        jTextField1.setText("");
        jTextField5.setText("");
        jPasswordField1.setText("");
        //==========================================================================================//
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        //=====================DESIGN===========================================================//
        int panelr = 220;
        int panelg =220;
        int panelb=220;
        //label//
        int labelr=70;
        int labelg=70;
        int labelb=70;
        jPanel11.setBackground(new Color(panelr,panelg,panelb));
        jLabel10.setForeground(new Color(labelr,labelg,labelb));
        //=====================FUNCTION=========================================//
        Random generateReservationID=new Random();
        String signinID=String.valueOf(generateReservationID.nextInt(1,500));
        String userText = jTextField3.getText();
        char[] passChar2=jPasswordField2.getPassword();
        String passText2 =String.valueOf(passChar2);
        int userLength = userText.length();
        int passLength = passText2.length();
        if(userText.isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter your username", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(passText2.isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter your password", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(userLength > 25){
            JOptionPane.showMessageDialog(null, "Username character exceeded", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(userLength <=4){
            JOptionPane.showMessageDialog(null, "Username must be at least 10 characters long", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(passLength>40){
            JOptionPane.showMessageDialog(null, "Password character exceeded", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(passLength<=10){
            JOptionPane.showMessageDialog(null, "Password must be at least 15 characters long", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(passText2.contains(" ")){
            JOptionPane.showMessageDialog(null, "Password must not have spaces", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else if(userText.contains(" ")){
            JOptionPane.showMessageDialog(null, "Username must not have spaces", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbforct", "root", "");
                st = con.createStatement();
                boolean t=st.execute("insert into acctableadmin(signinidDB,usernameDB,passwordDB) value ('"+signinID+"','"+jTextField3.getText()+"', '"+passText2+"')");
            } catch (ClassNotFoundException | SQLException ex) {
                System.getLogger(loginForAdmin.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            new adminPage().setVisible(true);
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Account created successfully");
            
                    
        }
            //==========================================================================================//
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        int panelr = 255;
        int panelg =255;
        int panelb=255;
        
        //label//
        int labelr=102;
        int labelg=102;
        int labelb=102;
        
        jPanel11.setBackground(new Color(panelr,panelg,panelb));
        jLabel10.setForeground(new Color(labelr,labelg,labelb));
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        jTextField3.setText("");
        jPasswordField2.setText("");
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            jPasswordField1.setEchoChar((char)0);
        }
        else{
            jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected()){
            jPasswordField2.setEchoChar((char)0);
        }
        else{
            jPasswordField2.setEchoChar('*');
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

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
        java.awt.EventQueue.invokeLater(() -> new loginForAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel loginReceptionist;
    private javax.swing.JPanel signinReceptionist;
    // End of variables declaration//GEN-END:variables
}
