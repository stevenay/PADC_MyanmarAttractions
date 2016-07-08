package me.naylinaung.padc_myanmarattractions.data.models;

import android.icu.text.DisplayContext;

import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import me.naylinaung.padc_myanmarattractions.data.vos.AttractionVO;
import me.naylinaung.padc_myanmarattractions.utils.CommonInstances;
import me.naylinaung.padc_myanmarattractions.utils.JsonUtils;

/**
 * Created by NayLinAung on 7/7/2016.
 */
public class AttractionModel {

    private static final String DUMMY_ATTRACTION_LIST = "myanmar_attractions.json";

    private static AttractionModel objInstance;

    private List<AttractionVO> mAttractionVOList;

    private AttractionModel() {
        mAttractionVOList = this.initializeAttractionList();
    }

    public static AttractionModel getInstance() {
        if (objInstance == null) {
            objInstance = new AttractionModel();
        }

        return objInstance;
    }

    private List<AttractionVO> initializeAttractionList() {
        List<AttractionVO> list = new ArrayList<>();

        try {
            String dummyAttractionList = JsonUtils.getInstance().LoadDummyData(DUMMY_ATTRACTION_LIST);

            // Get Data From Online
            // String onlineData = JsonUtils.getInstance().LoadOnlineData();

            Type listType = new TypeToken<List<AttractionVO>>(){}.getType();
            list = CommonInstances.getGsonInstance().fromJson(dummyAttractionList, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<AttractionVO> getAttractionVOList() {
        return mAttractionVOList;
    }

    public AttractionVO getAttractionbyTitle(String title) {
//        this.getAttractionVOList()
//                .stream()
//                .filter(attr -> attr.getTitle() == title)
//                .findFirst();

        if (title.isEmpty()) return null;

        for (AttractionVO attraction : mAttractionVOList) {
            if (attraction.getTitle().equals(title)) {
                return attraction;
            }
        }

        return null;
    }
}
