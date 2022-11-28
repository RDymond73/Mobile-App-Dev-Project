package rick.edu.g2_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class item_activity extends AppCompatActivity {
    //views from layout
//    TextView partName;
//    TextView partPrice;
//    TextView partDesc;
//    TextView partLink;
//    String nameString;
//    String priceString;
//    String descString;
//    String linkString;
//
//    //intent
//    Intent MyIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        //get widgets
//        partName = findViewById(R.id.partName);
//        partPrice = findViewById(R.id.partPrice);
//        partDesc = findViewById(R.id.partDesc);
//        partLink = findViewById(R.id.partLink);
//        MyIntent = getIntent();
////        //get part details from explore view
//////        nameString = MyIntent.getStringExtra("partName");
//////        priceString = MyIntent.getStringExtra("partPrice");
//        descString = MyIntent.getStringExtra("partDesc");
//        linkString = MyIntent.getStringExtra("partLink");
//////
//////
//////        //set textviews with part details
//////        partName.setText(nameString);
//////        partPrice.setText(priceString);
//        partDesc.setText(descString);
//        partLink.setText("Vendors: " + linkString);


    }
}