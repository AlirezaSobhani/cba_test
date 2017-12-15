package alirezasobhani.example.com.cba.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import alirezasobhani.example.com.cba.R;
import alirezasobhani.example.com.cba.model.Atm;

public class AtmMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String ATM_KEY = "atm";
    private Atm atm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            atm = (Atm) getIntent().getExtras().getSerializable(ATM_KEY);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if(atm == null) {
            return;
        }
        LatLng latLng = new LatLng(atm.getLocation().getLat(), atm.getLocation().getLng());
        googleMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(atm.getName())
                .snippet(atm.getAddress())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_atm_commbank)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }
}
