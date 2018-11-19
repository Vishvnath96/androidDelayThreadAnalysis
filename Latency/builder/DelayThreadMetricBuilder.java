package com.mmt.travel.app.NFR.Latency.builder;

import android.os.Build;
import android.util.Log;

import com.makemytrip.BuildConfig;
import com.mmt.travel.app.NFR.Latency.model.ThreadMetrics;
import com.mmt.travel.app.NFR.Latency.util.PgNameForDelayTread;
import com.mmt.travel.app.testmetrictracer.metricpojo.KeyMetric;
import com.mmt.travel.app.testmetrictracer.metricpojo.MetricPayload;
import com.mmt.travel.app.testmetrictracer.metricpojo.MetricsDeviceMeta;
import com.mmt.travel.app.testmetrictracer.util.CreateDBRequest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmt6054 on 23/10/18.
 */

public class DelayThreadMetricBuilder {

    static DecimalFormat decimalFormat = new DecimalFormat("#.##");
    public static int metricCounter = PgNameForDelayTread.threadCount;
    static int counter = 0;
    private static List<KeyMetric> keyMetricList = new ArrayList<>();

    public static void generateGrafanaData(ThreadMetrics threadMetrics, String activityName,Boolean appOnlyThread){

        MetricPayload metricPayload = new MetricPayload();
        MetricsDeviceMeta metricsDeviceMeta = new MetricsDeviceMeta();
        KeyMetric keyMetricNoOfCallee = new KeyMetric();
        KeyMetric keyMetricThreadTime = new KeyMetric();
        KeyMetric keyMetricThreadGlobalTime = new KeyMetric();

        if(!appOnlyThread){
            try{
                if(counter < metricCounter-1 ){
                    keyMetricNoOfCallee.setMethodName("noOfCallee");
                    keyMetricNoOfCallee.setMetricType(threadMetrics.getThreadName());
                    keyMetricNoOfCallee.setValue(Double.valueOf(threadMetrics.getNoOfCallee()));

                    keyMetricThreadTime.setMethodName("threadTotalTime");
                    keyMetricThreadTime.setMetricType(threadMetrics.getThreadName());
                    keyMetricThreadTime.setValue(Double.valueOf(decimalFormat.format(threadMetrics.getThreadTotalTime())));

                    keyMetricThreadGlobalTime.setMethodName("threadGlobalTime");
                    keyMetricThreadGlobalTime.setMetricType(threadMetrics.getThreadName());
                    keyMetricThreadGlobalTime.setValue(Double.valueOf(threadMetrics.getGlobalTotalTime()));

                    keyMetricList.add(keyMetricNoOfCallee);
                    keyMetricList.add(keyMetricThreadTime);
                    keyMetricList.add(keyMetricThreadGlobalTime);
                    counter++;
                }
                else {
                    metricsDeviceMeta.setDeviceName(Build.MODEL.replace(" ","-"));
                    metricsDeviceMeta.setApkVersion(BuildConfig.VERSION_NAME);
                    metricsDeviceMeta.setPlatform(activityName); //"Android" + Build.VERSION.SDK_INT
                    metricPayload.setDeviceMeta(metricsDeviceMeta);
                    metricPayload.setMetrics(keyMetricList);
                    publishData(metricPayload);
                    keyMetricList.clear();
                    counter=0;
                    Log.v("FrameMetrics","clear counter");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                keyMetricNoOfCallee.setMethodName("noOfCallee");
                keyMetricNoOfCallee.setMetricType(threadMetrics.getThreadName());
                keyMetricNoOfCallee.setValue(Double.valueOf(threadMetrics.getNoOfCallee()));

                keyMetricThreadTime.setMethodName("threadTotalTime");
                keyMetricThreadTime.setMetricType(threadMetrics.getThreadName());
                keyMetricThreadTime.setValue(Double.valueOf(decimalFormat.format(threadMetrics.getThreadTotalTime())));

                keyMetricThreadGlobalTime.setMethodName("threadGlobalTime");
                keyMetricThreadGlobalTime.setMetricType(threadMetrics.getThreadName());
                keyMetricThreadGlobalTime.setValue(Double.valueOf(threadMetrics.getGlobalTotalTime()));

                keyMetricList.add(keyMetricNoOfCallee);
                keyMetricList.add(keyMetricThreadTime);
                keyMetricList.add(keyMetricThreadGlobalTime);

                metricsDeviceMeta.setDeviceName(Build.MODEL.replace(" ", "-"));
                metricsDeviceMeta.setApkVersion(BuildConfig.VERSION_NAME);
                metricsDeviceMeta.setPlatform(activityName); //"Android" + Build.VERSION.SDK_INT
                metricPayload.setDeviceMeta(metricsDeviceMeta);
                metricPayload.setMetrics(keyMetricList);
                publishData(metricPayload);
                keyMetricList.clear();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private static void publishData(MetricPayload metricPayload) {
        try{
            CreateDBRequest.createAPIRequest(metricPayload);
        }catch (Exception e){
            Log.v("FrameMetrics",e.getMessage());
        }
    }
}
