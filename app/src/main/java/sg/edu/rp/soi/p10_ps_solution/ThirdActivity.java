package sg.edu.rp.soi.p10_ps_solution;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThirdActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    EditText et7;
    EditText et8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        et4 = findViewById(R.id.editText4);
        et5 = findViewById(R.id.editText5);
        et6 = findViewById(R.id.editText6);
        et7 = findViewById(R.id.editText7);
        et8 = findViewById(R.id.editText8);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Date date1 = null;
        try {
            date1 = sdf.parse(et8.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Movies movie = new Movies(et1.getText().toString(), Integer.parseInt(et2.getText().toString()), et4.getText().toString(), et3.getText().toString(), date1, et5.getText().toString(), et6.getText().toString(), Integer.parseInt(et7.getText().toString()));
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("year", movie.getYear());
        intent.putExtra("rated", movie.getRated());
        intent.putExtra("genre", movie.getGenre());
        intent.putExtra("date", movie.getWatched());
        intent.putExtra("theatre", movie.getTheatre());
        intent.putExtra("description", movie.getDescription());
        intent.putExtra("rating", movie.getRating());
        startActivity(intent);

    }
}

