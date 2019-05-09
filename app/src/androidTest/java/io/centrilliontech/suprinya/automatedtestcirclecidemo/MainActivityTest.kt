package io.centrilliontech.suprinya.automatedtestcirclecidemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import io.centrilliontech.suprinya.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.`is` as _is


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun testTypeTextEditText() {
        //onView(withId(R.id.editText)).perform(typeText("Hello World"))
    }

    @Test
    fun testCheckTextDisplay() {
        onView(withText("Hello World")).check(matches(isDisplayed()))
    }

    @Test
    fun testChangeButtonWord() {
        onView(withId(R.id.btnGet)).perform(TextViewAction().setTextInTextView("Go"))
        onView(withId(R.id.btnGet)).perform(click())
    }


    @Test
    fun testClickRecyclerViewItem() {
        onView(withId(R.id.btnGet)).perform(click())
        onView(withRecyclerView(R.id.rcvShoes).atPosition(1)).perform(click())
    }

    @Test
    fun testCheckRecyclerViewItem() {
        onView(withId(R.id.btnGet)).perform(click())
        onView(withRecyclerView(R.id.rcvShoes).atPosition(0))
            .check(matches(hasDescendant(withText("ADD TO CART"))))
    }

    @Test
    @Throws(Exception::class)
    fun ensureRecyclerViewIsPresent() {
        onView(withId(R.id.btnGet)).perform(click())
        onView(withId(R.id.rcvShoes)).check(RecyclerViewItemCountAssertion(5))
    }

    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }
}