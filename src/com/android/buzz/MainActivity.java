package com.android.buzz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn500 = (Button)findViewById(R.id.btn500);
		Button btn1000 = (Button)findViewById(R.id.btn1000);
		Button btn1500 = (Button)findViewById(R.id.btn1500);
		Button btn2000 = (Button)findViewById(R.id.btn2000);
		Button btnStop = (Button)findViewById(R.id.btnStop);
		
		btn500.setOnClickListener(this);
		btn1000.setOnClickListener(this);
		btn1500.setOnClickListener(this);
		btn2000.setOnClickListener(this);
		btnStop.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		AplexBuzz.disable();								// disable buzzer
		finish();
	}
	
	@Override
	public void onClick(View button) {
		String text = ((Button)button).getText().toString().trim();
		
		if ("stop".compareTo(text) == 0) {
			AplexBuzz.disable();							// disable buzzer
		} else {
			AplexBuzz.setFrequency(Integer.valueOf(text));	// set buzzer frequency
			AplexBuzz.enable();								// enable setted frequency 
		}
	}

}
