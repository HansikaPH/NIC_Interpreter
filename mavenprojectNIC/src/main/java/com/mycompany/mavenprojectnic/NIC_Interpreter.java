/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenprojectnic;
import java.util.Calendar;
import java.util.regex.Matcher;
import com.mycompany.mavenprojectnic.NICprop;
import com.mycompany.mavenprojectnic.exception.InvalidNicInterpreterException;

//import java.util.Scanner;
/**
 *
 * @author Hansika
 */
public class NIC_Interpreter {
    private int year, month, day;
    private String gender;
    private int yearCode, monthCode;
    private boolean isVoter;
    private Calendar c;
    
    public NICprop createNICprop( String ID ) throws InvalidNicInterpreterException{
        try{
            return new NICprop(ID);
        }
        catch( Exception ex ){
            throw new InvalidNicInterpreterException(); 
        }
        
    }
    
    public void checkValidity( NICprop prop ) throws InvalidNicInterpreterException{
        if( !validate( prop ) ) throw new InvalidNicInterpreterException();
        
        else{
            yearCode = Integer.parseInt(prop.getNIC().substring(0,2));
            monthCode = Integer.parseInt(prop.getNIC().substring(2,5));
            findGender();
            c = Calendar.getInstance();
            c.set(c.DAY_OF_YEAR, monthCode);
        } 
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

    public boolean isVoter() {
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
    
    public boolean validate( NICprop prop ){
        if( prop.getNIC().length() == 10 && (prop.getNIC().charAt(9) == 'v' || prop.getNIC().charAt(9) == 'V') && (prop.getNIC().substring(0, 9)).matches("[0-9]+")){
            return true;
        }
        else return false;
        
    }
    public String output(){
        return String.format("Nic[birthday=BirthDay[year=%d, month = %d, date = %d], gender = %s, isVoter = %b]",getYear(),getMonth(),getDay(),getGender(),isVoter());
    }
}
