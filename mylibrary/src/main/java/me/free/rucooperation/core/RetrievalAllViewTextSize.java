package me.free.rucooperation.core;

import android.view.View;
import android.widget.TextView;

import me.free.rucooperation.util.Utils;

/**
 * Created by cpf on 2017/8/17.
 */

public class RetrievalAllViewTextSize extends RetrievalAllView {

    @Override
    public String getTipText(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            return Utils.px2sp(view.getContext(), (int) textView.getTextSize()) + "";
        }
        return null;
    }


}
