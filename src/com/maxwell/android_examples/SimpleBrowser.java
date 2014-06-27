package com.maxwell.android_examples;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener{
	
	EditText url;
	WebView ourBrowser;
	Button go, back, refresh, forward, clearHistory;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		
		ourBrowser = (WebView) findViewById(R.id.wvBrowser);
		ourBrowser.getSettings().setJavaScriptEnabled(true);
		ourBrowser.getSettings().setLoadWithOverviewMode(true);
		ourBrowser.getSettings().setUseWideViewPort(true);
		
		try{
		ourBrowser.loadUrl("http://www.google.com/");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ourBrowser.setWebViewClient(new WebViewClient(){
			@Override 
			public boolean shouldOverrideUrlLoading(WebView view, String url) { 
				return super.shouldOverrideUrlLoading(view, url);
			}
		});
		
		go = (Button) findViewById(R.id.bGo);
		back = (Button) findViewById(R.id.bBack);
		refresh = (Button) findViewById(R.id.bRefresh);
		forward = (Button) findViewById(R.id.bForward);
		clearHistory = (Button) findViewById(R.id.bClear);
		url = (EditText) findViewById(R.id.etURL);
		
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		refresh.setOnClickListener(this);
		forward.setOnClickListener(this);
		clearHistory.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bGo:
			String webSite = url.getText().toString();
			ourBrowser.loadUrl(webSite);
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bBack:
			if(ourBrowser.canGoBack())
				ourBrowser.goBack();
			break;
		case R.id.bRefresh:
			ourBrowser.reload();
			break;
		case R.id.bForward:
			if(ourBrowser.canGoForward())
				ourBrowser.goForward();
			break;
		case R.id.bClear:
			ourBrowser.clearHistory();
			break;	
		}
	}

}
