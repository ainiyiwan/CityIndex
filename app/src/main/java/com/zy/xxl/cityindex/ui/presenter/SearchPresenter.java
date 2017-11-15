package com.zy.xxl.cityindex.ui.presenter;

import com.zy.xxl.cityindex.base.BasePresenter;
import com.zy.xxl.cityindex.common.ModelManager;
import com.zy.xxl.cityindex.common.TaskCallback;
import com.zy.xxl.cityindex.ui.model.CityInfoData;
import com.zy.xxl.cityindex.ui.model.CityModel;
import com.zy.xxl.cityindex.ui.view.SearchCityView;

import java.util.List;

/**
 * Created by SilenceDut on 2016/11/15 .
 */

public class SearchPresenter extends BasePresenter<SearchCityView> {
    private CityModel mCityModel;
    private SearchCityView mSearchCityView;

    public SearchPresenter(SearchCityView presenterView) {
        super(presenterView);
        mSearchCityView = presenterView;
        mCityModel = ModelManager.getModel(CityModel.class);
    }

    public void getAllCities() {
        mCityModel.getAllCities(new TaskCallback.Success<List<CityInfoData>>() {

            @Override
            public void onSuccess(List<CityInfoData> response) {
                mSearchCityView.onAllCities(response);
            }
        });
    }

    public void matchCities(final String key) {
        mCityModel.matchCities(key,new TaskCallback.Success<List<CityInfoData>>() {
            @Override
            public void onSuccess(List<CityInfoData> response) {
                mSearchCityView.onMatched(response);
            }
        });
    }
}
