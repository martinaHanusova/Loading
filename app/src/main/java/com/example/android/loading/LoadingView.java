// Credit for https://futurestud.io

package com.example.android.loading;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LoadingView extends LinearLayout {

    private Handler mHandler;

    ImageView first;
    ImageView two;
    ImageView three;
    ImageView four;
    ImageView five;

    int loadPosition = 0;

    public LoadingView(Context context) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.loading_view, this);

        first = findViewById(R.id.loading_view_one);
        two = findViewById(R.id.loading_view_two);
        three = findViewById(R.id.loading_view_three);
        four = findViewById(R.id.loading_view_four);
        five = findViewById(R.id.loading_view_five);

        mHandler = new Handler();
        mStatusChecker.run();
    }

    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            displayLoadingPosition(loadPosition);

            loadPosition++;

            mHandler.postDelayed(mStatusChecker, 500);
        }
    };

    private void displayLoadingPosition(int loadPosition) {
        int emphasizedViewPos = loadPosition % 5;

        first.setImageResource(R.drawable.plane_light);
        two.setImageResource(R.drawable.plane_light);
        three.setImageResource(R.drawable.plane_light);
        four.setImageResource(R.drawable.plane_light);
        five.setImageResource(R.drawable.plane_light);

        switch (emphasizedViewPos) {
            case 0:
                first.setImageResource(R.drawable.plane_dark);
                break;

            case 1:
                two.setImageResource(R.drawable.plane_dark);
                break;

            case 2:
                three.setImageResource(R.drawable.plane_dark);
                break;

            case 3:
                four.setImageResource(R.drawable.plane_dark);
                break;

            case 4:
                five.setImageResource(R.drawable.plane_dark);
                break;
        }
    }
}
