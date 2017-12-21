package me.free.rucooperation.util;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by cpf on 2017/8/18.
 */

public class Utils {

    /**
     *  get color rgb
     * @param color
     * @return
     */
    public static String getColorRGB(int color) {
        StringBuffer colorBuffer = new StringBuffer();

        colorBuffer.append(Integer.toHexString(Color.red(color)));
        colorBuffer.append(Integer.toHexString(Color.green(color)));
        colorBuffer.append(Integer.toHexString(Color.blue(color)));

        return colorBuffer.toString();
    }

    /**
     *  get status bar height
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Class<?> c;
        Object obj;
        Field field;
        int x, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     *  get view location
     * @param view
     * @return
     */
    public static int[] getViewLocation(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return location;
    }

    /**
     *  px2sp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, int pxValue) {
        float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }
}
