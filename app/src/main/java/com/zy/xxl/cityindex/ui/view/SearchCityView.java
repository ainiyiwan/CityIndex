package com.zy.xxl.cityindex.ui.view;


import com.zy.xxl.cityindex.base.BaseView;
import com.zy.xxl.cityindex.ui.model.CityInfoData;

import java.util.List;

/**
 * Created by SilenceDut on 16/10/22 .
 */

public interface SearchCityView extends BaseView {
    void onMatched(List<CityInfoData> cityInfoDatas);

    void onAllCities(List<CityInfoData> allInfoDatas);
}
