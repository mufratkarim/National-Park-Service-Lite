package com.mka.americanparks.viewmodel.data;

import com.mka.americanparks.model.Park;

import java.util.List;

public interface AsyncResponse {
    void parkProcessing(List<Park> parkList);
}
