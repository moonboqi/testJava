/**
 * 
 */
package com.alex.testfastjson;

/**  
* Title: JsonPojo  
* Description:   
* @author wangzi  
* @date 2018年6月1日  
*/
public class JsonPojo {
	    private String requestNo;
	    private String requestTime;
	    private String channelCode;
	    private String version;
	    private String sign;
	    private String requestData;
	    
	    
	    
		@Override
		public String toString() {
			return "JsonPojo [requestNo=" + requestNo + ", requestTime=" + requestTime + ", channelCode=" + channelCode
					+ ", version=" + version + ", sign=" + sign + ", requestData=" + requestData + "]";
		}
		public String getRequestNo() {
			return requestNo;
		}
		public void setRequestNo(String requestNo) {
			this.requestNo = requestNo;
		}
		public String getRequestTime() {
			return requestTime;
		}
		public void setRequestTime(String requestTime) {
			this.requestTime = requestTime;
		}
		public String getChannelCode() {
			return channelCode;
		}
		public void setChannelCode(String channelCode) {
			this.channelCode = channelCode;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		public String getRequestData() {
			return requestData;
		}
		public void setRequestData(String requestData) {
			this.requestData = requestData;
		}
	    
	    
	    
}
