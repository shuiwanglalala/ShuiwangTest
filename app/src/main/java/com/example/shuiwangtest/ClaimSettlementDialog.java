package com.example.shuiwangtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.example.shuiwangtest.util.LogUtils;

public class ClaimSettlementDialog extends Dialog {

    private static final String TAG = "ClaimSettlementDialog";

    private TextView tv2;
    private Context context;

    public ClaimSettlementDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
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
        setCanceledOnTouchOutside(false);
    }

    private void initView() {
        findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        tv2 = findViewById(R.id.tv2);

        SpannableString spanableInfo = new SpannableString("是常用的控件,经常要显示不同文字的大小");
        spanableInfo.setSpan(new MyClickText(context, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d(TAG, "onClick:1 ");
            }
        }), 1, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanableInfo.setSpan(new MyClickText(context, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d(TAG, "onClick:2 ");
            }
        }), 7, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv2.setText(spanableInfo);
        tv2.setMovementMethod(LinkMovementMethod.getInstance());
        tv2.setHighlightColor(context.getResources().getColor(R.color.transparent));
    }

    class MyClickText extends ClickableSpan{
        private Context context;
        private View.OnClickListener onClickListener;

        public MyClickText(Context context, View.OnClickListener onClickListener) {
            this.context = context;
            this.onClickListener = onClickListener;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            //设置文本的颜色
            ds.setColor(context.getResources().getColor(R.color.orange4));
            //超链接形式的下划线，false 表示不显示下划线，true表示显示下划线
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget) {
            onClickListener.onClick(widget);
        }
    }

}
