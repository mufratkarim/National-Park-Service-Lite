package com.mka.americanparks.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EntranceFees {
    private String cost;

    private String description;

    private String title;

    static EntranceFees fill(JSONObject jsonobj) throws JSONException {
        EntranceFees entity = new EntranceFees();
        if (jsonobj.has("cost")) {
            entity.setCost(jsonobj.getString("cost"));
        }
        if (jsonobj.has("description")) {
            entity.setDescription(jsonobj.getString("description"));
        }
        if (jsonobj.has("title")) {
            entity.setTitle(jsonobj.getString("title"));
        }
        return entity;
    }

    static List<EntranceFees> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<EntranceFees> olist = new ArrayList<EntranceFees>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    public String getCost() {
        return this.cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
                            }
