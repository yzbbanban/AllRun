package com.tarena.allrun;

import com.tarena.allrun.activity.BaseActivity;
import com.tarena.allrun.activity.MainFragmentActivity;
import com.tarena.allrun.widget.AnimationView;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends BaseActivity {
	AnimationView animationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom1603);
		animationView = (AnimationView) findViewById(R.id.animationView);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				// startActivity(
				// new Intent(MainActivity.this,
				// MainFragmentActivity.class));
			}
		}, 2000);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int width = animationView.getWidth();
		int height = animationView.getHeight();
		Log.i("widthheight", width + "," + height);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
