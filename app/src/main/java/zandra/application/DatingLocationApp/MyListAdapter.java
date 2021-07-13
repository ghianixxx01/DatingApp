package zandra.application.DatingLocationApp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 9/14/2017.
 */

//we need to extend the ArrayAdapter class as we are building an adapter
public class MyListAdapter extends ArrayAdapter<Items> {

    //the list values in the List of type hero
    List<Items> itemsList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource, List<Items> houses) {
        super(context, resource, houses);
        this.context = context;
        this.resource = resource;
        this.itemsList = houses;
    }

    public MyListAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.imageView);
        final TextView textViewName = view.findViewById(R.id.textViewHouseName);
        textViewName.getBackground().setAlpha(100);
        Button btnDetails = view.findViewById(R.id.buttonDetails);
        //getting the hero of the specified position
        Items houses = itemsList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(houses.getImage()));
        textViewName.setText(houses.getName());

        btnDetails.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = textViewName.getText().toString();
                String[] coords = parent.getResources().getStringArray(R.array.items_urdaneta_coords);
                String[] realCoords = coords[position].split(",");

                String v = realCoords[0];
                String v1 = realCoords[1];

                 Intent intent = new Intent(parent.getContext(), InfoActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("v", Double.valueOf(v));
                intent.putExtra("v1", Double.valueOf(v1));
                intent.putExtra("item", String.valueOf(position));
                parent.getContext().startActivity(intent);
            }
        });

        //finally returning the view
        return view;
    }
}
