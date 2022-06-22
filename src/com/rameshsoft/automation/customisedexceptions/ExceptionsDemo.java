package com.rameshsoft.automation.customisedexceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionsDemo {
public static void main(String[] args) {
	System.out.println("1");
	System.out.println("2");
	try {
		FileInputStream fip = new FileInputStream("D:\\new10ambatch1\\frameworks\\config.properties");
		System.out.println("Outer try block");
		try {
			System.out.println("Inner try block");
		}
		catch(Exception exception) {
			System.out.println("Inner catch block");
		}
	}
	catch(FileNotFoundException exception) {
		System.out.println("FNFE: Catch block");
		try {
			System.out.println("Inner try block");
		}
		catch(Exception exception1) {
			System.out.println("Inner catch block");
		}
	}
	catch(Exception exception) {
		System.out.println("Exception: Catch block");
	}
	finally
	{
		System.out.println("Finally block");
	}
	System.out.println("3");
	System.out.println("4");
}
}

