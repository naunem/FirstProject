package com.example.naunem.firstproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.naunem.firstproject.MockData;
import com.example.naunem.firstproject.R;
import com.example.naunem.firstproject.adapters.UserAdapter;
import com.example.naunem.firstproject.interfaces.MyOnClickListener;
import com.example.naunem.firstproject.models.ItemList;

import java.util.ArrayList;

/**
 * Created by naunem on 22/03/2017.
 */
public class ListUserFragment extends Fragment implements MyOnClickListener {
    private RecyclerView mRecyclerView;
    private UserAdapter mUserAdapter;
    private ArrayList<ItemList> mItemLists;
    private TextView mTvTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_user, container, false);
        mTvTitle = (TextView) view.findViewById(R.id.tvTitle);
        mTvTitle.setText("Fragment");
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewListUser);
        LinearLayoutManager ln = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(ln);
        mItemLists = MockData.getData();
        Log.d("zzzz", "onCreateView: " + mItemLists.size());
        mUserAdapter = new UserAdapter(view.getContext(), mItemLists, mRecyclerView, this);
        mRecyclerView.setAdapter(mUserAdapter);
        return view;
    }

    @Override
    public void onClickListener(int position) {

    }
}

