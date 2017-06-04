package com.github.rafaelcrz.themovie_android_wrapper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.rafaelcrz.themovie_android_wrapper.R;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.api.ImageSize;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.Movie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<Movie> movieList;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public ListMovieAdapter(Context c, List<Movie> movieList) {
        this.mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.movieList = movieList;
        this.context = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_movie, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {

        Movie movie = movieList.get(position);

        String imageUrlResize = ImageSize.setImageSize(movie.getPoster_path(), ImageSize.Poster.W154);
        Glide.with(context).load(imageUrlResize).into(myViewHolder.imgImage);

        myViewHolder.tvTitle.setText(movie.getTitle());
        try {
            myViewHolder.tvYear.setText(dateToString(stringToDate(movie.getRelease_date())));
        } catch (ParseException e) {
            myViewHolder.tvYear.setText(movie.getRelease_date());
            e.printStackTrace();
        }
        myViewHolder.tvVotes.setText(String.valueOf(movie.getVote_average()));
        myViewHolder.tvOverView.setText(movie.getOverview());


    }

    //Format date to String
    private String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }

    //Format String to Date
    private Date stringToDate(String dateString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);
        return date;
    }

    @Override
    public int getItemCount() {
        try {
            return this.movieList.size();
        } catch (Exception e) {
            return 0;
        }
    }


    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addItem(Movie movie, int position) {
        movieList.add(movie);
        notifyItemInserted(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTitle;
        public TextView tvYear;
        public TextView tvVotes;
        public TextView tvOverView;
        public ImageView imgImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvItemTitle);
            tvYear = (TextView) itemView.findViewById(R.id.tvItemYear);
            tvVotes = (TextView) itemView.findViewById(R.id.tvItemVotes);
            tvOverView = (TextView) itemView.findViewById(R.id.tvItemOverVIew);
            imgImage = (ImageView) itemView.findViewById(R.id.imgItemPoster);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (mRecyclerViewOnClickListenerHack != null) {
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }
        }
    }


}
