/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;


/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {

    public static final String STRING_TO_BE_TYPED = "Espresso";
    public static final String TITLE = "Hello Espresso!";
    public static final String BASIC = "Basic Espresso sample";
    public static final String WORD = "WORD";

    public static void methodToCheckText() {
        onView(allOf(is(instanceOf(TextView.class)), withText("Basic Espresso sample"))).check(matches(isDisplayed()));
    }
    /**
     * Use {@link ActivityScenarioRule} to create and launch the activity under test, and close it
     * after test completes. This is a replacement for {@link androidx.test.rule.ActivityTestRule}.
     */
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(allOf(withId(R.id.editTextUserInput), is(instanceOf(EditText.class))))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged)).check(matches(withText(STRING_TO_BE_TYPED)));
    }


    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BE_TYPED)));
    }

    @Test
    public void checkHelloEspressoTitle() {
        onView(withId(R.id.textToBeChanged)).check(matches(withText(TITLE))).check(matches(isDisplayed()));
    }

    @Test
    public void checkBasicEspressoTitle() {
        //check if the title matches the correct string
        methodToCheckText();
        //writes a word and clicks to send it to the next page
        onView(withId(R.id.editTextUserInput)).perform(typeText(WORD),
                closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        methodToCheckText();
        //checks that the word we sent is displayed
        onView(withId(R.id.show_text_view)).check(matches(isDisplayed()));

    }
}