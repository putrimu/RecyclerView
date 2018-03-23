package mu.android.belajar.recycler_view;

/**
 * Created by MUL-09 on 22/03/2018.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.java.util.jar.pack.Attribute;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        private TextView textView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MoviesAdapter(List<Movie> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());  //untuk panggil dari list title
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
       /* holder.onMovie.setOnClickListener((view) {
        Toast.makeText(context, "Tittle : " +movie.getTitle(), Toast.LENGTH_SHORT);
        toast.show();
    });
*/

    }


    public void toast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,(view) findViewById(R.id.onMovie));

        TextView toastText = layout.findViewById(R.id.toast_text);
        toastText.setText("Tittle: "+movie.getTitle);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast show();

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}