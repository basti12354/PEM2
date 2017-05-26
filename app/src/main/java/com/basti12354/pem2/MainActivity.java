package com.basti12354.pem2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Uri gmmIntentUri;
    EditText longitude ;
    EditText latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitude = (EditText) findViewById(R.id.latitude);
        longitude = (EditText) findViewById(R.id.longitude);


        Button go = (Button) findViewById(R.id.button);
        go.setOnClickListener(this);


        final LocationObject[]  locationObjects = {new LocationObject(0,0,""),new LocationObject(48.137079, 11.576006, "München"), new LocationObject( 48.856614, 2.3522219, "Paris"),
                new LocationObject(40.712784,-74.005941 ,"New York")};


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        CustomAdapter adapter = new CustomAdapter(this, locationObjects);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                removeErrorFromEdittext();

                Log.d("Selected", " " + position);
                if (!(position ==0)){
                    latitude.setText(locationObjects[position].getLatitude() + "");
                    longitude.setText(locationObjects[position].getLongitude() + "");
                }
                else {
                    latitude.setText("");
                    longitude.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                removeErrorFromEdittext();

                String latitudeString = latitude.getText().toString();
                String longitudeString = longitude.getText().toString();

                if(TextUtils.isEmpty(latitudeString)) {
                    latitude.setError("Error, please insert xxx.xxx");
                    return;
                }
                if(TextUtils.isEmpty(longitudeString)) {
                    longitude.setError("Error, please insert xxx.xxx");
                    return;
                }

                // Create a Uri from an intent string. Use the result to create an Intent.
                gmmIntentUri = Uri.parse("geo:"+ latitude.getText().toString()+"," +  longitude.getText().toString() + "?z=7");
               //125 gmmIntentUri = Uri.parse("geo:52.5200,13.4049?");

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
                break;
        }
    }

    private void removeErrorFromEdittext(){
        latitude.setError(null);
        longitude.setError(null);
    }
}
