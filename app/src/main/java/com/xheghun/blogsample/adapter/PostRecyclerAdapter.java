package com.xheghun.blogsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.xheghun.blogsample.R;
import com.xheghun.blogsample.model.Post;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.PostViewHolder> {

    private Context mContext;
    private List<Post> postList;
    private ListItemClickListener mOnClickListener;

    public PostRecyclerAdapter(Context mContext, List<Post> postList, ListItemClickListener mOnClickListener) {
        this.mContext = mContext;
        this.postList = postList;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.post_items,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        Glide.with(mContext).load(post.getAuthorPicture())
                .override(holder.author_picture.getWidth(),holder.author_picture.getHeight())
                .into(holder.author_picture);
        holder.author_name.setText(post.getAuthorName());
        holder.read_duration.setText(post.getReadDuration());
        holder.post_title.setText(post.getTitle());
        Glide.with(mContext).load(post.getCoverImage())
                .override(holder.post_cover_img.getWidth(),holder.post_cover_img.getHeight())
                .into(holder.post_cover_img);
        holder.post_tag.setText(post.getTag());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView author_name,read_duration,post_title, post_tag;
        CircleImageView author_picture;
        ImageView post_cover_img;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            author_name = itemView.findViewById(R.id.author_name);
            author_picture = itemView.findViewById(R.id.author_img);
            read_duration = itemView.findViewById(R.id.read_duration);
            post_title = itemView.findViewById(R.id.post_title);
            post_tag = itemView.findViewById(R.id.post_tag);
            post_cover_img =itemView.findViewById(R.id.post_cover_img);
        }
        @Override
        public void onClick(View view) {
            mOnClickListener.onItemClick(view,getAdapterPosition());
        }
    }
    public interface ListItemClickListener {
        void onItemClick(View view, int position);
    }
}
