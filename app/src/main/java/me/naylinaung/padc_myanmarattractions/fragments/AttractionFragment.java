package me.naylinaung.padc_myanmarattractions.fragments;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.naylinaung.padc_myanmarattractions.R;
import me.naylinaung.padc_myanmarattractions.adapters.AttractionAdapter;
import me.naylinaung.padc_myanmarattractions.data.models.AttractionModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class AttractionFragment extends Fragment {

    private AttractionAdapter mAttractionAdapter;

    public static AttractionFragment newInstance() {
        return new AttractionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAttractionAdapter = new AttractionAdapter(AttractionModel.getInstance().getAttractionVOList());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attraction, container, false);

        RecyclerView rvAttraction = (RecyclerView) view.findViewById(R.id.rv_attractions);
        rvAttraction.setAdapter(mAttractionAdapter);
        rvAttraction.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Normally load the data from the Network
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000); // millisecond
            }
        });

        return view;
    }
}
