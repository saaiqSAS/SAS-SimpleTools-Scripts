package com.sas.textrepeater;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

private static String text = "";
private static int repNum;
private static String filePath = "";
private static FileWriter saveFile;

  public static void main(String[] args) {
   System.out.println("SAS-TextRepeater v1.0");
   System.out.println("=====================\n");
   askText();
   getNumRepeat();
   getSaveFile();
   crtFile();
   repeat();
  }
  
  
  private static void askText() {
    Scanner grab = new Scanner(System.in);
 
    System.out.println("Enter the text you want to repeat: ");
    text = grab.next() + grab.nextLine(); 
  }
  
  
  private static void getNumRepeat(){
    Scanner grab = new Scanner(System.in);
    
    System.out.println("\nEnter the number of times you want to repeat: ");
    try{
    repNum = grab.nextInt();
    }catch (Exception e){
      System.out.println("\nError!!! Pls Enter A Number");
      askText();
    }
  }
  
  
  private static void getSaveFile() {
    Scanner grab = new Scanner(System.in);
    
    System.out.println("\nEnter the path to save file: ");
    filePath = grab.next();
  }
  
  
  private static void crtFile() {
  Scanner grab = new Scanner(System.in);
  
    File file = new File(filePath);
    
    if (file.exists() == false) { 
      System.out.println("\nError file not found!!! \nDo you want to create file "+filePath+"? \n [1] Yes \n [2] No ");
      String mknwFile = grab.next();
      
      switch (mknwFile) {
        case "1":
         System.out.println("\n[+]Creating file "+ filePath);
         break;
        case "2":
         getSaveFile();
         break;
        default:
         System.out.println("Error!!! Pls Enter A Number From The Given Options");
         crtFile();
      };    
    }
  }
  
  
  private static void repeat() {
  try {
    saveFile = new FileWriter(filePath, true);
    int cnumRep = 0;
    
    while (repNum >= cnumRep) {
      saveFile.write(text+"\n");
      cnumRep+=1;
    };
    saveFile.close();
    }catch (Exception e){};
    
    System.out.println("\n[+]Finished");
  }
  
}
