package android.com.projectcakemaker.parse;

import android.com.projectcakemaker.model.Product;

import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    public List<Product> listProduct;

    public ProductManager() {
        listProduct = new ArrayList<>();
    }

    public List<Product> getProduct() {
        ParseQuery<Product> query = ParseQuery.getQuery(Product.class);
        try {
            listProduct = query.find();
            for (Product p : query.find()) {
                p.setEventList(p.getEventRelation().getQuery().find());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return listProduct;
    }
}
