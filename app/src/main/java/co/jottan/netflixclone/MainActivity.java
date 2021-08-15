package co.jottan.netflixclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.jottan.netflixclone.model.Category;
import co.jottan.netflixclone.model.Movie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView categoryRecyclerView = findViewById(R.id.recycler_view_main);

        List<Category> categories = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        // filling the array movies and categories
        for (int j = 1; j <= 10; j++) {

            for (int i = 1; i <= 30; i++) {
                Movie movie = new Movie();
                movie.setCoverUrl(R.drawable.movie);
                movies.add(movie);
            }

            Category category = new Category();
            category.setName("Category " + j);
            category.setMovies(movies);
            categories.add(category);

        }

        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        categoryRecyclerView.setAdapter(categoryAdapter);

    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder>{

        List<Category> categories;

        // constructor
        public CategoryAdapter(List<Category> categories) {
            this.categories = categories;
        }

        @NonNull
        @Override
        public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CategoryHolder(getLayoutInflater().inflate(R.layout.category_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
            Category category = categories.get(position);
            TextView categoryTitle = holder.itemView.findViewById(R.id.text_view_category_title);

            categoryTitle.setText(category.getName());

            RecyclerView movieRecycleView = holder.itemView.findViewById(R.id.recycler_view_movie);
            movieRecycleView.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.HORIZONTAL, false));
            movieRecycleView.setAdapter(new MovieAdapter(category.getMovies()));

        }

        @Override
        public int getItemCount() {
            return categories.size();
        }
    }


    public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

        List<Movie> movies;

        // constructor
        public MovieAdapter(List<Movie> movies) {
            this.movies = movies;
        }

        @NonNull
        @Override
        public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MovieHolder(getLayoutInflater().inflate(R.layout.movie_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainActivity.MovieHolder holder, int position) {
            ImageView movieCover = holder.itemView.findViewById(R.id.image_view_cover);
            //movieCover.setImageResource(movies.get(position).getCoverUrl());
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }
    }

}