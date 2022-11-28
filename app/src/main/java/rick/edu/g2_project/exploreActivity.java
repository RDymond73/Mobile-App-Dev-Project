package rick.edu.g2_project;

import android.annotation.SuppressLint;
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

    String[] partDescs = {"This processor features a performance hybrid architecture designed for intelligent performance, optimized creating, and enhanced tuning to allow gamers to game with up to 5.8 GHz clock speed.", "test"};

    String[] partLinks = {"Amazon, Intel, Best Buy", "test"};

    Intent intentPart;

    @SuppressLint("MissingInflatedId")
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

        intentPart = new Intent(this, item_activity.class);


        //list on item click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String position = listView.getItemAtPosition(i).toString();
                if (i == 0) {
//////                    String partName = partNames[i];
//////                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
////////                    intentPart.putExtra("partName", partName);
////////                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 1) {
//                    String partName = partNames[i];
//                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
//                    intentPart.putExtra("partName", partName);
//                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 2) {
//                    String partName = partNames[i];
//                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
//                    intentPart.putExtra("partName", partName);
//                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 3) {
//                    String partName = partNames[i];
//                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
//                    intentPart.putExtra("partName", partName);
//                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 4) {
//                    String partName = partNames[i];
//                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
//                    intentPart.putExtra("partName", partName);
//                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
                else if (i == 5) {
//                    String partName = partNames[i];
//                    String partPrice = partPrices[i];
                    String partDesc = partDescs[i];
                    String partLink = partLinks[i];
//                    intentPart.putExtra("partName", partName);
//                    intentPart.putExtra("partPrice", partPrice);
                    intentPart.putExtra("partDesc", partDesc);
                    intentPart.putExtra("partLink", partLink);
                    exploreActivity.this.startActivity(intentPart);
                }
            }
        });

    }

    private void loadData() {
        DBHelper dbHelper = new DBHelper(this);
        myList = dbHelper.getAllParts();
        myAdapter = new myAdapter(this, myList);
        listView.setAdapter(myAdapter);
    }

}