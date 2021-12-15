package com.mka.americanparks.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Activities
{
   private String id;

   private String name;

    public void setId(String id){
       this.id = id;
   }
    public String getId(){
       return this.id;
   }
    public void setName(String name){
       this.name = name;
   }
    public String getName(){
       return this.name;
   }
    static Activities fill(JSONObject jsonobj) throws JSONException {
       Activities entity = new Activities();
       if (jsonobj.has("id")) {
           entity.setId(jsonobj.getString("id"));
       }
       if (jsonobj.has("name")) {
           entity.setName(jsonobj.getString("name"));
       }
       return entity;
   }
    static List<Activities> fillList(JSONArray jsonarray) throws JSONException {
       if (jsonarray == null || jsonarray.length() == 0)
           return null;
       List<Activities> olist = new ArrayList<Activities>();
       for (int i = 0; i < jsonarray.length(); i++) {
           olist.add(fill(jsonarray.getJSONObject(i)));
       }
       return olist;
   }
}
