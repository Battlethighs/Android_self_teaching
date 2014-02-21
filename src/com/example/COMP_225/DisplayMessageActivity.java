package com.example.COMP_225;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by ahansen4 on 2/19/14.
 */
public class DisplayMessageActivity extends Activity {

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        String[] addends = message.split(",");
        String toPrint;
        Integer sum = 0;

        for (String numStr : addends){
            Integer num = Integer.parseInt(numStr);
            sum += num;
        }

        String sumStr = sum.toString();
        message = "The sum is: " + sumStr;

        TextView textView = new TextView(this);
        textView.setTextSize(30);
        textView.setText(message);

        setContentView(textView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}