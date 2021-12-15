package com.mka.americanparks.data;

import com.mka.americanparks.model.Park;

import java.util.List;

public interface AsyncResponse {
    void parkProcessing(List<Park> parkList);
}
