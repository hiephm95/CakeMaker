package android.com.projectcakemaker;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.com.projectcakemaker.fragment.LoginFragment;
import android.com.projectcakemaker.model.Event;
import android.com.projectcakemaker.model.Picture;
import android.com.projectcakemaker.model.Product;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseRelation;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initParse();
        initProject();
        hidingStatusBar();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }

    private void initParse() {
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Product.class);
        ParseObject.registerSubclass(Event.class);
        ParseObject.registerSubclass(Picture.class);
        Parse.initialize(this, "l5OJy4F4rw3COKG6Jgc0VKNi7rFQzarUVLcjw4jA", "HCRpx0LQxTlvaBXDQ6BxeFsLnJqkGscA9xf1aq8Q");
    }



    private void initSubclass() {
        Product product = new Product();
        Event event = new Event();
        Product productReference = ParseObject.createWithoutData(Product.class, product.getObjectId());


        Picture picture = new Picture();
        picture.setPictureDescription("cake mania");
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.background);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] data = stream.toByteArray();
        ParseFile parseFile = new ParseFile("cake.png", data);
        picture.setFile(parseFile);

        Picture picture2 = new Picture();
        picture2.setPictureDescription("cake logo");
        Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
        bmp2.compress(Bitmap.CompressFormat.PNG, 100, stream2);
        byte[] data2 = stream.toByteArray();
        ParseFile parseFile2 = new ParseFile("cake_logo.png", data2);
        picture2.setFile(parseFile2);

        event.setName("Christmass");
        product.setItemCode("C2AP");
        product.setName("Fuck Cake");
        product.setDiscount(10);
        product.setEgg(true);
        product.setPrice(345);

        ParseRelation<ParseObject> relation = product.getRelation("pictures");
        relation.add(picture);
        relation.add(picture2);

        ParseRelation<ParseObject> relation_event = product.getRelation("events");
        relation_event.add(event);

//        product.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Toast.makeText(MainActivity.this, "Save ok!", Toast.LENGTH_SHORT).show();
//                }
//                else Toast.makeText(MainActivity.this, "" + e.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

        //initSubclass();
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Product");
//
//        query.getInBackground("Yl7XXDQJ46", new GetCallback<ParseObject>() {
//            @Override
//            public void done(ParseObject object, ParseException e) {
//                if(e == null)
//                {
//                    Picture p = new Picture();
//                    p.setObjectId("eoZYJBLgMh");
//                    Event event = new Event();
//                    event.setObjectId("NWKW4HwNfS");
//                    ParseRelation<ParseObject> relation = object.getRelation("events");
//                    relation.add(event);
//                    ParseRelation<ParseObject> relation_Picture = object.getRelation("pictures");
//                    relation_Picture.add(p);
//
//                    object.saveInBackground();
//                }
//            }
//        });
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
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hidingStatusBar();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

}
