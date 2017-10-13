/*
 * Copyright 2016, The Android Open Source Project
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

package com.kodevian.blackpinktheme;

import android.support.test.espresso.NoActivityResumedException;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;

import com.kodevian.blackpinktheme.presentation.activities.KoreanGirlsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.kodevian.blackpinktheme.TestUtils.getCurrentActivity;
import static com.kodevian.blackpinktheme.TestUtils.getToolbarNavigationContentDescription;
import static junit.framework.Assert.fail;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class AppNavigationTest {


    @Rule
    public ActivityTestRule<KoreanGirlsActivity> mActivityTestRule =
            new ActivityTestRule<>(KoreanGirlsActivity.class);


    @Test
    public void clickRandomItem() {
        int x = getRandomRecyclerPosition(R.id.rv_list);
        onView(withId(R.id.rv_list))
                .perform(actionOnItemAtPosition(x, click()));
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());


        x = getRandomRecyclerPosition(R.id.rv_list);
        onView(withId(R.id.rv_list))
                .perform(actionOnItemAtPosition(x, click()));
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());


        x = getRandomRecyclerPosition(R.id.rv_list);
        onView(withId(R.id.rv_list))
                .perform(actionOnItemAtPosition(x, click()));
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());


        x = getRandomRecyclerPosition(R.id.rv_list);
        onView(withId(R.id.rv_list))
                .perform(actionOnItemAtPosition(x, click()));
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());




        TestUtils.rotateOrientation(getCurrentActivity());


        x = getRandomRecyclerPosition(R.id.rv_list);
        onView(withId(R.id.rv_list))
                .perform(actionOnItemAtPosition(x, click()));
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());

        TestUtils.rotateOrientation(getCurrentActivity());


        //Magic happening
        //

        /*onView(withId(R.id.rv_list))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition(0, click()));*/
    }

    private int getRandomRecyclerPosition(int recyclerId) {
        Random ran = new Random();
        //Get the actual drawn RecyclerView
        RecyclerView recyclerView = (RecyclerView) mActivityTestRule
                .getActivity().findViewById(recyclerId);

        //If the RecyclerView exists, get the item count from the adapter
        int n = (recyclerView == null)
                ? 1
                : recyclerView.getAdapter().getItemCount();

        //Return a random number from 0 (inclusive) to adapter.itemCount() (exclusive)
        return ran.nextInt(n);
    }

}
