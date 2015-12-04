package android.com.projectcakemaker.model;

/**
 * Created by hoanghiep on 04/12/2015.
 */
public class Cake {
    private String name;
    private float price;

    public Cake(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
