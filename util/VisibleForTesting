package com.mmt.travel.app.NFR.Latency.util;

/**
 * Created by mmt6054 on 09/10/18.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Denotes that the class, method or field has its visibility relaxed so
 * that unit tests can access it.
 * <p/>
 * The <code>visibility</code> argument can be used to specific what the original
 * visibility should have been if it had not been made public or package-private for testing.
 * The default is to consider the element private.
 */
@Retention(RetentionPolicy.SOURCE)
public @interface VisibleForTesting {
    /**
     * Intended visibility if the element had not been made public or package-private for
     * testing.
     */
    enum Visibility {
        /** The element should be considered protected. */
        PROTECTED,
        /** The element should be considered package-private. */
        PACKAGE,
        /** The element should be considered private. */
        PRIVATE
    }
    /**
     * Intended visibility if the element had not been made public or package-private for testing.
     * If not specified, one should assume the element originally intended to be private.
     */
    Visibility visibility() default Visibility.PRIVATE;
}
