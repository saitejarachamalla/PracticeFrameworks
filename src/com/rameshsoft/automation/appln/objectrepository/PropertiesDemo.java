package com.rameshsoft.automation.appln.objectrepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
public static void main(String[] args) throws IOException {
	
	
	//File file = new File("D:\\new10ambatch\\frameworks\\config.properties");
	//FileInputStream fip = new FileInputStream(file);
	
	FileInputStream fip = new FileInputStream("D:\\new10ambatch\\frameworks\\config.properties");
	
	Properties properties = new Properties();
	properties.load(fip);
	
	properties.setProperty("hello", "java");
	properties.put("java", "python");
	properties.setProperty("hardwork", "life");
	properties.put("job", "solution");
	
	FileOutputStream fop = new FileOutputStream("D:\\new10ambatch\\frameworks\\config.properties");
	properties.store(fop, "File is saved successfully");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*String val1 = properties.getProperty("qa_url");
	System.out.println(val1);
	
	String val2 = properties.getProperty("qa_un456","java with selenium");
	System.out.println(val2);
	
	String val3 = properties.getProperty("qa_reports");
	System.out.println(val3);
	
	String val4 = properties.getProperty("qa_pwd");
	System.out.println(val4);
	
	String val5 = properties.getProperty("dev_url");
	System.out.println(val5);
	
	
	Set setKeys = properties.keySet();
	for(Object obj : setKeys)
	{
		String key = (String) obj;
		String value = properties.getProperty(key);
		System.out.println(key+" *********** "+value);
	}
	
	*/
	
	
	
	
	
}
}
