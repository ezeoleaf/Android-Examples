package com.example.android_examples;

import android.app.Activity;
import android.os.Bundle;

public class GFX extends Activity{

	Maxwell ourView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ourView = new Maxwell(this);
		setContentView(ourView);
	}
	
}
