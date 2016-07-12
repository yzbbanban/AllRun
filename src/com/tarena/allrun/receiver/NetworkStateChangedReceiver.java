package com.tarena.allrun.receiver;

import com.tarena.allrun.TAppliction;
import com.tarena.allrun.util.ExceptionUtil;
import com.tarena.allrun.util.LogUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

//�û������������
public class NetworkStateChangedReceiver extends BroadcastReceiver {
//��һ�֣�ʹ�þ�̬����
	//static boolean isOpenMobile=false;
	@Override
	public void onReceive(Context context, Intent intent) {
		try {
			// �ж��û��ǹ������Ǵ�����
			ConnectivityManager manager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
			if (activeNetworkInfo == null) {
				LogUtil.i("������", "�û� ������");
				TAppliction.networkIsNone=true;

			} else {
				// �ж��û��򿪵����ƶ����绹��wifi
				// ��Ӱ
				// ����100MB 1MB��1��Ǯ
				// 4G 1��100MB 1�� 24*60*60*100*1=
				// ���ƶ������£���������ʾ���������ƶ����磬���ػ�������á�
				NetworkInfo mobileNetwork = manager
						.getNetworkInfo(manager.TYPE_MOBILE);
				if (mobileNetwork != null && mobileNetwork.isConnected()) {
					LogUtil.i("������", "�û��򿪵����ƶ�����");
					//isOpenMobile=true;
					TAppliction.networkIsMobile=true;
				}

				NetworkInfo wifiNetworkInfo = manager
						.getNetworkInfo(manager.TYPE_WIFI);
				if (wifiNetworkInfo != null && wifiNetworkInfo.isConnected()) {
					LogUtil.i("������", "�û��򿪵���wifi����");
					TAppliction.networkIsWifi=true;

				}
			}
		} catch (Exception e) {
			ExceptionUtil.handleException(e);
		}
	}

}
