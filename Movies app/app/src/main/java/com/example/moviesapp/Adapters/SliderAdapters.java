
package com.example.moviesapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviesapp.Domain.Sliderltems;
import com.example.moviesapp.R;

import java.util.List;

public class SliderAdapters extends RecyclerView.Adapter<SliderAdapters.SliderViewHolder> {
    private List<Sliderltems> sliderltems;
    private ViewPager2 viewPager2;
    private Context context;

    public SliderAdapters(List<Sliderltems> sliderltems, ViewPager2 viewPager2) {
        this.sliderltems = sliderltems;
        this.viewPager2 = viewPager2;
    }


    @NonNull
    @Override
    public SliderAdapters.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slide_item_container,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapters.SliderViewHolder holder, int position) {
       holder.setImageView(sliderltems.get(position));
       if (position == sliderltems.size() - 2) {
           viewPager2.post(runnable);
       }

    }

    @Override
    public int getItemCount() {
        return sliderltems.size();
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageSlide);
        }
        void setImageView(Sliderltems sliderltems) {
            RequestOptions requestOptions=new RequestOptions();
            requestOptions=requestOptions.transforms(new CenterCrop(),new RoundedCorners(60));

            Glide.with(context)
                    .load(sliderltems.getImage())
                    .apply(requestOptions)
                    .into(imageView);



        }
    }
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            sliderltems.addAll(sliderltems);
            notifyDataSetChanged();
        }
    };
}
