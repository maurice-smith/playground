package com.kingmo.glideex.utils;

import android.content.Context;
import android.util.TypedValue;

public class Utils {

    public static int convertDpToPixels(int dp, Context context) {
        return Float.valueOf(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                Integer.valueOf(dp).floatValue(),
                context.getResources().getDisplayMetrics())).intValue();
    }


    public static int convertPixelsToDp(int pixels, Context context) {
        return (int) (pixels / context.getResources().getDisplayMetrics().density + 0.5f);
    }

}
