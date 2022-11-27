package rick.edu.g2_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class exploreActivity<DBHelper> extends AppCompatActivity {

    public static SQLiteDatabase db;
    DBHelper dbHelper;


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


    // Temporary Fix for List View

    ArrayAdapter adapter1;
    String[] parts = {"i9  $400", "i7 $300", "i5 $200", "i3 $100", "Ryzen 7  $350", "Ryzen 5  $200", "Ryzen 3  $100", "RTX 3090 $1000", "RTX 2070 $500", "GTX 1080  $300", "RTX 3070  $900" , "RTX 3060 $750", "RTX 2060  $500", "RTX 2060 Super  $550", "RX 6700  $380" , "RTX 3050  $349", "RX 580  $150", "RTX 3070 Ti  $749", "RTX 2080  $499", "RTX 2080 Super  $599" };

    String[] partNames = {"Intel Core i9 Processor", " Intel Core i7 Processor", "Intel Core i5 Processor", "Intel Core i3 Processor", "Ryzen 7", "Ryzen 5", "Ryzen 3", "RTX 3090", "RTX 2070", "GTX 1080", "RTX 3070" , "RTX 3060", "RTX 2060", "RTX 2060 Super", "RX 6700" , "RTX 3050", "RX 580", "RTX 3070 Ti", "RTX 2080", "RTX 2080 Super" };

    String[] partPrices = {"$400", "$300", "$200", "$100", "$350", "$200", "$100", "$1000", "$500", "$300", "$900" , "$750", "$500", "$550", "$380" , "$349", "$150", "$749", "$499", "$599" };

    String[] partDescs = {"This processor features a performance hybrid architecture designed for intelligent performance, optimized creating, and enhanced tuning to allow gamers to game with up to 5.8 GHz clock speed.", "test"};

    String[] partLinks = {"Amazon, Intel, Best Buy", "test"};

    //intent for listview
    Intent intentPart;

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


        // Temporary Fix
        adapter1 = new ArrayAdapter<String>(this, R.layout.list_item, parts);
        listView.setAdapter(adapter1);
        intentPart = new Intent(this, item_activity.class);

        //list on item click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String position = listView.getItemAtPosition(i).toString();
                if (i == 0) {
                    String partName = partNames[i];
                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
                    intentPart.putExtra("partName", partName);
                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 1) {
                    String partName = partNames[i];
                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
                    intentPart.putExtra("partName", partName);
                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 2) {
                    String partName = partNames[i];
                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
                    intentPart.putExtra("partName", partName);
                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 3) {
                    String partName = partNames[i];
                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
                    intentPart.putExtra("partName", partName);
                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 4) {
                    String partName = partNames[i];
                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
                    intentPart.putExtra("partName", partName);
                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 5) {
                    String partName = partNames[i];
                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
                    intentPart.putExtra("partName", partName);
                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
            }
        });







        //searchbar.setText("");
        //createDB();
        //AllQuery = "select * from CPU";
        //getResult(AllQuery);


        // spinner function not finished
        /*
        SpinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        */

        // need to fix search button listener
        /*
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
           */


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


        // Need to fix Database Helper to populate list view https://icedtealabs.com/android/android-use-existing-sqlite-database-in-android-app/
        /*
        dbHelper = new DataBaseHelper(getApplicationContext());
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listView = (ListView)findViewById(id.lvUsers);
        List<String> listUsers = dbHelper.getAllUsers();

        if(listUsers != null){
            myAdapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1, android.R.id.text1,
                    listUsers);
            listView.setAdapter(myAdapter);
        }
        */

         /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;


    }

     */



    }
}