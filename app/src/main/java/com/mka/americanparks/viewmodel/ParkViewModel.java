package com.mka.americanparks.viewmodel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mka.americanparks.model.Park;

public class ParkViewModel extends ViewModel {
    private final MutableLiveData<Park> selectedPark = new MutableLiveData<>();
    private final MutableLiveData<String> code = new MutableLiveData<>();
    private final MutableLiveData<List<Park>> selectedParks = new MutableLiveData<>();

    public void selectCode(String c) {
        code.setValue(c);
    }

    public LiveData<String> getCode() {
        return code;
    }

    public void selectPark(Park park) {
        selectedPark.setValue(park);
    }

    public LiveData<Park> getSelectedPark() {
        return selectedPark;
    }

    public void setSelectedParks(List<Park> parks) {
        selectedParks.setValue(parks);
    }

    public LiveData<List<Park>> getParks() {
        return selectedParks;
    }


}
