package com.tarena.allrun.activity;

import com.tarena.allrun.R;
import com.tarena.allrun.util.ExceptionUtil;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Shopping_Activity extends Activity {
	private WebView webView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taobao);
		try {
			webView = (WebView) findViewById(R.id.taobaoWebView);
			webView.loadUrl("https://www.baidu.com/");
			webView.setWebViewClient(new WebViewClient() {
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					return super.shouldOverrideUrlLoading(view, url);
				}
			});
			WebSettings settings = webView.getSettings();
			settings.setJavaScriptEnabled(true);

		} catch (Exception e) {
			ExceptionUtil.handleException(e);
		}

	}

}
