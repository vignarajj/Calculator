package com.sci.cal;;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class dlgtt extends Activity{
	ImageButton inf02,hlp;
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.dlgt);
	inf02=(ImageButton)findViewById(R.id.info1);
	hlp=(ImageButton)findViewById(R.id.help);
	inf02.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent inf2=new Intent(dlgtt.this,infopg.class);
			startActivity(inf2);
		}
	});
	hlp.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent hl=new Intent(dlgtt.this,Reginfo.class);
			startActivity(hl);
		}
	});
}
public void onPause()
{
	super.onPause();
	finish();
}
}
