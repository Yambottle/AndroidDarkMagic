package com.example.yam.scanbloxlogindemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.yam.scanbloxlogindemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomCheckboxDialog extends Dialog {

    private Context context;
    private RecyclerView checkList;
    private CheckDialogAdapter checkDialogAdapter;
    private List<String> userList;
    private HashMap<Integer, Boolean> isCheckedMap;
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

    public CustomCheckboxDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
        this.context = context;
        isCheckedMap = new HashMap<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_checkfilter);
        checkList = findViewById(R.id.dialog_checkbox_list);
        okBtn = findViewById(R.id.checkdialog_ok_btn);
        cancelBtn = findViewById(R.id.checkdialog_cancel_btn);

        initData();
        checkList.setLayoutManager(new LinearLayoutManager(context));
        checkList.setAdapter(checkDialogAdapter = new CheckDialogAdapter());
        checkDialogAdapter.notifyDataSetChanged();

        initEvent();
    }

    private void initData() {
        //userList
        userList = new ArrayList<>();
        for(int i=0;i<10;i++){
            userList.add("User"+i);
        }
    }

    public class CheckDialogAdapter extends RecyclerView.Adapter<CheckDialogAdapter.CheckDialogHolder>{

        @NonNull
        @Override
        public CheckDialogHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            CheckDialogHolder checkDialogHolder = new CheckDialogHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_checkbox_dialog, viewGroup,
                    false));
            return checkDialogHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CheckDialogHolder checkDialogHolder, final int position) {
            checkDialogHolder.checkBox.setText(userList.get(position));
            checkDialogHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        isCheckedMap.put(position, true);
                    } else {
                        isCheckedMap.remove(position);
                    }
                }
            });
            if (isCheckedMap != null && isCheckedMap.containsKey(position)) {
                checkDialogHolder.checkBox.setChecked(true);
            } else {
                checkDialogHolder.checkBox.setChecked(false);
            }
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }

        private class CheckDialogHolder extends RecyclerView.ViewHolder {
            CheckBox checkBox;

            public CheckDialogHolder(@NonNull View itemView) {
                super(itemView);
                checkBox = itemView.findViewById(R.id.dialog_checkbox);
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

    public HashMap<Integer, Boolean> getIsCheckedMap() {
        return isCheckedMap;
    }
}
