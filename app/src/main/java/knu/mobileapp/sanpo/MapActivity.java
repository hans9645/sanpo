package knu.mobileapp.sanpo;



import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymap);

        MapFragment mapFragment = (MapFragment)this.getFragmentManager()
                .findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

    }





    public void onMapReady(GoogleMap googleMap) {//마커꼽는거
        LatLng location = new LatLng(35.88848, 128.61007);//공대 12호관
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.title("공대 12호관");
        markerOptions.snippet("모바일앱프로그래밍 수업 장소");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,15));

    }
}
