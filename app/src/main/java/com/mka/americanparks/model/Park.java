package com.mka.americanparks.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class PhoneNumbers {
    private String phoneNumber;

    private String description;

    private String extension;

    private String type;

    static PhoneNumbers fill(JSONObject jsonobj) throws JSONException {
        PhoneNumbers entity = new PhoneNumbers();
        if (jsonobj.has("phoneNumber")) {
            entity.setPhoneNumber(jsonobj.getString("phoneNumber"));
        }
        if (jsonobj.has("description")) {
            entity.setDescription(jsonobj.getString("description"));
        }
        if (jsonobj.has("extension")) {
            entity.setExtension(jsonobj.getString("extension"));
        }
        if (jsonobj.has("type")) {
            entity.setType(jsonobj.getString("type"));
        }
        return entity;
    }

    static List<PhoneNumbers> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<PhoneNumbers> olist = new ArrayList<PhoneNumbers>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    String getPhoneNumber() {
        return this.phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String getDescription() {
        return this.description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getExtension() {
        return this.extension;
    }

    void setExtension(String extension) {
        this.extension = extension;
    }

    String getType() {
        return this.type;
    }

    void setType(String type) {
        this.type = type;
    }
}

class EmailAddresses {
    private String description;

    private String emailAddress;

    static EmailAddresses fill(JSONObject jsonobj) throws JSONException {
        EmailAddresses entity = new EmailAddresses();
        if (jsonobj.has("description")) {
            entity.setDescription(jsonobj.getString("description"));
        }
        if (jsonobj.has("emailAddress")) {
            entity.setEmailAddress(jsonobj.getString("emailAddress"));
        }
        return entity;
    }

    static List<EmailAddresses> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<EmailAddresses> olist = new ArrayList<EmailAddresses>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    String getDescription() {
        return this.description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getEmailAddress() {
        return this.emailAddress;
    }

    void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

class Contacts {
    private List<PhoneNumbers> phoneNumbers;

    private List<EmailAddresses> emailAddresses;

    static Contacts fill(JSONObject jsonobj) throws JSONException {
        Contacts entity = new Contacts();
        if (jsonobj.has("phoneNumbers")) {
            entity.setPhoneNumbers((List<PhoneNumbers>) jsonobj.getJSONArray("phoneNumbers"));
        }
        if (jsonobj.has("emailAddresses")) {
            entity.setEmailAddresses((List<EmailAddresses>) jsonobj.getJSONArray("emailAddresses"));
        }
        return entity;
    }

    static List<Contacts> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<Contacts> olist = new ArrayList<Contacts>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    List<PhoneNumbers> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    List<EmailAddresses> getEmailAddresses() {
        return this.emailAddresses;
    }

    void setEmailAddresses(List<EmailAddresses> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }
}


class ExceptionHours {
    static ExceptionHours fill(JSONObject jsonobj) {
        ExceptionHours entity = new ExceptionHours();
        return entity;
    }

    static List<ExceptionHours> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<ExceptionHours> olist = new ArrayList<ExceptionHours>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}


class Exceptions {
    private ExceptionHours exceptionHours;

    private Date startDate;

    private String name;

    private Date endDate;

    static Exceptions fill(JSONObject jsonobj) throws JSONException {
        Exceptions entity = new Exceptions();
        if (jsonobj.has("exceptionHours")) {
            // entity.setExceptionHours(jsonobj.ge("exceptionHours"));
        }
        if (jsonobj.has("startDate")) {
            entity.setStartDate((Date) jsonobj.get("startDate"));
        }
        if (jsonobj.has("name")) {
            entity.setName(jsonobj.getString("name"));
        }
        if (jsonobj.has("endDate")) {
            //entity.setEndDate(jsonobj.getDate("endDate"));
        }
        return entity;
    }

    static List<Exceptions> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<Exceptions> olist = new ArrayList<Exceptions>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    ExceptionHours getExceptionHours() {
        return this.exceptionHours;
    }

    void setExceptionHours(ExceptionHours exceptionHours) {
        this.exceptionHours = exceptionHours;
    }

    Date getStartDate() {
        return this.startDate;
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    Date getEndDate() {
        return this.endDate;
    }

    void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}


public class Park {
    private String id;

    private String url;

    private String fullName;

    private String parkCode;

    private String description;

    private String latitude;

    private String longitude;

    private String latLong;

    private List<Activities> activities;

    private List<Topics> topics;

    private String states;

    private Contacts contacts;

    private List<EntranceFees> entranceFees;

    private List<String> entrancePasses;

    private List<String> fees;

    private String directionsInfo;

    private String directionsUrl;

    private List<OperatingHours> operatingHours;

    private List<Addresses> addresses;

    private List<Images> images;

    private String weatherInfo;

    private String name;

    private String designation;

    static Park fill(JSONObject jsonobj) throws JSONException {
        Park entity = new Park();
        if (jsonobj.has("id")) {
            entity.setId(jsonobj.getString("id"));
        }
        if (jsonobj.has("url")) {
            entity.setUrl(jsonobj.getString("url"));
        }
        if (jsonobj.has("fullName")) {
            entity.setFullName(jsonobj.getString("fullName"));
        }
        if (jsonobj.has("parkCode")) {
            entity.setParkCode(jsonobj.getString("parkCode"));
        }
        if (jsonobj.has("description")) {
            entity.setDescription(jsonobj.getString("description"));
        }
        if (jsonobj.has("latitude")) {
            entity.setLatitude(jsonobj.getString("latitude"));
        }
        if (jsonobj.has("longitude")) {
            entity.setLongitude(jsonobj.getString("longitude"));
        }
        if (jsonobj.has("latLong")) {
            entity.setLatLong(jsonobj.getString("latLong"));
        }
        if (jsonobj.has("activities")) {
            entity.setActivities((List<Activities>) jsonobj.getJSONArray("activities"));
        }
        if (jsonobj.has("topics")) {
            entity.setTopics((List<Topics>) jsonobj.getJSONArray("topics"));
        }
        if (jsonobj.has("states")) {
            entity.setStates(jsonobj.getString("states"));
        }
        if (jsonobj.has("contacts")) {
            entity.setContacts((Contacts) jsonobj.get("contacts"));
        }
        if (jsonobj.has("entranceFees")) {
            entity.setEntranceFees((List<EntranceFees>) jsonobj.getJSONArray("entranceFees"));
        }
        if (jsonobj.has("entrancePasses")) {
            entity.setEntrancePasses((List<String>) jsonobj.getJSONArray("entrancePasses"));
        }
        if (jsonobj.has("fees")) {
            entity.setFees((List<String>) jsonobj.getJSONArray("fees"));
        }
        if (jsonobj.has("directionsInfo")) {
            entity.setDirectionsInfo(jsonobj.getString("directionsInfo"));
        }
        if (jsonobj.has("directionsUrl")) {
            entity.setDirectionsUrl(jsonobj.getString("directionsUrl"));
        }
        if (jsonobj.has("operatingHours")) {
            entity.setOperatingHours((List<OperatingHours>) jsonobj.getJSONArray("operatingHours"));
        }
        if (jsonobj.has("addresses")) {
            entity.setAddresses((List<Addresses>) jsonobj.getJSONArray("addresses"));
        }
        if (jsonobj.has("images")) {
            entity.setImages((List<Images>) jsonobj.getJSONArray("images"));
        }
        if (jsonobj.has("weatherInfo")) {
            entity.setWeatherInfo(jsonobj.getString("weatherInfo"));
        }
        if (jsonobj.has("name")) {
            entity.setName(jsonobj.getString("name"));
        }
        if (jsonobj.has("designation")) {
            entity.setDesignation(jsonobj.getString("designation"));
        }
        return entity;
    }

    static List<Park> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<Park> olist = new ArrayList<Park>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getParkCode() {
        return this.parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatLong() {
        return this.latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public List<Activities> getActivities() {
        return this.activities;
    }

    public void setActivities(List<Activities> activities) {
        this.activities = activities;
    }
    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
    public List<Topics> getTopics() {return this.topics; }

    public String getStates() {
        return this.states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public Contacts getContacts() {
        return this.contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<EntranceFees> getEntranceFees() {
        return this.entranceFees;
    }

    public void setEntranceFees(List<EntranceFees> entranceFees) {
        this.entranceFees = entranceFees;
    }

    public List<String> getEntrancePasses() {
        return this.entrancePasses;
    }

    public void setEntrancePasses(List<String> entrancePasses) {
        this.entrancePasses = entrancePasses;
    }

    public List<String> getFees() {
        return this.fees;
    }

    public void setFees(List<String> fees) {
        this.fees = fees;
    }

    public String getDirectionsInfo() {
        return this.directionsInfo;
    }

    public void setDirectionsInfo(String directionsInfo) {
        this.directionsInfo = directionsInfo;
    }

    public String getDirectionsUrl() {
        return this.directionsUrl;
    }

    public void setDirectionsUrl(String directionsUrl) {
        this.directionsUrl = directionsUrl;
    }

    public List<OperatingHours> getOperatingHours() {
        return this.operatingHours;
    }

    public void setOperatingHours(List<OperatingHours> operatingHours) {
        this.operatingHours = operatingHours;
    }

    public List<Addresses> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(List<Addresses> addresses) {
        this.addresses = addresses;
    }

    public List<Images> getImages() {
        return this.images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getWeatherInfo() {
        return this.weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

