package knu.mobileapp.sanpo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    MenuItem item1,item2,item3;

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
                ad.setIcon(R.mipmap.ic_nuri_foreground);
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



    }

    public void comebackhome(View view){//home버튼 실행 코드
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //메뉴를 확장시켜라

        this.getMenuInflater().inflate(R.menu.mymenu,menu);
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.mymenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.apple:
                Toast.makeText(this,"개발자에게 전화하기", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01024749645"));
                startActivity(intent);
                break;
            case R.id.banana:
                Toast.makeText(this,"2015114563", Toast.LENGTH_SHORT).show();
                break;
            case R.id.graph:
                Toast.makeText(this,"김한영", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
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

    public void onClick(View view) {// 노래 재생
        Intent intent=new Intent(this,MapActivity.class);
        startActivity(intent);
        Intent intent2 =new Intent(this,MusicServices.class);
        intent2.putExtra("command",1);
        startService(intent2);
    }


    public void onClick_4friendlist(View view) {//friend list 인텐트로 실행하기
        Intent intent1=new Intent(this, friends_listactivity.class);
        startActivity(intent1);

    }


    public void onButtonNext(View view) { //쇼핑리스트 인텐트로 실행하기
      //  setContentView(new MyCustomView(this));
        Intent intent1=new Intent(this, shop_listactivity.class);
        startActivity(intent1);
    }

    public void callMe(View view){
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:01024749645"));
        startActivity(intent);
    }

    public void gotogithub(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://github.com/hans9645/sanpo"));
        startActivity(intent);
    }

    public void openhistory(View view){
        setContentView(R.layout.history);

    }

    public void openchat(View view){
        setContentView(R.layout.chatting);
    }
}