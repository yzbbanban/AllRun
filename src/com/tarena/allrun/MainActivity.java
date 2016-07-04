package com.tarena.allrun;

import com.tarena.allrun.activity.BaseActivity;
import com.tarena.allrun.activity.MainFragmentActivity;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TAppliction tAppliction=
//        		(TAppliction) 
//        		getApplication();
//        tAppliction.activityList.add(this);
        
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
startActivity(
		new Intent(MainActivity.this,
				MainFragmentActivity.class));				
			}
			
		}, 2000);
  
    }
    @Override
    protected void onDestroy() {
//    	TAppliction tAppliction=		(TAppliction) 
//        		getApplication();
//    	tAppliction.activityList.remove(this);
    	super.onDestroy();
    	
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
String s=null;
s.toCharArray();
    	return super.onTouchEvent(event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
