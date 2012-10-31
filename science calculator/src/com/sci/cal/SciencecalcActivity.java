package com.sci.cal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SciencecalcActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try
				{
					int waited=0;
					while(waited<100)
					{
					Thread.sleep(4000);
					waited+=100;
					}
				}
				catch(InterruptedException e)
				{
				}
				finally
				{
					
					Intent i=new Intent();
					i.setClass(SciencecalcActivity.this,Regcalc.class);
					startActivity(i);
				}
				
			}
		}).start();
    }
}