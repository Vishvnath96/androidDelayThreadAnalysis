# androidDelayThreadAnalysis

Thread will be delay thread if and only if it meets two conditions simultaneously: 

1.it processes user input directly or indirectly,
2.it changes screen output directly or indirectly. Obviously, if a thread meets the preceding two conditions (e.g., displaying an image upon a button click), its execution time can be perceivable to users and thus affect user-perceived latency.(e.g., displaying an image upon a button click).

Here we are capturing android thread dump analasys via automated solution.same we can calculate after running android profiler in Android studio for the time period and analyze its call stack like threads name,invocation count,no. of callee ,no of subcallee ,time taken by the method name in callee class etc.

same things we captured after:
1.running automation test for specific scenario
2. captured tracefile for the scenario in the end (activityname.trace) in @test class
3. this tets class extends DelayCriticalBaseTest ,pass the .tracefile in captureThreadData(filename.trace) and will parse the .tracefile and extract all threads info with its callee,parents and invocation count.
4. this information highly useful in performance engineering phase where we need in depth analysis of issues like(black screen on android ,fixing slow ui/janky frames etc)
4. after capturing data we hit one opentsdb api for dumping data in db. (here we use opentsdb as grafana dashboard integration is quite easy with  it).
5. generate dashboard on grafana for regular monitoring.
(dashboard images attached for reference)

