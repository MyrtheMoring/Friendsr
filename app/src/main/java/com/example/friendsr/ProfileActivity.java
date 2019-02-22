package com.example.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private Friend retrievedFriend;

    /* The function onCreate will navigate to the second activity, which provide details on the
    friend that was selected. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView profilepicture = (ImageView) findViewById(R.id.profilepicture);
        profilepicture.setImageResource(retrievedFriend.getDrawableId());

        TextView profilename = (TextView) findViewById(R.id.profilename);
        profilename.setText(retrievedFriend.getName());

        TextView profilebio = (TextView) findViewById(R.id.profilebio);
        profilebio.setText(retrievedFriend.getBio());

        RatingBar personRatingBar = findViewById(R.id.profilerating);
        personRatingBar.setOnRatingBarChangeListener(new RatingBarChangeListener());

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float r = prefs.getFloat(retrievedFriend.getName(), (float) 0.0);
        Log.d("FLOAT", ""+r);

        if (r == (float) 0.0) {
            personRatingBar.setRating((float) 0.0);
        }
        else {
            personRatingBar.setRating(r);
        }

    }

    /* Function RatingBarChangeListener will implement the OnRatingBarChangeListener for changing
     ratings.*/
    private class RatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putFloat(retrievedFriend.getName(), rating);
            editor.apply();
            retrievedFriend.setRating(rating);
        }
    }




}
