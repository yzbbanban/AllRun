package com.tarena.allrun.util;

import android.util.Log;

import com.tarena.allrun.TAppliction;

//��־������
public class LogUtil {
	public static void i(String tag, Object msg) {
		if (TAppliction.ISRELEASE) {
			// �������û��������
			return;
		}
     //������
		Log.i(tag, String.valueOf(msg));
	}
	
//	public static void i(String tag,int msg)
//	{
//		i(tag,String.valueOf(msg));
//	}
}
