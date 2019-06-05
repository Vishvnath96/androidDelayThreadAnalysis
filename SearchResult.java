package com.mmt.travel.app.NFR.Latency;

import android.support.annotation.NonNull;

import java.util.Set;

/**
 * Created by mmt6054 on 09/10/18.
 */

public class SearchResult {
    private final Set<MethodInfo> mMethods;
    private final Set<Call> mInstances;
    public SearchResult(@NonNull Set<MethodInfo> methods, @NonNull Set<Call> instances) {
        mMethods = methods;
        mInstances = instances;
    }
    @NonNull
    public Set<MethodInfo> getMethods() {
        return mMethods;
    }
    @NonNull
    public Set<Call> getInstances() {
        return mInstances;
    }
}
