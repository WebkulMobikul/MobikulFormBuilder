package com.example.manishchoudhary.formbuilder.Singleton;

import android.content.Context;

import com.example.manishchoudhary.formbuilder.CustomForm.MyEdittext;

/**
 * Created by manish.choudhary on 3/11/17.
 */

public class GetEditext {

    private static MyEdittext edittext;

    public static MyEdittext getInstance(Context mContext) {
        if (edittext == null) {
            edittext = new MyEdittext(mContext);
        }
        return edittext;
    }

}
