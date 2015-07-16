package com.lzp.common.jxls;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.xml.sax.SAXException;

public class JxlsTest {
	private String xmlConfig = "/com/lzp/common/jxls/test.xml";
	private String dataXLS ="/com/lzp/common/jxls/test.xls";

	public  void  read() throws IOException, SAXException, InvalidFormatException{
		 InputStream inputXML = new BufferedInputStream(getClass().getResourceAsStream(xmlConfig));
         XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );
         InputStream inputXLS = new BufferedInputStream(getClass().getResourceAsStream(dataXLS));
         Employee employee = new Employee();
         Map beans = new HashMap();
         List employees = new ArrayList();
         beans.put("employee", employee);
         beans.put("employees", employees);
         XLSReadStatus readStatus = mainReader.read( inputXLS, beans);
         for (Object object : employees) {
        	 Employee emp = (Employee)object;
        	 System.out.println(emp.getName());
		}
         System.out.println(employees.size());
	}
	public static void main(String[] args) {
		try {
			JxlsTest reader = new JxlsTest();
			reader.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
