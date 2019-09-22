package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    public static final int CONNECT_TIME_OUT=10000;
    public static final int READ_TIME_OUT=30000;
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    public static String postJson(String reqUrl,String postData){
        logger.info("请求url,参数:{}{}",reqUrl,postData);
        HttpURLConnection conn = null;
        conn = getConnection(reqUrl,"json");
        return getResponseStr(conn,postData);
    }
    public static HttpURLConnection getConnection(String reqUrl,String type){
        HttpURLConnection conn=null;
        try {
            URL url = new URL(reqUrl);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestProperty("Connection","keep-alive");
            conn.setConnectTimeout(CONNECT_TIME_OUT);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
        }catch(Exception e){
          logger.error("无法建立连接",e);
        }
     return conn;
    }
    public static String getResponseStr(HttpURLConnection conn,String data){
        try {
        conn.getOutputStream().write(data.getBytes());
        conn.getOutputStream().flush();
        int responseCode = conn.getResponseCode();
        if(responseCode!=200){
            logger.warn("failed");
            return null;
        }
        String respData = readInputStream(conn.getInputStream());
        return respData;
        }catch(Exception e){
            logger.error("发送失败",e);
        }finally{
            if(conn!=null){
                conn.disconnect();
            }
        }
        return null;
    }
    public static String readInputStream(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
        String line = null;
        while((line=br.readLine())!=null){
            sb.append(line).append("\n");
        }
        br.close();
        return sb.toString();
    }
}
