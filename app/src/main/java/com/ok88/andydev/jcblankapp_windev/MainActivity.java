//4-30-15 JChoy A blank android app created in AndroidStudio on windows
//
//5-1-2015 JChoy - abandon textView. use Toast.

package com.ok88.andydev.jcblankapp_windev;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.bluetooth.*;
import android.os.*;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private int prevState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Let's do this");  

        prevState=-1;
        for (int i=0; i<1; i++) {
            checkBTconnection();
            //Thread.sleep(1000);
        }
        
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        //TextView t=(TextView)findViewById(R.id.hello_world); 
        //t.setText("Done");
        //getSupportActionBar().setTitle("Done");  
    }

    private void checkBTconnection(){
        int state;
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        String[] msg= {"NOT connected","connecting","connectED","DISconnecting"};
        if (!mBluetoothAdapter.isEnabled()) return;
        state=mBluetoothAdapter.getProfileConnectionState( BluetoothProfile.A2DP);
        if (prevState != state){
            prevState = state;
            getSupportActionBar().setTitle( msg[state] );  
        }
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
