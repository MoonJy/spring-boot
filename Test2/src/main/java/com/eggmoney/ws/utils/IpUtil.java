package com.eggmoney.ws.utils;


import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IpUtil {
	 public static String getClientIP(HttpServletRequest request) {

	     String ip = request.getHeader("X-FORWARDED-FOR"); 
	     
	     if(ip == null || ip.length() == 0) {
	         ip = request.getHeader("Proxy-Client-IP");
	     }
	     if(ip == null || ip.length() == 0) {
	         ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
	     }
	     if(ip == null || ip.length() == 0) {
	         ip = request.getRemoteAddr() ;
	     }
	     return ip;
	 }
	 
	 public static String getCurrentEnvironmentNetworkIp(){
	        Enumeration netInterfaces = null;
	        try {
	            netInterfaces = NetworkInterface.getNetworkInterfaces();
	        } catch (SocketException e) {
	            return getLocalIp();
	        }

	        while (netInterfaces.hasMoreElements()) {
	            NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
	            Enumeration address = ni.getInetAddresses();
	            if (address == null) {
	                return getLocalIp();
	            }
	            while (address.hasMoreElements()) {
	                InetAddress addr = (InetAddress)address.nextElement();
	                if (!addr.isLoopbackAddress() && !addr.isSiteLocalAddress() && !addr.isAnyLocalAddress() ) {
	                    String ip = addr.getHostAddress();
	                    if( ip.indexOf(".") != -1 && ip.indexOf(":") == -1 ){
	                        return ip;
	                    }
	                }
	            }
	        }
	        return getLocalIp();
	    }

	    public static String getLocalIp(){
	        try {
	            return InetAddress.getLocalHost().getHostAddress();
	        } catch (UnknownHostException e) {
	            return null;
	        }
	    }
}

