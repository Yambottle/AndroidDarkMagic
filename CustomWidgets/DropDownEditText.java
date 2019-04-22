package com.example.yam.scanbloxlogindemo.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.yam.scanbloxlogindemo.R;

public class DropDownEditText extends AppCompatEditText {
    final int DRAWABLE_LEFT = 0;
    final int DRAWABLE_TOP = 1;
    final int DRAWABLE_RIGHT = 2;
    final int DRAWABLE_BOTTOM = 3;
    Context context;

    public DropDownEditText(Context context) {
        super(context);
        this.context = context;
    }

    public DropDownEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public interface OnDropArrowClickListener {
        void onDropArrowClick();
    }
    public interface OnClearCrossClickListener {
        void onClearCrossClick();
    }

    private OnDropArrowClickListener onDropArrowClickListener;

    private OnClearCrossClickListener onClearCrossClickListener;

    public void setOnDropArrowClickListener(OnDropArrowClickListener onDropArrowClickListener) {
        this.onDropArrowClickListener = onDropArrowClickListener;
    }

    public void setOnClearCrossClickListener(OnClearCrossClickListener onClearCrossClickListener) {
        this.onClearCrossClickListener = onClearCrossClickListener;
    }

    public void setDrawableRight(boolean visible){
        if(visible){
            Drawable mDrawableRight = ContextCompat.getDrawable(context, R.drawable.clear_search);
            // 设置Drawable大小和位置
            mDrawableRight.setBounds(0, 0, mDrawableRight.getIntrinsicWidth(), mDrawableRight.getIntrinsicHeight());
            // 将其添加到控件上
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], mDrawableRight, getCompoundDrawables()[3]);
        }else{
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {

            if (getCompoundDrawables()[DRAWABLE_LEFT] != null) {
                Drawable drawableLeft = getCompoundDrawables()[DRAWABLE_LEFT];
                if (event.getX() <= getLeft() + drawableLeft.getIntrinsicWidth()) {
                    setFocusableInTouchMode(false);
                    setFocusable(false);
                    if (onDropArrowClickListener != null) {
                        onDropArrowClickListener.onDropArrowClick();
                    }
                    setDrawableRight(false);
                } else {
                    setFocusableInTouchMode(true);
                    setFocusable(true);
                }
            }
            if (getCompoundDrawables()[DRAWABLE_RIGHT] != null) {
                Drawable drawableRight = getCompoundDrawables()[DRAWABLE_RIGHT];
                if (event.getX() >= (getWidth() - getPaddingRight() - drawableRight.getIntrinsicWidth())) {
                    setFocusableInTouchMode(false);
                    setFocusable(false);
                    if (onClearCrossClickListener != null) {
                        onClearCrossClickListener.onClearCrossClick();
                    }
                } else {
                    setFocusableInTouchMode(true);
                    setFocusable(true);
                }
            }
        }
        return super.onTouchEvent(event);
    }
}