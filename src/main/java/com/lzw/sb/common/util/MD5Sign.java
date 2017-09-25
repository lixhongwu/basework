package com.lzw.sb.common.util;


import java.io.UnsupportedEncodingException;  
import java.util.HashMap;
import java.util.Map;  
import java.util.Map.Entry;  
import java.util.Set;  
import java.util.TreeMap;  
  

  


import org.apache.commons.codec.digest.DigestUtils;  

/**
 * 
* @ClassName: MD5Sign
* @Description:  类MD5Sign.java的实现描述：MD5签名和验签  
* @author lixhongwu@163.com
* @date 2017年6月27日 上午10:27:07 
*
 */
public class MD5Sign {  
  
 
	/**
	* 
	* @Title: md5
	* @Description: 将字符串MD5加码 生成32位md5码 
	* @param @param inStr
	* @param @return    加密后串
	* @return String    返回类型
	* @throws
	 */
    public static String md5(String inStr) {  
        try {  
            return DigestUtils.md5Hex(inStr.getBytes("UTF-8"));  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("MD5签名过程中出现错误");  
        }  
    }  
  
    /**
     * 
    * @Title: sign
    * @Description: 签名字符串 
    * @param @param params 需要签名的参数 
    * @param @param appSecret签名密钥 
    * @param @return    参数
    * @return String    返回类型
    * @throws
     */
    public static String sign(HashMap<String, String> params, String appSecret) {  
        StringBuilder valueSb = new StringBuilder();  
        params.put("appSecret", appSecret);  
        // 将参数以参数名的字典升序排序  
        Map<String, String> sortParams = new TreeMap<String, String>(params);  
        Set<Entry<String, String>> entrys = sortParams.entrySet();  
        // 遍历排序的字典,并拼接value1+value2......格式  
        for (Entry<String, String> entry : entrys) {  
            valueSb.append(entry.getValue());  
        }  
        params.remove("appSecret");  
        return md5(valueSb.toString());  
    }  
  
    /** 
     * 方法描述:验证签名 
     *  
     * @param appSecret 加密秘钥 
     * @param request 
     * @return 
     * @throws Exception 
     */  
    public static boolean verify(String appSecret, HashMap<String, String> params) throws Exception {  
  
        String sign = params.get("token");  
        if (sign == null) {  
            throw new Exception("请求中没有带签名token");  
        }  
        params.put("appSecret", appSecret);  
        params.remove("token");
        // 将参数以参数名的字典升序排序  
        Map<String, String> sortParams = new TreeMap<String, String>(params);  
        Set<Entry<String, String>> entrys = sortParams.entrySet();  
  
        // 遍历排序的字典,并拼接value1+value2......格式  
        StringBuilder valueSb = new StringBuilder();  
        for (Entry<String, String> entry : entrys) {  
            valueSb.append(entry.getValue());  
        }  
  
        String mysign = md5(valueSb.toString());  
        if (mysign.equals(sign)) {  
            return true;  
        } else {  
            return false;  
        }  
  
    }  
    public static void main(String[] args) {
    	String appSecret="opeddsaead323353484591dadbc382a18340bf83414536";
    	HashMap<String, String> params = new HashMap<String, String>();
    	params.put("phone", "我");
    	params.put("cid", "432522239729389");
    	params.put("orderid", "YC232323");
    	params.put("orderids", "");
    	params.put("merchantId", "YC123123123");
    	String str=MD5Sign.sign(params, appSecret);
    	
    	try {
        	HashMap<String, String> params2 = new HashMap<String, String>();
        	params2.put("phone", "我");
        	params2.put("cid", "432522239729389");
        	params2.put("orderid", "YC232323");
        	params2.put("merchantId", "YC123123123");
    		params2.put("token", str);
			System.out.println(MD5Sign.verify(appSecret, params2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
}  
