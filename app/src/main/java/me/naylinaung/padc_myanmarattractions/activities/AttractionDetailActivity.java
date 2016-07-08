package me.naylinaung.padc_myanmarattractions.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.naylinaung.padc_myanmarattractions.MyanmarAttractionsApp;
import me.naylinaung.padc_myanmarattractions.R;
import me.naylinaung.padc_myanmarattractions.data.models.AttractionModel;
import me.naylinaung.padc_myanmarattractions.data.vos.AttractionVO;

public class AttractionDetailActivity extends AppCompatActivity {

    private static final String IE_ATTRACTION_TITLE = "IE_ATTRACTION_TITLE";
    private ShareActionProvider mShareActionProvider;

    //region ButterKnife Injections
    @BindView(R.id.iv_attraction_image)
    public ImageView ivAttractionPhoto;

    @BindView(R.id.tv_attraction_desc)
    public TextView tvAttractionDesc;

    @BindView(R.id.collapsing_toolbar)
    public CollapsingToolbarLayout collapsingToolbar;
    //endregion

    public static Intent newIntent(String attractionTitle) {
        Intent intent = new Intent(MyanmarAttractionsApp.getContext(), AttractionDetailActivity.class);
        intent.putExtra(IE_ATTRACTION_TITLE, attractionTitle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivAttractionPhoto.setTransitionName(getResources().getString(R.string.event_attraction_photo_shared_transition));
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_accent_24dp);
        }

        Intent intent = this.getIntent();
        String attractionTitle = intent.getStringExtra(IE_ATTRACTION_TITLE);

        final AttractionVO attraction = AttractionModel.getInstance().getAttractionbyTitle(attractionTitle);
        if (attraction == null) {
            throw new RuntimeException("Can't find Attraction object with the title: " + attractionTitle);
        } else {
            this.collapsingToolbar.setTitle(attraction.getTitle());
            tvAttractionDesc.setText(attraction.getDescription());

            Glide.with(ivAttractionPhoto.getContext())
                    .load(AttractionVO.getImagePath() + attraction.getFirstImage())
                    .centerCrop()
                    .placeholder(R.drawable.stock_photo_placeholder)
                    .into(ivAttractionPhoto);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myShareIntent = new Intent(Intent.ACTION_SEND);
                myShareIntent.setType("text/*");
                myShareIntent.putExtra(Intent.EXTRA_TEXT, AttractionVO.getImagePath() + attraction.getFirstImage());
                startActivity(Intent.createChooser(myShareIntent, "Share via"));
            }
        });
    }

}
