/**
 * 
 */
package com.alex.xmlandjson;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

/**  
* Title: TestXml2Pojo  
* Description:   
* @author wangzi  
* @date 2018年6月4日  
*/
public class TestXml2Pojo {
	/**
     * pojo convert to xml string
     */
    public static String obj2xml(Object obj) throws Exception{
        JAXBContext context =JAXBContext.newInstance(obj.getClass()); 
        Marshaller marshaller = context.createMarshaller();  
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        StringWriter writer = new StringWriter();  
        marshaller.marshal(obj, writer);  
        return writer.toString();   
//        return xmlMapper.writeValueAsString(obj);
    }
    
    public static <T> T xml2pojo(String xmlStr,Class<T> clazz) throws Exception{
    	JAXBContext context = JAXBContext.newInstance(clazz);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (T) unmarshaller.unmarshal(new StringReader(xmlStr));  
//        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        return xmlMapper.readValue(xmlStr, clazz);
    }
	
	@Test
	public void testPojo2Xml() throws Exception {
		XmlPojo xmlPojo = new XmlPojo();
		xmlPojo.setName("张三");
		xmlPojo.setAge(42);
		xmlPojo.setAddress("广州东站");
		InnerPojo innerPojo = new InnerPojo();
		innerPojo.setInnerName("张小");
		innerPojo.setInnerAge(18);
		xmlPojo.setInnerPojo(innerPojo);
//		xmlPojo.setContent("<innerPojo>\r\n" + 
//				"        <abc>张小</abc>\r\n" + 
//				"        <innerAge>18</innerAge>\r\n" + 
//				"    </innerPojo>");
		String obj2xml = obj2xml(xmlPojo);
		System.out.println(obj2xml);
	}
	
	
	
	@Test
	public void testXml2Pojo1() throws Exception {
		String xmlStr1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
				"<OutsideElem>\r\n" + 
				"    <name>张三</name>\r\n" + 
				"    <address>广州东站</address>\r\n" + 
				"    <age>42</age>\r\n" + 
				"    <innerPojo>\r\n" + 
				"        <innerName>张小</innerName>\r\n" + 
				"        <innerAge>18</innerAge>\r\n" + 
				"    </innerPojo>\r\n" + 
				"</OutsideElem>";
		XmlPojo xml2pojo1 = xml2pojo(xmlStr1, XmlPojo.class);
		System.out.println(xml2pojo1);
	}
	@Test
	public void testXml2Pojo2() throws Exception {
		String xmlStr2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
				"<OutsideElem>\r\n" + 
				"    <name>张三</name>\r\n" + 
				"    <address>广州东站</address>\r\n" + 
				"    <age>42</age>\r\n" + 
				"    <content>&lt;innerPojo&gt;\r\n" + 
				"        &lt;abc&gt;张小&lt;/abc&gt;\r\n" + 
				"        &lt;innerAge&gt;18&lt;/innerAge&gt;\r\n" + 
				"    &lt;/innerPojo&gt;</content>\r\n" + 
				"</OutsideElem>";
		XmlPojo xml2pojo2 = xml2pojo(xmlStr2, XmlPojo.class);
		System.out.println(xml2pojo2);
	}
}
