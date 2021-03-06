package android.com.projectcakemaker.model;


import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;

import java.util.ArrayList;
import java.util.List;

@ParseClassName("Product")
public class Product extends ParseObject{
    private List<Event> eventList;
    private List<Picture> picturesList;

    public Product() {
        eventList = new ArrayList<>();
        picturesList = new ArrayList<>();
    }

    //Id
    public String getId() {
        return getObjectId();
    }

    //description
    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String value) {
        put("description", value);
    }

    //name
    public String getName() {
        return getString("name");
    }

    public void setName(String value) {
        put("name", value);
    }

    //itemCode
    public String getItemCode() {
        return getString("itemCode");
    }

    public void setItemCode(String value) {
        put("itemCode", value);
    }

    //price
    public double getPrice() {
        return getDouble("price");
    }

    public void setPrice(double value) {
        put("price", value);
    }

    //egg
    public boolean getEgg() {
        return getBoolean("egg");
    }

    public void setEgg(Boolean value) {
        put("egg", value);
    }

    //discount
    public Double getDiscount() {
        return getDouble("discount");
    }

    public void setDiscount(double value) {
        put("discount", value);
    }

    //Event
    public ParseRelation<Event> getEventRelation() {
        return getRelation("events");
    }

    public void setEventRelation(Event e) {
        getEventRelation().add(e);
    }

    public void setEventList(List<Event> list) {
        eventList = list;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    //Picture
    public ParseRelation<Picture> getPictureRelation() {
        return getRelation("pictures");
    }

    public void setPictureRelation(Picture p) {
        getPictureRelation().add(p);
    }

    public void setPictureList(List<Picture> list) {
        picturesList = list;
    }

    public List<Picture> getPicturesList() {
        return picturesList;
    }


    //Get list all product
    public static void getListProduct(FindCallback<Product> callback) {
        ParseQuery<Product> query = ParseQuery.getQuery(Product.class);
        query.findInBackground(callback);
    }
}
