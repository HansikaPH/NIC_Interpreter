/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenprojectnic;
import java.util.Calendar;
//import java.util.Scanner;
/**
 *
 * @author Hansika
 */
public class NIC_Interpreter {
    private int year, month, day;
    String gender;
    String NIC;
    int yearCode, monthCode;
    boolean isVoter;
    Calendar c;
    
 /*   public static void main(){
        Scanner input = new Scanner(System.in);
        String y = input.nextLine();
        NIC_Interpreter x = new NIC_Interpreter(y);
        
    }*/
    public NIC_Interpreter( String ID ){
        NIC = ID;
        yearCode = Integer.parseInt(NIC.substring(0,2));
        monthCode = Integer.parseInt(NIC.substring(2,5));
        findGender();
        c = Calendar.getInstance();
        c.set(c.DAY_OF_YEAR, monthCode);
    }
    
    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public String getGender() {
        return gender;
    }

    public boolean isIsVoter() {
        return isVoter;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIsVoter(boolean isVoter) {
        this.isVoter = isVoter;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public void calculateYear(){
        setYear( 1900 + yearCode );
    }
    
    public void calculateMonth (){
        
        
        setMonth(c.get(c.MONTH)+1);

   //     System.out.println(year1 + "-" +month +"-" + mydate);

    }

    public void calculateDay(){
        setDay(c.get(c.DATE)-1); 
    }     
   
    public void findGender(){
        if (monthCode > 500 ){
            gender = "FEMALE";
            monthCode -= 500;
        }
        else gender = "MALE";
    }  
    
    public void findVoter(){
        if( (2013 - getYear()) > 18 ) isVoter = true;
        else isVoter = false;
    }
}
