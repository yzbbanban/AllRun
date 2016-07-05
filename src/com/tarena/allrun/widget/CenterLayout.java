package com.tarena.allrun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CenterLayout extends ViewGroup {

	public CenterLayout(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// ����ÿ���ӿؼ�
		int childCount = getChildCount();
		for (int i = 0; i < childCount; i++) {
			// �õ��ӿؼ�
			View childView = getChildAt(i);
			// �����ӿؼ�
			childView.measure(widthMeasureSpec, heightMeasureSpec);
		}
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int childViewCount = this.getChildCount();
		// �õ��ӿؼ�
		View animationView = this.getChildAt(0);
		View shadeView = this.getChildAt(1);
		// ģ���linearLayout
		animationView.layout(0, 0, 120, 120);
		shadeView.layout(120, 120, 1080, 120 + 100);

	}

}
