package com.example.ui_testing;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.uiautomator.UiDevice;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule   // UI test für MainActivity
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void userNameTest(){
        onView(withId(R.id.user_name)).check(matches(isDisplayed()));
    }

    @Test   // erste eingebe
    public void userNameTestInput(){
        try { // sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.user_name)).perform(ViewActions.typeText("mustafa"));// Nutzername
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.pass_word)).perform(ViewActions.typeText("mustafa0000")); // passwort
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.btn_send)).perform(ViewActions.click());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



    @Test    // zweite eingebe
    public void userNameTestInput2(){
        onView(ViewMatchers.withId(R.id.user_name)).perform(ViewActions.typeText("mustafa Ahmed")); //Nutzername
        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.pass_word)).perform(ViewActions.typeText("mustafa0000N"));// passwort
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.btn_send)).perform(ViewActions.click());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

    @Test  // dritte eingebe
    public void userNameTestInput3(){
        onView(ViewMatchers.withId(R.id.user_name)).perform(ViewActions.typeText("mustafa Ahmed")); //Nutzername
        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.pass_word)).perform(ViewActions.typeText("mustafa0000N")); //passwort
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.btn_send)).perform(ViewActions.click());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test   // vierte eingebe
    public void userNameTestInput4(){
        onView(ViewMatchers.withId(R.id.user_name)).perform(ViewActions.typeText("mustafa Ahmed")); // Nutzername
        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.pass_word)).perform(ViewActions.typeText("mustafa0000N"));// passwort
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.btn_send)).perform(ViewActions.click());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test // fünfte eingabe
    public void userNameTestInput5(){
        onView(ViewMatchers.withId(R.id.user_name)).perform(ViewActions.typeText("mustafa Ahmed")); //Nutzername
        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.pass_word)).perform(ViewActions.typeText("mustafa0000N")); //passwort
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {// sleep eine sekunde
            Thread.sleep(1000);
            onView(ViewMatchers.withId(R.id.btn_send)).perform(ViewActions.click());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}