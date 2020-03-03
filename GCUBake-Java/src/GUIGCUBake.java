/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class GUIGCUBake extends javax.swing.JFrame {
    
    //Global variables
    
    GCUuser theUser; 

    /**
     * Creates new form GUIGCUBake
     */
    public GUIGCUBake() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedGCUBake = new javax.swing.JTabbedPane();
        pnlView = new javax.swing.JTabbedPane();
        pnlBook = new javax.swing.JTabbedPane();
        pnlCreate = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JTabbedPane();
        pnlDelete = new javax.swing.JTabbedPane();
        lblUserView = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GCUBake");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabbedGCUBake.addTab("View Lesson", pnlView);
        tabbedGCUBake.addTab("Book Lesson", pnlBook);
        tabbedGCUBake.addTab("Create Lesson", pnlCreate);
        tabbedGCUBake.addTab("Edit Lesson", pnlEdit);
        tabbedGCUBake.addTab("Delete Lesson", pnlDelete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tabbedGCUBake, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUserView)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblUserView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(tabbedGCUBake, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        tabbedGCUBake.getAccessibleContext().setAccessibleName("View Lesson");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //test registering
        
        
        register();
        //checklogin();
    }//GEN-LAST:event_formWindowOpened

    // Methods here
    
    
public void userDisplay(){
        GCUUser_Data_Handler myCheckAccount = new GCUUser_Data_Handler();
            myCheckAccount.checkUserIsValid(theUser);

            if (myCheckAccount.checkUserIsValid(theUser)){
                lblUserView.setText( theUser.getUsername());
            }
    }
    public void checklogin()
    {
        //programatically create the labels and texfields for the optionpane
        JLabel label_login = new JLabel("Username:");
        JTextField login = new JTextField();
        JLabel label_password = new JLabel("Password:");
        JPasswordField password = new JPasswordField();
        //-----------------------------------------------------
        // store these in an object array
        Object[] login_GUI_Elelemnts = {label_login, login, label_password, password};
        //-----------------------------------------------------
        int userInteraction = JOptionPane.showConfirmDialog(null, login_GUI_Elelemnts, "Login",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        
        
        // this integer variable 'userInteraction' will hold the result of
        //the users interaction with the JOpttionPane
        //we will then test the result against common returned values. OK OPtion , Cancel , Closed
        //-----------------------------------------------------
        if (userInteraction == JOptionPane.OK_OPTION) {
            String user = login.getText().trim(); // user string that the user entered in the textfield
            String pass = new String(password.getPassword()); //pulls the password string from textfield
            Boolean entryGranted = false;// setup boolean as false.

           GCUuser  theUser = new GCUuser();
            theUser.setUsername(user);
            theUser.setPassCode(Integer.parseInt(pass));

            System.out.println("The users data is now " + theUser.toString());

            GCUUser_Data_Handler theUsersDataHandler = new GCUUser_Data_Handler();
            if (theUsersDataHandler.checkUserIsValid(theUser)) {
                theUser = theUsersDataHandler.getValidUser(theUser);
                System.out.println("The users data is now: " + theUser.toString());
            }

           //************************************Customer********************************* 
            if (theUser.getGcuRole().toUpperCase().equals("CUSTOMER")) {
                JOptionPane.showMessageDialog(this, "Logged in as Customer \nAll Chef and Admin panels will be removed");
                
                //If an ordinary user logged in then remove the panel tabs that relate to administrators.
                this.tabbedGCUBake.remove(pnlCreate); //removes the create tab
                this.tabbedGCUBake.remove(pnlEdit); //removes the edit tab
                this.tabbedGCUBake.remove(pnlDelete);// removes the delete tab
                
                entryGranted = true;
                
            }
            if (theUser.getGcuRole().toUpperCase().equals("CHEF")) {
                JOptionPane.showMessageDialog(this, "Logged in as Chef\nAccess granted to all areas");
                entryGranted = true;
            }
            if (!entryGranted) //entry denied
            {
                JOptionPane.showMessageDialog(this, "Entry Denied");
                userInteraction = JOptionPane.CANCEL_OPTION;
            }
        } else {//user clicked on CANCEL or the X close button- we change the userInteraction to force execution of the CANCEL block of code
            userInteraction = JOptionPane.CANCEL_OPTION;
        }
        if ((userInteraction == JOptionPane.CANCEL_OPTION) || (userInteraction == JOptionPane.CLOSED_OPTION)) // the cancel block of code - if user presses the X or CANCEL
        {
            //feedback to user and close the application as no suitable login credentials have been supplied.
            JOptionPane.showMessageDialog(this, "You have not supplied valid credentials\n the application will now terminate");
            System.exit(0);
        }

    }
    
    /*
    Notes for Register
    
    Register- fill out the textbox and taken to the login page
        already a member; where they will taken to the login form
    */
    public void register()
    {
        //programatically create the labels and texfields for the optionpane
        
        JLabel label_message = new JLabel("Please enter your details to register");
        
        JLabel label_login = new JLabel("Username:");
        JTextField login = new JTextField();
        
//-----------------------------------------------------
        // store these in an object array
        Object[] Register_GUI_Elelemnts = {label_login, login};
        /*-----------------------------------------------------buttons of the register page -
        Register- fill out the textbox and taken to the login page
        already a member; where they will taken to the login form
        
        
        */
        int userInteraction = JOptionPane.showConfirmDialog(null, Register_GUI_Elelemnts, "Register",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        
    
    }




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
            java.util.logging.Logger.getLogger(GUIGCUBake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIGCUBake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIGCUBake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIGCUBake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIGCUBake().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblUserView;
    private javax.swing.JTabbedPane pnlBook;
    private javax.swing.JTabbedPane pnlCreate;
    private javax.swing.JTabbedPane pnlDelete;
    private javax.swing.JTabbedPane pnlEdit;
    private javax.swing.JTabbedPane pnlView;
    private javax.swing.JTabbedPane tabbedGCUBake;
    // End of variables declaration//GEN-END:variables
}
