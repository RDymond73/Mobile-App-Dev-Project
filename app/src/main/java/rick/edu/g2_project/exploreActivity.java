package rick.edu.g2_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class exploreActivity<DBHelper> extends AppCompatActivity {

    public static SQLiteDatabase db;
    DBHelper myDbHelper;


    // widgets for app main screen
    EditText searchbar;
    Button searchbtn;


    // spinner plus adapter
    Spinner SpinnerFilter;
    ArrayAdapter<String> SpinnerAdapter;

    // list view and its adapter
    ListView listView;
    ArrayAdapter<String> myAdapter;

    // ArrayList for every column in database
    ArrayList<Integer> RIDList;
    ArrayList<String> RName;
    ArrayList<String> RCost;

    // Array for spinner
    String[] filters = {"All", "CPUs", "GPUs"};

    // Strings
    String txt = "";
    String AllQuery = "";







    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        searchbar = findViewById(R.id.searchbar);
        searchbtn = findViewById(R.id.searchbtn);
        listView = findViewById(R.id.listView);
        SpinnerFilter = findViewById(R.id.filter);


        SpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, filters);
        SpinnerFilter.setAdapter(SpinnerAdapter);

        //searchbar.setText("");
        //createDB();
        //AllQuery = "select * from CPU";
        //getResult(AllQuery);


        // spinner function not finished
        SpinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // need to fix search button listener
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = searchbar.getText().toString();
                String searchQuery = "select * from recipe where ingredients like '%"
                        + txt + "%'";
                //getResult(searchQuery);

                //to hide the soft keyboard after pressing the search button
                //hideSoftKeyboard();
                //categorySpinner.setSelection(6);
            }
        });


        // need to fix getResult method
        /*
        public void getResult(String q) {
            Cursor result = db.rawQuery(q, null);
            result.moveToFirst();
            int count = result.getCount();
            Log.i("count=", String.valueOf(count));
            //arrays for name, ingredients and preparation for each recipe
            RIDList = new ArrayList<Integer>();
            RName = new ArrayList<String>();
            RCost = new ArrayList<String>();



                myAdapter = new myAdapter(exploreActivity.this,
                        RIDList, RName, RCost);
                listView.setAdapter(myAdapter);

            } //else {
                //listView.setVisibility(View.GONE);
                //noResult.setVisibility(View.VISIBLE);


    */

    }
}