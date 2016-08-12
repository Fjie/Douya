package me.fanjie.douya.view.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.fanjie.douya.R;
import me.fanjie.douya.view.HotInterestActivity;
import me.fanjie.douya.view.HotVideosActivity;
import me.fanjie.douya.view.LocalVideosActivity;

public class FindFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    public static FindFragment newInstance(String param1, String param2) {
        FindFragment fragment = new FindFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FindFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        view.findViewById(R.id.btnHotVideos).setOnClickListener(this);
        view.findViewById(R.id.btnLocalVideos).setOnClickListener(this);
        view.findViewById(R.id.btnHotInterests).setOnClickListener(this);
        view.findViewById(R.id.btnPleaseWaitUs).setOnClickListener(this);
        return view;
    }

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
            case R.id.btnHotVideos:
                new HotVideosActivity().startChildActivity(getActivity());
                break;
            case R.id.btnLocalVideos:
                new LocalVideosActivity().startChildActivity(getActivity());
                break;
            case R.id.btnHotInterests:
                new HotInterestActivity().startChildActivity(getActivity());
                break;
            case R.id.btnPleaseWaitUs:
                Toast.makeText(getActivity(),"敬请期待！",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
