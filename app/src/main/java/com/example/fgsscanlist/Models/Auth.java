package com.example.fgsscanlist.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Auth {
    /*
    "token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKYXlKYXlNaWxscyI
sInN1YiI6IkF1dGhlbnRpY2F0aW9uIiwiZXhwIjoxNzE0NDU3NTgzLCJpYXQiOjE3MTQzNzExODMs
InVzZXIiOiJGR1MifQ.g3i8a8bUQ1h9fdxVW1i1XmiC-1Ub3M_Lxt3AlgfmX8M"
     */
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
