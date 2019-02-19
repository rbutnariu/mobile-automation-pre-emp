package com.example.android.logindemo.tests;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import com.example.android.logindemo.R;
import com.example.android.logindemo.screens.SignIn;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class EspressoTests extends EspressoTestBase {

    @Test
    public void mytest() {
        onView(ViewMatchers.withId(R.id.btnLogin)).check(matches(isDisplayed()));
        SignIn.navigateTo();
    }
}
