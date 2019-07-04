package com.xheghun.blogsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.xheghun.blogsample.R;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {
    Context mContext;

    public SliderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_slider_item,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        int[] imgs = {R.drawable.image_1,R.drawable.image_2,R.drawable.image_3};
        Random random = new Random();
        int img = random.nextInt(imgs.length);
        Glide.with(mContext).load(imgs[img]).override(viewHolder.imageView.getWidth(),viewHolder.imageView.getHeight())
                .into(viewHolder.imageView);
        Glide.with(mContext).load(R.drawable.image_2)
                .override(viewHolder.circleImageView.getWidth(),viewHolder.circleImageView.getHeight())
                .into(viewHolder.circleImageView);
    }

    @Override
    public int getCount() {
        return 3;
    }

    class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;
        CircleImageView circleImageView;
        public SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.slider_img);
            circleImageView = itemView.findViewById(R.id.circular_img);
        }
    }
}
