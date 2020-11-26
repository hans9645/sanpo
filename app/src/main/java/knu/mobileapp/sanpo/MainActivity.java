package knu.mobileapp.sanpo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView profile_round;
    ContextCompat context;
    Context mcontext;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profile_round=findViewById(R.id.profile_img);
        GradientDrawable drawable=(GradientDrawable)context.getDrawable(mcontext,R.drawable.background_round);

        profile_round.setBackground(drawable);
        profile_round.setClipToOutline(true);

    }


}
class RoundImageView extends androidx.appcompat.widget.AppCompatImageView {
//실패 왜 안되는거지??? 하..시간날렸네...

    public static float radius = 20.0f;

    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setRectRadius(Float radius) {
        this.radius = radius;
        invalidate();//화면갱신
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path clipPath = new Path();
        RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}