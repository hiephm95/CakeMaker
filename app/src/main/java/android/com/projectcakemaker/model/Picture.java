package android.com.projectcakemaker.model;

import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseRelation;

@ParseClassName("Picture")
public class Picture extends ParseObject {
    public Picture() {
    }

    //Name
    public String getPictureDescription()
    {
        return getString("Description");
    }

    public void setPictureDescription(String value)
    {
        put("Description", value);
    }

    //get/set file
    public ParseFile getFile()
    {
        return getParseFile("fileName");
    }

    public void setFile(ParseFile parseFile)
    {
        put("fileName", parseFile);
    }

}
