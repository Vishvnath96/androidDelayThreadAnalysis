package com.mmt.travel.app.NFR.Latency;

import java.util.concurrent.TimeUnit;

/**
 * Created by mmt6054 on 09/10/18.
 */

public abstract class TimeSelector {
    public abstract long get(MethodInfo info, ThreadInfo thread, TimeUnit unit);
    private static final TimeSelector sInclusiveThreadTimeSelector = new TimeSelector() {
        @Override
        public long get(MethodInfo info, ThreadInfo thread, TimeUnit unit) {
            return info.getProfileData().getInclusiveTime(thread, ClockType.THREAD, unit);
        }
    };
    private static final TimeSelector sInclusiveGlobalTimeSelector = new TimeSelector() {
        @Override
        public long get(MethodInfo info, ThreadInfo thread, TimeUnit unit) {
            return info.getProfileData().getInclusiveTime(thread, ClockType.GLOBAL, unit);
        }
    };
    private static final TimeSelector sExclusiveThreadTimeSelector = new TimeSelector() {
        @Override
        public long get(MethodInfo info, ThreadInfo thread, TimeUnit unit) {
            return info.getProfileData().getExclusiveTime(thread, ClockType.THREAD, unit);
        }
    };
    private static final TimeSelector sExclusiveGlobalTimeSelector = new TimeSelector() {
        @Override
        public long get(MethodInfo info, ThreadInfo thread, TimeUnit unit) {
            return info.getProfileData().getExclusiveTime(thread, ClockType.GLOBAL, unit);
        }
    };
    public static TimeSelector create(ClockType type, boolean useInclusiveTime) {
        switch (type) {
            case THREAD:
                return useInclusiveTime ?
                        sInclusiveThreadTimeSelector : sExclusiveThreadTimeSelector;
            case GLOBAL:
                return useInclusiveTime ?
                        sInclusiveGlobalTimeSelector : sExclusiveGlobalTimeSelector;
            default:
                throw new IllegalArgumentException();
        }
    }
}
