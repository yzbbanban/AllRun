package com.tarena.allrun.widget;

import com.tarena.allrun.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class AnimationView extends View {
	Bitmap[] array;
	int index = 0;
	Thread thread;
	boolean isRunning = true;
	int height;
	int width;

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		array = new Bitmap[4];
		array[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.logo1);
		array[1] = BitmapFactory.decodeResource(getResources(),
				R.drawable.logo2);
		array[2] = BitmapFactory.decodeResource(getResources(),
				R.drawable.logo3);
		array[3] = BitmapFactory.decodeResource(getResources(),
				R.drawable.logo4);
		thread = new Thread(new MyRunnable());
		thread.start();
	}

	/**
	 * ÏÔÊ¾Í¼Æ¬
	 * 
	 * @author tarena
	 * 
	 */
	class MyRunnable implements Runnable {
		@Override
		public void run() {
			try {
				while (isRunning) {
					index++;
					if (index > array.length - 1) {
						index = 0;
					}
					postInvalidate();
					Thread.currentThread().sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ÀLÑuˆDÆ¬
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		try {

			Paint paint = new Paint();
			paint.setColor(Color.RED);

			RectF r = new RectF(0, 0, width, height);
			canvas.drawRect(r, paint);
			Bitmap bitmap = array[index];
			canvas.drawBitmap(bitmap, 0, 0, paint);

		} catch (Exception e) {
			// TODO: handle exception
		}
		super.onDraw(canvas);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		height = h;
		width = w;
		super.onSizeChanged(w, h, oldw, oldh);
	}

}
