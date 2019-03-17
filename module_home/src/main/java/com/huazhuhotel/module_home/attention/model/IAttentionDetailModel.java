package com.huazhuhotel.module_home.attention.model;

import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;

import io.reactivex.Observable;

public interface IAttentionDetailModel {
    Observable<UnRecipesListInfo> getUnRecipesListInfo(String userID, int page);
    Observable<UserNoteInfo> getUserNoteInfo(String userID, int page);
}
