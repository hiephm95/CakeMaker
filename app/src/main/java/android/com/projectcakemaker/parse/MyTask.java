package android.com.projectcakemaker.parse;

import android.com.projectcakemaker.model.Product;
import android.os.AsyncTask;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class MyTask extends AsyncTask<Void, Void, List<Product>> {
    @Override
    protected void onPostExecute(List<Product> products) {
        super.onPostExecute(products);
        try {
            Log.d("Event", "" + products.get(0).getEventRelation().getQuery().find().get(0).getName());
            Log.d("Events", "" + products.get(0).getEventList().get(0).getName());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected List<Product> doInBackground(Void... params) {
        ParseQuery<Product> query = ParseQuery.getQuery(Product.class);
        try {
            return query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


}
