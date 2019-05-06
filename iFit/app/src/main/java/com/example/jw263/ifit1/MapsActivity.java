package com.example.jw263.ifit1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jw263.ifit1.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private EditText mAddress;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mAddress = findViewById(R.id.TextMap);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



//        // Add a marker in Sydney and move the camera
//        LatLng SICE = new LatLng(39.173059, -86.523026);
//        mMap.addMarker(new MarkerOptions().position(SICE).title("Marker in SICE"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(SICE));
//
//        // Add a marker in Sample Gates
//        LatLng Gates = new LatLng(39.167428, -86.526493);
//        mMap.addMarker(new MarkerOptions().position(Gates).title("Marker in Sample Gates"));
//
//        // Add a marker in Jacobs School of Music
//        LatLng Music = new LatLng(39.165233, -86.512602);
//        mMap.addMarker(new MarkerOptions().position(Music).title("Marker in Music"));




        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        UiSettings mapUiSettings = mMap.getUiSettings();
        mapUiSettings.setZoomControlsEnabled(true);
    }

    public void onButtonClickMaps(View view){
        double myLong, myLat;
        List<Address> myMatches = null;

        String myAddress;
        

        

        myAddress = mAddress.getText().toString();

        if(!myAddress.isEmpty()) {
            try{
                myMatches = new Geocoder(this).getFromLocationName(myAddress,1);
            }
            catch (IOException e) {
                Toast.makeText(this,"Cant' access Internet?", Toast.LENGTH_LONG).show();
            }

            if(!myMatches.isEmpty())
            {
                myLat = myMatches.get(0).getLatitude();
                myLong = myMatches.get(0).getLongitude();

                LatLng myLatLng = new LatLng(myLat, myLong);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLatLng,12));
            }
            else
                Toast.makeText(this,"Address not found", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,"please enter address", Toast.LENGTH_LONG).show();
    }
}
