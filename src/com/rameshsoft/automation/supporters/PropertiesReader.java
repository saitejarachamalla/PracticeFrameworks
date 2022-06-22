package com.rameshsoft.automation.supporters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {

	private String filePath;
	private FileInputStream fileInputStream;
	private Properties properties;
	private String value;
	
	public PropertiesReader(String filePath) throws IOException
	{
		this.filePath = filePath;
		fileInputStream = new FileInputStream(filePath);
		properties = new Properties();
		properties.load(fileInputStream);
	}
	
	public String getPropertyValue(String key) {
		if (properties!=null) {
			value = properties.getProperty(key);
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
		return value;
	}
	
	public String getPropertyValue(String key,String defaultValue) {
		if (properties!=null) {
			value = properties.getProperty(key);
			if (value == null) {
				value = defaultValue;
			}
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
		return value;
	}
	
	public String getPropertyValue(Object key) {
		if (properties!=null) {
			value = (String) properties.get(key);
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
		return value;
	}
	
	public String getPropertyValue(Object key,Object defaultValue) {
		if (properties!=null) {
			value = (String) properties.getOrDefault(key, defaultValue);
			if (value == null) {
				value = (String) defaultValue;
			}
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
		return value;
	}
	
	public Set getAllKeys() {
		Set setKeys = null;
		if (properties!=null) {
			setKeys = properties.keySet();
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
		return setKeys;
	}
	
	public List allValues() {
		Set keys = getAllKeys();
		List listKeys = new ArrayList<>();
		for(Object objKey : keys)
		{
			Object value = properties.get(objKey);
			listKeys.add(value);
		}
		return listKeys;
	}
	
	
	public void removeKeyValue(String key,String value) throws IOException {
		if (properties!=null) {
			properties.remove(key, value);
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			properties.store(fileOutputStream, "File is saved successfully");
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
	}
	
	public Map<String, String> getAllKeysValues() {
		Map<String, String> mapKeyValue = new LinkedHashMap<String, String>();
		Set setKyes = getAllKeys();
		for(Object obj : setKyes)
		{
			String key = (String) obj;
			value = properties.getProperty(key);
			mapKeyValue.put(key, value);
		}
		return mapKeyValue;
	}
	
	public void writeKeyValue(String key,String value) throws IOException {
		if (properties!=null) {
			properties.setProperty(key, value);
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			properties.store(fileOutputStream, "File is saved successfully");
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
	}
	
	public void writeKeyValue(Object key,Object value) throws IOException {
		if (properties!=null) {
			properties.put(key, value);
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			properties.store(fileOutputStream, "File is saved successfully");
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
	}
	
	public void removeValue(String key) throws IOException {
		if (properties!=null) {
			properties.remove(key);
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			properties.store(fileOutputStream, "File is saved successfully");
		}
		else {
			//thow the exception
			System.out.println("PROPERTIES OBJECT IS POINTING TO NULL......");
		}
	}
	
}
