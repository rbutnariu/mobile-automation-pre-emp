package com.example.avjindersinghsekhon.minimaltodo.wait;


import android.support.test.espresso.ViewInteraction;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class WaitHelper {

    public interface ExpectedCondition {
        boolean apply();
    }

    public static final int kWaitTime100 = 100;
    public static final int kWaitTime500 = 500;
    public static final int kWaitTime10000 = 10000;

    /// An expectation for checking that a UI element is found.
    public static ExpectedCondition elementToBeFound(final ViewInteraction element) {
        return new ExpectedCondition() {
            @Override
            public boolean apply() {
                try {
                    element.check(matches(isDisplayed()));
                } catch (Throwable t) {
                    return false;
                }
                return true;
            }
        };
    }


    public static ExpectedCondition and(final ExpectedCondition... conditions) {

        return new ExpectedCondition() {
            @Override
            public boolean apply() {
                boolean result = true;
                for (ExpectedCondition condition : conditions) {
                    result = condition.apply() && result;
                }
                return result;
            }

        };
    }


    public static void customSleep(Integer duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //        /// Wait for an expected condition @expectedCondition to be met, until timeout.
//        ///
//        /// - parameter timeout: the time in millis to wait for the condition to be met. The default timeout is 10000.
//        /// - parameter stepTime: the time in millis to sleep at every condition validation step. The default stepTime is 500.
//        /// - returns: true if the condition was achieved before timeout, else false
//        @discardableResult
    public static boolean waitedFor(ExpectedCondition expectedCondition, Integer timeout, Integer stepTime) {
        boolean verifiedOnce = false;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= timeout || !verifiedOnce) {
            verifiedOnce = true;
            boolean result;
            result = expectedCondition.apply();
            if (result) {
                return true;
            }
            customSleep(stepTime);
        }
        return false;
    }

    public static boolean waitedFor(ExpectedCondition expectedCondition) {
        return waitedFor(expectedCondition, kWaitTime10000, kWaitTime100);
    }

    public static ExpectedCondition or(final ExpectedCondition... conditions) {
        return new ExpectedCondition() {
            @Override
            public boolean apply() {
                boolean result = true;

                for (ExpectedCondition ec : conditions) {
                    result = ec.apply() || result;
                }
                return result;
            }
        };

    }
}