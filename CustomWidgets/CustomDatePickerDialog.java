package com.example.yam.scanbloxlogindemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;

import com.example.yam.scanbloxlogindemo.R;

import java.lang.reflect.Field;

public class CustomDatePickerDialog extends Dialog {

    private DatePicker datePicker;
    private Button okBtn, cancelBtn;

    private onOkClickListener okClickListener;
    private onCancelClickListener cancelClickListener;

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }


    public interface onOkClickListener{
        void onOkClick();
    }

    public interface onCancelClickListener{
        void onCancelClick();
    }

    public void setOkClickListener(onOkClickListener okClickListener){
        this.okClickListener = okClickListener;
    }

    public void setCancelClickListener(onCancelClickListener cancelClickListener){
        this.cancelClickListener = cancelClickListener;
    }

    public CustomDatePickerDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_datepicker);

        datePicker = findViewById(R.id.datePicker);
        okBtn = findViewById(R.id.datedialog_ok_btn);
        cancelBtn = findViewById(R.id.datedialog_cancel_btn);

        setDatePickerDividerColor(datePicker);
        initEvent();
    }

    private void setDatePickerDividerColor(DatePicker datePicker) {
        // Divider changing:

        // 获取 mSpinners
        LinearLayout llFirst = (LinearLayout) datePicker.getChildAt(0);

        // 获取 NumberPicker
        LinearLayout mSpinners = (LinearLayout) llFirst.getChildAt(0);
        for (int i = 0; i < mSpinners.getChildCount(); i++) {
            NumberPicker picker = (NumberPicker) mSpinners.getChildAt(i);

            Field[] pickerFields = NumberPicker.class.getDeclaredFields();
            for (Field pf : pickerFields) {
                if (pf.getName().equals("mSelectionDivider")) {
                    pf.setAccessible(true);
                    try {
                        pf.set(picker, new ColorDrawable(Color.parseColor("#99FFFFFF")));//设置分割线颜色
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private void initEvent() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okClickListener.onOkClick();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelClickListener.onCancelClick();
            }
        });
    }
}
