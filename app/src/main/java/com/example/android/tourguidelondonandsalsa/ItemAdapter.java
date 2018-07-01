package com.example.android.tourguidelondonandsalsa;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by malgo on 18/02/2018.
 */

public class ItemAdapter extends ArrayAdapter<Items> {



    public ItemAdapter(Activity context, ArrayList<Items> places) {
        // **Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // We use 0 as a second argument because we don't need to rely on the ArrayAdapter to create a ListView for us.
        // Instead, the getView method will handle the inflating of the layout from the layout ressource ID.*/
        super(context, 0, places);
    }
    @Override
    //**Provides a view for an adapter View (ListView, GridView)
    // @param position - the adapter position that is requesting a view
    // @param convertView - the recycled view to populate
    // @param parent - the parent view which is used for inflation*/

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item, parent, false);
        }

        // Get the object located at this position in the list
        Items currentItem = getItem(position);

        // Find the TextView in the item.xml layout
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the name from the current Items object and
        // set this text on the name TextView
        nameTextView.setText(currentItem.getName());

        // Find the TextView in the list_item.xml layout
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the English word from the current Word object and
        // set this text on the number TextView
        addressTextView.setText(currentItem.getAddress());

        // Find the ImageView in the list_item.xml layout with the ID list_icon.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.picture);
        // Check if an image is provided for this word or not
        if (currentItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentItem.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
