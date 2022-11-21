package rick.edu.g2_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView homeTitle;
    Button homeBTN;
    Intent mainPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeTitle = findViewById(R.id.homeTitle);
        homeBTN = findViewById(R.id.homeBTN);

        mainPage = new Intent(this, exploreActivity.class);

        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(mainPage);
            }
        });




    }
}