package com.mmt.travel.app.NFR.Latency;//package com.mmt.travel.app.hotel.util.Latency;
//
//import android.support.test.rule.ActivityTestRule;
//
//import com.mmt.travel.app.home.ui.SplashActivity;
//
//import junit.framework.TestCase;
//
//import org.junit.Rule;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//
///**
// * Created by mmt6054 on 09/10/18.
// */
//
//public class VmTraceParserTest extends TestCase {
//
//    @Rule
//    ActivityTestRule<SplashActivity> activityActivityTestRule = new ActivityTestRule<SplashActivity>(SplashActivity.class);
//
//    public void testParseHeader() throws IOException {
//        String path = "/header.trace";
//        File f = new File(path);
//        if(f.exists()){
//            VmTraceData.Builder dataBuilder = new VmTraceData.Builder();
//
//        }
//
//    }
//
//    private File getFile(String path) {
//        URL resource = getClass().getResource(path);
//        // Note: When running from an IntelliJ, make sure the IntelliJ compiler settings treats
//        // *.trace files as resources, otherwise they are excluded from compiler output
//        // resulting in a NPE.
//        assertNotNull(path + " not found", resource);
//        return null;   //TestResources.getFile(getClass(), path);
//    }
//}
