package QAIT.TatocProject;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Document;

public class Custom_Report {
	
	public static void main(String[] e)
	{
		String testName = "";
		try {
		String filePath = "C:\\Users\\deepakdaroch\\Desktop\\Reports\\New folder\\Report.html";
		File htmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(htmlFile);
		
		doc.getDocumentElement().normalize();
		System.out.println("Test");
		
//		NodeList nNode = doc.getDocumentElement().getNodeName();
		
		}catch(Exception a)
		{
			a.getStackTrace();
		}
	}
	
}
