package com.chong.flowlayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chong.flowlayout.R;
import com.chong.flowlayout.adapter.TagAdapter;
import com.chong.flowlayout.view.FlowLayout;

import java.util.Set;

public class EventTestFragment extends Fragment {
    private String[] mVals = new String[]{"Hello", "Android", "Weclome Hi ", "Button", "TextView",
            "Hello", "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
            "Android", "Weclome Hello", "Button Text", "TextView"};

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
        mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }

            @Override
            public boolean setSelected(int position, String s) {
                return s.equals("Android");
            }
        });

        mFlowLayout.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(getActivity(), mVals[position], Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        mFlowLayout.setOnSelectListener(new FlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                getActivity().setTitle("choose:" + selectPosSet.toString());
            }
        });
    }
}