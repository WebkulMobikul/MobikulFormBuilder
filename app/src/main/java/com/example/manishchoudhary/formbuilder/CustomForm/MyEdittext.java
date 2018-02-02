package com.example.manishchoudhary.formbuilder.CustomForm;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.manishchoudhary.formbuilder.R;

/**
 * Created by manish.choudhary on 2/11/17.
 */

public class MyEdittext extends android.support.v7.widget.AppCompatEditText {

    private Context mContext;

    public MyEdittext(Context context) {
        super(context);
        this.mContext = context;
        setBackgroundEditext();
    }

    public MyEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setBackgroundEditext();

    }

    public MyEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        setBackgroundEditext();
    }

    private void setBackgroundEditext() {
        Drawable backgroud = ContextCompat.getDrawable(mContext, R.drawable.background);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(backgroud);
        }
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);
        this.setLayoutParams(params);
        this.setPadding(20,20,20,20);
    }
}
