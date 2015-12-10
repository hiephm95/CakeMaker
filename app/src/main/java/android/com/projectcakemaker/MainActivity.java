package android.com.projectcakemaker;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.com.projectcakemaker.fragment.LoginFragment;
import android.com.projectcakemaker.model.Event;
import android.com.projectcakemaker.model.Product;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initParse();
        initProject();
        hidingStatusBar();
    }

    private void initParse() {
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Product.class);
        ParseObject.registerSubclass(Event.class);
        Parse.initialize(this, "l5OJy4F4rw3COKG6Jgc0VKNi7rFQzarUVLcjw4jA", "HCRpx0LQxTlvaBXDQ6BxeFsLnJqkGscA9xf1aq8Q");
        initSubclass();
    }

    private void initSubclass() {
        Product product = new Product();
        Event event = new Event();
        Product productReference = ParseObject.createWithoutData(Product.class, product.getObjectId());
    }


    private void initProject() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.replace(R.id.main_frame, loginFragment);
        fragmentTransaction.commit();
    }

    public void hidingStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    protected void onStart() {
        super.onStart();

        hidingStatusBar();

    }

    @Override
    protected void onResume() {
        super.onResume();
        hidingStatusBar();

    }

}
