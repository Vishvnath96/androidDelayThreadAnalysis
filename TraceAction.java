package com.mmt.travel.app.NFR.Latency;

/**
 * Created by mmt6054 on 09/10/18.
 */

enum TraceAction {
    METHOD_ENTER,           // method entry
    METHOD_EXIT,            // method exit
    METHOD_EXIT_UNROLL      // method exited by exception unrolling
}
