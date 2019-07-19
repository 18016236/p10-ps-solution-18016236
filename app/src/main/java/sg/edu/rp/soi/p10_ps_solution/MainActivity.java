package sg.edu.rp.soi.p10_ps_solution;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMovies;
    ArrayList<Movies>MoviesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMovies=findViewById(R.id.ListViewMovies);
        Date date1 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        try{
            date1=sdf.parse("15/11/2014");
        }catch (parseException e){
            e.printStackTrace();
        }
        Date date2 = null;
        try{
            date2 = sdf.parse("15/5/2015");
        }catch (ParseException e){
            e.printStackTrace();
        }
        movieList.add(new Movies("The Avengers",2012,"pg13","Action | Sci-Fi",date1,"Golden Village - Bishan","Nick Fury of S.H.I.E.L.D .  assembles a team of superheroes to save the planet from Loki and his army",4));
        movieList.add(new Movies("Planes", 2013, "pg", "Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.", 2));


        CustomAdapter adapter = new CustomAdapter(this,
                R.layout.row, movieList);

        lvExamTips.setAdapter(adapter);

        lvExamTips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Movies movie = movieList.get(position);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
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
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    }
}
