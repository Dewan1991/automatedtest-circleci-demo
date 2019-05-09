package io.centrilliontech.suprinya.automatedtestcirclecidemo

import android.support.v7.widget.RecyclerView
import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.`is` as _is


class RecyclerViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }

        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter
        //assertThat(adapter!!.itemCount, _is(expectedCount))
        assertThat(adapter!!.itemCount, greaterThan(expectedCount))
    }
}