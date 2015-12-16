package android.com.projectcakemaker.fragment;

import android.com.projectcakemaker.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Bui on 12/16/2015.
 */
public class OrderFragment extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_order);

        Spinner dropdown = (Spinner)findViewById(R.id.spDistrict);
        String[] items = new String[]{"Tay Ho","Long Bien","Ha Dong","Cau Giay"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }
}
