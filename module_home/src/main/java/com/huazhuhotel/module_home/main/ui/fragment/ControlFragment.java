package com.huazhuhotel.module_home.main.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.control.ControlActivity;
import com.huazhuhotel.module_home.main.dialog.AddWifiDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ControlFragment extends Fragment implements View.OnClickListener,AddWifiDialogFragment.OnDialogListener{


    ImageView mLayoutControlAdd;
    private TextView noticeTv;
    LinearLayout mLayoutControlOne;
    private View view;
    private onControlClickListener listener;
    private AddWifiDialogFragment dialogFragment;

    public ControlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=inflater.inflate(R.layout.fragment_control, container, false);
         initView();
         initData();
        return view;
    }

    private void initData() {
        mLayoutControlOne.setOnClickListener(this);
        mLayoutControlAdd.setOnClickListener(this);
    }

    private void initView() {
        mLayoutControlAdd=view.findViewById(R.id.layout_control_add);
        mLayoutControlOne=view.findViewById(R.id.layout_control_one);
        noticeTv=view.findViewById(R.id.layout_control_notice);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.layout_control_add:
                dialogFragment=new AddWifiDialogFragment();
                dialogFragment.setListener(this);
                dialogFragment.show(getChildFragmentManager(),"cc");
                break;
            case R.id.layout_control_one:
                startActivity(new Intent(getActivity(), ControlActivity.class));
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSuccessClick() {
        noticeTv.setVisibility(View.GONE);
        mLayoutControlOne.setVisibility(View.VISIBLE);
    }

    public void setListener(onControlClickListener listener) {
        this.listener = listener;
    }

    public interface onControlClickListener{
        void onClickContriol();
    }
}
