package com.example.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

//    constructor
    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

//    This method will be called every time a new grid item is to be displayed (for example, when scrolling).
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        Friend friend = friends.get(position);
        ImageView image = convertView.findViewById(R.id.image);
        image.setImageResource(friend.getDrawableId());
        TextView name = convertView.findViewById(R.id.name);
        name.setText(friend.getName());

        return convertView;
    }
}
