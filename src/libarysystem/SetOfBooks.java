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
import java.io.Serializable;
import java.util.Vector;

public class SetOfBooks extends Vector<Book> implements Serializable{
     private static final long serialVersionUID = 4277168882107543981L;
   
    private SetOfBooks  modifiedList;  

public SetOfBooks()
  {
      /*calling the defoult constructor of the vector class
      if we didn't call the super() this will not become a vector
      vector is also like an arraylist bt we don't want to initilized the vector like arrays
      */
    super();
  }
 public void addBook(Book aBook)
  {
    super.add(aBook);
  }
public void removeBook(Book aBook)
  {
    super.remove(aBook);
  }
public SetOfBooks findBookByAuthor(String author)
  {
      modifiedList=new SetOfBooks();
      
      for (Book book : this) 
      {
	if (book.getAuthor().toLowerCase().contains(author.toLowerCase()))
            {
		modifiedList.add(book);
            }
      }
		return modifiedList;
  }
public SetOfBooks findBookByTitle (String title)
  {
     modifiedList=new SetOfBooks();
      
      for (Book book : this) 
      {
	if (book.getTitle().toLowerCase().contains(title.toLowerCase())) 
            {
		modifiedList.add(book);
            }
      }
		return modifiedList;
  }
public SetOfBooks findBookFromAccNumber(String number)
  {
     modifiedList=new SetOfBooks();
    
      for (Book book : this) 
      {
        if (Integer.toString(book.getAccessionNumber()).equalsIgnoreCase(number)) 
            {
			
                modifiedList.add(book);
            }
      }
        return modifiedList;
		
  }
 public SetOfBooks findBookFromISBN(String ISBN)
  {
      modifiedList=new SetOfBooks();
      
      for (Book book : this) 
      {
            if (book.getISBNNumber().equalsIgnoreCase(ISBN)||book.getISBNNumber().startsWith(ISBN)) 
                {
                    modifiedList.add(book);
		}
      }
	return modifiedList;
  }
 public SetOfBooks getNotBorrowedBooks()
  {
      		
                modifiedList=new SetOfBooks();
                
                modifiedList.addAll(this);
                        int i=0;
                        for(Book mbook:this)
                        {
                            if(modifiedList.elementAt(i).isOnLoan())
                            {
                                modifiedList.remove(i);
                                i--;
                            }
                                i++;
                            
                        }

                return modifiedList;
		
  }
  public SetOfBooks getBorrowedBooks()
  {
            modifiedList=new SetOfBooks();
                        int i=0;
                        for(Book book:this)
                        {
                            if(book.isOnLoan())
                                {
                                     modifiedList.add(book);
                                }
                            i++;
                            
                        }
                        
                return modifiedList;
             
  }
  public void return_book(Book objbook)
  {
      this.elementAt(this.indexOf(objbook)).setBorrower(null);
      
  }

}


