package com.example.hola.appmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button  mtypeBtn,mtypeBtn2, mtypeBtn4, mtypeBtn5;
    private final static int MY_PERMISSION_FINE_LOCATION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        mtypeBtn2 = (Button) findViewById(R.id.btnhibrido);
        mtypeBtn = (Button) findViewById(R.id.btnsatelite);

        mtypeBtn4 = (Button) findViewById(R.id.btn4);
        mtypeBtn5 = (Button) findViewById(R.id.btn5);



        mtypeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });


        mtypeBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });


        mtypeBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        mtypeBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        John(googleMap);
        mMap = googleMap;


        mMap.getUiSettings().setZoomControlsEnabled(true);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            mMap.setMyLocationEnabled(true);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                        mMap.setMyLocationEnabled(true);
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "This app requires location premissions to be granted",Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
    }

    public void John (GoogleMap googleMap){
        mMap = googleMap;

        final LatLng punto1= new LatLng(-12.0580334,-77.0793496);
        final LatLng punto2= new LatLng(-12.056377,-77.079175);
        final LatLng punto3= new LatLng(-12.059199,-77.078070);
        final LatLng punto4= new LatLng(-12.060678,-77.080420);
        final LatLng punto5= new LatLng(-12.058255,-77.078971);
        final LatLng punto6= new LatLng(-12.055212,-77.080720);
        final LatLng punto7= new LatLng(-12.055139,-77.079476);
        final LatLng punto8= new LatLng(-12.055076,-77.081836);

        mMap.addMarker(new MarkerOptions().position(punto1).title("Cochera1"));
        mMap.addMarker(new MarkerOptions().position(punto2).title("Cochera2"));
        mMap.addMarker(new MarkerOptions().position(punto3).title("Cochera3"));
        mMap.addMarker(new MarkerOptions().position(punto4).title("Cochera4"));
        mMap.addMarker(new MarkerOptions().position(punto5).title("Cochera5"));
        mMap.addMarker(new MarkerOptions().position(punto6).title("Cochera6"));
        mMap.addMarker(new MarkerOptions().position(punto7).title("Cochera7"));
        mMap.addMarker(new MarkerOptions().position(punto8).title("Cochera8"));



    }
}