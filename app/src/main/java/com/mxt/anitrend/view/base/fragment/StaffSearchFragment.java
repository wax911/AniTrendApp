package com.mxt.anitrend.view.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mxt.anitrend.api.model.Staff;
import com.mxt.anitrend.base.custom.async.AsyncTaskFetch;
import com.mxt.anitrend.viewmodel.fragment.SearchFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by max on 2017/08/11.
 */

public class StaffSearchFragment extends SearchFragment<Staff> {

    public static StaffSearchFragment newInstance(String query) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, query);
        StaffSearchFragment fragment = new StaffSearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Override if you need to include extra functionality into the method,
     * the method will get the arguments from the from your bundle and into
     * the model followed by initialization of your presenter
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mRequestType = AsyncTaskFetch.RequestType.STAFF_SEARCH_REQ;
        super.onCreate(savedInstanceState);
    }

    /**
     * Override this as normal the save instance for your model will be managed for you,
     * so there is no need to to restore the state of your model from save state.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResponse(Call<List<Staff>> call, Response<List<Staff>> response) {
        if(isVisible() && (!isDetached() || !isRemoving()))
            if(response.isSuccessful() && response.body() != null) {
                model = response.body();
                updateUI();
            }
            else
                showError();
    }

    /**
     * The sorting runner must be invoked in here
     */
    @Override
    public void sortItems() {

    }
}
