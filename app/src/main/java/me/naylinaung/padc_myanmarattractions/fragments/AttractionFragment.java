package me.naylinaung.padc_myanmarattractions.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.naylinaung.padc_myanmarattractions.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AttractionFragment extends Fragment {

    public AttractionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
