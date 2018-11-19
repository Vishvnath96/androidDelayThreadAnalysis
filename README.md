# androidDelayThreadAnalysis

Thread will be delay thread if and only if it meets two conditions simultaneously: 

1.it processes user input directly or indirectly,
2.it changes screen output directly or indirectly. Obviously, if a thread meets the preceding two conditions (e.g., displaying an image upon a button click), its execution time can be perceivable to users and thus affect user-perceived latency.(e.g., displaying an image upon a button click).

Here we are capturing android thread dump analasys via automated solution.same we can calculate after running android profiler in Android studio for the time period and analyze its call stack like threads name,invocation count,no. of callee ,no of subcallee ,time taken by the method name in callee class etc.

# Architecture
![](https://github.com/Vishvnath96/androidDelayThreadAnalysis/blob/integration/architecture.png)
above things we captured after:
1.running automation test for specific scenario
2. captured tracefile for the scenario in the end (activityname.trace) in @test class
3. this tets class extends DelayCriticalBaseTest ,pass the .tracefile in captureThreadData(filename.trace) and will parse the .tracefile and extract all threads info with its callee,parents and invocation count.
4. this information highly useful in performance engineering phase where we need in depth analysis of issues like(black screen on android ,fixing slow ui/janky frames etc)
4. after capturing data we hit one opentsdb api for dumping data in db. (here we use opentsdb as grafana dashboard integration is quite easy with  it).
5. generate dashboard on grafana for regular monitoring.
(dashboard images attached for reference)


# How to use it
include <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> in your debug manifest or mainApp manifest file , as store .trace file in external storage.
1.integrate this latency folder in your android espresso project where all your test packages are there.
2.android test class should extends DelayCriticalBaseTest
3.in your test cases call captureThreadData(traceFileName)
4. run your test and and you will visualize result as given below

![Visualization](https://github.com/Vishvnath96/androidDelayThreadAnalysis/blob/integration/HomePageTread.png)

We can also get thread info and method info for further dig analysis
![moreinfo](https://github.com/Vishvnath96/androidDelayThreadAnalysis/blob/integration/threadInfo.png)
![moreinfo](https://github.com/Vishvnath96/androidDelayThreadAnalysis/blob/integration/calleecount.png)
