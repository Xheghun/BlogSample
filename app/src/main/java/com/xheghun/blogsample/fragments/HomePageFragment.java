package com.xheghun.blogsample.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xheghun.blogsample.R;
import com.xheghun.blogsample._interface.NavigationHost;
import com.xheghun.blogsample.adapter.PostRecyclerAdapter;
import com.xheghun.blogsample.model.Post;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements PostRecyclerAdapter.ListItemClickListener {


    @BindView(R.id.post_list_rc)
    RecyclerView recyclerView;
    private List<Post> postList;
    private DividerItemDecoration itemDecoration;

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this,view);

        postList = new ArrayList<>();

        Thread thread = new Thread() {
            @Override
            public void run() {
                setUpPosts();
            }
        };

        thread.start();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new PostRecyclerAdapter(getContext(), postList,this));
      //  recyclerView.addItemDecoration(itemDecoration);
        return view;
    }

    private void setUpPosts() {

        for (int i = 0; i < 25; i++) {
            Post post = new Post();
            post.setAuthorPicture(R.drawable.image_3);
            post.setAuthorName("John Doe");
            post.setReadDuration("5 min read");
            post.setTitle("HTTP Injection with Nmap(Harry Potter Edition)");
            post.setCoverImage(R.drawable.image_2);
            post.setTag("HTTP");

            postList.add(post);
        }


        itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.horizontal_line));


    }

    @Override
    public void onItemClick(View view,int position) {
        ((NavigationHost)getActivity()).navigateTo(new PostDetailsFragment(),true);
    }
}
