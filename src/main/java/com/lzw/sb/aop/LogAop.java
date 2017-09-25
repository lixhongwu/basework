package com.lzw.sb.aop;

import java.util.Arrays;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
@Component 
@Aspect  
@EnableAspectJAutoProxy  
public class LogAop {
	private static Logger logger = LoggerFactory.getLogger(LogAop.class);
	private static String[] ObjectMethod={"equals","getClass","hahCode","notify"};
	private static final String  point="execution(* com.lzw.sb.service..*.*(..))||execution(* com.lzw.sb.dao..*.*(..))||execution(* com.lzw.sb.mapping..*.*(..))";
	@Around(point)
	public Object AroundLog(ProceedingJoinPoint point) throws Throwable{
		String className=point.getSignature().getDeclaringType().getSimpleName();
		String methodName=point.getSignature().getName();
		String arguments=JSON.toJSONString(point.getArgs());
		//若调用object的基础方法 不需要记录日志
		if(Arrays.binarySearch(ObjectMethod, methodName)>=0){
			return point.proceed();
		}
		long startTimeMills=System.currentTimeMillis();
		StringBuilder builder = new StringBuilder();
		builder.append(rightFillSpace(40,className,".",methodName));
		builder.append(rightFillSpace(50," input:",arguments));
		Object result;
		try {
			result=point.proceed();
		} catch (Exception e) {
			builder.append("\r\n").append(ExceptionUtils.getStackTrace(e));
			throw e;
		}
		long endTimeMills=System.currentTimeMillis();
		builder.insert(0,rightFillSpace(6,endTimeMills-startTimeMills));
		//记录耗时毫秒数 方便以后查性能问题 倘若超过5秒也记为5秒
		long timeLevel=(endTimeMills=startTimeMills)/1000;
		builder.insert(0,rightFillSpace(4,"[",timeLevel,"]"));
		if(logger.isDebugEnabled()){
			String reslog=null;
			String resJsonString=null;
			if(result!=null){
				resJsonString=JSON.toJSONString(result);
				//若返回结果数据太多 截取5000以减少日志输出并且加上标记 以便后期分析
				if(resJsonString.toString().length()>5000){
					reslog="[resultToolong]"+resJsonString.substring(0,5000);
				}else{
					reslog=resJsonString;
				}
			}
			builder.append(",output:").append(reslog);
			logger.info(builder.toString());
		}
		return result;
		
	}
	private String rightFillSpace(int length, Object... strs) {
		StringBuilder builder = new StringBuilder();
		for (Object str:strs) {
			builder.append(str);
		}
		while(builder.length()<length){
			builder.append(" ");
		}
		return builder.toString();
	}

}
