package com.example.proyectocovid;

import android.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        //
        Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        //
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //




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

        intento();


        localización(googleMap);
        Antut(googleMap);
        // Add a marker in Sydney and move the camera

    }

    public void Antut(GoogleMap googleMap){
        mMap = googleMap;
        final LatLng inde = new LatLng(-11.9854853,-77.0449321);
        final LatLng inde2 = new LatLng(-11.990837, -77.060711);
        final LatLng inde3 = new LatLng(-11.994008, -77.063283);
        final LatLng inde4 = new LatLng(-11.993988, -77.054367);
        final LatLng inde5 = new LatLng(-12.001333, -77.052592);
        final LatLng inde6 = new LatLng(-12.008381, -77.057804);
        final LatLng inde7 = new LatLng(-12.027922, -77.033564);
        final LatLng inde8 = new LatLng(-12.015802, -77.074929);
        final LatLng inde9 = new LatLng(-12.009575, -77.058377);
        final LatLng inde10 = new LatLng(-11.997117, -77.056543);
        final LatLng inde11 = new LatLng(-11.996128, -77.061314);
        final LatLng olivo = new LatLng(-11.991481, -77.071508);
        final LatLng olivo2 = new LatLng(-11.978817, -77.074036);
        final LatLng olivo3 = new LatLng(-11.971254, -77.067970);
        final LatLng olivo4 = new LatLng(-11.972888, -77.080142);
        final LatLng olivo5 = new LatLng(-11.983657, -77.076704);
        final LatLng olivo6 = new LatLng(-11.955090, -77.062050);
        final LatLng olivo7 = new LatLng(-11.948843, -77.079867);
        final LatLng olivo8 = new LatLng(-11.965511, -77.073580);
        final LatLng olivo9 = new LatLng(-11.962104, -77.066009);
        final LatLng olivo10 = new LatLng(-11.985389, -77.058056);
        final LatLng olivo11 = new LatLng(-11.966707, -77.093327);

        mMap.addMarker(new MarkerOptions().position(inde).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde2).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde3).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde4).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde5).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde6).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde7).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde8).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde9).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde10).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(inde11).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo2).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo3).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo4).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo5).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo6).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo7).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo8).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo9).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo10).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));
        mMap.addMarker(new MarkerOptions().position(olivo11).title("Infectado").icon(BitmapDescriptorFactory.fromResource(R.drawable.virus)));

    }

    public  void intento(){


        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if(permissionCheck==PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){

            }else{

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

            }
        }


    }

    public void localización(final GoogleMap googleMap){
        LocationManager locationManager = (LocationManager)MapsActivity.this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double varLatitud =location.getLatitude();
                double varLongitud =location.getLongitude();

                mMap = googleMap;
                final LatLng miUbica = new LatLng(varLatitud,varLongitud);
                mMap.addMarker(new MarkerOptions().position(miUbica).title("Mi ubicación").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(miUbica,13));
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(miUbica));
                //mMap.getUiSettings();
                mMap.getUiSettings().setZoomControlsEnabled(true);


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);

    }





}
