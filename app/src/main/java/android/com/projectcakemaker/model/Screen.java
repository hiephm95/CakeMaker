package android.com.projectcakemaker.model;

/**
 * Created by Hoang on 11/26/2015.
 */
public class Screen {

    public static final int HOME = 0;
    public static final int PRODUCT = 1;
    public static final int EVENT = 2;


    public String title;
    public int icon_res;
    public boolean is_selected;

    public Screen(int icon_res, String title) {
        this.title = title;
        this.icon_res = icon_res;

    }

    public Screen(int icon_res, boolean is_selected, String title) {
        this.title = title;
        this.icon_res = icon_res;
        this.is_selected = is_selected;

    }
}
