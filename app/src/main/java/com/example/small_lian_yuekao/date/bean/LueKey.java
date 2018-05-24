package com.example.small_lian_yuekao.date.bean;

import java.io.Serializable;

/**
 * Created by 金雪晗 on 2018/5/23.
 */

public class LueKey implements Serializable{
    String orgId;
    String key;
    String userId;

    public LueKey(String orgId, String key, String userId) {
        this.orgId = orgId;
        this.key = key;
        this.userId = userId;
    }

    public LueKey() {
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LueKey{" +
                "orgId='" + orgId + '\'' +
                ", key='" + key + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
