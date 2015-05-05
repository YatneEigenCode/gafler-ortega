//5-5-15 JChoy New app project Jcapp_Cholly_B by Copiing MainActivity.java contents from jcblankapp_windev.
//          Successfully renamed app project by changing these 4 files:
//          app.imp, build.gradle, jcapp_cholly_b/MainActivity.java, and strings.xml
//          Note: also commented out everything in jcblankapp_windev/MainActivity.java
//          In git, this new project is a BRANCH (jcapp_cholly_b) of the main repository instead of a subfolder.
//

package com.ok88.andydev.jcapp_cholly_b;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
