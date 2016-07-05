package com.tarena.allrun.widget;

import com.tarena.allrun.R;
import com.tarena.allrun.util.DisplayUtil;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

//��Ӱ�ؼ�
public class ShadeView extends View {
	String text;
	int textColor, shadeColor;
	float textSize;
	int shadeSize = 5;
	int stringWidth;
	int stringHeight;

	public ShadeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.Shade);
		text = typedArray.getString(R.styleable.Shade_text);
		textColor = typedArray.getColor(R.styleable.Shade_text_color,
				Color.BLACK);
		shadeColor = typedArray.getColor(R.styleable.Shade_shade_color,
				Color.GRAY);
		//�õ�ֵ���ٶ���λ��dp
		textSize = typedArray.getFloat(R.styleable.Shade_text_size, 24);
		//��dpת��px
		textSize=DisplayUtil.dp2px(getContext(), textSize);
		shadeSize = (int) (textSize / 10);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// ��rect�����ֵĿ�ȣ��߶�
		Paint paint = new Paint();
		paint.setTextSize(textSize);
		Rect sizeRect = new Rect();
		paint.getTextBounds(text, 0, text.length(), sizeRect);
		// ���ֵĿ�ȣ��߶ȾͿؼ��Ŀ�ȣ��߶�
		stringWidth = sizeRect.width();
		stringHeight = sizeRect.height();
		// ���⣺���ֵ������е���ʾ������
		// ������������ӿؼ��ĸ߶�
		int viewHeight = (int) (stringHeight * 1.2);
		setMeasuredDimension(stringWidth, viewHeight);

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		Paint paint = new Paint();
		paint.setTextSize(textSize);
		// ����Ӱ
		paint.setColor(shadeColor);
		canvas.drawText(text, shadeSize, stringHeight + shadeSize, paint);
		// ������
		paint.setColor(textColor);
		canvas.drawText(text, 0, stringHeight, paint);

	}

}
