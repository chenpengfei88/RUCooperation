package me.free.rucooperation.core;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.free.rucooperation.RUCTip;
import me.free.rucooperation.util.Utils;

/**
 * Created by cpf on 2017/8/17.
 */

public abstract class RetrievalAllView {


    /**
     *  retrieval view tip list
     */
    private List<RUCTip> mTipList = new ArrayList<>();

    /**
     *  start retrieval
     * @param activityContentView
     */
    public void retrieval(View activityContentView) {
        if (activityContentView instanceof ViewGroup) {
            ViewGroup activityContentViewGroup = (ViewGroup) activityContentView;

            for (int i = 0, count = activityContentViewGroup.getChildCount(); i < count; i++) {
                View childView = activityContentViewGroup.getChildAt(i);
                if (childView instanceof ViewGroup) {
                    retrieval(childView);
                    if (isRetrievalViewGroup()) mTipList.add(getRUCTipOfView(childView));
                } else {
                    mTipList.add(getRUCTipOfView(childView));
                }
            }
        }
    }

    /**
     *  get tip of view
     * @param view
     * @return
     */
    protected RUCTip getRUCTipOfView(View view) {
        RUCTip rucTip = new RUCTip();

        int[] location = Utils.getViewLocation(view);
        rucTip.setLeft(location[0]);
        rucTip.setTop(location[1] - Utils.getStatusBarHeight(view.getContext()));
        rucTip.setTip(getTipText(view));
        return rucTip;
    }

    /**
     *  得到提示的信息
     * @param view
     * @return
     */
    protected abstract String getTipText(View view);

    /**
     *  get tip list
     * @return
     */
    public List<RUCTip> getTipList() {
        return mTipList;
    }

    /**
     *  is  retrieval viewGroup
     */
    protected boolean isRetrievalViewGroup() {
        return false;
    }










}
