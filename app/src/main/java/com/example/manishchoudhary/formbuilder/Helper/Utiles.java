package com.example.manishchoudhary.formbuilder.Helper;

import android.content.res.Resources;

/**
 * Created by manish.choudhary on 2/11/17.
 */

public class Utiles {
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
