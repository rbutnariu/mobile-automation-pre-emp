package com.example.android.logindemo.tests;

import android.support.test.rule.ActivityTestRule;
import com.example.android.logindemo.MainActivity;
import org.junit.Rule;

public class EspressoTestBase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
}
