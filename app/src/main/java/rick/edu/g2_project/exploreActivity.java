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

    //arrays for third view
    String[] partNames = {"Intel Core i9 Processor", " Intel Core i7 Processor", "Intel Core i5 Processor", "Intel Core i3 Processor", "Ryzen 7", "Ryzen 5", "Ryzen 3", "RTX 3090", "RTX 2070", "GTX 1080", "RTX 3070" , "RTX 3060", "RTX 2060", "RTX 2060 Super", "RX 6700" , "RTX 3050", "RX 580", "RTX 3070 Ti", "RTX 2080", "RTX 2080 Super" };
    String[] partPrices = {"$400", "$300", "$200", "$100", "$350", "$200", "$100", "$1000", "$500", "$300", "$900" , "$750", "$500", "$550", "$380" , "$349", "$150", "$749", "$499", "$599" };
    String[] partDescs = {"This processor features a performance hybrid architecture designed for intelligent performance, optimized creating, and enhanced tuning to allow gamers to game with up to 5.8 GHz clock speed.",
            "Fast 45 W processor designed for use in larger, beefier laptops. The Comet Lake-H family CPU was launched in mid-2020. It features six cores (twelve threads) running at 2.6 GHz Boosting up to 5 GHz (single-core Boost). The likely all-core Boost frequency is 4.3 GHz.",
            "This processor offers a base clock speed of 2.9 GHz and a max speed up to 4.3 GHz. You can also enjoy Intel Turbo Boost Technology 2.0 with this CPU. It comes with other advanced features like Intel Quick Sync Video technology.",
            "10th Generation Intel Core i3 Processor has 4 Cores; 8 Threads, 4.30 GHz Max Turbo Frequency, 3.60 GHz Processor Base Frequency 6 MB Intel Smart Cache",
            "Ryzen 7 5800X3D is an impressive chip that delivers leading-edge gaming performance and leaves room for future GPU upgrades, making it the best CPU at its price point for gaming-focused rigs.",
            "6 cores and 12 processing threads bundled with the quiet AMD wraith stealth cooler max temps 95°C, 4 2 GHz max Boost unlocked for overclocking 35 MB of game Cache DDR4 3200 support",
            "3.4 GHz Precision Boost (up to 3.45 GHz with XFR) True quad core, unlocked CPU architecture",
            "Big ferocious GPU (BFGPU) with TITAN class performance. It's powered by Ampere - NVIDIA's 2nd gen RTX architecture - doubling down on ray tracing and AI performance with enhanced Ray Tracing (RT) Cores, Tensor Cores, and new streaming multiprocessors. Video Memory: 24 GB",
            "Leveraging advanced cooling technologies derived from flagship STRIX graphics cards, the Dual GeForce RTX 2070 opts for substance over style, the perfect choice for a well-balanced build.",
            "Integrated with 8GB GDDR5X 256bit memory, Turbo Fan Cooling System Support up to 8K display @60Hz One-click overclocking",
            "Powered by Ampere—NVIDIA’s 2nd gen RTX architecture. Built with dedicated 2nd gen RT Cores and 3rd gen Tensor Cores, streaming multiprocessors, and high-speed memory, they give you the power you need to rip through the most demanding games.",
            "The GeForce RTX 3060 lets you take on the latest games using the power of Ampere - NVIDIA's 2nd generation RTX architecture. Video Memory: 8 GB, 24 GB",
            "Delivering max-setting 60+ FPS gaming at 1920x1080, and excellent high-setting performance at 2560x1440.",
            "Ideal mid-range GPU. It's affordable, fast and offers excellent cooling. And as a bonus, you'll be ready as more games start to support ray tracing.",
            "An excellent 1080p or 1440p card. At 1080p it's a good choice for high refresh rate monitors, even in demanding games at the highest settings. Its 12GB of memory comes to the fore when pushing high details at 1440p.",
            "The RTX 3050 is built with the powerful graphics performance of the NVIDIA Ampere architecture. It offers dedicated 2nd gen RT Cores and 3rd gen Tensor Cores, new streaming multiprocessors, and high-speed G6 memory.",
            "AMD's Radeon RX 580 uses the same Ellesmere GPU as its predecessor at higher clock rates. The new cards should start around $230 and compete against Nvidia's GeForce GTX 1060 6GB.",
            "The GeForce RTX 3070 Ti graphics card is powered by Ampere - NVIDIA's 2nd gen RTX architecture.",
            "An exceptionally powerful graphics card, the GeForce RTX 2080 Founders Edition is a home run for gaming at 4K or high refresh rates.",
            "The GeForce RTX Super series brings you faster performance. It's time to gear up and get super powers."
            };
    String[] partLinks = {"Amazon, Intel, Best Buy", "Amazon, Intel, Best Buy",
            "Amazon, Intel, Best Buy", "Amazon, Intel, Best Buy", "AMD, Gamestop, Micro Center",
            "AMD, Gamestop, Micro Center", "AMD, Gamestop, Micro Center", "NVIDIA, Newegg, Redbubble",
            "NVIDIA, Newegg, Redbubble", "NVIDIA, Newegg, ebay", "NVIDIA, Newegg, Redbubble", "NVIDIA, Newegg, Redbubble",
            "NVIDIA, Newegg, Redbubble", "NVIDIA, Newegg, ebay", "AMD, Gamestop, Micro Center" , "NVIDIA, Newegg, ebay", "AMD, Gamestop, Micro Center", "NVIDIA, Newegg, Redbubble" , "NVIDIA, Newegg, Redbubble", "NVIDIA, Newegg, Redbubble"};

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
                else if (i == 6) {
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
                else if (i == 7) {
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
                else if (i == 8) {
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
                else if (i == 9) {
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
                else if (i == 10) {
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
                else if (i == 11) {
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
                else if (i == 12) {
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
                else if (i == 13) {
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
                else if (i == 14) {
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
                else if (i == 15) {
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
                else if (i == 16) {
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
                else if (i == 17) {
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
                else if (i == 18) {
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
                else if (i == 19) {
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
                else if (i == 20) {
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

    }

    private void loadData() {
        DBHelper dbHelper = new DBHelper(this);
        myList = dbHelper.getAllParts();
        myAdapter = new myAdapter(this, myList);
        listView.setAdapter(myAdapter);
    }

}