package zandra.application.DatingLocationApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class Menu extends AppCompatActivity {
    ScrollView linearLayout;

    String title, item;
    double v, v1;
    int layout, scID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        v = getIntent().getDoubleExtra("v", -34);
        v1 = getIntent().getDoubleExtra("v1", 151);
        title = getIntent().getStringExtra("title");
        item = getIntent().getStringExtra("item");
        load();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Menu.this, InfoActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("v", Double.valueOf(v));
        intent.putExtra("v1", Double.valueOf(v1));
        intent.putExtra("item", item);
        startActivity(intent);
        finish();
    }

    public void whatItem() {
        switch (item) {
            case "0":
                layout = R.layout.layout_menu_macao;
                scID = R.id.scrollViewMacao;
                break;
            case "1":
                layout = R.layout.layout_menu_bell;
                scID = R.id.scrollViewBell;
                break;
            case "2":
                layout = R.layout.layout_menu_silverspoon;
                scID = R.id.scrollViewSilver;
                break;
            case "3":
                layout = R.layout.layout_menu_figarro;
                scID = R.id.scrollViewFigaro;
                break;
            case "4":
                layout = R.layout.layout_menu_philbear;
                scID = R.id.scrollViewPhil;
                break;
            case "5":
                layout = R.layout.layout_menu_golden;
                scID = R.id.scrollViewGolden;
                break;
            case "6":
                layout = R.layout.layout_menu_catcafe;
                scID = R.id.scrollViewCat;
                break;
            case "7":
                layout = R.layout.layout_menu_foodcamp;
                scID = R.id.scrollViewFood;
                break;
            case "8":
                layout = R.layout.layout_menu_booba;
                scID = R.id.scrollViewBooba;
                break;
            case "9":
                layout = R.layout.layout_menu_tea_to_go;
                scID = R.id.scrollViewTeaToGo;
                break;
            case "10":
                layout = R.layout.layout_menu_myrnas;
                scID = R.id.scrollViewMyrnas;
                break;
            case "11":
                layout = R.layout.layout_menu_meshroom;
                scID = R.id.scrollViewMeshroom;
                break;
        }
    }

    public void load() {

        whatItem();

        linearLayout = findViewById(R.id.linearLayoutMenu);
        linearLayout.removeAllViews();

        View child = getLayoutInflater().inflate(layout, null);
        ScrollView sc = child.findViewById(scID);
        linearLayout.addView(child);
    }
}
