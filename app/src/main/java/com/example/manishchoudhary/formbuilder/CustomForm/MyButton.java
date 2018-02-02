package com.example.manishchoudhary.formbuilder.CustomForm;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by manish.choudhary on 2/11/17.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText("Register", type);
    }

    @Override
    public void setGravity(int gravity) {
        super.setGravity(gravity);
    }
}
