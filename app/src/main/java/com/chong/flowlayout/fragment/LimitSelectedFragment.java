package com.chong.flowlayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chong.flowlayout.R;
import com.chong.flowlayout.view.TagAdapter;
import com.chong.flowlayout.view.FlowLayout;

public class LimitSelectedFragment extends Fragment {
    private String[] mValues = new String[]{"Hello", "Android", "Welcome Hi ", "Button", "TextView",
            "Hello", "Android", "Welcome", "Button ImageView", "TextView", "Hello World", "Android",
            "Welcome Hello", "Button Text", "TextView", "Hello", "Android", "Welcome Hi ",
            "Button", "TextView", "Hello", "Android", "Welcome", "Button ImageView"};

    private FlowLayout mFlowLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final LayoutInflater mInflater = LayoutInflater.from(getActivity());
        mFlowLayout = (FlowLayout) view.findViewById(R.id.id_flowlayout);
        mFlowLayout.setMaxSelectCount(3);
        mFlowLayout.setAdapter(new TagAdapter<String>(mValues) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
    }
}
