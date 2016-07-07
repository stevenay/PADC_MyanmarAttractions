package me.naylinaung.padc_myanmarattractions.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.w3c.dom.Attr;

import java.util.List;

import me.naylinaung.padc_myanmarattractions.MyanmarAttractionsApp;
import me.naylinaung.padc_myanmarattractions.R;
import me.naylinaung.padc_myanmarattractions.data.vos.AttractionVO;
import me.naylinaung.padc_myanmarattractions.views.holders.AttractionViewHolder;

/**
 * Created by NayLinAung on 7/7/2016.
 */
public class AttractionAdapter extends RecyclerView.Adapter<AttractionViewHolder> {

    private LayoutInflater inflator;
    private List<AttractionVO> attractionList;

    public AttractionAdapter(List<AttractionVO> attractionList) {
        inflator = LayoutInflater.from(MyanmarAttractionsApp.getContext());
        this.attractionList = attractionList;
    }

    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.view_item_attraction, parent, false);
        final AttractionViewHolder viewHolder = new AttractionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, int position) {
        holder.setData(attractionList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.attractionList.size();
    }
}
