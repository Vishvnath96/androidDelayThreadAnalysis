package com.mmt.travel.app.NFR.Latency;

/**
 * Created by mmt6054 on 09/10/18.
 */

/**
 * This interface used by {@link VmTraceParser}. {@link VmTraceParser} parses a trace file and
 * informs the handler about parsing events.
 */
public interface VmTraceHandler {
    /** @param version - version of the trace file. */
    void setVersion(int version);
    /**
     * Sets a parsed property of the trace file. Example keys are: "elapsed-time-usec", "clock",
     * "data-file-overflow", "vm"
     */
    void setProperty(String key, String value);
    /**
     * Receives notification about a thread.
     *
     * @param id - id of the thread.
     * @param name - name of the thread.
     */
    void addThread(int id, String name);
    /**
     * Receives notification about a method.
     *
     * @param id - id of the method.
     * @param info - {@link MethodInfo} that contains information about the method.
     */
    void addMethod(long id, MethodInfo info);
    /**
     * Receives notification about a method event. Example events are: method entered, method
     * exited.
     *
     * @param threadId - id of the thread where this event happened.
     * @param methodId - id of the method where this event happened.
     * @param methodAction - type of the action
     * @param threadTime - thread time when this event happened.
     * @param globalTime - global time when this event
     */
    void addMethodAction(
            int threadId, long methodId, TraceAction methodAction, int threadTime, int globalTime);
    /** @param startTimeUs - tracing start time. */
    void setStartTimeUs(long startTimeUs);
}
