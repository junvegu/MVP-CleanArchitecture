package com.kodevian.blackpinktheme.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kodevian.blackpinktheme.R;

/**
 * Created by junior on 13/10/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public void showMessageSnack(@Nullable View container, @NonNull String message, int colorResource) {
        if (container != null) {
            Snackbar snackbar = Snackbar
                    .make(container, message, Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.WHITE);
            View sbView = snackbar.getView();
            sbView.setBackgroundColor(ContextCompat.getColor(this, colorResource));
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        } else {
            Toast toast =
                    Toast.makeText(getApplicationContext(),
                            message, Toast.LENGTH_LONG);

            toast.show();
        }

    }

    protected void nextActivity(@NonNull Activity context, @Nullable Bundle bundle, Class<?> activity, boolean destroy) {
        Intent intent = new Intent(context, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (destroy) context.finish();
    }

    public void showSuccessMessage(@NonNull String message) {
        CoordinatorLayout container = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        this.showMessageSnack(container, message, R.color.colorPrimaryDark);
    }

    public void showErrorMessages(@NonNull String message) {
        CoordinatorLayout container = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        this.showMessageSnack(container, message, R.color.error_red);
    }

}
