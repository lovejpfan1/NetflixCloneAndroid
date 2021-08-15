package co.jottan.netflixclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.jottan.netflixclone.model.Movie;

public class MovieActivity extends AppCompatActivity {

    RecyclerView recyclerViewSimilar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        recyclerViewSimilar = findViewById(R.id.recycler_view_similar);

        Toolbar toolbar = findViewById(R.id.toolbar_move);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
            getSupportActionBar().setTitle(null);
        }

        LayerDrawable drawable = (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.shadows);

        if (drawable != null) {
            Drawable movieCover = ContextCompat.getDrawable(this, R.drawable.movie_4);
            drawable.setDrawableByLayerId(R.id.cover_drawable, movieCover);
            ((ImageView) findViewById(R.id.shadow_cover)).setImageDrawable(drawable);

        }

        TextView cast = (TextView) findViewById(R.id.text_view_cast);
        cast.setText(getString(R.string.cast, "Adam West, Michael Keaton, Val Kilmer, George Clooney, Christian Bale e Ben Affleck."));

        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i <= 30; i++) {

            Movie movie = new Movie();
            movie.setCoverUrl(R.layout.movie_item_similar);
            movies.add(movie);

            recyclerViewSimilar.setLayoutManager(new GridLayoutManager(this, 3));
            recyclerViewSimilar.setAdapter(new SimilarAdapter(movies));
        }


    }

    public static class SimilarHolder extends RecyclerView.ViewHolder {

        public SimilarHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class SimilarAdapter extends RecyclerView.Adapter<SimilarHolder> {

        List<Movie> movieList;

        public SimilarAdapter(List<Movie> movies) {
            this.movieList = movies;
        }

        @NonNull
        @Override
        public SimilarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SimilarHolder(getLayoutInflater().inflate(R.layout.movie_item_similar, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull  MovieActivity.SimilarHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return movieList.size();
        }
    }
}