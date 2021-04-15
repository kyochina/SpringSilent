package com.china.utils.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class HttpClientUtil {
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    // 编码格式
    public static final String CHARSET_UTF_8 = "UTF-8";

    public static final String CONTENT_TYPE_JSON_URL = "application/json;charset=utf-8";

    /**
     * HY 发送POST请求，参数为JSON格式
     * @param url
     * @param paramsJson
     * @return
     */
    public static String sendPostJson(String url, String paramsJson) {
        // 获取一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        Header header=new BasicHeader("Accept-Encoding",null);
        httpPost.setHeader(header);

        if (StringUtils.isNotBlank(paramsJson)) {
            // 设置报文和通讯格式
            StringEntity stringEntity = new StringEntity(paramsJson,CHARSET_UTF_8);
            stringEntity.setContentEncoding(CHARSET_UTF_8);
            stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
            httpPost.setEntity(stringEntity);
        }

        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            // 判断响应状态
            if (response.getStatusLine().getStatusCode() >= 300) {
                throw new Exception("Http Request is not success, Response code is" + response.getStatusLine().getStatusCode());
            }

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode() && entity != null) {
                result = EntityUtils.toString(entity, CHARSET_UTF_8);
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            log.error("POST请求失败：", e);
        } finally {
            try {
                response.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * HY 发送POST请求，参数为JSON格式
     * @param url
     * @param paramsJson
     * @return
     */
    public static String sendPostJsonWithCookie(String url, Map<String, String> headers,
                                                Map<String, String> querys, String paramsJson, BasicCookieStore cookieStore) throws Exception {
        // 获取一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost httpPost = new HttpPost(buildUrl(url, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            httpPost.addHeader(e.getKey(), e.getValue());
        }
        if (StringUtils.isNotBlank(paramsJson)) {
            // 设置报文和通讯格式
            StringEntity stringEntity = new StringEntity(paramsJson,CHARSET_UTF_8);
            stringEntity.setContentEncoding(CHARSET_UTF_8);
            httpPost.setEntity(stringEntity);
        }
        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            // 判断响应状态
            if (response.getStatusLine().getStatusCode() >= 300) {
                log.info("Http Request is not success, Response code is" + response.getStatusLine().getStatusCode());
                throw new Exception("Http Request is not success, Response code is" + response.getStatusLine().getStatusCode());
            }

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode() && entity != null) {
                result = EntityUtils.toString(entity, CHARSET_UTF_8);
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            log.error("POST请求失败：", e);
        } finally {
            try {
                response.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    /**
     * HY 发送POST请求，参数为JSON格式
     * @param url
     * @param paramsJson
     * @return
     */
    public static String sendPostJsonWithCookie(String url, String paramsJson, BasicCookieStore cookieStore) {
        // 获取一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(new BasicHeader("TENANT-ID", "18"));

        if (StringUtils.isNotBlank(paramsJson)) {
            // 设置报文和通讯格式
            StringEntity stringEntity = new StringEntity(paramsJson,CHARSET_UTF_8);
            stringEntity.setContentEncoding(CHARSET_UTF_8);
            stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
            httpPost.setEntity(stringEntity);
        }

        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            // 判断响应状态
            if (response.getStatusLine().getStatusCode() >= 300) {
                throw new Exception("Http Request is not success, Response code is" + response.getStatusLine().getStatusCode());
            }

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode() && entity != null) {
                result = EntityUtils.toString(entity, CHARSET_UTF_8);
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            log.error("POST请求失败：", e);
        } finally {
            try {
                response.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    private static String buildUrl(String url, Map<String, String> querys) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(url);
        if (null != querys) {
            StringBuilder sbQuery = new StringBuilder();
            for (Map.Entry<String, String> query : querys.entrySet()) {
                if (0 < sbQuery.length()) {
                    sbQuery.append("&");
                }
                if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
                    sbQuery.append(query.getValue());
                }
                if (!StringUtils.isBlank(query.getKey())) {
                    sbQuery.append(query.getKey());
                    if (!StringUtils.isBlank(query.getValue())) {
                        sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                    }
                }
            }
            if (0 < sbQuery.length()) {
                sbUrl.append("?").append(sbQuery);
            }
        }

        return sbUrl.toString();
    }
}
