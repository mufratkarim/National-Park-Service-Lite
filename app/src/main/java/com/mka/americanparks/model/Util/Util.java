package com.mka.americanparks.model.Util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Util {
    public static final String PARKS_URL = "https://developer.nps.gov/api/v1/parks?stateCode=ny&api_key=cCZXbmavHusfZl0FegI4yNlWMe5rHyqF1JQvypbS";

    public static String getParksUrl(String stateCode) {
        return "https://developer.nps.gov/api/v1/parks?stateCode=" + stateCode + "&api_key=cCZXbmavHusfZl0FegI4yNlWMe5rHyqF1JQvypbS";
    }

    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

}
