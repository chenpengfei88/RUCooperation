package me.free.rucooperation;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.free.rucooperation.core.RetrievalAllView;
import me.free.rucooperation.core.RetrievalAllViewFactory;

/**
 * Created by cpf on 2017/8/17.
 */

public class RUCLayout extends RelativeLayout implements View.OnClickListener {


    /**
     *  context
     */
    private Context mContext;

    /**
     * Activity Content View
     */
    private View mActivityContentView;

    /**
     *  tip textview list
     * @param context
     * @param activityContentView
     */
    private List<TextView> mTextViewList;



    public RUCLayout(Context context, View activityContentView) {
        super(context);

        init(activityContentView, context);
    }

    public RUCLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RUCLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RUCLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     *  init
     * @param activityContentView
     * @param context
     */
    private void init(View activityContentView, Context context) {
        mContext = context;
        mActivityContentView = activityContentView;
        mTextViewList = new ArrayList<>();
        setBackgroundColor(Color.WHITE);

        addFunctionView();
        addActivityContentView();
    }

    /**
     *  parse function layout add to this
     */
    private void addFunctionView() {
        View functionView = LayoutInflater.from(mContext).inflate(R.layout.activity_function, this);

        /**
         *  text size and color and view spacing add clicklistener
         */
        functionView.findViewById(R.id.tv_text_size).setOnClickListener(this);
        functionView.findViewById(R.id.tv_text_color).setOnClickListener(this);
        functionView.findViewById(R.id.tv_view_spacing).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        removeAllTipView();

        RetrievalAllView retrievalAllView = RetrievalAllViewFactory.create(view.getId());
        retrieval(retrievalAllView);
    }

    /**
     *  retrieval allview add to layout
     * @param retrievalAllView
     */
    private void retrieval(RetrievalAllView retrievalAllView) {
        retrievalAllView.retrieval(mActivityContentView);

        addTipToLayout(retrievalAllView.getTipList());
    }

    /**
     *  add retrieval tip to layout
     * @param tipList
     */
    private void addTipToLayout(List<RUCTip> tipList) {
        for (int i = 0, count = tipList.size(); i < count; i++) {
            TextView tipTextView = getTipViewOfRUCTip(tipList.get(i));
            addView(tipTextView);

            mTextViewList.add(tipTextView);
        }
    }

    /**
     *  remove all tip view
     */
    private void removeAllTipView() {
        for (int i = 0, count = mTextViewList.size(); i < count; i++) {
              View childView = mTextViewList.get(i);
            if (childView != null) removeView(childView);
        }
        mTextViewList.clear();
    }

    /**
     *  get tip view of RUCTip
     * @param rucTip
     * @return
     */
    private TextView getTipViewOfRUCTip(RUCTip rucTip) {
        TextView textView = new TextView(mContext);
        textView.setText(rucTip.getTip());
        textView.setTag(rucTip);
        textView.setTextColor(Color.WHITE);
        TextPaint paint = textView.getPaint();
        paint.setFakeBoldText(true);
        textView.setBackgroundResource(R.drawable.bg_tip_style);
        textView.setTextSize(10);
        textView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return textView;
    }

    /**
     *  add  activityConentView to this
     */
    private void addActivityContentView() {
        LayoutParams contentLp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        contentLp.addRule(RelativeLayout.BELOW, R.id.function);
        mActivityContentView.setLayoutParams(contentLp);

        addView(mActivityContentView);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        for (int i = 0, count = getChildCount(); i < count; i++) {
            View view = getChildAt(i);
            Object tag = view.getTag();

            if (tag != null && tag instanceof RUCTip) {
                RUCTip rucTip = (RUCTip) tag;

                final int left = rucTip.getLeft();
                final int top = rucTip.getTop();
                final int right = left + view.getMeasuredWidth();
                final int bottom = top + view.getMeasuredHeight();

                view.layout(left, top, right, bottom);
            }
        }
    }

    /**
     *  get activity content view
     * @return
     */
    public View getActivityContentView() {
        return mActivityContentView;
    }





}
