package com.xheghun.blogsample.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xheghun.blogsample.R;
import com.xheghun.blogsample._interface.NavigationHost;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @OnClick(R.id.sign_in_btn)
    void toSignIn() {
        ((NavigationHost)getActivity()).navigateTo(new LoginFragment(),false);
    }

}
