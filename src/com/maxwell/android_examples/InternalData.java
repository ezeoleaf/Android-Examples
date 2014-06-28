package com.maxwell.android_examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener{
	
	Button bSave, bLoad;
	EditText etData;
	TextView tvRes;
	FileOutputStream fos;
	String FILENAME = "InternalString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVars();
	}
	
	private void setupVars() {
		bSave = (Button) findViewById(R.id.bSave);
		bLoad = (Button) findViewById(R.id.bLoad);
		etData = (EditText) findViewById(R.id.etData);
		tvRes = (TextView) findViewById(R.id.tvRes);
		bSave.setOnClickListener(this);
		bLoad.setOnClickListener(this);
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSave:
			String data = etData.getText().toString();
			Log.i("my_info",data);
			try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.bLoad:
			new loadSomeStuff().execute(FILENAME);
			break;
		}
	}
	
	public class loadSomeStuff extends AsyncTask<String, Integer, String>{
		
		protected void onPreExecute(String f){
			f = "whatever";
		}
		
		@Override
		protected String doInBackground(String... params) {
			String collected = null;
			FileInputStream fis = null;
			try {
				fis = openFileInput(FILENAME);
				byte[] dataArray = new byte[fis.available()];
				while(fis.read(dataArray) != 1){
					collected = new String(dataArray);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					fis.close();
					return collected;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		
		protected void onProgressUpdated(Integer...progress){
			
		}
		
		protected void onPostExecute(String result){
			tvRes.setText(result);
			Log.i("my_info",result);
		}
	}	
}
