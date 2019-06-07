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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
    public static final String FILE_NAME_BOOKS = "Books.txt";
    public static final String FILE_NAME_MEMBERS = "Members.txt";

    public static void Serialize(Object object, String filename) throws IOException 
        {

		FileOutputStream out = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(object);
		oos.flush();
		out.close();
                System.out.println(filename+" Serialized -successful !!");
	}

public static SetOfBooks deserializeBooks()throws IOException, ClassNotFoundException
  {

		FileInputStream in = new FileInputStream(FILE_NAME_BOOKS);
		ObjectInputStream ois = new ObjectInputStream(in);
		SetOfBooks books = (SetOfBooks) ois.readObject();
		in.close();
                System.out.println(FILE_NAME_BOOKS+" Deserialized -successful!");
		return books;
  }

 public static SetOfMembers deserializeMembers()throws IOException, ClassNotFoundException
  {

		FileInputStream in = new FileInputStream(FILE_NAME_MEMBERS);
		ObjectInputStream ois = new ObjectInputStream(in);
		SetOfMembers members = (SetOfMembers) ois.readObject();
		in.close();
                System.out.println(FILE_NAME_MEMBERS+" Deserialized !");
		return members;
  }





}

