/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenprojectnic.exception;

/**
 *
 * @author User 123
 */
public class InvalidNicInterpreterException extends Exception{
    
    public InvalidNicInterpreterException() {
		super("Invalid NIC entered.");
	}
}
