package sg.edu.rp.soi.p10_ps_solution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    ImageView iv1;
    ImageView s1;
    ImageView s2;
    ImageView s3;
    ImageView s4;
    ImageView s5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        iv1 = findViewById(R.id.imageView);
        s1 = findViewById(R.id.imageView7);
        s2 = findViewById(R.id.imageView8);
        s3 = findViewById(R.id.imageView9);
        s4 = findViewById(R.id.imageView10);
        s5 = findViewById(R.id.imageView11);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int year = intent.getIntExtra("year", 0);
        String rated = intent.getStringExtra("rated");
        Date date = (Date)intent.getSerializableExtra("date");
        String genre = intent.getStringExtra("genre");
        String theatre = intent.getStringExtra("theatre");
        String desc = intent.getStringExtra("description");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String dateStr = sdf.format(date);
        int rating = intent.getIntExtra("rating", 0);

        tv1.setText(title);
        tv2.setText(year + "-" + genre + "\n\n" + desc + "\n\nWatch on: " + dateStr + "\nIn Theatre: " + theatre);
        String check = rated;
        if (check.equals("g")) {
            iv1.setImageResource(R.drawable.rating_g);
        }
        else if (check.equals("pg")) {
            iv1.setImageResource(R.drawable.rating_pg);
        }
        else if (check.equals("pg13")) {
            iv1.setImageResource(R.drawable.rating_pg13);
        }
        else if (check.equals("nc16")) {
            iv1.setImageResource(R.drawable.rating_nc16);
        }
        else if (check.equals("m18")) {
            iv1.setImageResource(R.drawable.rating_m18);
        }
        else if (check.equals("r21")) {
            iv1.setImageResource(R.drawable.rating_r21);
        }

        if (rating!=0) {
            s1.setImageResource(android.R.drawable.star_big_on);
            rating--;
        }
        if (rating!=0) {
            s2.setImageResource(android.R.drawable.star_big_on);
            rating--;
        }
        if (rating!=0) {
            s3.setImageResource(android.R.drawable.star_big_on);
            rating--;
        }
        if (rating!=0) {
            s4.setImageResource(android.R.drawable.star_big_on);
            rating--;
        }
        if (rating!=0) {
            s5.setImageResource(android.R.drawable.star_big_on);
            rating--;
        }
    }

}
