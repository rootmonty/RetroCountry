package badebaba.retrocountry;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by badebaba on 9/29/2016.
 */

public class MyAdapter extends ArrayAdapter<Model> {

    List<Model> obj;

    public MyAdapter(Context context, List<Model> objects) {
        super(context, 0, objects);
        this.obj = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Model c = getItem(position);
        Viewholder v = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.country, parent, false);
            v = new Viewholder();
            v.tvc1 = (TextView) convertView.findViewById(R.id.textView1);
            v.tvc2 = (TextView) convertView.findViewById(R.id.textView2);

            convertView.setTag(v);
        } else {
            v = (Viewholder) convertView.getTag();
        }

        v.tvc1.setText(c.getName());
        v.tvc2.setText(Double.toString(c.getArea()));
        Log.d("checking", "" + c);


        return convertView;
    }

    static class Viewholder {
        TextView tvc1;
        TextView tvc2;
    }
}
