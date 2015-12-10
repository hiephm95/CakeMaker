package android.com.projectcakemaker.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Event")
public class Event extends ParseObject {

    public Event() {
    }

    //id
    public String getId() {
        return getString("eventId");
    }

    public void setId(String value)
    {
        put("eventId", value);
    }

    //name
    public String getName() {
        return getString("name");
    }

    public void setName(String value) {
        put("name", value);
    }
}
