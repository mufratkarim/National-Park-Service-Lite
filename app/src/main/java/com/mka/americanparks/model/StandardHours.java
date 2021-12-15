package com.mka.americanparks.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StandardHours {
    private String wednesday;

    private String monday;

    private String thursday;

    private String sunday;

    private String tuesday;

    private String friday;

    private String saturday;

    static StandardHours fill(JSONObject jsonobj) throws JSONException {
        StandardHours entity = new StandardHours();
        if (jsonobj.has("monday")) {
            entity.setMonday(jsonobj.getString("monday"));
        }

        if (jsonobj.has("tuesday")) {
            entity.setTuesday(jsonobj.getString("tuesday"));
        }

        if (jsonobj.has("wednesday")) {
            entity.setWednesday(jsonobj.getString("wednesday"));
        }

        if (jsonobj.has("thursday")) {
            entity.setThursday(jsonobj.getString("thursday"));
        }

        if (jsonobj.has("friday")) {
            entity.setFriday(jsonobj.getString("friday"));
        }
        if (jsonobj.has("saturday")) {
            entity.setSaturday(jsonobj.getString("saturday"));
        }
        if (jsonobj.has("sunday")) {
            entity.setSunday(jsonobj.getString("sunday"));
        }


        return entity;
    }

    static List<StandardHours> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<StandardHours> olist = new ArrayList<StandardHours>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    public String getMonday() {
        return this.monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return this.tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return this.wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return this.thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return this.friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return this.saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return this.sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    @Override
    public String toString() {
        return "Monday= " + monday +
                "\nTuesday= " + tuesday +
                "\nWednesday= " + wednesday +
                "\nThursday= " + thursday +
                "\nFriday= " + friday +
                "\nSaturday= " + saturday +
                "\nSunday= " + sunday;
    }
}
