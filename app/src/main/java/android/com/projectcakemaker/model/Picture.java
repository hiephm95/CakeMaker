package android.com.projectcakemaker.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("Picture")
public class Picture extends ParseObject {
    public Picture() {
    }

//    //Id
//    public String getId()
//    {
//        return getString("itemCode");
//    }
//
//    public void setId(String value)
//    {
//        put("itemCode", value);
//    }

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
        return getFile();
    }

    public void setFile(ParseFile parseFile)
    {
        put("fileName", parseFile);
    }
}
