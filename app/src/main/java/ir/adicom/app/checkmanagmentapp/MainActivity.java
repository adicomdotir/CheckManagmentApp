package ir.adicom.app.checkmanagmentapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_check);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.toolbar_layout);

//        CustomControl btnUp = (CustomControl) findViewById(R.id.custom_button);
//        try {
//            btnUp.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e(TAG, "onClick: ");
//                }
//            });
//        } catch (Exception e) {
//            Log.e(TAG, "" + e.getMessage());
//        }
    }
}
