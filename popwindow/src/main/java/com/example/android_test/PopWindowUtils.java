package com.example.android_test;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;

/**
 * xiaxl
 */
public class PopWindowUtils {

    public static class PopWindowItem {
        // 条目的内容
        public String name;
        // 条目的点击事件
        public OnClickListener listener;
    }

    /**
     * 显示pop
     *
     * @param view
     * @param mItemList
     */
    public static void showPopWindow(final View view,
                                     List<PopWindowItem> mItemList) {

        if (view == null || mItemList == null || mItemList.size() == 0) {
            return;
        }
        if (view == null) {
            return;
        }

        // --------------------UI初始化----------------------
        View popupLayout = View.inflate(view.getContext(),
                R.layout.pop_window_main, null);
        final PopupWindow mCommentPopWindow = new PopupWindow(popupLayout,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mCommentPopWindow.setBackgroundDrawable(view.getContext()
                .getResources().getDrawable(android.R.color.transparent));
        // contentView
        View contentView = mCommentPopWindow.getContentView();


        // ------------UI绑定数据-------------

        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.pop_root_tv);

        for (int i = 0; i < mItemList.size(); i++) {
            // ###### 数据
            PopWindowItem itemData = mItemList.get(i);
            // ######加载View
            View itemView = View.inflate(view.getContext(),
                    R.layout.pop_window_item, null);
            TextView tv = (TextView) itemView.findViewById(R.id.pop_item_tv);
            View dv = itemView.findViewById(R.id.pop_item_divider);
            ll.addView(itemView);
            // ##### 绑定数据
            // listener
            itemView.setOnClickListener(itemData.listener);
            // name
            tv.setText(itemData.name);
            // 分割线
            if (mItemList.size() == (i + 1)) {
                dv.setVisibility(View.GONE);
            } else {
                dv.setVisibility(View.VISIBLE);
            }
        }

        /**
         * ----------更改显示位置---------------
         */
        //
        mCommentPopWindow.setOutsideTouchable(true);
        // 显示
        mCommentPopWindow.showAsDropDown(view, 0, 0);

    }
}
