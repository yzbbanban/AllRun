package com.tarena.allrun.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.tarena.allrun.TAppliction;

import android.util.Log;

public class ExceptionUtil {
	public static void handleException(Throwable ex) {
		// �ж�������������ϻ����ڿ�����
		if (TAppliction.ISRELEASE) {
			// �ռ��쳣��Ϣ
			String info = ex.getMessage();
			Log.i("uncaughtException", "info=" + info);

			StringWriter stringWriter = new StringWriter();

			PrintWriter printWriter = new PrintWriter(stringWriter);
			// ��ϸ�쳣��Ϣ��ӡ��printWriter
			// printWriter�ְ���Ϣ��StringWirter
			// ͨ��stringWriterת��string
			ex.printStackTrace(printWriter);
			info = stringWriter.toString();
			Log.i("uncaughtException", "info=" + info);

			// �������͸���������
			// ������Աͨ����������ʱ���쳣��Ϣ
		} else {
			ex.printStackTrace();
		}
	}
}
