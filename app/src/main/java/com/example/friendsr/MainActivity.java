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

    /* Function onCreate that takes the Bundle in order to restore the friends list.
    When this Bundle is empty, there will be a new ArrayList created.*/
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

    /* Function onSaveInstanceState that saves the Bundle in order to restore the friends list. */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("friends", friends);
    }

    /* Apart function to fill in the friends ArrayList. */
    public void makeFriends() {
        friends.add(new Friend("Arya", "Arya is great",
                this.getResources().getIdentifier("arya", "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Cersei", "Cersei is strong and plays an important role.",
                this.getResources().getIdentifier("cersei" , "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Daenerys", "Daenerys is nice",
                this.getResources().getIdentifier("daenerys" , "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Jaime", "Jaime is kind",
                this.getResources().getIdentifier("jaime" , "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Jon", "Jon is brave",
                this.getResources().getIdentifier("jon" , "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Jorah", "Jorah is a hero ",
                this.getResources().getIdentifier("jorah" , "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Margaery", "Margaery is beautiful",
                this.getResources().getIdentifier("margaery" , "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Melisandre", "Melisandre is elegant",
                this.getResources().getIdentifier("melisandre" , "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Sannsa", "Sansa is wonderful",
                this.getResources().getIdentifier("sansa" , "drawable",
                        this.getPackageName())));
        friends.add(new Friend("Tyrion", "Tyrion is super",
                this.getResources().getIdentifier("tyrion" , "drawable",
                        this.getPackageName())));
    }

    /* Function setAdapter to initialize the adapter in order to fill in the grid with friends from
    the friends list. */
    public void setAdapter() {
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView view = findViewById(R.id.mainContainer);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new GridItemClickListener());
    }

    /* Function that implements the OnItemClickListener from the grid view.
    Creates an intent and put the clicked friend on in. */
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
