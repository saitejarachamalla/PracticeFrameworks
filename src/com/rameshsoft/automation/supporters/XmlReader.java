package com.rameshsoft.automation.supporters;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReader {
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	
	
	File file = new File("D:\\new10ambatch\\frameworks\\src\\com\\rameshsoft\\automation\\supporters\\demo.xml");
	
	DocumentBuilderFactory dbfc = DocumentBuilderFactory.newInstance();
	
	DocumentBuilder db = dbfc.newDocumentBuilder();
	
	Document document = db.parse(file);
	
	document.getDocumentElement().normalize();
	
	String nodeName = document.getDocumentElement().getNodeName();
	System.out.println(nodeName);
	
	NodeList nodeList = document.getElementsByTagName("emp");
	
	for(int i=0; i<nodeList.getLength(); i++)
	{
		Node node = nodeList.item(i);
		System.out.println("Node names are: "+node.getNodeName());
		
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			System.out.println("emp id: "+element.getElementsByTagName("empname").item(0).getTextContent());
			System.out.println("emp id: "+element.getElementsByTagName("empsal").item(0).getTextContent());
			System.out.println("emp id: "+element.getElementsByTagName("empdesi").item(0).getTextContent());
		}
	}
	
	
	
	
	
	
	
	
}
}
