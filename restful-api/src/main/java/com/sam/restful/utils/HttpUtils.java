package com.sam.restful.utils;

import com.google.common.base.Strings;
import mtime.lark.pb.utils.StringUtils;
import mtime.lark.util.config.AppConfig;
import mtime.lark.util.lang.FaultException;
import mtime.lark.util.log.Logger;
import mtime.lark.util.log.LoggerManager;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;

public class HttpUtils {
    static Logger log = LoggerManager.getLogger(HttpUtils.class);
    private static final int SOCKET_TIMEOUT = getConfigValue("SOCKET_TIMEOUT", 30000);
    private static final int CONNECTION_TIMEOUT = getConfigValue("CONNECTION_TIMEOUT", 30000);
    private static final int MAX_CONN_PRE_HOST = getConfigValue("MAX_CONN_PRE_HOST", 10);
    private static final int MAX_CONN = getConfigValue("MAX_CONN", 30);
    private static final int PROXY_PORT = getConfigValue("proxy_port", 7788);
//    private static final String PROXY_HOST1 = getConfigStringValue("proxy_ip1", "");
//    private static final String PROXY_HOST2 = getConfigStringValue("proxy_ip2", "");
//    private static final String PROXY_HOST3 = getConfigStringValue("proxy_ip3", "");
//    private static final String PROXY_USER_NAME = getConfigStringValue("proxy_user", "");
//    private static final String PROXY_PASS_WORD = getConfigStringValue("proxy_user", "");
//    private static final String IS_USE_PROXY = getConfigStringValue("use_proxy", "false");
    private final HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
    private static HttpUtils crossHttpClientUtil=null;
    private static String USERAGENT = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
    private static int getConfigValue(String key, int value) {
        String property = AppConfig.getDefault().getCustom().getString(key);
        return Strings.isNullOrEmpty(property)?value:Integer.parseInt(property);
    }
    private static String getConfigStringValue(String key, String value) {
        String property = AppConfig.getDefault().getCustom().getString(key);
        return Strings.isNullOrEmpty(property)?value:property;
    }

    public static synchronized HttpUtils getHttpUitlsClient() {
        if(crossHttpClientUtil == null) {
            return new HttpUtils();
        }
        return crossHttpClientUtil;
    }
    //设置代理
    private HttpClient getHttpClient(String proxy_host) {
        HttpClient httpClient = new HttpClient(this.httpConnectionManager);
//        if(StringUtils.isEmpty(IS_USE_PROXY)||"false".equalsIgnoreCase(IS_USE_PROXY)){
//            return httpClient;
//        }else{
//            httpClient.getHostConfiguration().setProxy(proxy_host, PROXY_PORT);
//            httpClient.getParams().setAuthenticationPreemptive(true);
//            httpClient.getState().setProxyCredentials(AuthScope.ANY,
//                    new UsernamePasswordCredentials(PROXY_USER_NAME,PROXY_PASS_WORD));
//        }

        return httpClient;
    }


    private HttpUtils() {
        HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(CONNECTION_TIMEOUT);
        params.setSoTimeout(SOCKET_TIMEOUT);
        params.setDefaultMaxConnectionsPerHost(MAX_CONN_PRE_HOST);
        params.setMaxTotalConnections(MAX_CONN);
        httpConnectionManager.setParams(params);
        log.info("======CONNECTION_TIMEOUT======{}",CONNECTION_TIMEOUT);
    }

    private static NameValuePair[] buildNameValuePairs(Map<String, Object> params) {
        if (params==null){
            return new NameValuePair[0];
        }
        Object[] keys = params.keySet().toArray();
        NameValuePair[] pairs = new NameValuePair[keys.length];

        for(int i = 0; i < keys.length; ++i) {
            String key = (String)keys[i];
            pairs[i] = new NameValuePair(key, params.get(key) == null?null:params.get(key) + "");
        }

        return pairs;
    }

    private static String handleUrl(String url, Map<String, Object> params, String code, HttpMethod method) {
        setMxTcHeaders(params, url, method);
        String getData = getQuery(params, code);
        if(params!=null&&params.size() > 0) {
            url = url + getData;
        }

        return url;
    }

    private static String getQuery(Map<String, Object> params, String code) {
        StringBuilder getData = new StringBuilder();
        String query = "";
        if(params != null && params.size() > 0) {
//            getData.append("?");
            Iterator var4 = params.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry entry = (Map.Entry)var4.next();

                try {
                    getData.append((String)entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue() + "", code)).append("&");
                } catch (UnsupportedEncodingException var7) {
                    log.warn("", var7);
                }
            }

            if(params.size() > 0) {
                query = getData.toString();
                query = query.substring(0, query.length() - 1);
            }
        }

        return query;
    }

    private static void setMxTcHeaders(Map<String, Object> param, String url, HttpMethod method)  {
        long time = System.currentTimeMillis();
        log.debug("",param,url);
        method.setRequestHeader("X-Timestamp", Long.toString(time));
    }


    /**
     * 请求
     * @param url
     * @param params
     * @param method
     * @return
     */
    public static String sendHttpRequest(String url, Map params, String method)  {
        if(Strings.isNullOrEmpty(url)) {
            return HttpUtils.returnError("推送地址错误[url=" + url + "]");
        } else if("GET".equalsIgnoreCase(method)) {
            GetMethod pairs1 = new GetMethod(url);
            url = handleUrl(url, params, "UTF-8", pairs1);
            log.info("Url = " + url);
            pairs1.setQueryString(getQuery(params, "UTF-8"));
            pairs1.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            pairs1.setRequestHeader("User-Agent",USERAGENT);
            pairs1.getParams().setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler());

            return doHttpRequest(pairs1, "UTF-8");
        } else if("POST".equalsIgnoreCase(method)) {
            NameValuePair[] pairs = buildNameValuePairs(params);
            PostMethod postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            postMethod.setRequestHeader("User-Agent",USERAGENT);
            if (pairs!=null){
                postMethod.setRequestBody(pairs);
            }

            postMethod.getParams().setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler());
            handleUrl(url, params, "UTF-8", postMethod);
            return doHttpRequest(postMethod, "UTF-8");
        } else {
            return null;
        }
    }


    private static String returnError(String reason) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(reason);
        return buffer.toString();
    }


    private static String retryRequest(HttpMethod method, String code, HttpClient httpClient){
        String resultString ;

        try {
            int e = httpClient.executeMethod(method);
            if(e != 200) {
                log.error("Method failed:" + method.getStatusLine());
            }
        } catch (IOException e) {
            log.error("向外部接口发送数据失败" + e.toString(), e);
            throw new FaultException(e);
        }

        try {
            BufferedReader e1 = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), code));
            Throwable var6 = null;

            try {
                StringBuilder buffer = new StringBuilder();
                String line ;

                while((line = e1.readLine()) != null) {
                    buffer.append(line);
                }

                resultString = buffer.toString();
            } catch (Exception e) {
                throw new FaultException(e);
            } finally {
                if(e1 != null) {
                    if(var6 != null) {
                        try {
                            e1.close();
                        } catch (Exception e) {
                            throw new FaultException(e);
                        }
                    } else {
                        e1.close();
                    }
                }

            }
        } catch (SocketTimeoutException var34) {
            log.error("连接超时" + var34.toString(), var34);
            throw new FaultException(var34);
        } catch (UnknownHostException var35) {
            log.error("请求的主机地址无效" + var35.toString(), var35);
            throw new FaultException(var35);
        } catch (IOException var36) {
            log.error("向外部接口发送数据失败" + var36.toString(), var36);
            throw new FaultException(var36);
        } finally {
            method.releaseConnection();
        }

        return resultString;
    }

    private static String doHttpRequest(HttpMethod method, String code) {
        String resultString ;
        try {
//            HttpClient httpClient = getHttpUitlsClient().getHttpClient(PROXY_HOST1);
            HttpClient httpClient = getHttpUitlsClient().getHttpClient(null);
            resultString = retryRequest(method,code,httpClient);
        } catch (Exception e) {
            throw new FaultException(e);
//            try {
//                HttpClient httpClient = getHttpUitlsClient().getHttpClient(PROXY_HOST2);
//                resultString = retryRequest(method,code,httpClient);
//            }catch (Exception e1) {
//                try {
//                    HttpClient httpClient = getHttpUitlsClient().getHttpClient(PROXY_HOST3);
//                    resultString = retryRequest(method,code,httpClient);
//                }catch (Exception e2){
//                    throw new FaultException(e2);
//                }
//
//            }

        }
        return resultString;
    }
}
