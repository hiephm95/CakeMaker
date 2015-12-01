package android.com.projectcakemaker.adapter;

import android.com.projectcakemaker.R;
import android.com.projectcakemaker.model.Screen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hoang on 11/26/2015.
 */
public class MenuAdapter extends BaseAdapter {
    ArrayList<Screen> screenArrayList;

    public MenuAdapter(ArrayList<Screen> screenArrayList) {
        this.screenArrayList = screenArrayList;
    }

    @Override
    public int getCount() {
        return screenArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return screenArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Screen screen = screenArrayList.get(position);
        vh.tvMenu.setText(screen.title.toUpperCase());
        vh.ivIcon.setImageResource(screen.icon_res);

        if (screen.is_selected) {
            convertView.setBackgroundColor(parent.getContext().getResources().getColor(R.color.white));
            vh.tvMenu.setTextColor(parent.getContext().getResources().getColor(R.color.pink));
        } else {
            convertView.setBackgroundColor(parent.getContext().getResources().getColor(R.color.white));
            vh.tvMenu.setTextColor(parent.getContext().getResources().getColor(R.color.black));
        }
        return convertView;
    }

    class ViewHolder {
        TextView tvMenu;
        ImageView ivIcon;

        public ViewHolder(View container) {
            tvMenu = (TextView) container.findViewById(R.id.tvTitleMenu);
            ivIcon = (ImageView) container.findViewById(R.id.ivIcon);
        }
    }

}
