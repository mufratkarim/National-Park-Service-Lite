package com.mka.americanparks.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Addresses {
    private String postalCode;

    private String city;

    private String stateCode;

    private String line1;

    private String type;

    private String line;

    private String line2;

    static Addresses fill(JSONObject jsonobj) throws JSONException {
        Addresses entity = new Addresses();
        if (jsonobj.has("postalCode")) {
            entity.setPostalCode(jsonobj.getString("postalCode"));
        }
        if (jsonobj.has("city")) {
            entity.setCity(jsonobj.getString("city"));
        }
        if (jsonobj.has("stateCode")) {
            entity.setStateCode(jsonobj.getString("stateCode"));
        }
        if (jsonobj.has("line1")) {
            entity.setLine1(jsonobj.getString("line1"));
        }
        if (jsonobj.has("type")) {
            entity.setType(jsonobj.getString("type"));
        }
        if (jsonobj.has("line")) {
            entity.setLine(jsonobj.getString("line"));
        }
        if (jsonobj.has("line2")) {
            entity.setLine2(jsonobj.getString("line2"));
        }
        return entity;
    }

    static List<Addresses> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<Addresses> olist = new ArrayList<Addresses>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getLine1() {
        return this.line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLine() {
        return this.line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLine2() {
        return this.line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }
}
