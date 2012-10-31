package com.sci.cal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class dialg extends Activity
{
	ImageButton info,calc;
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.dlg);
	info=(ImageButton)findViewById(R.id.info);
	calc=(ImageButton)findViewById(R.id.scien);
	info.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent inf1=new Intent(dialg.this,infopg.class);
			startActivity(inf1);
		}
	});
	calc.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent sc=new Intent(dialg.this,Scicalc.class);
			startActivity(sc);
		}
	});
}
public void onPause()
{
	super.onPause();
	finish();
}
}
