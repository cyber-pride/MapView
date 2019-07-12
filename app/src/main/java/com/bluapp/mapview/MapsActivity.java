package com.bluapp.mapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private RecyclerView recyclerView;
    private ItemAdapter<DoctorItemAdapter> otheritemAdapter;
    private FastAdapter<DoctorItemAdapter> otherfastAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        initRecyclerView();
        listDoctor(getDoctor());

    }

    private void initRecyclerView() {
        Context context;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }



    private void listDoctor(List<DoctorModel> doctorList) {
        otheritemAdapter = new ItemAdapter<>();
        otherfastAdapter = FastAdapter.with(otheritemAdapter);
        recyclerView.setAdapter(otherfastAdapter);
        List<DoctorItemAdapter> dataSource = new ArrayList<>();
        for (DoctorModel model : doctorList) {
            dataSource.add(new DoctorItemAdapter(model));
        }
        otheritemAdapter.add(dataSource);
        otherfastAdapter.withOnClickListener((v, adapter, item, position) -> {
            String name = item.getDoctorModel().getName();

            return false;
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.profile))));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    private Bitmap getMarkerBitmapFromView(@DrawableRes int resId) {
        View customMarkerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker, null);
        CircleImageView markerImageView = (CircleImageView) customMarkerView.findViewById(R.id.profile_image);
        markerImageView.setImageResource(resId);
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }

    public static List<DoctorModel> getDoctor(){
        List<DoctorModel> alldoctor = new ArrayList<>();
        alldoctor.add(new DoctorModel(R.drawable.profile, "Dr. Emmanuel Adenuga", "Cardiac Surgeon", "At Apple Hospital, Water street, wallington, New York", "22 yrs", "$30", "4.0"));
        alldoctor.add(new DoctorModel(R.drawable.profile, "Dr. Emmanuel Adenuga", "Cardiac Surgeon", "At Apple Hospital, Water street, wallington, New York", "22 yrs", "$30", "4.0"));
        alldoctor.add(new DoctorModel(R.drawable.profile, "Dr. Emmanuel Adenuga", "Cardiac Surgeon", "At Apple Hospital, Water street, wallington, New York", "22 yrs", "$30", "4.0"));
        alldoctor.add(new DoctorModel(R.drawable.profile, "Dr. Emmanuel Adenuga", "Cardiac Surgeon", "At Apple Hospital, Water street, wallington, New York", "22 yrs", "$30", "4.0"));
        alldoctor.add(new DoctorModel(R.drawable.profile, "Dr. Emmanuel Adenuga", "Cardiac Surgeon", "At Apple Hospital, Water street, wallington, New York", "22 yrs", "$30", "4.0"));

        return alldoctor;
    }

}
