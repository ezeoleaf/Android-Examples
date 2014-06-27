package com.maxwell.android_examples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BundleReciver extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tvMessage = new TextView(this);
		TextView tvReciver = new TextView(this);
		String data1, data2;
		
		tvMessage.setText("Es el momento de recibir los datos del Bundle!");
		setContentView(tvMessage);
		
		Bundle getDatos = getIntent().getExtras();
		data1 = getDatos.getString("data_1");
		data2 = getDatos.getString("data_2");
		
		tvReciver.setText(data1 + "\n" + data2);
		setContentView(tvReciver);
	}
}
