package com.dcbd.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 基类Fragment
 */
public abstract class BaseFragment extends Fragment {

    protected View mfragmentview;
    protected LayoutInflater mfragmentinflater;
    protected Bundle savedInstanceState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        this.mfragmentinflater = inflater;
        setConvertView();
        return mfragmentview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        init();
    }

    private void init() {
        findViewById();
        setListener();
        initData();
    }

    protected abstract void setConvertView();

    protected abstract void findViewById();

    protected abstract void setListener();

    protected abstract void initData();


}
