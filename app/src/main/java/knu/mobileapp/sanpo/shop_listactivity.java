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

public class shop_listactivity extends AppCompatActivity {

    ListView list1;
    String[] titles={"개 껌","개껌인형","사료","물통","목줄","예방접종 "};
    Integer [] images={
            R.drawable.gum,
            R.drawable.toy,
            R.drawable.saryo,
            R.drawable.water,
            R.drawable.neck,
            R.drawable.shot
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppings);
        CustomList adapter=new CustomList(shop_listactivity.this);
        list1=(ListView)findViewById(R.id.list12);
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
            View rowView=inflater.inflate(R.layout.shoplist,null, true);
            ImageView imageView=(ImageView)rowView.findViewById(R.id.image3);
            //imageView.setImageResource(images[position]);
            TextView title=(TextView) rowView.findViewById(R.id.product_name);
            TextView rating=(TextView) rowView.findViewById(R.id.price);
            TextView genre=(TextView) rowView.findViewById(R.id.sort);
            TextView year=(TextView) rowView.findViewById(R.id.releaseYear);

            title.setText(String.valueOf(titles[position]));
            imageView.setImageResource(images[position]); // 왜 안되는 건지?

            int rand = (int)(Math.random() *40000);
            int price=2000+rand-(2000+rand)%100;
            rating.setText("9.0"+position);
            if(rand>20000){
                genre.setText("TOY");
            }else genre.setText("FOOD");


            year.setText(2000+price+"won");

            return rowView;
        }
    }
}
