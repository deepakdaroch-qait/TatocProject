package QAIT.TatocProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Report {
	
	public static void main(String[] args)
	{
		String testName = "";
		try {
		String filePath = "C:\\Users\\deepakdaroch\\Desktop\\Backup_Automation\\Tatoc1\\TatocProject\\target\\surefire-reports\\testng-results.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		String pass_Test = doc.getDocumentElement().getAttributeNode("passed").getNodeValue();
		String fail_Test = doc.getDocumentElement().getAttributeNode("failed").getNodeValue();
		
		NodeList nList = doc.getElementsByTagName("test-method");
		NodeList nList1 = doc.getElementsByTagName("suite");
		System.out.println("----------------------------");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
//			System.out.println(nNode.getAttributes());
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				System.out.println("Name: " + eElement.getAttribute("name"));
				System.out.println("Status: " + eElement.getAttribute("status"));
				System.out.println("Status: " + eElement.getAttribute("started-at"));
				System.out.println("Status: " + eElement.getAttribute("finished-at"));
			}
		}
		
		for (int temp = 0; temp < nList1.getLength(); temp++) {

			Node nNode1 = nList1.item(temp);
					
			System.out.println("\nCurrent Element :" + nNode1.getNodeName());

				Element eElement = (Element) nNode1;
//				System.out.println(nNode1.getNodeType());
				testName = eElement.getAttribute("name");
		}
		
		consolidate_HTML(pass_Test, fail_Test, testName);
		
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
	public static void consolidate_HTML(String pass, String fail, String testName)
	{
		try {
			StringBuilder htmlBuilder = new StringBuilder();
			htmlBuilder.append("<html><head><title>Selenium TestNG Report</title></head>");
			
			htmlBuilder.append("<body>");
            //append table
            htmlBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
            
            htmlBuilder.append("<tr><td style='background: #090959; color: white; width: 200; height: 1em; line-height: 1em; text-align: center'><b>Test</b></td><td style='background: #090959; color: white; width: 200; height: 1em; line-height: 1em; text-align: center;'><b>#Passed</b></td><td style='background: #090959; color: white; width: 200; height: 1em; line-height: 1em; text-align: center;'><b>#Failed</b></td></tr>");
            htmlBuilder.append("<tr><td style='color: red; width: 200; height: 1em; line-height: 1em; text-align: center'><b>" + testName + "</b></td><td style='color: black; width: 200; height: 1em; line-height: 1em; text-align: center;'><b>" + pass + "</b></td><td style='color: black; width: 200; height: 1em; line-height: 1em; text-align: center;'><b>" + fail + "</b></td></tr>");
            htmlBuilder.append("</table></body></html>");
            
            WriteToFile(htmlBuilder.toString(),"Report.html");
            
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void WriteToFile(String content, String filename)
	{
		String path = "C:\\Users\\deepakdaroch\\Desktop\\Reports\\Report.html";
		File file = new File(path);
		
		if(!file.exists())
		{
			try {
                File newFileName = new File("C:\\Users\\deepakdaroch\\Desktop\\Reports\\Automation_" + filename);
                file.renameTo(newFileName);
                file.createNewFile();
                
                OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
                Writer writer=new OutputStreamWriter(outputStream);
                writer.write(content);
                writer.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
		}else {
			OutputStream outputStream;
			try {
				outputStream = new FileOutputStream(file.getAbsoluteFile());
				Writer writer=new OutputStreamWriter(outputStream);
	            writer.write(content);
	            writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
