package com.alex.util.common;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The class Public util.
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtil {

	/**
	 * 判断对象是否Empty(null或元素为0)
	 * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
	 *
	 * @param pObj 待检查对象
	 *
	 * @return boolean 返回的布尔值
	 */
	public static boolean isEmpty(Object pObj) {
		if (pObj == null) {
			return true;
		}
		if (pObj == "") {
			return true;
		}
		if (pObj instanceof String) {
			return ((String) pObj).length() == 0;
		} else if (pObj instanceof Collection) {
			return ((Collection) pObj).isEmpty();
		} else if (pObj instanceof Map) {
			return ((Map) pObj).size() == 0;
		}
		return false;
	}

	/**
	 * 判断对象是否为NotEmpty(!null或元素大于0)
	 * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
	 *
	 * @param pObj 待检查对象
	 *
	 * @return boolean 返回的布尔值
	 */
	public static boolean isNotEmpty(Object pObj) {
		if (pObj == null) {
			return false;
		}
		if (pObj == "") {
			return false;
		}
		if (pObj instanceof String) {
			return ((String) pObj).length() != 0;
		} else if (pObj instanceof Collection) {
			return !((Collection) pObj).isEmpty();
		} else if (pObj instanceof Map) {
			return ((Map) pObj).size() != 0;
		}
		return true;
	}

	/**
	 * 返回指定位数的数字字符串
	 * 
	 * @param charCount
	 * @return
	 * 
	 * @author huangyubing
	 * @date 2018-05-31 11:16
	 *
	 */
	public static String getRandNum(int charCount) {
        String charValue = "";
        Random r = new Random();
        for (int i = 0; i < charCount; i++) {
        	int randowInt = 0+ r.nextInt(10);
            char c = (char) (randowInt + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

	/**
	 * inputStream 转为字符串
	 * 
	 * @param in_st
	 * @return
	 * @throws IOException
	 * 
	 * @author huangyubing
	 * @date 2018-05-31 11:18
	 *
	 */
	public static String inputStream2String(InputStream in_st) throws IOException{
	    BufferedReader in = new BufferedReader(new InputStreamReader(in_st));
	    StringBuffer buffer = new StringBuffer();
	    String line = "";
	    while ((line = in.readLine()) != null){
	      buffer.append(line);
	    }
	    return buffer.toString();
	}
	
	/**
	 * 字符串 转为inputStream
	 * 
	 * @param str
	 * @return
	 * 
	 * @author huangyubing
	 * @date 2018-05-31 11:19
	 *
	 */
	public static InputStream String2InputStream(String str){
	    ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
	    return stream;
	}
	
	
	public static Map<String, Object> getList(List<Map<String,Object>> list,String [] array){
		Map<String,Object> result = new HashMap<>();
		List<Map<String, Object>> arr = new ArrayList<Map<String, Object>>();
		for (Map map1 : list) {
			Map<String,Object> map = new HashMap<String,Object>();
			String ProtocolTmplCode = map1.get("ProtocolTmplCode").toString();
			for (String string : array) {
				if (string.equals(ProtocolTmplCode)) {
					map.put("protocolTmplCode",map1.get("ProtocolTmplCode"));
					map.put("protocolName",map1.get("ProtocolName"));
					map.put("protocolUrl",map1.get("ProtocolUrl"));
					arr.add(map);
					break;
				}
			}
		}
		result.put("protocolDetail",arr);
		return result;
	}
	
	/**
	 * 字节转成字符串
	 * 
	 * @param data
	 * @return
	 */
	public static String byte2String(byte[] data) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			sb.append(Integer.toHexString(0xff & data[i]));
		}
		return sb.toString();
	}

	/**
	 * 输入流转成字节数组
	 * @param stream
	 * @return
	 */
	public static final byte[] inputStream2Byte(InputStream stream) {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		try {
			while ((rc = stream.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}

	public static String inputStreamToString(InputStream inputStream){
		try {
			StringBuilder sb = new StringBuilder();
			String line;

			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			String str = sb.toString();
			return str;
		}catch (Exception e){

		}
		return null;
	}
	
	/**
     * 文件转为字节
     */
    public static byte[] file2byte(File file) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
    
    

	public  static String getUUId() {
		int first = new Random(10).nextInt(8) + 1;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {//有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return first + String.format("%015d", hashCodeV);
	}
	
	//校验时间格式  {2018-06-07}
  	public static boolean checkTimeFormat(String date) {
  		//正则规则校验的字符串  
  		String regexp="^2[0-9]{3}-[0-9]{2}-[0-9]{2}$";
          Pattern pattern=Pattern.compile(regexp);  
          Matcher match=pattern.matcher(date);
          if(match.matches()) {
          	return true;
          }
  		return false;  
  	}
	
	/**
	 * 字节转为文件
	 * 
	 * @param buf
	 * @param file
	 * @throws IOException
	 * 
	 * @author huangyubing
	 * @date 2018-06-08 14:20
	 *
	 */
	public static void byte2File(byte[] buf,  File file) throws IOException
    {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;

        try
        {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            if (bos != null)
            {
                try
                {
                    bos.close();
                }
                catch (IOException e)
                {
                    throw e;
                }
            }
            if (fos != null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                    throw e;
                }
            }
        }
    }


	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try{
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
