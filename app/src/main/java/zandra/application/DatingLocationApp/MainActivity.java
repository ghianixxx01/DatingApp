package zandra.application.DatingLocationApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnLocations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLocations = findViewById(R.id.buttonLocations);
        btnLocations.setBackgroundResource(R.drawable.buttonstyle);

        btnLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toListOfLocation = new Intent(MainActivity.this, ListOfLocation.class);
                startActivity(toListOfLocation);
            }
        });
    }
}
