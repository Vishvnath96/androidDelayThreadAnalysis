package com.mmt.travel.app.NFR.Latency.util;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;

/**
 * Created by mmt6054 on 11/10/18.
 */


 //Utility methods to deal with loading the test data.
public class TestUtils {
    /**
     * returns a File for the subfolder of the test resource data.
     * <p>
     * This is basically "src/test/resources/testData/$name".
     * <p>
     * Note that this folder is relative to the root project which is where gradle
     * sets the current working dir when running the tests.
     * <p>
     * If you need a full folder path, use {@link #getCanonicalRoot(String...)}.
     *
     * @param names the names of the subfolders.
     * @return a File
     */
    public static File getRoot(String... names) {
        File root = null;
        for (String name : names) {
            if (root == null) {
                root = new File("src/test/resources/testData/" + name);
            } else {
                root = new File(root, name);
            }
            TestCase.assertTrue("Test folder '" + name + "' does not exist!",
                    root.isDirectory());
        }
        return root;
    }

    /**
     * returns a File for the subfolder of the test resource data.
     * <p>
     * The full path is canonized.
     * This is basically ".../src/test/resources/testData/$name".
     *
     * @param names the names of the subfolders.
     * @return a File
     */
    public static File getCanonicalRoot(String... names) throws IOException {
        File root = getRoot(names);
        return root.getCanonicalFile();
    }
}