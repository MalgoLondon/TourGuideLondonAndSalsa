package com.example.android.tourguidelondonandsalsa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFagment extends Fragment {


    public RestaurantsFagment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_list, container, false);

        final ArrayList<Items> places = new ArrayList<Items>();
        places.add(new Items("Sowa", "W5 5DB", R.drawable.sowa));
        places.add(new Items("Ognisko", "SW7 2PN", R.drawable.ognisko));
        places.add(new Items("Wright Brothers Battersea", "SW8 4NN", R.drawable.wright));
        places.add(new Items("Barraffina", "W1D 3LL", R.drawable.barraffina));
        places.add(new Items("Dishroom Carnaby", "W1B 5QB", R.drawable.dishroom));
        places.add(new Items("Rangrez", "W6 9PH", R.drawable.rangrez));
        places.add(new Items("Frenchie", "WC2E 8QH", R.drawable.frenchie));
        places.add(new Items("Brasserie Zedel", "W1F 7ED", R.drawable.zedel));
        places.add(new Items("The Oak", "W2 5QL", R.drawable.oak));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        ItemAdapter adapter = new ItemAdapter(getActivity(), places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(getString(R.string.PlaceChosen), places.get(position));
                startActivity(intent);
            }

        });
        return rootView;
    }
}


