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
import javax.swing.JOptionPane;

public class SetOfMembers extends Vector<Member> implements Serializable
{
    private static final long serialVersionUID = 2428035439452881234L;
    
    SetOfMembers modifiedList;
     public SetOfMembers()
  {
    super();
  }
     public void addMember(Member aMember) 
  {
    super.add(aMember);
  }
    
     public boolean removeMember(Member member)
  {
      return super.remove(member);
  }
     public SetOfMembers getMemberFromName(String name)
  {
     modifiedList=new SetOfMembers();
  
      for(Member member:this)
      {
          if(member.getName().toLowerCase().contains(name.toLowerCase()))
          {
              modifiedList.addMember(member);
             
          }
      }
         return modifiedList; 
  }
     public SetOfMembers getMemberFromNumber(int number)
  {
      modifiedList=new SetOfMembers();
      for(Member member:this)
      {
          if(member.getMemberNumber()==number)
          {
             modifiedList.addMember(member);
              
          }
      }
      
      return modifiedList; 
  }
}
