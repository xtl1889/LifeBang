package com.pro.xtl1889.lifebang.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zuoxian on 15/9/7.
 */
public abstract class BaseFragment extends Fragment {

    private View fragmentRootView;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(fragmentRootView == null){
            fragmentRootView = inflater.inflate(getLayoutRes(), container, false);

        }
        ViewGroup parent = (ViewGroup) fragmentRootView.getParent();
        if (parent != null) {
            parent.removeView(fragmentRootView);
        }
        unbinder=ButterKnife.bind(this, fragmentRootView);
        setupView();
        return fragmentRootView;
    }

    protected void setupView(){

    }

    protected abstract int getLayoutRes();

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Fresco.getImagePipeline().clearMemoryCaches();
    }


}
