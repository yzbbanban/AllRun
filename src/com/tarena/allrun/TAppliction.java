package com.tarena.allrun;

import java.util.ArrayList;

import com.baidu.mapapi.SDKInitializer;
import com.tarena.allrun.util.CrashHandler;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

public class TAppliction extends Application{
	public ArrayList<Activity> activityList=
			new ArrayList<Activity>();
	public void finishActivity()
	{
		for (Activity activity:activityList)
		{
			try {
				activity.finish();
			} catch (Exception e) {
			}
		}
		Process.killProcess(Process.myPid());
	}
	@Override
	public void onCreate() {
		super.onCreate();
		//��ʼ����ͼ
		SDKInitializer.initialize(this);
//		CrashHandler crashHandler=new CrashHandler(this);
//		//�����쳣û�м�catch,��ܵ�crashHandler
//		Thread
//		.setDefaultUncaughtExceptionHandler
//		(crashHandler);
	}

}
