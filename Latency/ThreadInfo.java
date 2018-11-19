package com.mmt.travel.app.NFR.Latency;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by mmt6054 on 09/10/18.
 */

    public class ThreadInfo {
        /** Thread id */
        private final int mId;
        /** Thread name */
        private final String mName;
        /** Top level call in this thread */
        private final Call mTopLevelCall;
        public ThreadInfo(int threadId, @NonNull String name, @Nullable Call topLevelCall) {
            mId = threadId;
            mName = name;
            mTopLevelCall = topLevelCall;
        }
        public int getId() {
            return mId;
        }
        @NonNull
        public String getName() {
            return mName;
        }
        @Nullable
        public Call getTopLevelCall() {
            return mTopLevelCall;
        }
    }
