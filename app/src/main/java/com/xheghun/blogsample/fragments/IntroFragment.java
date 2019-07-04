package com.xheghun.blogsample.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.xheghun.blogsample.R;
import com.xheghun.blogsample._interface.NavigationHost;
import com.xheghun.blogsample.adapter.SliderAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroFragment extends Fragment {

    @BindView(R.id.imageSlider)
    SliderView sliderView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_intro,container,false);
        ButterKnife.bind(this,view);

        sliderView.setSliderAdapter(new SliderAdapter(getContext()));
        sliderView.startAutoCycle();
        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.setScrollTimeInSec(4);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);

        return view;
    }

    @OnClick(R.id.login_btn)
    void login() {
        ((NavigationHost)getActivity()).navigateTo(new LoginFragment(),true);
    }

    @OnClick(R.id.sign_up_btn)
    void toSignUp() {
        ((NavigationHost)getActivity()).navigateTo(new SignUpFragment(),true);
    }
}
