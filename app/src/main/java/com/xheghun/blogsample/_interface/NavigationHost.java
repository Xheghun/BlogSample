package com.xheghun.blogsample._interface;

import androidx.fragment.app.Fragment;

public interface NavigationHost {
    void navigateTo(Fragment fragment,boolean addToBackStack);
}
