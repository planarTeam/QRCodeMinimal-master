package com.example.michal.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @Click
    void skanujClicked()
    {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Zeskanuj identyfikator sali");
        integrator.initiateScan();
    }

    @OnActivityResult(49374)
    void onResult(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String wynik = data.getStringExtra("SCAN_RESULT");
            Toast.makeText(this, wynik, Toast.LENGTH_LONG).show();
        }
    }
}
