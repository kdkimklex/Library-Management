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
public class BarrowBook extends javax.swing.JFrame {

    /**
     * Creates new form BarrowBook
     */
      private Book SelectBK;
  private Member SelectedMemb;
  private SetOfMembers theMembers=new SetOfMembers();   
  private SetOfBooks holdings=new SetOfBooks();
  private SetOfBooks currentLoans=new SetOfBooks();
      int timeRun=0;
    public BarrowBook() {
        initComponents();
        
        
         try { 
            for(Book book : Serialization.deserializeBooks())
            {
                holdings.addBook(book);
            }
        } catch (IOException | ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(this, ex);
        }
        try { 
            for(Member member : Serialization.deserializeMembers())
            {
                theMembers.addMember(member);
            }
        } catch (IOException | ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(this, ex);
        }
        
        TableLoad(selectMemberTable,theMembers);
        TableLoad(bookDetailsTable,holdings.getNotBorrowedBooks());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        bookTitle = new javax.swing.JRadioButton();
        memberName = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtBooks = new javax.swing.JTextField();
        lblToday = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMemID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookDetailsTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        currentLoanTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        selectMemberTable = new javax.swing.JTable();
        btnlendBooks = new javax.swing.JButton();
        showdate = new javax.swing.JLabel();
        showtime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagers/logo.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(280, 10, 280, 90);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagers/homeButton.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(0, 0, 107, 90);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Search : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 110, 60, 20);

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });
        jPanel1.add(searchTxt);
        searchTxt.setBounds(130, 110, 170, 30);

        buttonGroup1.add(bookTitle);
        bookTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bookTitle.setText("Book Title");
        jPanel1.add(bookTitle);
        bookTitle.setBounds(320, 110, 110, 25);

        buttonGroup1.add(memberName);
        memberName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        memberName.setText("Member Name");
        jPanel1.add(memberName);
        memberName.setBounds(450, 110, 130, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Collected Date :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 150, 120, 17);

        txtBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBooksActionPerformed(evt);
            }
        });
        jPanel1.add(txtBooks);
        txtBooks.setBounds(140, 180, 140, 30);
        jPanel1.add(lblToday);
        lblToday.setBounds(140, 150, 140, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Book ID :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 190, 80, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Member ID :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 230, 100, 20);
        jPanel1.add(txtMemID);
        txtMemID.setBounds(140, 220, 140, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Book Details : ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(330, 150, 120, 30);

        bookDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bookDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookDetailsTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookDetailsTableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(bookDetailsTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(330, 180, 440, 110);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Current Loan Details :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(90, 320, 150, 17);

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
        jScrollPane3.setViewportView(currentLoanTable);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(90, 340, 640, 110);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Member Details :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(90, 480, 120, 17);

        selectMemberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        selectMemberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMemberTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(selectMemberTable);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(90, 500, 640, 110);

        btnlendBooks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlendBooks.setText("Lend Book");
        btnlendBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlendBooksActionPerformed(evt);
            }
        });
        jPanel1.add(btnlendBooks);
        btnlendBooks.setBounds(140, 260, 120, 25);

        showdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.add(showdate);
        showdate.setBounds(610, 80, 210, 30);

        showtime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(showtime);
        showtime.setBounds(620, 10, 200, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagers/bkground.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 840, 640);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LibaryHome l=new LibaryHome();
        l.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBooksActionPerformed

    private void btnlendBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlendBooksActionPerformed
        // TODO add your handling code here:
        if (txtBooks.getText().equals("")) {
            
            JOptionPane.showMessageDialog(this, "Please select a book to Loan","Error",JOptionPane.ERROR_MESSAGE);
            return ;
        }
    else if(txtMemID.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this, "Please select a Member to Loan","Error",JOptionPane.ERROR_MESSAGE);
        return ;
    }
else
    {
                int isCnf = JOptionPane.showConfirmDialog(this, "Do you want to proceed", "confirm", JOptionPane.OK_CANCEL_OPTION);

                System.out.println(isCnf);
                if (isCnf == 0) {
                    try{
                        
                       lendBooks();
                       txtBooks.setText(null);
                       txtMemID.setText(null);
                    }
                    catch(Exception ex)
                    {
                        
                    }
                    
                }
                else
                {
                    return;
                }
            }
        
        
        
        
        
        
    }//GEN-LAST:event_btnlendBooksActionPerformed

    private void bookDetailsTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookDetailsTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bookDetailsTableMouseEntered

    private void bookDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookDetailsTableMouseClicked
        // TODO add your handling code here:
          // get selected row
        int row = bookDetailsTable.getSelectedRow();

        txtBooks.setText(bookDetailsTable.getValueAt(row, 0).toString());       
  ////////////////////////////////////////////      
    }//GEN-LAST:event_bookDetailsTableMouseClicked

    private void selectMemberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMemberTableMouseClicked
        // TODO add your handling code here:
           int row = selectMemberTable.getSelectedRow();
        txtMemID.setText(selectMemberTable.getValueAt(row, 0).toString());     
        ///////////////////////////
    }//GEN-LAST:event_selectMemberTableMouseClicked

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        // TODO add your handling code here:
        if(searchTxt.getText().toString() != "")
 {
     
        
     if(bookTitle.isSelected())
        {
            
            SetOfBooks searchList=new  SetOfBooks();
           searchList=holdings.getNotBorrowedBooks().findBookByTitle(searchTxt.getText().toString());
           TableLoad(bookDetailsTable,searchList); 
        }
        else if(memberName.isSelected())
        {
            
        SetOfMembers searchList=new  SetOfMembers();
            searchList=theMembers.getMemberFromName(searchTxt.getText().toString());
               TableLoad(selectMemberTable,searchList); 
        }
    } 
        ///////////
    }//GEN-LAST:event_searchTxtKeyReleased
 //loan book method
    
    public void lendBooks() throws IOException, ClassNotFoundException
  {
      /*SelectedMemb is a object of Member class 
      have to use firstElement() method to get the first element of the setofMembers
      */
     SelectedMemb=theMembers.getMemberFromNumber(Integer.parseInt(txtMemID.getText())).firstElement();
     SelectBK=holdings.findBookFromAccNumber(txtBooks.getText()).firstElement();
        
      if(SelectedMemb.getBooksOnLoan().size()>=3)
      {
        JOptionPane.showMessageDialog(rootPane, "This member has already borrowed maximum of 3 books !");    
      }
      else
      {
          
      SelectedMemb.borrowBook(SelectBK);
       Serialization.Serialize(holdings, "Books.txt");
      Serialization.Serialize(theMembers, "Members.txt");
      JOptionPane.showMessageDialog(rootPane, "Book borrowed Successfully !");
      TableLoadLoans(currentLoanTable,holdings.getBorrowedBooks());
    TableLoad(bookDetailsTable,holdings.getNotBorrowedBooks());
      
      }
      
  }
    
    
    //////////////////////////////////////////////
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
      public void TableLoad(JTable table,SetOfBooks holdings)
    {
        String[] colName = { "Accession Number", "ISBN Number", "Title", "Author "};
            Object[][] object = new Object[ holdings.size()][4];
            int i = 0;
            if ( holdings.size() != 0) {
                for (Book book :  holdings) {
                    object[i][0] = book.getAccessionNumber();
                    object[i][1] = book.getISBNNumber();
                    object[i][2] = book.getTitle();
                    object[i][3] = book.getAuthor();
                    i++;
                  
                }    
            }
            //DefaultTableModel is used to change the template of the table according to our requirements
            
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
    
    //////////////////////
       //member table load
    
     //tableload
    public void TableLoad(JTable table,SetOfMembers theMembers)
    {
        String[] colName = { "Member ID", "Name"};
            Object[][] object = new Object[ theMembers.size()][2];
            int i = 0;
            if ( theMembers.size() != 0) {
                for (Member member : theMembers) {
                    object[i][0] = member.getMemberNumber();
                    object[i][1] = member.getName();
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
    
     public static String now_short_date() {

        String date = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(date);
        return dateFormat.format(calendar.getTime());
    }
      
      
    //////////////////////////  
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
            java.util.logging.Logger.getLogger(BarrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarrowBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookDetailsTable;
    private javax.swing.JRadioButton bookTitle;
    private javax.swing.JButton btnlendBooks;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable currentLoanTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblToday;
    private javax.swing.JRadioButton memberName;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTable selectMemberTable;
    private javax.swing.JLabel showdate;
    private javax.swing.JLabel showtime;
    private javax.swing.JTextField txtBooks;
    private javax.swing.JTextField txtMemID;
    // End of variables declaration//GEN-END:variables
}
