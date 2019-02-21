package com.example.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.io.Serializable;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            friends = new ArrayList<>();
            makeFriends();
        }
      else {
            friends = savedInstanceState.getParcelableArrayList("friends");
        }
        setAdapter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("friends", friends);
    }

    public void makeFriends() {
        friends.add(new Friend("Arya", "Arya .. ", this.getResources().getIdentifier("arya", "drawable", this.getPackageName())));
        friends.add(new Friend("Cersei", "", this.getResources().getIdentifier("cersei" , "drawable", this.getPackageName())));
        friends.add(new Friend("Daenerys", "", this.getResources().getIdentifier("daenerys" , "drawable", this.getPackageName())));
        friends.add(new Friend("Jaime", "", this.getResources().getIdentifier("jaime" , "drawable", this.getPackageName())));
        friends.add(new Friend("Jon", "", this.getResources().getIdentifier("jon" , "drawable", this.getPackageName())));
        friends.add(new Friend("Jorah", "Jorah .. ", this.getResources().getIdentifier("jorah" , "drawable", this.getPackageName())));
        friends.add(new Friend("Margaery", "", this.getResources().getIdentifier("margaery" , "drawable", this.getPackageName())));
        friends.add(new Friend("Melisandre", "", this.getResources().getIdentifier("melisandre" , "drawable", this.getPackageName())));
        friends.add(new Friend("Sannsa", "", this.getResources().getIdentifier("sansa" , "drawable", this.getPackageName())));
        friends.add(new Friend("Tyrion", "", this.getResources().getIdentifier("tyrion" , "drawable", this.getPackageName())));
    }

    public void setAdapter() {
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView view = findViewById(R.id.mainContainer);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", (Serializable) clickedFriend);
            startActivity(intent);
        }
    }


}
