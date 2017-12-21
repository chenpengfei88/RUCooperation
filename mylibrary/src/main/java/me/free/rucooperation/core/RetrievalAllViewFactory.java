package me.free.rucooperation.core;

import me.free.rucooperation.R;

/**
 * Created by cpf on 2017/8/18.
 */

public class RetrievalAllViewFactory {

    /**
     *  create RetrievalAllView by viewId
     * @param viewId
     * @return
     */
    public static RetrievalAllView create(int viewId) {
        RetrievalAllView retrievalAllView;
        if (viewId == R.id.tv_text_size) {
            retrievalAllView = new RetrievalAllViewTextSize();
        } else if(viewId == R.id.tv_text_color) {
            retrievalAllView = new RetrievalAllViewTextColor();
        } else {
            retrievalAllView = new RetrievalAllViewSpace();
        }

        return retrievalAllView;
    }
}
