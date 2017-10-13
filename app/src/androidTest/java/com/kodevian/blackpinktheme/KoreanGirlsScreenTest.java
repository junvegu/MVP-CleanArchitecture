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

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;

import com.kodevian.blackpinktheme.presentation.activities.KoreanGirlsActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.kodevian.blackpinktheme.TestUtils.getCurrentActivity;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;

/**
 * Tests for the tasks screen, the main screen which contains a list of all tasks.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class KoreanGirlsScreenTest {

    private final static String TITLE1 = "TITLE1";

    private final static String DESCRIPTION = "DESCR";

    private final static String TITLE2 = "TITLE2";

    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule
    public ActivityTestRule<KoreanGirlsActivity> mTasksActivityTestRule =
            new ActivityTestRule<KoreanGirlsActivity>(KoreanGirlsActivity.class) {


                @Override
                protected void beforeActivityLaunched() {
                    super.beforeActivityLaunched();
                    // Doing this in @Before generates a race condition.
                    Injection.provideKoreanGirlRepostoryRepository(InstrumentationRegistry.getTargetContext())
                            .refreshKoreanGirls();
                    Injection.provideKoreanGirlRepostoryRepository(InstrumentationRegistry.getTargetContext())
                        .deleteAllKoreanGirls();
                }
            };







    @Test
    @SdkSuppress(minSdkVersion = 21) // Blinking cursor after rotation breaks this in API 19
    public void orientationChange_DuringEdit_ChangePersists() throws Throwable {
        TestUtils.rotateOrientation(mTasksActivityTestRule.getActivity());

    }

}
