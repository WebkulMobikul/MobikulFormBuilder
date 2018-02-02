package com.example.manishchoudhary.formbuilder.CustomForm;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * Created by manish.choudhary on 9/11/17.
 */

public class MySpinner extends android.support.v7.widget.AppCompatSpinner {
    public MySpinner(Context context) {
        super(context);
    }

    public MySpinner(Context context, int mode) {
        super(context, mode);
        setLayoutParamsSpinner();
    }

    public MySpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutParamsSpinner();

    }

    public MySpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutParamsSpinner();
    }

    public MySpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
        setLayoutParamsSpinner();
    }

    private void setLayoutParamsSpinner() {
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params1.setMargins(10, 10, 10, 10);
        this.setLayoutParams(params1);
        this.setPadding(20, 20, 20, 20);
        this.setLayoutParams(params1);
    }

}
