package knu.mobileapp.sanpo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class friends_listactivity extends AppCompatActivity {

    ListView list1;
    String[] titles={"댕댕쓰","복희","철수","뽀삐","누렁이","아름이","렉스","찰스","춘자","강인","달마"};
    int[] images={
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9,
            R.drawable.a10,
            R.drawable.a11
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);
        CustomList adapter=new CustomList(friends_listactivity.this);
        list1=(ListView)findViewById(R.id.list);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getBaseContext(),titles[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }
    class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context){
            super(context,R.layout.list, titles);
            this.context=context;

        }
        @Override
        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.list,null, true);
            ImageView imageView=(ImageView) rowView.findViewById(R.id.image2);
            TextView title=(TextView) rowView.findViewById(R.id.title);
            TextView rating=(TextView) rowView.findViewById(R.id.rating);
            TextView genre=(TextView) rowView.findViewById(R.id.genre);
            TextView year=(TextView) rowView.findViewById(R.id.releaseYear);

            title.setText(String.valueOf(titles[position]));
            //imageView.setImageResource(images[position]);
            int rand = (int)(Math.random() * 4);

            rating.setText("8."+rand*position);
            genre.setText("we are friend");
            year.setText("since"+2000+rand+"");

            return rowView;
        }
    }
}
