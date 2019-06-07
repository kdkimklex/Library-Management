/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libarysystem;

/**
 *
 * @author Thilina
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Book implements Serializable{
     private static final long serialVersionUID = -4961399386462512454L;
    
  private String title;
  private int accessionNumber;
  private Member borrower;
  private String ISBNNumber;
  private String author;
  
  private static int bookCount=1;
 
  public Book()
  {
      
  }
  public Book(String name)
  {
    title=name;
    borrower=null;
    accessionNumber=bookCount++;
  }
  
  public Book(String name,String ISBN,String authorName)
  {
    title=name;
    borrower=null;
    accessionNumber=bookCount++;
    ISBNNumber=ISBN;
    author=authorName;   
  }
  
   public String getISBNNumber() {
        return ISBNNumber;
    }
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getAccessionNumber() {
        return accessionNumber;
    }

    public void setBorrower(Member theBorrower) 
  {
    borrower=theBorrower;
  }

  public Member getBorrower() 
  {
    return borrower;
  }
  
  public String toString()
  {
    return Integer.toString(accessionNumber)+" "+title+" "+ISBNNumber+" "+author+" ";
  }
  
  public boolean isOnLoan()
  {
    if(this.borrower==null)
    {
        return false;
    }
    else
    {
        return true;
    }
    
  }
  
  // to read and write static values
  
  private void writeObject(ObjectOutputStream oos)
        throws IOException 
    {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(bookCount));
    }

    private void readObject(ObjectInputStream ois)
    throws ClassNotFoundException, IOException 
    {
        ois.defaultReadObject();
        bookCount = (Integer)ois.readObject();
    }
    
    
    
}
