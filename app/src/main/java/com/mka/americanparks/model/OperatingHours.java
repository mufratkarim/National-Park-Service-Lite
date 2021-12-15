package com.mka.americanparks.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OperatingHours {
    private List<Exceptions> exceptions;

    private String description;

    private StandardHours standardHours;

    private String name;

    static OperatingHours fill(JSONObject jsonobj) throws JSONException {
        OperatingHours entity = new OperatingHours();
        if (jsonobj.has("exceptions")) {
            //entity.setExceptions(jsonobj.getJSONArray("exceptions"));
        }
        if (jsonobj.has("description")) {
            entity.setDescription(jsonobj.getString("description"));
        }
        if (jsonobj.has("standardHours")) {
            entity.setStandardHours((StandardHours) jsonobj.get("standardHours"));
        }
        if (jsonobj.has("name")) {
            entity.setName(jsonobj.getString("name"));
        }
        return entity;
    }

    static List<OperatingHours> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<OperatingHours> olist = new ArrayList<OperatingHours>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    List<Exceptions> getExceptions() {
        return this.exceptions;
    }

    void setExceptions(List<Exceptions> exceptions) {
        this.exceptions = exceptions;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StandardHours getStandardHours() {
        return this.standardHours;
    }

    public void setStandardHours(StandardHours standardHours) {
        this.standardHours = standardHours;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
