package me.naylinaung.padc_myanmarattractions.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.naylinaung.padc_myanmarattractions.R;
import me.naylinaung.padc_myanmarattractions.data.models.AttractionModel;
import me.naylinaung.padc_myanmarattractions.data.vos.AttractionVO;

/**
 * Created by NayLinAung on 7/7/2016.
 */
public class AttractionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_attraction_title)
    TextView tvTitle;

    @BindView(R.id.iv_attraction_image)
    ImageView ivAttraction;

    @BindView(R.id.tv_attraction_desc)
    TextView tvDescription;

    public AttractionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
    }

    public void setData(AttractionVO data)
    {
        this.tvTitle.setText(data.getTitle());
        this.tvDescription.setText(data.getDescription());

        Glide.with(this.ivAttraction.getContext())
                .load(AttractionModel.getImagePath() + data.getFirstImage())
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .into(ivAttraction);
    }

    @Override
    public void onClick(View view) {

    }
}
