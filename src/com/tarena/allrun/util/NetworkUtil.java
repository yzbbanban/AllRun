package com.tarena.allrun.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

public class NetworkUtil {
	public static void checkNetwork(final Activity activity) {
		try {
			// 1,�ж���û������,��Ȩ��ACCESS_NETWORK_STATE
			ConnectivityManager manager = (ConnectivityManager) activity
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
			if (activeNetworkInfo == null) {
				// 2,û������,��ʾdialog
				AlertDialog.Builder dialog = new Builder(activity);
				dialog.setMessage("�ף�����û��");
				dialog.setNegativeButton("ȡ��", null);
				dialog.setPositiveButton("������", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						try {
							int osVersion = Build.VERSION.SDK_INT;
							String phoneType = Build.MODEL;
							String phoneConstr = Build.MANUFACTURER;

							if (osVersion > 10) {

								// 3,��ϵͳ�Դ����������activity

								// ���������������
								Intent intent = new Intent(
										Settings.ACTION_WIRELESS_SETTINGS);
								activity.startActivity(intent);
								dialog.cancel();
							}

						} catch (Exception e) {
							ExceptionUtil.handleException(e);
						}
					}
				});

				dialog.show();

			}
		} catch (Exception e) {
			ExceptionUtil.handleException(e);
		}
	}
}
