package com.mmt.travel.app.NFR.Latency;//package com.mmt.travel.app.hotel.util.Latency;

import android.support.test.rule.ActivityTestRule;

import com.mmt.travel.app.home.ui.SplashActivity;

import junit.framework.TestCase;

import org.junit.Rule;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class VmTraceParserTest extends extends DelayCriticalBaseTest {
    private static final String TAG = "HotelPage";
    HotelsLanding hotelsLanding = new HotelsLanding();

    @Rule
    ActivityTestRule<SplashActivity> activityActivityTestRule = new ActivityTestRule<SplashActivity>(SplashActivity.class);


    @Test
    @Lob(stringValue = "HTL_Landing")
    public void a_openHtlLandingPage() throws TimeoutException, InterruptedException, IOException {
        setSearchData();
        Assert.assertTrue("espressoLog - error in open method of hotelsLanding.", hotelsLanding.open(getHotelDbTestData()));
        Assert.assertTrue(waitUntil(HotelConstant.HOTEL_SEARCH,0,2000,100));
        captureThreadData(PgNameForDelayTread.hotelLanding); //activity name for generating .tracefile for the same name
    }

    }
}
