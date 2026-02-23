package testExamples.ExcelDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

//Used when there exist the common value to multiple tests
public class ReadPropertiesFile {
	
	public static void main(String args[]) throws IOException
	{
		//create properties object
		Properties prop=new Properties();
		
		//Load properties file
		FileInputStream in=new FileInputStream(System.getProperty("user.dir")+"\\testData\\system.properties");
		prop.load(in);
		
		//read properties file
		String url=prop.getProperty("appurl");
		String uname=prop.getProperty("uname");
		String password=prop.getProperty("password");

		System.out.println(url+" "+uname+" "+password+" ");
		
		//Keys
		ArrayList<String>ls=new ArrayList<String>(prop.stringPropertyNames());// prop.keySet();
		System.out.println(ls.toString());
		
		//values
		Collection<Object>l=prop.values();
		System.out.println(l.toString());
	}
	
}
