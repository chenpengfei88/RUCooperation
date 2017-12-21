package me.free.rucooperation;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lenovo on 2017/8/17.
 */

public class Test {


    public void show() {
        Activity topActivity = RUCooperation.getDefault().getStackTopActivity();

        RUCLayout rucLayout = new RUCLayout(topActivity, getViewOfActivity(topActivity));

        RUCDialog rucDialog = new RUCDialog();
        rucDialog.show(topActivity, rucLayout);

//        RetrievalAllView retrievalAllView = new RetrievalAllViewTextSize();
//        retrievalAllView.retrieval(rucLayout);
//
//        List<RUCTip> list = retrievalAllView.getTipList();
//
//        for (int i = 0; i < list.size(); i++) {
//          //  System.out.println("=====list=====" + list.get(i).getLeft() + "==" + list.get(i).getTop() + "==" + list.get(i).getTip());
//        }
//
//        rucLayout.addTip(list);
    }

    private ViewGroup getViewOfActivity(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        ViewGroup contentParent = (ViewGroup) decorView.findViewById(android.R.id.content);
        ViewGroup contentViewGroup = (ViewGroup) contentParent.getChildAt(0);

        ViewGroup viewParent = (ViewGroup) contentViewGroup.getParent();
        if (viewParent != null) {
            viewParent.removeView(contentViewGroup);
        }
        return contentViewGroup;
    }
}
