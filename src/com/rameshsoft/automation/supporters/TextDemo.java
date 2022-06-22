package com.rameshsoft.automation.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextDemo {
public static void main(String[] args) throws IOException {
	
	
	File file = new File("D:\\new10ambatch\\frameworks\\src\\com\\rameshsoft\\automation\\supporters\\demo.txt");
	
	boolean status = file.createNewFile();
	if (status) {
		System.out.println("File is created newly.....");
	}
	else {
		System.out.println("Returns existing file!");
	}
	FileReader fileReader = new FileReader(file);
	BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	while(bufferedReader.ready())
	{
		String data = bufferedReader.readLine();
		System.out.println(data);
	}
	
	
	//FileWriter fw = new FileWriter(file);
	FileWriter fw = new FileWriter(file,true);
	BufferedWriter bw = new BufferedWriter(fw);
	
	bw.write("hello");
	bw.newLine();
	bw.write("java");
	bw.newLine();
	bw.write("selenium");
	bw.newLine();
	bw.write("job");
	bw.newLine();
	bw.flush();
	
	
	
	
	
	
	
	
	
	
}
}
