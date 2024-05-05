package com.example.fgsscanlist.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Auth implements Serializable {
    String token;

    public Auth() {
    }
    public Auth(JSONObject jsonObject) throws JSONException {
        this.token = jsonObject.getString("token");
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
