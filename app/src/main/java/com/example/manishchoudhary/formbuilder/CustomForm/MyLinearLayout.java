package com.example.manishchoudhary.formbuilder.CustomForm;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.manishchoudhary.formbuilder.Helper.Utiles;

/**
 * Created by manish.choudhary on 2/11/17.
 */

public class MyLinearLayout extends LinearLayout {
    private int padding;

    public MyLinearLayout(Context context) {
        super(context);
        setDefaultLayoutParmas();
    }

    public void setDefaultLayoutPadding(int padding) {
        this.setPadding(padding, padding, padding, padding);
    }

    private void setDefaultLayoutParmas() {
        LayoutParams params = new LayoutParams(Utiles.getScreenWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setDefaultLayoutParmas();
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDefaultLayoutParmas();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setDefaultLayoutParmas();
    }
}
