package knu.mobileapp.sanpo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicServices extends IntentService {

    static MediaPlayer player;//player 를 공유하기 위해서 service는 다르지만


    public MusicServices(){
        super("MyMusicServices");
    }
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {//OS가 태어나게 해주려고 쓰는 메서드 이후 onCreate 실행
//        return null;
//    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String cmd =intent.getStringExtra("command");
        if(player!=null){

        }
        else {
            player = MediaPlayer.create(this, R.raw.deamn_save_me); //다른데서도 쓰려고 클래스 멤버 변수로 ㄱㄱ
            player.setLooping(true);
            player.start();

        }




        }
    }

    // @Override
//    public void onCreate() {//변수생성용
//        player= MediaPlayer.create(this,R.raw.soul); //다른데서도 쓰려고 클래스 멤버 변수로 ㄱㄱ
//        player.setLooping(false);
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {//음악 스타트
//        player.start();
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onDestroy() {//서비스 끝날 때 음악종료
//        player.stop();
//    }
