package com.tarena.allrun.widget;

import com.tarena.allrun.R;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

//�Զ��嶯���ؼ�
public class AnimationView extends View {
	Bitmap[] array;
	int index=0;
	Thread thread;
	boolean isRunning=true;
	int viewWidth,viewHeight;
	float sleepTime;
	//�����ؼ���С
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		//ͼƬ�Ĵ�С���ǿؼ��Ĵ�С
		int imageWidth=array[0].getWidth();
		int imageHeight=array[0].getHeight();
		//�ѵ�ͼ�Ĵ�С���óɿؼ��Ĵ�С
		setMeasuredDimension(imageWidth, imageHeight);
	}
	class MyRunnable implements Runnable
	{

		@Override
		public void run() {
			while (isRunning) {
				try {
					index++;
					if (index>array.length-1)
					{
						index=0;
					}
					
					//���̵߳�onDraw()��invalidate();
					//�����̵߳�onDraw()
					postInvalidate();
					Log.i("ondraw()", "run index="+index+","+System.currentTimeMillis());

					Thread.currentThread().sleep((int)sleepTime);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
		}
		
	}

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
	//�Ӳ����ļ��ж�ȡ�Զ�������
		TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.AnimationView);
		sleepTime=typedArray.getFloat(R.styleable.AnimationView_sleep_time, 0);
	//��ȡ����
		Resources resources=getResources();
		TypedArray imageIDArray=resources.obtainTypedArray(R.array.animationImages);
		int length=imageIDArray.length();
		array=new Bitmap[length];
		for (int i=0;i<length;i++)
		{
			//�������ж�ȡͼ��id 
			int imageId=imageIDArray.getResourceId(i, 0);
			//����ͼ��id��ȡͼ
			array[i]=BitmapFactory.decodeResource(resources, imageId);
		}
		thread=new Thread(new MyRunnable());
		thread.start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		try {
			Paint paint=new Paint();
			paint.setColor(Color.RED);
			//������
			Rect rect=new Rect(0, 0, viewWidth, viewHeight);
			canvas.drawRect(rect, paint);
			
			Bitmap bitmap=array[index];
			
			canvas.drawBitmap(bitmap, 0, 0, paint);
			Log.i("ondraw()", "index="+index+",bitmap="+bitmap.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
viewHeight=h;
viewWidth=w;
		super.onSizeChanged(w, h, oldw, oldh);
	}
}
