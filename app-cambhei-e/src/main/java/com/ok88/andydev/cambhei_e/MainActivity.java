//5-6-15 JChoy New app project Cambhei-E by Copied from Cholly-B.
//5-6-15 JChoy v0.1.1006 - Write wifi results to textview.

package com.ok88.andydev.cambhei_e;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.net.wifi.*;
import android.net.NetworkInfo;
import android.net.NetworkInfo.*;
import android.content.Context;
import android.widget.*;
import android.util.TypedValue;

public class MainActivity extends ActionBarActivity {
    public TextView actTextView;

    public String getWifiName(Context context) {
        WifiManager manager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (manager.isWifiEnabled()) {
           WifiInfo wifiInfo = manager.getConnectionInfo();
           if (wifiInfo != null) {
              DetailedState state = WifiInfo.getDetailedStateOf(wifiInfo.getSupplicantState());
              if (state == DetailedState.CONNECTED || state == DetailedState.OBTAINING_IPADDR) {
                  return wifiInfo.getSSID();
              }
           }
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actTextView = (TextView)findViewById(R.id.hello_tv);
        actTextView.setText("WIfi info goes here");

        actTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        actTextView.setText(getWifiName(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
