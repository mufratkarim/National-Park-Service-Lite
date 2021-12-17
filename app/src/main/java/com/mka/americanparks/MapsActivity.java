package com.mka.americanparks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.mka.americanparks.Util.Util;
import com.mka.americanparks.adapter.CustomInfoWindow;
import com.mka.americanparks.data.AsyncResponse;
import com.mka.americanparks.data.Repository;
import com.mka.americanparks.databinding.ActivityMapsBinding;
import com.mka.americanparks.model.Park;
import com.mka.americanparks.model.ParkViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private List<Park> parks;
    private ParkViewModel parkViewModel;
    private String code = "AZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        parkViewModel = new ViewModelProvider(this).get(ParkViewModel.class);
        parks = new ArrayList<>();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        binding.bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            if (id == R.id.map_button) {
                if (binding.cardview.getVisibility() == View.GONE) {
                    binding.cardview.setVisibility(View.VISIBLE);
                }

                if (parks != null) {
                    parks.clear();
                }
                mMap.clear();
                ft.replace(R.id.map, mapFragment)
                        .commit();
                mapFragment.getMapAsync(this);
            } else if (id == R.id.parks_button) {
                binding.cardview.setVisibility(View.GONE);
                ft.add(R.id.map, Objects.requireNonNull(ParksFragment.newInstance()))
                        .commit();
            }
            return true;
        });

        binding.stateSearchButton.setOnClickListener(view -> {
            parks.clear();
            Util.hideSoftKeyboard(view);
            String stateCode = binding.stateSearchText.getText().toString();
            if (!TextUtils.isEmpty(stateCode)) {
                code = stateCode;
                parkViewModel.selectCode(code);
                onMapReady(mMap);
                binding.stateSearchText.setText("");
            }
        });
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
        mMap.setInfoWindowAdapter(new CustomInfoWindow(this));
        mMap.setOnInfoWindowClickListener(this);
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.setPadding(0,0,0,150);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        parks.clear();
        populateMap();
    }

    private void populateMap() {
        mMap.clear();
        Repository.getParks(parkList -> {
            parks = parkList;
            for (Park park : parkList) {

                // Add a marker and move the camera
                String parkMapTitle = park.getName();
                String parkMapStates = park.getStates();
                double parkMapLong = Double.parseDouble(park.getLatitude());
                double parkMapLat = Double.parseDouble(park.getLongitude());
                LatLng parkMap = new LatLng(parkMapLat, parkMapLong);

                MarkerOptions markerOptions = new MarkerOptions().title(parkMapTitle)
                        .position(parkMap)
                        .snippet(parkMapStates)
                        .icon(BitmapDescriptorFactory.defaultMarker(new Random().nextInt(360)));

                Marker marker = mMap.addMarker(markerOptions);
                Objects.requireNonNull(marker).setTag(park);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(parkMap, 8),3000, null);
            }
            parkViewModel.setSelectedParks(parks);
            Log.d("Parks\t", "populateMap: " + parks.size());
        }, code);
    }

    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {
        binding.cardview.setVisibility(View.GONE);
        Park selectedPark = (Park) marker.getTag();
        assert selectedPark != null;
        parkViewModel.selectPark(selectedPark);
        //Toast.makeText(getApplicationContext(), selectedPark.getLatitude() + ", " + selectedPark.getLongitude(), Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().add(R.id.map, DetailsFragment.newInstance())
                .commit();
    }
}