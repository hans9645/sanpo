package knu.mobileapp.sanpo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;


import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
//    private FragmentManager fragmentManager;
//    private MapFragment mapFragment;


    Button btn_dialog;
    TextView tv_result;
    TextView side_name;
    TextView what;
    TextView condition_today;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView=(View)findViewById(R.id.drawer);


        Button btn_open=(Button)findViewById(R.id.btn_open);//open버튼 눌려졌을 때 메뉴 레이아웃 열리도록함.
        btn_open.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_close=(Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });


        btn_dialog=(Button)findViewById(R.id.btn_dialog);
        tv_result=(TextView)findViewById(R.id.custom_name);
        side_name=(TextView)findViewById(R.id.side_name);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad= new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("설정");
                ad.setMessage("반려동물의 이름을 무엇으로 설정하겠습니까?");


                final EditText et= new EditText(MainActivity.this);
                ad.setView(et);

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result=et.getText().toString();
                        tv_result.setText(result);
                        side_name.setText(result);
                        dialog.dismiss();
                    }
                });

                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                ad.show();//다이얼로그가 정상적으로 뜨게 하려고 하는 거

            }
        });

        condition_today=(TextView) findViewById(R.id.condition_today);
        what=(TextView) findViewById(R.id.what);

        check();//반려동물 기분상태 랜덤으로 바꿈

//
//        fragmentManager=getFragmentManager();
//        mapFragment=(MapFragment)fragmentManager.findFragmentById(R.id.googleMap);
//        mapFragment.getMapAsync(this);

    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };


    public void check() {
        int rand = (int)(Math.random() * 4);
        switch (rand) {
            case 0:
                what.setText("좋음");
                condition_today.setText("좋음");
                 break;
            case 1:
                what.setText("조금 좋음");
                condition_today.setText("조금 좋음");
                break;
            case 2:
                what.setText("별로");
                condition_today.setText("별로");
                break;
            case 3:
                what.setText("나쁨");
                condition_today.setText("나쁨");
                break;
        }

}

    public void onClick(View view) {
        Intent intent=new Intent(this,MapActivity.class);
        startActivity(intent);
    }



//    @Override
//    public void onMapReady(GoogleMap googleMap) {//마커꼽는거
//        LatLng location = new LatLng(35.88848, 128.61007);//공대 12호관
//        MarkerOptions markerOptions=new MarkerOptions();
//        markerOptions.title("공대 12호관");
//        markerOptions.snippet("모바일앱프로그래밍 수업 장소");
//        markerOptions.position(location);
//        googleMap.addMarker(markerOptions);
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,15));
//
 // }
}