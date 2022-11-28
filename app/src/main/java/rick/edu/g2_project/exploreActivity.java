package rick.edu.g2_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class exploreActivity extends AppCompatActivity {
    private ListView listView;

    private ArrayList<Explore> myList;

    myAdapter myAdapter;

    // spinner plus adapter
    Spinner SpinnerFilter;
    ArrayAdapter<String> SpinnerAdapter;
    String[] filters = {"All", "CPUs", "GPUs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        listView = findViewById(R.id.listView);

        myList = new ArrayList<>();
        loadData();

        SpinnerFilter = findViewById(R.id.filter);

        SpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, filters);
        SpinnerFilter.setAdapter(SpinnerAdapter);

    }

    private void loadData() {
        DBHelper dbHelper = new DBHelper(this);
        myList = dbHelper.getAllParts();
        myAdapter = new myAdapter(this, myList);
        listView.setAdapter(myAdapter);
    }
}