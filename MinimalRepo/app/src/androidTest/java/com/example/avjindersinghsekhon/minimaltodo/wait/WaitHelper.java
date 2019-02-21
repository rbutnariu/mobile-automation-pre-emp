package com.example.avjindersinghsekhon.minimaltodo.wait;

import android.support.test.espresso.ViewInteraction;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class WaitHelper {
    public static interface ExpectedCondition {
        boolean apply();
    }

    public static final Integer kWaitTime100 = 100;
    public static final Integer kWaitTime500 = 500;
    public static final Integer kWaitTime1000 = 1000;
    public static final Integer kWaitTime5000 = 5000;
    public static final Integer kWaitTime10000 = 10000;


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
                {
                    boolean result = true;
                    for (ExpectedCondition condition : conditions) {
                        result = condition.apply() && result;
                    }
                    return result;
                }
            }

            public ExpectedCondition or(final ExpectedCondition... conditions) {

                return new ExpectedCondition() {
                    @Override
                    public boolean apply() {

                        if (conditions.length == 0) {
                            return true;
                        }
                        boolean result = false;
                        for (ExpectedCondition condition : conditions) {
                            result = condition.apply() || result;
                        }
                        return result;
                    }
                };
            }
            public ExpectedCondition not(final ExpectedCondition conditions) {

                return new ExpectedCondition() {
                    @Override
                    public boolean apply() {

                       boolean result=!conditions.apply();

                       return result;
                    }
                };
            }


            public void customSleep(Integer duration) {
                try {
                    Thread.sleep(duration);
                } catch (Throwable t1) {

                }
            }


            public boolean waitedFor(ExpectedCondition expectedCondition, Integer timeout, Integer stepTime) {
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

            public boolean waitedFor(ExpectedCondition expectedCondition) {
                return waitedFor(expectedCondition, kWaitTime10000, kWaitTime100);
            }

        };

    }
}
