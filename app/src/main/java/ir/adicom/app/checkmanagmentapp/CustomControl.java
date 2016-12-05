package ir.adicom.app.checkmanagmentapp;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by adicom on 12/5/16.
 */

public class CustomControl extends LinearLayout {

    LinearLayout linearLayout;
    Button btnDown, btnUp;
    TextView tvText;
    int number = 0;

    public CustomControl(Context context) {
        super(context);
        init(context);
    }

    public CustomControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomControl(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflate(context, R.layout.custom_layout, null);
        view = inflater.inflate(R.layout.custom_layout, this, true);

        tvText = (TextView) view.findViewById(R.id.tv_custom);
        btnDown = (Button) view.findViewById(R.id.btn_custom_down);
        btnUp = (Button) view.findViewById(R.id.btn_custom_up);
        tvText.setText("" + number);

        linearLayout = (LinearLayout) view.findViewById(R.id.custom_layout);

        btnUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                tvText.setText("" + number);
            }
        });

        btnDown.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number--;
                tvText.setText("" + number);
            }
        });
        //addView(view);
    }
}