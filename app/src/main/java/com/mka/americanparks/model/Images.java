package com.mka.americanparks.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Images
{
   private String credit;

   private String title;

   private String altText;

   private String caption;

   private String url;

    public void setCredit(String credit){
       this.credit = credit;
   }
    public String getCredit(){
       return this.credit;
   }
    public void setTitle(String title){
       this.title = title;
   }
    public String getTitle(){
       return this.title;
   }
    public void setAltText(String altText){
       this.altText = altText;
   }
    public String getAltText(){
       return this.altText;
   }
    public void setCaption(String caption){
       this.caption = caption;
   }
    public String getCaption(){
       return this.caption;
   }
    public void setUrl(String url){
       this.url = url;
   }
    public String getUrl(){
       return this.url;
   }
    static Images fill(JSONObject jsonobj) throws JSONException {
       Images entity = new Images();
       if (jsonobj.has("credit")) {
           entity.setCredit(jsonobj.getString("credit"));
       }
       if (jsonobj.has("title")) {
           entity.setTitle(jsonobj.getString("title"));
       }
       if (jsonobj.has("altText")) {
           entity.setAltText(jsonobj.getString("altText"));
       }
       if (jsonobj.has("caption")) {
           entity.setCaption(jsonobj.getString("caption"));
       }
       if (jsonobj.has("url")) {
           entity.setUrl(jsonobj.getString("url"));
       }
       return entity;
   }
    static List<Images> fillList(JSONArray jsonarray) throws JSONException {
       if (jsonarray == null || jsonarray.length() == 0)
           return null;
       List<Images> olist = new ArrayList<Images>();
       for (int i = 0; i < jsonarray.length(); i++) {
           olist.add(fill(jsonarray.getJSONObject(i)));
       }
       return olist;
   }
}
