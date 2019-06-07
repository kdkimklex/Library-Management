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


public class Member implements Serializable{
         private static final long serialVersionUID = -47594027994670654L;
   
  private int memberNumber;
  private String name;
  private SetOfBooks currentLoans;

  private static int memberCount=0;
    
  public Member(String aName)
  {
     name=aName;
     memberNumber=++memberCount;
     currentLoans=new SetOfBooks();
  }
public Member()
  {
     
  }

  public void borrowBook(Book aBook)
  {
    currentLoans.addBook(aBook);
    aBook.setBorrower(this);
  }
  
    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void returnBook(Book book)
  {
      
                        SetOfBooks modifiedList=new SetOfBooks();
                        modifiedList.addAll(currentLoans);
                        int i=0;
                        for(Book mbook:currentLoans)
                        {
                            if((currentLoans.elementAt(i)).getAccessionNumber() == (book.getAccessionNumber()))
                                {
                                    modifiedList.remove(i);
                            
                                    break;
                                }
                            i++;
                        }
                        currentLoans.removeAllElements();
                        
                        currentLoans.addAll(modifiedList);
                        
                   
      
  }
  
  public SetOfBooks getBooksOnLoan()
  {
      
      return currentLoans;
  }
   @Override
  public String toString()
  {
    return Integer.toString(memberNumber)+" "+name;
  }
  
   // to read and write static values
  
  private void writeObject(ObjectOutputStream oos)
        throws IOException 
    {
        oos.defaultWriteObject();
        oos.writeObject(memberCount);
        
        
    }

    private void readObject(ObjectInputStream ois)
    throws ClassNotFoundException, IOException 
    {
        ois.defaultReadObject();
        memberCount = (Integer)ois.readObject();
        
    }
  
}
