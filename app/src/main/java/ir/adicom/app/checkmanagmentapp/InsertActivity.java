package ir.adicom.app.checkmanagmentapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by adicom on 12/6/16.
 */

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomControl customBtn1, customBtn2, customBtn3;
    private DBHelper dbHelper;
    private EditText edtPrice, edtVajhe, edtBabat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_check);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_layout);

        dbHelper = new DBHelper(this);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnBack.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        edtPrice = (EditText) findViewById(R.id.edtPrice);
        edtVajhe = (EditText) findViewById(R.id.edtVajhe);
        edtBabat = (EditText) findViewById(R.id.edtBabat);

        customBtn1 = (CustomControl) findViewById(R.id.custom_btn_1);
        customBtn2 = (CustomControl) findViewById(R.id.custom_btn_2);
        customBtn3 = (CustomControl) findViewById(R.id.custom_btn_3);
        try {
            customBtn1.setNumber(1395);
            customBtn1.setMinMax(1395, 1399);
            customBtn1.setLen(4);
            customBtn1.setUp();
            customBtn2.setNumber(9);
            customBtn2.setMinMax(1, 12);
            customBtn2.setLen(2);
            customBtn2.setUp();
            customBtn3.setNumber(1);
            customBtn3.setMinMax(1, 31);
            customBtn3.setLen(2);
            customBtn3.setUp();
        } catch (Exception e) {
            Log.e(G.TAG, "" + e.getMessage());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnBack) {
            finish();
        }
        if (id == R.id.btnSubmit) {
            String date = customBtn1.getText() + "/" + customBtn2.getText() + "/" + customBtn3.getText();
            if (edtPrice.getText().length() > 0
                    || edtVajhe.getText().length() > 0
                    || edtBabat.getText().length() > 0) {
                Check check = new Check();
                check.setPrice(edtPrice.getText().toString());
                check.setVajhe(edtVajhe.getText().toString());
                check.setBabat(edtBabat.getText().toString());
                check.setDate(date);
                dbHelper.addCheck(check);
            } else {
                Toast.makeText(this, "لطفا فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
