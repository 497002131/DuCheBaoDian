package com.dcbd.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


/**
 * 所有Activity的父类
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected LayoutInflater minflater;
    protected Bundle msavedInstanceState;
    protected View mactivityview;
    private InputMethodManager inputMethodManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        this.minflater = getLayoutInflater();// 调用Activity的getLayoutInflater()
        this.msavedInstanceState = savedInstanceState;
        setContentView(msavedInstanceState);
        setContentView(mactivityview);
        inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        init();
    }

    public void init() {
        findViews();
        addListener();
        initData();
    }

    public abstract void setContentView(Bundle savedInstanceState);

    public abstract void findViews();

    public abstract void addListener();

    public abstract void initData();


    protected void hideSoftKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null)
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
