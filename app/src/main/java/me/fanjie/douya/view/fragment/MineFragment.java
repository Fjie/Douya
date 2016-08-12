package me.fanjie.douya.view.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.fanjie.douya.R;
import me.fanjie.douya.controller.MyTest;
import me.fanjie.douya.model.User;
import me.fanjie.douya.view.ChildActivity;
import me.fanjie.douya.view.ListActivity;
import me.fanjie.douya.view.SettingsActivity;
import me.fanjie.douya.view.UserContentActivity;
import me.fanjie.douya.view.UserInterestActivity;

public class MineFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private User me;

    private ImageView ivMyImage;
    private TextView tvMyName, tvMyResume;

    private OnFragmentInteractionListener mListener;

    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        me = MyTest.getUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        view.findViewById(R.id.btnMyPanel).setOnClickListener(this);
        view.findViewById(R.id.btnMyVideos).setOnClickListener(this);
        view.findViewById(R.id.btnLearnNowVideos).setOnClickListener(this);
        view.findViewById(R.id.btnMyPartys).setOnClickListener(this);
        view.findViewById(R.id.btnMyInterests).setOnClickListener(this);
        view.findViewById(R.id.btnSettings).setOnClickListener(this);

        ivMyImage = (ImageView) view.findViewById(R.id.ivMyImage);
        tvMyName = (TextView) view.findViewById(R.id.tvMyName);
        tvMyResume = (TextView) view.findViewById(R.id.tvMyResume);

        MyTest.setHttpImage(ivMyImage,me.getUserImageUri());
        tvMyName.setText(me.getUserName());
        tvMyResume.setText(me.getUserResume());

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMyPanel:
                new UserContentActivity().startChildActivity(getActivity(),me, ChildActivity.USER);
                break;
            case R.id.btnMyVideos:
                new ListActivity().startActivity(getActivity(), me.getUserName() + " 的视频", ListActivity.VIDEO_LIST);
                break;
            case R.id.btnLearnNowVideos:
                new ListActivity().startActivity(getActivity(), me.getUserName() + " 正在学习", ListActivity.VIDEO_LIST);
                break;
            case R.id.btnMyPartys:
                new ListActivity().startActivity(getActivity(), me.getUserName() + " 的活动", ListActivity.PARTY_LIST);
                break;
            case R.id.btnMyInterests:
                new UserInterestActivity().startChildActivity(getActivity());
                break;
            case R.id.btnSettings:
                new SettingsActivity().startChildActivity(getActivity());
                break;

        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
