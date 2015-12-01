package android.com.projectcakemaker;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SharedElementCallback;
import android.com.projectcakemaker.adapter.MenuAdapter;
import android.com.projectcakemaker.fragment.EventFragment;
import android.com.projectcakemaker.fragment.HomeFragment;
import android.com.projectcakemaker.fragment.ProductFragment;
import android.com.projectcakemaker.interfaces.ScreenChangeListener;
import android.com.projectcakemaker.model.Screen;
import android.os.Build;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainProductActivity extends AppCompatActivity implements View.OnClickListener, ScreenChangeListener {

    TextView tvTitle;

    ListView lsvMenu;
    RelativeLayout rlLeftDrawer;
    DrawerLayout dlLayout;
    ImageView vActionLeft;

    ActionBarDrawerToggle mDrawerToggle;

    MenuAdapter menuAdapter;
    ArrayList<Screen> screenArrayList = new ArrayList<>();

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product);
        setEnterSharedElementCallback(new SharedElementCallback() {
            View mSnapshot;

            @Override
            public void onSharedElementStart(List<String> sharedElementNames,
                                             List<View> sharedElements,
                                             List<View> sharedElementSnapshots) {
                addSnapshot(sharedElementNames, sharedElements, sharedElementSnapshots, false);
                if (mSnapshot != null) {
                    mSnapshot.setVisibility(View.VISIBLE);
                }
                findViewById(R.id.main_layout).setVisibility(View.INVISIBLE);
            }

            @Override
            public void onSharedElementEnd(List<String> sharedElementNames,
                                           List<View> sharedElements,
                                           List<View> sharedElementSnapshots) {
                addSnapshot(sharedElementNames, sharedElements, sharedElementSnapshots,
                        true);
                if (mSnapshot != null) {
                    mSnapshot.setVisibility(View.INVISIBLE);
                }
                findViewById(R.id.main_layout).setVisibility(View.VISIBLE);
            }

            @Override
            public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                findViewById(R.id.main_layout).setVisibility(View.INVISIBLE);
            }

            private void addSnapshot(List<String> sharedElementNames,
                                     List<View> sharedElements,
                                     List<View> sharedElementSnapshots,
                                     boolean relayoutContainer) {
                if (mSnapshot == null) {
                    for (int i = 0; i < sharedElementNames.size(); i++) {
                        if ("hello".equals(sharedElementNames.get(i))) {
                            FrameLayout element = (FrameLayout) sharedElements.get(i);
                            mSnapshot = sharedElementSnapshots.get(i);
                            int width = mSnapshot.getWidth();
                            int height = mSnapshot.getHeight();
                            FrameLayout.LayoutParams layoutParams =
                                    new FrameLayout.LayoutParams(width, height);
                            layoutParams.gravity = Gravity.CENTER;
                            int widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
                            int heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
                            mSnapshot.measure(widthSpec, heightSpec);
                            mSnapshot.layout(0, 0, width, height);
                            mSnapshot.setTransitionName("snapshot");
                            if (relayoutContainer) {
                                ViewGroup container = (ViewGroup) findViewById(R.id.container);
                                int left = (container.getWidth() - width) / 2;
                                int top = (container.getHeight() - height) / 2;
                                element.measure(widthSpec, heightSpec);
                                element.layout(left, top, left + width, top + height);
                            }
                            element.addView(mSnapshot, layoutParams);
                            break;
                        }
                    }
                }
            }
        });

        startActivityProduct();

        initViews();

        setUpMenu();

        setActions();

        hideStatusBar();
    }



    public void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions  = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void startActivityProduct() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.main_product, homeFragment);
        fragmentTransaction.commit();
    }


    private void initViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        lsvMenu = (ListView) findViewById(R.id.lsvMenu);
        rlLeftDrawer = (RelativeLayout) findViewById(R.id.left_drawer);
        dlLayout = (DrawerLayout) findViewById(R.id.layout_drawer);
        vActionLeft = (ImageView) findViewById(R.id.actionLeft);

    }

    private void setUpMenu() {
        mDrawerToggle = new ActionBarDrawerToggle(this, dlLayout, 0, 0);

        screenArrayList.add(new Screen(R.mipmap.home, "home"));
        screenArrayList.add(new Screen(R.mipmap.cake, "product"));
        screenArrayList.add(new Screen(R.mipmap.event, "event"));

        lsvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //de-select all items
                for (Screen screen : screenArrayList) {
                    screen.is_selected = false;
                }

                //set clicked item is_selected = true
                screenArrayList.get(position).is_selected = true;

                //update menu UI
                menuAdapter.notifyDataSetChanged();

                //close menu after item clicked
                dlLayout.closeDrawer(rlLeftDrawer);

                //display fragment depend on menu item selected
                displayScreen(position);
            }
        });
        menuAdapter = new MenuAdapter(screenArrayList);
        lsvMenu.setAdapter(menuAdapter);
    }

    private void displayScreen(final int position) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                switch (position) {
                    case Screen.HOME:
                        transaction.replace(R.id.main_product, new HomeFragment());
                        transaction.commit();
                        break;
                    case Screen.PRODUCT:
                        transaction.replace(R.id.main_product, new ProductFragment());
                        transaction.commit();
                        break;
                    case Screen.EVENT:
                        transaction.replace(R.id.main_product, new EventFragment());
                        transaction.commit();
                        break;

                    default:
                        break;
                }
            }
        }, 200);
    }


    private void setActions() {
        vActionLeft.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        //Fragment currentFragment = getFragmentManager().findFragmentById(R.id.main_product);

        switch (v.getId()) {
//            case R.id.actionLeft:
//                if (currentFragment instanceof DetailsFragment) {
//                    getFragmentManager().popBackStack();
//                } else {
//                    dlLayout.openDrawer(rlLeftDrawer);
//                }
//                break;
            case R.id.actionLeft:
                dlLayout.openDrawer(rlLeftDrawer);
                break;
        }
    }

    @Override
    public void finishAfterTransition() {
        super.finishAfterTransition();
        findViewById(R.id.main_layout).setVisibility(View.VISIBLE);
    }

    @Override
    public void setTitleMenu(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void setIconActionLeft(int image_res) {
        vActionLeft.setImageResource(image_res);

    }

    @Override
    protected void onStart() {
        super.onStart();
        View decorView = getWindow().getDecorView();
        int uiOptions  = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions  = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }
}
