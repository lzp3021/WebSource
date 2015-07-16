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

public class ExcelReader {
	private String xmlConfig = "/com/lzp/common/jxls/departments.xml";
	private String dataXLS ="/com/lzp/common/jxls/departmentdata.xls";

	public  void  read() throws IOException, SAXException, InvalidFormatException{
		 InputStream inputXML = new BufferedInputStream(getClass().getResourceAsStream(xmlConfig));
         XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );
         InputStream inputXLS = new BufferedInputStream(getClass().getResourceAsStream(dataXLS));
         Department department = new Department();
         Department hrDepartment = new Department();
         List departments = new ArrayList();
         Map beans = new HashMap();
         beans.put("department", department);
         beans.put("hrDepartment", hrDepartment);
         beans.put("departments", departments);
         XLSReadStatus readStatus = mainReader.read( inputXLS, beans);
         System.out.println(department.getName());
	}
	public static void main(String[] args) {
		try {
			ExcelReader reader = new ExcelReader();
			reader.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
