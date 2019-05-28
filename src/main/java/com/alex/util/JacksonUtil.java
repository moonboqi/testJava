package com.alex.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/**
 * Json数据操作工具
 * 
 * @author heshaojian
 *
 */
public class JacksonUtil {

    
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static XmlMapper xmlMapper = new XmlMapper();
    
    private static ConcurrentHashMap<Class, JAXBContext> jaxbContentMap = new ConcurrentHashMap<Class, JAXBContext>();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
        xmlMapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(xmlMapper.getTypeFactory()));
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION,true);
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    
    /**
     * javaBean,list,array convert to json string
     */
    public static String obj2json(Object obj) throws Exception{
//    	objectMapper.setSerializationInclusion(Include.NON_NULL);
        return objectMapper.writeValueAsString(obj);
    }
    
    /**
     * json string convert to javaBean
     */
    public static <T> T json2pojo(String jsonStr,Class<T> clazz) throws Exception{
    	objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper.readValue(jsonStr, clazz);
    }
    
    /**
     * json string convert to map
     */
    public static <T> Map<String,Object> json2map(String jsonStr)throws Exception{
        return objectMapper.readValue(jsonStr, Map.class);
    }
    
    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String,T> json2map(String jsonStr,Class<T> clazz)throws Exception{
        Map<String,Map<String,Object>> map =  objectMapper.readValue(jsonStr, new TypeReference<Map<String,T>>() {
        });
        Map<String,T> result = new HashMap<String, T>();
        for (Entry<String, Map<String,Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr,Class<T> clazz)throws Exception{
        List<Map<String,Object>> list = objectMapper.readValue(jsonArrayStr, new TypeReference<List<T>>() { });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }
    
    /**
     * map convert to javaBean
     */
    public static <T> T map2pojo(Map map,Class<T> clazz){
        return objectMapper.convertValue(map, clazz);
    }
    
    /**
     * json string convert to xml string
     */
//    public static String json2xml(String jsonStr)throws Exception{
//        JsonNode root = objectMapper.readTree(jsonStr);
//        String xml = xmlMapper.writeValueAsString(root);
//        return xml;
//    }
    
    /**
     * xml string convert to json string
     * @throws JAXBException 
     */
//    public static String xml2json(String xml)throws Exception{
//        StringWriter w = new StringWriter();
//        JsonParser jp = xmlMapper.getFactory().createParser(xml);
//        JsonGenerator jg = objectMapper.getFactory().createGenerator(w);
//        while (jp.nextToken() != null) {
//            jg.copyCurrentEvent(jp);
//        }
//        jp.close();
//        jg.close();
//        return w.toString();
//    }
    
    public static JAXBContext getJaxbContent(Class clazz) throws JAXBException{
    	JAXBContext context = jaxbContentMap.get(clazz);  
    	if(context == null){
    		context = JAXBContext.newInstance(clazz); 
    		jaxbContentMap.put(clazz, context);
    	}
    	return context;
    }
    /**
     * xml string convert to pojo
     */
    public static <T> T xml2pojo(String xmlStr,Class<T> clazz) throws Exception{
    	JAXBContext context = getJaxbContent(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (T) unmarshaller.unmarshal(new StringReader(xmlStr));  
//        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        return xmlMapper.readValue(xmlStr, clazz);
    }
    /**
     * xml string convert to pojo
     */
    public static <T> T xml2pojo(String xmlStr,Class<T> clazz, JAXBContext context) throws Exception{
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (T) unmarshaller.unmarshal(new StringReader(xmlStr));  
//        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        return xmlMapper.readValue(xmlStr, clazz);
    }
    /**
     * xml string convert to pojo
     */
    public static <T> T xml2pojo(String xmlStr,TypeReference<T> typeRef) throws Exception{
        return xmlMapper.readValue(xmlStr, typeRef);
    }
    
    public static <K,T> K xml2pojo(String requestContent,Class<K> claxx, Class<T> clazz) throws Exception {
		JavaType eleType = xmlMapper.getTypeFactory().constructType(clazz);
		JavaType type = xmlMapper.getTypeFactory().constructParametricType(claxx, eleType);
		return xmlMapper.readValue(requestContent, type);
	}
    /**
     * pojo convert to xml string
     */
    public static String obj2xml(Object obj) throws Exception{
   	 	JAXBContext jaxbContext = getJaxbContent(obj.getClass());;
   	 
   	 	Marshaller marshaller = jaxbContext.createMarshaller();
   	 	marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");   
   	 	marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);  
        
        StringWriter writer = new StringWriter();
        
    	marshaller.marshal(obj, writer);
    	
    	return writer.toString();
    }
    
    /**
     * pojo convert to xml string By jackson
     */
    /**
     * @param obj
     * @param includeNull 是否包含null节点标识  false 不生成null节点
     * @return
     * @throws Exception
     */
    public static String obj2XmlJackson(Object obj,boolean includeNull) throws Exception{
		StringWriter writer = new StringWriter();
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		
	 	xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION,false);
	 	xmlMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
	 	if(!includeNull) {
	 		xmlMapper.setSerializationInclusion(Include.NON_NULL);
	 	}
		xmlMapper.writeValue(writer, obj);
		return writer.toString();
    }
    
    private static List<HashMap<String,Object>> getBeanFieldFromJson(String jsonStr, String className){
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		Map<String, Object> bean = new HashMap<String, Object>();
		List<HashMap<String,Object>> attrClassAry = new ArrayList<HashMap<String,Object>>();
		Iterator<?> it = jsonObj.keys();
		while (it.hasNext()) {
            String key = (String) it.next();
            Object value = jsonObj.get(key);
            
            bean.put(key, getTypeFromJsonVal(value,key, attrClassAry));
		}
		
		HashMap<String, Object> newBean = new HashMap<String, Object>();
		newBean.put("name", className);
		newBean.put("val", bean);

		List<HashMap<String,Object>> beanList = new ArrayList<HashMap<String,Object>>();
		beanList.add(newBean);
		
		for(HashMap<String, Object> map : attrClassAry){
			beanList.add(map);
		}
		
	    return beanList;
	}
	
    private static String getTypeFromJsonVal(Object value, String key, List<HashMap<String,Object>> attrClassAry){
		if(value instanceof JSONArray) {
			String type  = getTypeFromJsonVal(((JSONArray)value).get(0),key,attrClassAry);
            return "List<"+type +">";
		}else if(value instanceof JSONObject){
			String typeName = camelCaseWithFirstCharUpper(key);
			
			Map<String, Object> bean = new HashMap<String, Object>();
			JSONObject jsonObj = (JSONObject)value;
			Iterator<?> it = (jsonObj).keys();
			while (it.hasNext()) {
				String tempKey = (String) it.next();
                Object fieldValue = jsonObj.get(tempKey);
                bean.put(tempKey,getTypeFromJsonVal(fieldValue,tempKey,attrClassAry));
            }
			HashMap<String,Object> newMap = new HashMap<String,Object>();
			newMap.put("name", typeName);
			newMap.put("val", bean);
			attrClassAry.add(newMap);
			
            return typeName;
		}else{
			return value.getClass().getSimpleName();
		}
	}
	
    private static String camelCaseWithFirstCharUpper(String str){
		if(str == null || str.length()==0){
			return "";
		}
	    return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
	
    private static String toBeanText(HashMap<String, Object> bean, String packageName) {
		String separator = System.getProperty("line.separator");
		HashMap<String,Object> beanFields = (HashMap<String,Object>)bean.get("val");
	    String className = (String)bean.get("name");
	    
	    String importText = "";
	    String fieldText = "";
	    String setterText = "";
	    HashMap<String,Object> typeSet = new HashMap<String,Object>();
	    
	    for(Map.Entry<String,Object> entry :beanFields.entrySet()){  
            String key = entry.getKey();
            String camelKey = key;
            
            //生成属性定义
            fieldText += "    private " + beanFields.get(key) + " " + camelKey + ";" + separator;
            //记录属性类型,beanFields[key]可能有一些值，是List<Date>之类，要替换成Date
            String type = (String)beanFields.get(key);
            if(type.indexOf("List<") > -1){
                type = ((String)beanFields.get(key)).replace("List<","");
                type = type.replace(">","");
                typeSet.put("List","true");
            }
            typeSet.put("type", "true") ;

        }  

	    //生成import语句

        importText += "import java.util.Date;";
        importText += separator;
        importText += "import java.util.List;";
        importText += separator;
        importText += separator;
        importText += "import lombok.Getter;";
        importText += separator;
        importText += "import lombok.Setter;";
        importText += separator;
        if(packageName!= null){
            importText = "package "+ packageName+";" +separator+separator+ importText ;
        }
        
        StringBuffer returnSb = new StringBuffer();
        returnSb.append(importText);
        returnSb.append(separator);
        returnSb.append("@Setter");
        returnSb.append(separator);
        returnSb.append("@Getter");
        returnSb.append(separator);
        returnSb.append("public class "+className+" {");
        returnSb.append(separator);
        returnSb.append(fieldText);
        returnSb.append(separator);
        returnSb.append(setterText);
        returnSb.append("}");
        
	    return returnSb.toString();
	}
	
    /**
     * xsd file generate java class file
     * 
     * @param xsdPath xsd文件的路径
     * @param javaFilePath 生成Java文件的存放路径
     * @param packageName Java类的包名
     * @throws IOException
     * 
     * @author huangyubing
     * @date 2018-05-15 14:52
     *
     */
    public static void xsd2java(String xsdPath, String javaFilePath, String packageName) throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("cmd /k  xjc "+xsdPath+" -d "+javaFilePath + " -p " + packageName);
    }
    
    /**
     * json string generate java class file
     * 
     * @param jsonStr json格式的字符串
     * @param javaFilePath 生成Java文件的存放路径
     * @param packageName Java类的包名
     * @param className Java类名
     * @throws IOException
     * 
     * @author huangyubing
     * @date 2018-05-15 11:22
     */
    public static void json2java(String jsonStr, String javaFilePath, String packageName, String className) throws IOException {
    	List<HashMap<String,Object>> beanList = getBeanFieldFromJson(jsonStr,className);
		for(HashMap<String, Object> bean : beanList){
			String beanText = toBeanText(bean, packageName);
			
			File file = new File(javaFilePath+"\\"+bean.get("name")+".java");
			PrintStream ps = new PrintStream(new FileOutputStream(file));  
            ps.println(beanText);// 往文件里写入字符串  
            ps.close();
		}
    }

    /**
     * xml string generate java class file
     * 
     * @param jsonStr json格式的字符串
     * @param javaFilePath 生成Java文件的存放路径
     * @param packageName Java类的包名
     * @throws IOException
     * 
     * @author huangyubing
     * @date 2018-05-15 11:22
     */
    public static void xml2java(String xmlStr, String javaFilePath, String packageName) throws IOException {
    	JSONObject xmlJSONObj = XML.toJSONObject(xmlStr);
    	
    	String className = (String)xmlJSONObj.keySet().iterator().next();
    	String jsonStr = xmlJSONObj.get(className).toString();
    	json2java(jsonStr, javaFilePath, packageName, camelCaseWithFirstCharUpper(className));
    }
    
    
    public static void main(String[] args) throws Exception {
    String str  = "{\"channelCode\":\"9021510100000000\",\"requestTime\":\"20180830102204\",\"requestData\":\"VL7pexOfj9hRe8p5L0B66zI9ytylxq45VvS2N5/fBUS+KzOL2aXNPBWyPc9S6eXzaH3GqRGoLCnr\n" +
            "GvNjPn/A2hR1Iy74/kO+mEoyxxVuMjB3nbzW/xqzh5a9yPVryI16+rfh6WqvUNyIzQbghc0bNlUR" +
            "/8KFpGfDUPRDSlLmKKO+ItwUw1MtmaF6W0Q3f1lHCDLlK/3vqNasBFnf0ixmuA+q8UefP1lAsqTj" +
            "N79djzGclmv7H2SJfLC8fSCoDNMotR/8im4njMRPiEEq9IlE0+o4OJfsEpUyDWYyUqeTHaIo1uD8" +
            "BTUvQuXHitmIu1/QlYSXxuYD71Q363mK/xScHA==\n" +
            "\",\"sysSign\":\"H/5yKEL88QjVuuiIlQxgEgyRzPyRRMnXAMJIWHRHMMEZszuvFYsgoS1mYtd7LFgXnQIQnEbgwXkl\n" +
            "Z2I6ZdmC8fFfgiwPFHaJu4x0xlqrSe1PF7WW1uPh6mMJEMuO4o+dl8ewbZXGAtAZhWb77uvcadyz" +
            "HKx6wPCJ0YokiFyKcjE3NVEaUivl3K448huFAs6qyD57f/Sc6in3WxwUdf8uU+LnrxYQiVW0zE0r" +
            "zSFR8z9JNcqmPLEBdGQZOePP2F4AErsYOXl6Dmx9+or1jjHctSxDhaAru6Xk9zaTGEMpaiRdtr1I" +
            "FS1CXwdy/ITmck6Oj6346bjfyhK1ZSwMdVWjMA==" +
            "\"}";
        Map<String, Object> stringObjectMap = JacksonUtil.json2map(str);
        System.out.println(stringObjectMap);
    }
}
