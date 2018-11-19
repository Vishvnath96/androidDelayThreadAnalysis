package com.mmt.travel.app.NFR.Latency;

import android.support.annotation.NonNull;

import java.util.Locale;

/**
 * Created by mmt6054 on 09/10/18.
 */

public class MethodInfo {
    public final long id;
    public final String className;
    public final String methodName;
    public final String signature;
    public final String srcPath;
    public final int srcLineNumber;
    private MethodProfileData mProfileData;
    private String mFullName;
    private String mShortName;
    public MethodInfo(long id, String className, String methodName, String signature,
                      String srcPath, int srcLineNumber) {
        this.id = id;
        this.className = className;
        this.methodName = methodName;
        this.signature = signature;
        this.srcPath = srcPath;
        this.srcLineNumber = srcLineNumber;
    }
    public String getFullName() {
        if (mFullName == null) {
            mFullName = String.format(Locale.US, "%s.%s: %s", className, methodName, signature);
        }
        return mFullName;
    }
    public String getShortName() {
        if (mShortName == null) {
            mShortName = String.format(Locale.US, "%s.%s", getUnqualifiedClassName(), methodName);
        }
        return mShortName;
    }
    private String getUnqualifiedClassName() {
        String cn = className;
        int i = cn.lastIndexOf('/');
        if (i > 0) {
            cn = cn.substring(i + 1);
        }
        return cn;
    }
    @NonNull
    public MethodProfileData getProfileData() {
        return mProfileData;
    }
    public void setProfileData(@NonNull MethodProfileData profileData) {
        mProfileData = profileData;
    }
}
