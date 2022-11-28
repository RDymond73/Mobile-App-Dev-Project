package rick.edu.g2_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class myAdapter extends BaseAdapter {
    Context context;
    ArrayList<Explore> arrayList;

    public myAdapter(Context context, ArrayList<Explore> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    //edit this to add more widgets to your list view
    //the DBHelper will also need to be modified to add more data to display
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item, null);

        TextView t0 = (TextView) view.findViewById(R.id.list_item_tv0);
        TextView t1 = (TextView) view.findViewById(R.id.list_item_tv1);
        TextView t2 = (TextView) view.findViewById(R.id.list_item_tv2);

        Explore explore = arrayList.get(i);

        t0.setText(String.valueOf("ID: " + explore.getId()));
        t1.setText("Cpu Model: " + explore.getCpu());
        t2.setText("Price: " + String.valueOf(explore.getCpu_price()));

        return view;
    }
}
