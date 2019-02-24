package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import android.widget.Checkable;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.isA;

public class AddToDo extends ScreenBase {

    public void checkCurrentScreen(){
        onView(withId(R.id.makeToDoFloatingActionButton)).check(matches(isCompletelyDisplayed()));
    }

    public void navigateTo() {

        onView(withId(R.id.addToDoItemFAB)).check(matches(isDisplayed())).perform(click());
    }
    public void insertTitle(String text){
        insertData(text, R.id.userToDoEditText);
    }
    public void insertDescription(String text){
        insertData(text,R.id.userToDoDescription);
    }

    public boolean isElementChecked(int resourceId) {
        boolean flag = true;
        try {
            onView(withId(resourceId)).check(matches(isChecked()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public void clickSubmit(){
       clickButton(R.id.makeToDoFloatingActionButton);
    }

    public void deleteToDo(){

    }

    public void switchRemindMeButton(String state){
      switch(state){
          case "ON":
             if(true){
                // clickButton(R.id.toDoHasDateSwitchCompat);
                 onView(withId(R.id.toDoHasDateSwitchCompat)).perform(setChecked(true));
             }
             break;
          case "OFF":
              if(isElementChecked(R.id.toDoHasDateSwitchCompat)){
                  clickButton(R.id.toDoHasDateSwitchCompat);
              }
              break;
          default:
              System.out.println("Invalid state!");
      }

    }

    public static ViewAction setChecked(final boolean checked) {
        return new ViewAction() {
            @Override
            public BaseMatcher<View> getConstraints() {
                return new BaseMatcher<View>() {
                    @Override
                    public boolean matches(Object item) {
                        return isA(Checkable.class).matches(item);
                    }

                    @Override
                    public void describeMismatch(Object item, Description mismatchDescription) {}

                    @Override
                    public void describeTo(Description description) {}
                };
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {
                Checkable checkableView = (Checkable) view;
                checkableView.setChecked(checked);
            }
        };

    }
}
