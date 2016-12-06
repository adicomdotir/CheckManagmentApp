package ir.adicom.app.checkmanagmentapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by adicom on 12/6/16.
 */

public class InsertActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_check);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_layout);

        CustomControl customBtn1 = (CustomControl) findViewById(R.id.custom_btn_1);
        CustomControl customBtn2 = (CustomControl) findViewById(R.id.custom_btn_2);
        CustomControl customBtn3 = (CustomControl) findViewById(R.id.custom_btn_3);
        try {
            customBtn1.setNumber(1395);
            customBtn1.setMinMax(1395,1399);
            customBtn1.setLen(4);
            customBtn1.setUp();
            customBtn2.setNumber(9);
            customBtn2.setMinMax(1,12);
            customBtn2.setLen(2);
            customBtn2.setUp();
            customBtn3.setNumber(1);
            customBtn3.setMinMax(1,31);
            customBtn3.setLen(2);
            customBtn3.setUp();
        } catch (Exception e) {
            Log.e(G.TAG, "" + e.getMessage());
        }
    }
}
