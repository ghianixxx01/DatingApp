package zandra.application.DatingLocationApp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    String title, item;
    String[] arrayItem;
    double v, v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        v = getIntent().getDoubleExtra("v", -34);
        v1 = getIntent().getDoubleExtra("v1", 151);
        title = getIntent().getStringExtra("title");
        item = getIntent().getStringExtra("item");

        functions();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(InfoActivity.this, ListOfLocation.class);
        startActivity(intent);
    }

    public void functions(){

        TextView txtTitle = findViewById(R.id.textViewTitle);
        txtTitle.setText(title);

        Button btnMenu = findViewById(R.id.imageViewMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, Menu.class);
                intent.putExtra("title", title);
                intent.putExtra("v", Double.valueOf(v));
                intent.putExtra("v1", Double.valueOf(v1));
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });

        Button btnMap = findViewById(R.id.imageViewMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMaps();
            }
        });

        Button btnSchedule = findViewById(R.id.imageViewTime);
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeButton();
            }
        });

        Button btnContactInfo = findViewById(R.id.imageViewOtherInfo);
        btnContactInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactInformation();
            }
        });

    }

    public void toMaps() {
        Intent intent = new Intent(InfoActivity.this, MapsActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("v", Double.valueOf(v));
        intent.putExtra("v1", Double.valueOf(v1));
        startActivity(intent);
    }

    public void timeButton() {

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Schedule of store (Open-Close)");
        View mView = getLayoutInflater().inflate(R.layout.schedule_style, null);
        switch (item) {
            case "0":
                arrayItem = getResources().getStringArray(R.array.schedule_macao_imperial);
                break;
            case "1":
                arrayItem = getResources().getStringArray(R.array.schedule_bell);
                break;
            case "2":
                arrayItem = getResources().getStringArray(R.array.schedule_silver_spoon);
                break;
            case "3":
                arrayItem = getResources().getStringArray(R.array.schedule_figaro);
                break;
            case "4":
                arrayItem = getResources().getStringArray(R.array.schedule_philbear);
                break;
            case "5":
                arrayItem = getResources().getStringArray(R.array.schedule_golden_treasure);
                break;
            case "6":
                arrayItem = getResources().getStringArray(R.array.schedule_catffee);
                break;
            case "7":
                arrayItem = getResources().getStringArray(R.array.schedule_food_camp);
                break;
            case "8":
                arrayItem = getResources().getStringArray(R.array.schedule_booba);
                break;
            case "9":
                arrayItem = getResources().getStringArray(R.array.schedule_tea_togo);
                break;
            case "10":
                arrayItem = getResources().getStringArray(R.array.schedule_myrnas);
                break;
            case "11":
                arrayItem = getResources().getStringArray(R.array.schedule_meshroom);
                break;
        }
        LinearLayout linearLayout = mView.findViewById(R.id.linearLayoutSchedule);
        TextView[] tx = new TextView[arrayItem.length];

        for (int i = 0; i < arrayItem.length; i++) {

            ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT
            );
            tx[i] = new TextView(this);
            tx[i].setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
            tx[i].setText("\t\t" + arrayItem[i]);
            params.setMargins(20, 25, 10, 25);
            tx[i].setTextSize((float) 15);
            tx[i].setLayoutParams(params);

            linearLayout.addView(tx[i]);
        }

        adb.setView(mView);
        final AlertDialog dialog = adb.create();
        dialog.show();

    }

    public void contactInformation(){

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Contact Information");

        String contactInfo = "";

        switch (item) {
            case "0":
                contactInfo = getResources().getString(R.string.contact_info_macao_imperal);
                break;
            case "1":
                contactInfo = getResources().getString(R.string.contact_info_bell);
                break;
            case "2":
                contactInfo = getResources().getString(R.string.contact_info_silver_spoon);
                break;
            case "3":
                contactInfo = getResources().getString(R.string.contact_info_figaro);
                break;
            case "4":
                contactInfo = getResources().getString(R.string.contact_info_philbear);
                break;
            case "5":
                contactInfo = getResources().getString(R.string.contact_info_golden_treasure);
                break;
            case "6":
                contactInfo = getResources().getString(R.string.contact_info_catffee);
                break;
            case "7":
                contactInfo = getResources().getString(R.string.contact_info_food_camp);
                break;
            case "8":
                contactInfo = getResources().getString(R.string.contact_info_booba);
                break;
            case "9":
                contactInfo = getResources().getString(R.string.contact_info_tea_togo);
                break;
            case "10":
                contactInfo = getResources().getString(R.string.contact_info_myrnas);
                break;
            case "11":
                contactInfo = getResources().getString(R.string.contact_info_meshroom);
                break;
        }
        adb.setMessage(contactInfo);
        adb.show();
    }

}
