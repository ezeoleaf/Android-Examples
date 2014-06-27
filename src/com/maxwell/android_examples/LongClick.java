package com.maxwell.android_examples;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

public class LongClick extends Activity implements OnLongClickListener{
	
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setText("accion de long click desactivada...haceme click :)");
		tv.setTextSize(25);
		View v = new View(this);
		tv.setOnLongClickListener(this);
		setContentView(v);
		setContentView(tv);
	}

	@Override
	public boolean onLongClick(View v) {
		tv.setText("accion de long click activada!");
		return false;
	}
}
