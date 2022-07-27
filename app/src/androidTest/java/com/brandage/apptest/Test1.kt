package com.brandage.apptest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailViewTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<DetailedActivity>()

    @Test
    fun detailedActivityCheck(){

        val activityScenario = ActivityScenario.launch(DetailedActivity::class.java)

        onView(withId(R.id.model_name))
            .check(matches(isDisplayed()))

        onView(withId(R.id.model_dose))
            .check(matches(isDisplayed()))

        onView(withId(R.id.model_strength))
            .check(matches(isDisplayed()))
    }
}