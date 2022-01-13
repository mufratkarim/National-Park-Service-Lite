package com.mka.americanparks.viewmodel.data;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.mka.americanparks.viewmodel.Util.Util;
import com.mka.americanparks.viewmodel.Util.AppController;
import com.mka.americanparks.model.Activities;
import com.mka.americanparks.model.EntranceFees;
import com.mka.americanparks.model.Images;
import com.mka.americanparks.model.OperatingHours;
import com.mka.americanparks.model.Park;
import com.mka.americanparks.model.StandardHours;
import com.mka.americanparks.model.Topics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static List<Park> parkList = new ArrayList<>();

    public static void getParks(final AsyncResponse callback, String stateCode) {

        String url = Util.getParksUrl(stateCode);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("data");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            Park park = new Park();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            park.setId(jsonObject.getString("id"));
                            park.setFullName(jsonObject.getString("fullName"));
                            park.setLatitude(jsonObject.getString("latitude"));
                            park.setLongitude(jsonObject.getString("longitude"));
                            park.setDesignation(jsonObject.getString("designation"));
                            park.setStates(jsonObject.getString("states"));
                            park.setParkCode(jsonObject.getString("parkCode"));
                            park.setWeatherInfo(jsonObject.getString("weatherInfo"));
                            park.setName(jsonObject.getString("name"));
                            park.setUrl(jsonObject.getString("url"));

                            // Setting Images
                            JSONArray imagesArray = jsonObject.getJSONArray("images");
                            List<Images> imagesList = new ArrayList<>();
                            for (int img = 0; img < imagesArray.length(); img++) {
                                Images images = new Images();
                                images.setCredit(imagesArray.getJSONObject(img).getString("credit"));
                                images.setTitle(imagesArray.getJSONObject(img).getString("title"));
                                images.setUrl(imagesArray.getJSONObject(img).getString("url"));

                                imagesList.add(images);
                            }
                            park.setImages(imagesList);

                            // Setting Activities
                            JSONArray activitiesArray = jsonObject.getJSONArray("activities");
                            List<Activities> activitiesList = new ArrayList<>();
                            for (int act = 0; act < activitiesArray.length(); act++) {
                                Activities acts = new Activities();
                                acts.setId(activitiesArray.getJSONObject(act).getString("id"));
                                acts.setName(activitiesArray.getJSONObject(act).getString("name"));

                                activitiesList.add(acts);
                            }
                            park.setActivities(activitiesList);
                            
                            // Setting Topics
                            JSONArray topicsArray = jsonObject.getJSONArray("topics");
                            List<Topics> topicsList = new ArrayList<>();
                            for (int t = 0; t < topicsArray.length(); t++) {
                                Topics topics = new Topics();
                                topics.setId(topicsArray.getJSONObject(t).getString("id"));
                                topics.setName(topicsArray.getJSONObject(t).getString("name"));

                                topicsList.add(topics);
                            }
                            park.setTopics(topicsList);

                            // Setting Entrance Fees
                            JSONArray entranceArray = jsonObject.getJSONArray("entranceFees");
                            List<EntranceFees> entranceFeesList = new ArrayList<>();
                            for (int ef = 0; ef < entranceArray.length(); ef++) {
                                EntranceFees entranceFees = new EntranceFees();
                                entranceFees.setCost(entranceArray.getJSONObject(ef).getString("cost"));
                                entranceFees.setTitle(entranceArray.getJSONObject(ef).getString("title"));
                                entranceFees.setDescription(entranceArray.getJSONObject(ef).getString("description"));

                                entranceFeesList.add(entranceFees);
                            }
                            park.setEntranceFees(entranceFeesList);

                            // Setting Operating Hours
                            JSONArray opHoursArray = jsonObject.getJSONArray("operatingHours");
                            List<OperatingHours> opHoursList = new ArrayList<>();
                            for (int op = 0; op < opHoursArray.length(); op++) {
                                OperatingHours operatingHours = new OperatingHours();
                                operatingHours.setName(opHoursArray.getJSONObject(op).getString("name"));
                                operatingHours.setDescription(opHoursArray.getJSONObject(op).getString("description"));

                                StandardHours standardHours = new StandardHours();
                                JSONObject hours = opHoursArray.getJSONObject(op).getJSONObject("standardHours");
                                standardHours.setMonday(hours.getString("monday"));
                                standardHours.setTuesday(hours.getString("tuesday"));
                                standardHours.setWednesday(hours.getString("wednesday"));
                                standardHours.setThursday(hours.getString("thursday"));
                                standardHours.setFriday(hours.getString("friday"));
                                standardHours.setSaturday(hours.getString("saturday"));
                                standardHours.setSunday(hours.getString("sunday"));


                                operatingHours.setStandardHours(standardHours);
                                opHoursList.add(operatingHours);

                            }
                            park.setOperatingHours(opHoursList);

                            park.setDirectionsInfo(jsonObject.getString("directionsInfo"));
                            park.setDirectionsUrl(jsonObject.getString("directionsUrl"));
                            park.setDescription(jsonObject.getString("description"));

                            parkList.add(park);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (callback != null) {
                        callback.parkProcessing(parkList);
                    }

                }, Throwable::printStackTrace);
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
