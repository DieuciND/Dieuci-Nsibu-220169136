/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 */
public class Execution {
     Supplier[] supparray= new Supplier[5];
     Customer[] custarray= new Customer[6];
     private ObjectOutputStream output;
     private ObjectInputStream input;
    
     public void custArray()
    {
        
    custarray[0]= new Customer("C150", "Luke", "Atmyass", "Bellville", "1981-01-27", 1520.50, false);
    custarray[1]= new Customer("C130", "Stu", "Padassol", "Sea Point", "1987-05-18", 645.25, true);
    custarray[2]= new Customer("C100", "Mike", "Rohsopht", "Bellville", "1993-01-24", 975.10, true);
    custarray[3]= new Customer("C300", "Ivana.B", "Withew", "Langa", "1998-07-16", 1190.50, false);
    custarray[4]= new Customer("C250", "Eileen", "Sideways", "Nyanga", "1999-11-27", 190.85, true);
    custarray[5]= new Customer("C260", "Ima", "Stewpidas", "Atlantis", "2001-01-27", 1890.70, true);
    }
    
     public void supplierList()
    {
    supparray[0]= new Supplier("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan");
    supparray[1]= new Supplier("S400", "Prime Motors", "Lexus", "Luxury sedan");
    supparray[2]= new Supplier("S300", "We got Cars", "Toyota", "10-seater minibus");
    supparray[3]= new Supplier("S350", "Auto Delight", "BMW", "Luxury SUV");
    supparray[4]= new Supplier("S290", "MotorMania", "Hyundai", "compact budget");
    }
 
     public void openFile(){
        try
        {
            
            output = new ObjectOutputStream( new FileOutputStream( "customerOutFile" ) ); 
            System.out.println("*** customerOutFile.txt file created ***\n");  
             for(int i=0;i<custarray.length;i++)
         {
             output.writeObject(custarray[i]);
            
         } 
             
            output = new ObjectOutputStream( new FileOutputStream( "supplierOutFile" ) ); 
            System.out.println("*** supplierOutFile.txt file created ***\n"); 
             for(int i=0;i<supparray.length;i++)
         {
             output.writeObject(supparray[i]);
            
         } 
            
     }
        catch (IOException ioe){
            System.out.println("error opening ser file: " + ioe.getMessage());
            System.exit(1);
        }
        try{
        output.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("error closing  file: " + ioe.getMessage());
            System.exit(1);
        }        
   
    }
 
   public void readFile()
    {
        

        try
        {
          
            input = new ObjectInputStream( new FileInputStream( "customerOutFile" ) ); 
          System.out.println("\n***Sample customer text-file output: opened for Reading ***\n"); 
          System.out.println("*** SUPPLIERS  ***\n");
          System.out.println("============================================================================================================================");
          for(int i=0;i<custarray.length;i++)
         {
             custarray[i]=(Customer)input.readObject();
             System.out.println(custarray[i]);
         } 
          
        System.out.println("============================================================================================================================");
        
             input = new ObjectInputStream( new FileInputStream( "supplierOutFile" ) ); 
            System.out.println("\n*** Sample supplier text-file output: opened for Reading ***\n");
            System.out.println("**** CUSTOMERS ***\n");
           
         System.out.println("============================================================================================================================");
            
         for(int i=0;i<supparray.length;i++)
         {
             supparray[i]=(Supplier)input.readObject();
             System.out.println(supparray[1]);
         } 
         System.out.println("============================================================================================================================\n");
      }
        
         catch(ClassNotFoundException ioe)
       {
        System.out.println("class error reading file: " + ioe);
         
       }
        catch (IOException ioe)
        {
            System.out.println("error opening file: " + ioe);
        }   
       finally
       {
        try
        {
        input.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("***file has been closed***");
           System.exit(1);
        }        
       
       }
        
    }
  
 public static void main(String args[])  {
       Execution obj = new Execution();
       obj.custArray();
       obj.supplierList();
       obj.openFile();
       obj.readFile();
   
       
       
       
    }
    
    
    
    
    
    
    
}
