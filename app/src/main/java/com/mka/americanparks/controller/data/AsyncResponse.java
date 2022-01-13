package com.mka.americanparks.controller.data;

import com.mka.americanparks.model.Park;

import java.util.List;

public interface AsyncResponse {
    void parkProcessing(List<Park> parkList);
}
