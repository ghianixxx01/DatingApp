package zandra.application.DatingLocationApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListOfLocation extends AppCompatActivity {
    ListView listview;
    List<Items> itemIMGs;
    int[] itemIMG = {R.drawable.macao, R.drawable.belle, R.drawable.silverspoon,
            R.drawable.figaro, R.drawable.philbear, R.drawable.golden, R.drawable.cat, R.drawable.food, R.drawable.boobacoolers, R.drawable.teatwogo, R.drawable.myrnas, R.drawable.meshroom};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_location);
        populate();
    }

    private void populate() {
        listview = findViewById(R.id.listViewItems);
        itemIMGs = new ArrayList<>();

        String names[] = getResources().getStringArray(R.array.items_urdaneta);
        
        //adding some values to our list
        for(int i = 0; i < itemIMG.length; i ++){
            itemIMGs.add(new Items(itemIMG[i], names[i]));
        }

        //creating the adapter
        MyListAdapter adapter = new MyListAdapter(this, R.layout.layout_list_item, itemIMGs);
        //attaching adapter to the listview
        listview.setAdapter(adapter);
        
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ListOfLocation.this, MainActivity.class));
        super.onBackPressed();

    }

    private void populateListView() {

        listview = findViewById(R.id.listViewItems);

        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.items_urdaneta, android.R.layout.simple_list_item_1);
        listview.setAdapter(aa);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtView = view.findViewById(android.R.id.text1);
                String title = txtView.getText().toString();
                //Toast.makeText(ListOfLocation.this, txtView.getText().toString() , Toast.LENGTH_SHORT).show();

                String[] coords = getResources().getStringArray(R.array.items_urdaneta_coords);
                String[] realCoords = coords[i].split(",");

                String v = realCoords[0];
                String v1 = realCoords[1];

                Intent intent = new Intent(ListOfLocation.this, InfoActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("v", Double.valueOf(v));
                intent.putExtra("v1", Double.valueOf(v1));
                intent.putExtra("itemIMG", String.valueOf(i));
                startActivity(intent);
            }
        });
    }
}
