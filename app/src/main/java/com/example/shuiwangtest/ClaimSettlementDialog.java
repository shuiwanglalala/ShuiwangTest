package com.example.shuiwangtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class ClaimSettlementDialog extends Dialog {

    public ClaimSettlementDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_claim_settlement);
//        Window window = getWindow();
//        window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
//        WindowManager.LayoutParams params = window.getAttributes();
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        window.setAttributes(params);
        initView();
    }

    private void initView() {
    }

}
