/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import libarysystem.Book;
import libarysystem.Member;
import libarysystem.Serialization;
import libarysystem.SetOfBooks;
import libarysystem.SetOfMembers;
/**
 *
 * @author Thilina
 */
public class ReturnBooks extends javax.swing.JFrame {

    /**
     * Creates new form ReturnBooks
     */
  private SetOfMembers theMembers=new SetOfMembers();   
  private SetOfBooks holdings=new SetOfBooks();
     int timeRun=0;
    public ReturnBooks() {
        initComponents();
        
        
       try { 
            for(Book book : Serialization.deserializeBooks())
            {
                holdings.addBook(book);
            }
        } catch (IOException | ClassNotFoundException ex) {
            
        }
      
        try { 
            for(Member member : Serialization.deserializeMembers())
            {
                theMembers.addMember(member);
            }
        } catch (IOException | ClassNotFoundException ex) {
            
        }
    
        TableLoadLoans(currentLoanTable,holdings.getBorrowedBooks()); 
        
           ////////////////////////////////////////////////////////////////////////
        
         currentDate();
        
        new Thread()
        {
        public void run()
        {
        while(timeRun==0)
        {
            Calendar cal=new GregorianCalendar();
            
            int hour=cal.get(Calendar.HOUR);
            int minute=cal.get(Calendar.MINUTE);
            int second=cal.get(Calendar.SECOND);
            int AM_PM=cal.get(Calendar.AM_PM);
            String day_night=" ";
            
            if(AM_PM==1)
        {
            day_night="PM";
        }
            else
        {
            day_night="AM";
        }
            
            String time= hour+":"+minute+":"+second+" "+day_night;
            showtime.setText(time);
        }
        }
        
        }.start();  
        
        ////////////////////////////////////////////////////////////////////////
        
        
    }
       private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        // load today
        lblToday.setText(now_short_date());

    } 
       //show date
    public void currentDate(){

                    Calendar cal=new GregorianCalendar();
                    int month=cal.get(Calendar.MONTH);
                    int year=cal.get(Calendar.YEAR);
                    int day=cal.get(Calendar.DAY_OF_MONTH);
                    showdate.setText(year+"-"+(month+1)+"-"+day);
               }
    
    
    //////////////////////////////////////////////////////////////
       
       
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSeach1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMemberID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        btnComplete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentLoanTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        showdate = new javax.swing.JLabel();
        showtime = new javax.swing.JLabel();
        lblToday = new javax.swing.JLabel();
        BackgroundImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagers/logo.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 0, 280, 120);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Search   :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(240, 130, 70, 20);

        txtSeach1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSeach1KeyReleased(evt);
            }
        });
        jPanel1.add(txtSeach1);
        txtSeach1.setBounds(320, 130, 210, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Return Date : ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 160, 110, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Member ID :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 210, 90, 17);
        jPanel1.add(txtMemberID);
        txtMemberID.setBounds(100, 200, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Book ID :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 250, 80, 17);
        jPanel1.add(txtBookID);
        txtBookID.setBounds(100, 240, 150, 30);

        btnComplete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnComplete.setText("Return Books");
        btnComplete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompleteMouseClicked(evt);
            }
        });
        jPanel1.add(btnComplete);
        btnComplete.setBounds(260, 240, 140, 25);

        currentLoanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        currentLoanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currentLoanTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(currentLoanTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(210, 310, 510, 150);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Current Loan Details :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(410, 280, 160, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagers/homeButton.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(0, 0, 80, 70);

        showdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showdate.setText("..");
        jPanel1.add(showdate);
        showdate.setBounds(110, 160, 150, 20);

        showtime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        showtime.setText("..");
        jPanel1.add(showtime);
        showtime.setBounds(610, 30, 150, 40);
        jPanel1.add(lblToday);
        lblToday.setBounds(110, 150, 130, 30);

        BackgroundImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagers/bkground.jpg"))); // NOI18N
        jPanel1.add(BackgroundImg);
        BackgroundImg.setBounds(0, 0, 800, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompleteMouseClicked
        // TODO add your handling code here:
        
          if (txtMemberID.getText().equals("")) {
            
            JOptionPane.showMessageDialog(this, "Please select a book to Return","Error",JOptionPane.ERROR_MESSAGE);
            return ;
        }
    else
         {
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to return this book?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      if (response == JOptionPane.YES_OPTION)
       {
           Book book=holdings.findBookFromAccNumber(txtBookID.getText()).firstElement();
           Member member=book.getBorrower();
           theMembers.getMemberFromNumber(member.getMemberNumber()).firstElement().returnBook(book);
           holdings.return_book(book);
           TableLoadLoans(currentLoanTable,holdings.getBorrowedBooks());
            try {
                Serialization.Serialize(holdings, "Books.txt");
            } catch (IOException ex) {
                Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Serialization.Serialize(theMembers, "Members.txt");
            } catch (IOException ex) {
                Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtMemberID.setText(null);
            txtBookID.setText(null);
           JOptionPane.showMessageDialog(rootPane, "Book returned Successfully !");
       }
        }
        
        /////////////////////
    }//GEN-LAST:event_btnCompleteMouseClicked

    private void currentLoanTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentLoanTableMouseClicked
        // TODO add your handling code here:
         // get selected row
        int row = currentLoanTable.getSelectedRow();

       txtBookID.setText(currentLoanTable.getValueAt(row, 0).toString());
       try{
           txtMemberID.setText(Integer.toString((theMembers.getMemberFromName(currentLoanTable.getValueAt(row,4).toString())).firstElement().getMemberNumber()));
       }
       catch(NullPointerException e)
       {
           JOptionPane.showMessageDialog(this, e);
       }
        /////////////////////////
    }//GEN-LAST:event_currentLoanTableMouseClicked

    private void txtSeach1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeach1KeyReleased
        // TODO add your handling code here:
          if(!txtSeach1.getText().equalsIgnoreCase(""))
        {
            
              SetOfBooks searchList=new SetOfBooks();
              
              int i=0;
              for(Book book:holdings.getBorrowedBooks())
              {
                  if(book.getTitle().toLowerCase().contains(txtSeach1.getText().toLowerCase()))
                  {
                      searchList.add(book);
                  }
                  
                  i++;
              }

                TableLoadLoans(currentLoanTable,searchList);
           
            
        }
        ////////////////////////////
    }//GEN-LAST:event_txtSeach1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
          LibaryHome l=new LibaryHome();
        l.setVisible(true);
        dispose();
        
        
        
       //////////////////////////////////
    }//GEN-LAST:event_jButton1ActionPerformed

     // clear all fields
    public void clear(){
    
        txtBookID.setText(null);
        txtMemberID.setText(null);
    }
       //tableload
    public void TableLoadLoans(JTable table,SetOfBooks holdings)
    {
         table.removeAll();
        String[] colName = { "Accession Number", "ISBN Number", "Title", "Author ","Borrower"};
            Object[][] object = new Object[ holdings.size()][5];
            int i = 0;
            if ( holdings.size() != 0) {
                for (Book book :  holdings) {
                    object[i][0] = book.getAccessionNumber();
                    object[i][1] = book.getISBNNumber();
                    object[i][2] = book.getTitle();
                    object[i][3] = book.getAuthor();
                    object[i][4]=book.getBorrower().getName();
                     i++;
                   
            }
            }
            DefaultTableModel model = new DefaultTableModel(object,colName)
                    {
    public boolean isCellEditable(int row, int column)
    {
      return false;//This causes all cells to be not editable
    }
  };
            table.setModel(model);
            table.setRowSorter(new TableRowSorter<TableModel> (model));
            table.setAutoscrolls(true);
            table.getTableHeader().setReorderingAllowed(false);
        
    }
    
    
    ////////////////////////////////////////////////////
    
      public static String now_short_date() {

        String date = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(date);
        return dateFormat.format(calendar.getTime());
    }
    /////////////////////////////////////
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
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundImg;
    private javax.swing.JButton btnComplete;
    private javax.swing.JTable currentLoanTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblToday;
    private javax.swing.JLabel showdate;
    private javax.swing.JLabel showtime;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtMemberID;
    private javax.swing.JTextField txtSeach1;
    // End of variables declaration//GEN-END:variables
}