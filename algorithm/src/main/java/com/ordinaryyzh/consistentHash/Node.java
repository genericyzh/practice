package com.ordinaryyzh.consistentHash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author genericyzh
 * @date 2018/6/24 21:23
 */
public class Node {

    private final static int DEFAULT_MAPSIZE = 3000;

    private String domain;

    private String ip;

    private Map<String, Object> data = new HashMap<>(DEFAULT_MAPSIZE);

    public Node(String domain, String ip) {
        this.domain = domain;
        this.ip = ip;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Map<String, Object> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "ip='" + ip + '\'' +
                '}';
    }
}