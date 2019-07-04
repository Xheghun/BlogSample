package com.xheghun.blogsample.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
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
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);

        getActivity().getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));

        return view;
    }

    @OnClick(R.id.sign_up_btn)
    void toSignUp() {
        ((NavigationHost)getActivity()).navigateTo(new SignUpFragment(), false);
    }

    @OnClick(R.id.sign_in_btn)
    void toMain() {
        ((NavigationHost)getActivity()).navigateTo(new BaseContainerFragment(),false);
    }

}
