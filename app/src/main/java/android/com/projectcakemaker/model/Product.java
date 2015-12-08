package android.com.projectcakemaker.model;


import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.List;

@ParseClassName("Product")
public class Product extends ParseObject{
    public Product() {
    }

    //Id
    public int getId()
    {
        return  getInt("objectId");
    }

    //itemCode
    public String getItemCode()
    {
        return getString("itemCode");
    }

    public void setItemCode(String value)
    {
        put("itemCode", value);
    }

    //price
    public double getPrice()
    {
        return getDouble("price");
    }

    public void setPrice(double value)
    {
        put("price", value);
    }

    //egg
    public boolean getEgg()
    {
        return getBoolean("egg");
    }

    public void setEgg(Boolean value)
    {
        put("egg", value);
    }

    //image
    public List<String> imageList()
    {
        return getList("imageList");
    }

    public void setImageList(List<String> value)
    {
        put("imageList", value);
    }

    //discount
    public Double getDiscount()
    {
        return getDouble("discount");
    }

    public void setDiscount(double value)
    {
        put("discount", value);
    }

    //Event
    public ParseObject getEvent()
    {
        return getParseObject("event");
    }

    public void setEvent(Event e)
    {
        put("event", e);
    }
}
