package com.example.yam.scanbloxlogindemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yam.scanbloxlogindemo.R;

public class CustomTextDialog extends Dialog {

    private Context context;
    private String message;
    private TextView messageText;
    private Button okBtn, cancelBtn;

    private onOkClickListener okClickListener;
    private onCancelClickListener cancelClickListener;

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

    public CustomTextDialog(@NonNull Context context, String message) {
        super(context);
        this.context = context;
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_text);
        messageText = findViewById(R.id.dialog_message);
        messageText.setText(message);
        okBtn = findViewById(R.id.textdialog_ok_btn);
        cancelBtn = findViewById(R.id.textdialog_cancel_btn);

        initEvent();
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
