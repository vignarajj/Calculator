package com.sci.cal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
//import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Regcalc extends Activity {
    AdView adview;
	EditText txtCalc=null;
	ImageButton btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,
		                    btnPlus,btnMinus,btnMultiply,btnDivide,btnEquals,btnC,btnDecimal,btnMC,btnMR,btnMM,btnMP,btnBS,btnPerc,
		                    btnSqrRoot,btnPM;
	
	private double num = 0;
	private double memNum = 0;
	private int operator = 1; 
	
	private boolean readyToClear = false;
	private boolean hasChanged = false;
					
	
	//for gesture
	private GestureDetector gestureDetector;
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
				 	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.normalcalc);
	
	//for ad 
	LinearLayout lay=(LinearLayout)findViewById(R.id.lay1);
	adview =new AdView(Regcalc.this, AdSize.BANNER, "a14f6187339eab5");
	lay.addView(adview);
	//AdRequest request = new AdRequest();
   // request.setTesting(true);
    adview.loadAd(new AdRequest());	
	
	//for gesture
    gestureDetector=new GestureDetector(new MyGestureDetector());
    View gesturefling=(View)findViewById(R.id.nor);
    gesturefling.setOnTouchListener(new View.OnTouchListener() {
				
    
    	
    	public boolean onTouch(View v, MotionEvent event) {
            if (gestureDetector.onTouchEvent(event)) {
                return true;
            }
            return false;
        }
	});
						
	txtCalc = (EditText) findViewById(R.id.txtCalc);
	btnZero = (ImageButton) findViewById(R.id.btnZero);
	btnOne = (ImageButton) findViewById(R.id.btnOne);
	btnTwo = (ImageButton) findViewById(R.id.btnTwo);
	btnThree = (ImageButton) findViewById(R.id.btnThree);
	btnFour = (ImageButton) findViewById(R.id.btnFour);
	btnFive = (ImageButton) findViewById(R.id.btnFive);
	btnSix = (ImageButton) findViewById(R.id.btnSix);
	btnSeven = (ImageButton) findViewById(R.id.btnSeven);
	btnEight = (ImageButton) findViewById(R.id.btnEight);
	btnNine = (ImageButton) findViewById(R.id.btnNine);
	btnPlus = (ImageButton) findViewById(R.id.btnPlus);
	btnMinus = (ImageButton) findViewById(R.id.btnMinus);
	btnMultiply = (ImageButton) findViewById(R.id.btnMultiply);
	btnDivide = (ImageButton) findViewById(R.id.btnDivide);
	btnEquals = (ImageButton) findViewById(R.id.btnEquals);
	btnC = (ImageButton) findViewById(R.id.btnC);
	btnDecimal = (ImageButton) findViewById(R.id.btnDecimal);
	btnMC = (ImageButton) findViewById(R.id.btnMC);
	btnMR = (ImageButton) findViewById(R.id.btnMR);
	btnMM = (ImageButton) findViewById(R.id.btnMM);
	btnMP = (ImageButton) findViewById(R.id.btnMP);
	btnBS = (ImageButton) findViewById(R.id.btnBS);
	btnPerc = (ImageButton) findViewById(R.id.btnPerc);
	btnSqrRoot = (ImageButton) findViewById(R.id.btnSqrRoot);
	btnPM = (ImageButton) findViewById(R.id.btnPM);
									
					  btnZero.setOnClickListener(new OnClickListener() {
					  public void onClick(View v) {
							handleNumber(0);
						}
						});
					   btnOne.setOnClickListener(new OnClickListener() {
					    public void onClick(View v) {
						     handleNumber(1);
						}
						});
						btnTwo.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleNumber(2);
						}
						});
						btnThree.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleNumber(3);
						}
						});
						btnFour.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleNumber(4);
						}
						});
						btnFive.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleNumber(5);
						}
						});
						btnSix.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleNumber(6);
						}
						});
						btnSeven.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleNumber(7);
						}
						});
						btnEight.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleNumber(8);
						}
						});
						btnNine.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleNumber(9);
						}
						});
						btnPlus.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleEquals(1);
							readyToClear = true;
						}
						});
						btnMinus.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleEquals(2);
							readyToClear = true;
						}
						});
						btnMultiply.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleEquals(3);
							readyToClear = true;
						}
						});
						btnDivide.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleEquals(4);
							readyToClear = true;
						}
						});
						btnEquals.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleEquals(0);
						}
						});
						btnC.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							reset();
						}
						});
						btnDecimal.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleDecimal();
						}
						});
						btnPM.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handlePlusMinus();
						}
						});
						btnMC.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							memNum = 0;
						}
						});
						btnMR.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							setValue(Double.toString(memNum));
						}
						});
						btnMM.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							memNum = memNum
									- Double.parseDouble(txtCalc.getText().toString());
							operator = 0;
						}
						});
						btnMP.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							memNum = memNum
									+ Double.parseDouble(txtCalc.getText().toString());
							operator = 0;
						}
						});
						btnBS.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							handleBackspace();
						}
						});
						btnSqrRoot.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							setValue(Double.toString(Math.sqrt(Double.parseDouble(txtCalc
									.getText().toString()))));
						}
						});
						btnPerc.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							setValue(Double.toString(num* (0.01 * Double.parseDouble(txtCalc.getText()
											.toString()))));
						}
						});
			

	txtCalc.setOnKeyListener(new OnKeyListener() {
		public boolean onKey(View v, int i, android.view.KeyEvent e) {
			if (e.getAction() == KeyEvent.ACTION_DOWN) {
				int keyCode = e.getKeyCode();

				// txtCalc.append("["+Integer.toString(keyCode)+"]");

				switch (keyCode) 
				{
				case KeyEvent.KEYCODE_0:
					handleNumber(0);
					break;

				case KeyEvent.KEYCODE_1:
					handleNumber(1);
					break;

				case KeyEvent.KEYCODE_2:
					handleNumber(2);
					break;

				case KeyEvent.KEYCODE_3:
					handleNumber(3);
					break;

				case KeyEvent.KEYCODE_4:
					handleNumber(4);
					break;

				case KeyEvent.KEYCODE_5:
					handleNumber(5);
					break;

				case KeyEvent.KEYCODE_6:
					handleNumber(6);
					break;

				case KeyEvent.KEYCODE_7:
					handleNumber(7);
					break;

				case KeyEvent.KEYCODE_8:
					handleNumber(8);
					break;

				case KeyEvent.KEYCODE_9:
					handleNumber(9);
					break;

				case 43:
					handleEquals(1);
					break;

				case KeyEvent.KEYCODE_EQUALS:
					handleEquals(0);
					break;

				case KeyEvent.KEYCODE_MINUS:
					handleEquals(2);
					break;

				case KeyEvent.KEYCODE_PERIOD:
					handleDecimal();
					break;

				case KeyEvent.KEYCODE_C:
					reset();
					break;

				case KeyEvent.KEYCODE_SLASH:
					handleEquals(4);
					break;
				
				case KeyEvent.KEYCODE_BACK:
					AlertDialog ad=new AlertDialog.Builder(Regcalc.this).create();
					ad.setTitle("Confirm");
					ad.setMessage("Do you want to leave this app?");
					ad.setIcon(R.drawable.alert);
					ad.setButton("Ok", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						Intent i =new Intent(Intent.ACTION_MAIN);
						i.addCategory(Intent.CATEGORY_HOME);
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivityForResult(i, which);
						android.os.Process.killProcess(0);
						System.exit(which);
						
						}
					});
					
					ad.setButton2("Cancel", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
					ad.show();
					//finish();
					break;
				case KeyEvent.KEYCODE_MENU:
					Intent men=new Intent(Regcalc.this,dialg.class);
					startActivity(men);
					return true;
				default:
				}					
			}
			return true;
		}
	});
	reset();
	}
			//initScreenLayout();

		/*private void initScreenLayout() {
			// TODO Auto-generated method stub

			DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
		}*/

	private void handleEquals(int newOperator) {
		if (hasChanged) {
			switch (operator) {
			case 1:
				num = num + Double.parseDouble(txtCalc.getText().toString());
				break;
			case 2:
				num = num - Double.parseDouble(txtCalc.getText().toString());
				break;
			case 3:
				num = num * Double.parseDouble(txtCalc.getText().toString());
				break;
			case 4:
				num = num / Double.parseDouble(txtCalc.getText().toString());
				break;
			}

			String txt = Double.toString(num);
			txtCalc.setText(txt);
			txtCalc.setSelection(txt.length());

			readyToClear = false;
			hasChanged = false;
		}

		operator = newOperator;
	}

	private void handleNumber(int num) {
		if (operator == 0)
			reset();

		String txt = txtCalc.getText().toString();
		if (readyToClear) {
			txt = "";
			readyToClear = false;
		} else if (txt.equals("0"))
			txt = "";

		txt = txt + Integer.toString(num);

		txtCalc.setText(txt);
		txtCalc.setSelection(txt.length());

		hasChanged = true;
	}

	private void reset() {
		// TODO Auto-generated method stub
		num = 0;
		txtCalc.setText("0");
		txtCalc.setSelection(1);
		operator = 1;
	}
	private void setValue(String value) {
		if (operator == 0)
			reset();

		if (readyToClear) {
			readyToClear = false;
		}

		txtCalc.setText(value);
		txtCalc.setSelection(value.length());

		hasChanged = true;
	}

	private void handleDecimal() {
		if (operator == 0)
			reset();

		if (readyToClear) {
			txtCalc.setText("0.");
			txtCalc.setSelection(2);
			readyToClear = false;
			hasChanged = true;
		} else {
			String txt = txtCalc.getText().toString();

			if (!txt.contains(".")) {
				txtCalc.append(".");
				hasChanged = true;
			}
		}
	}

	private void handleBackspace() {
		if (!readyToClear) {
 			String txt = txtCalc.getText().toString();
 			if (txt.length() > 0) {
 				txt = txt.substring(0, txt.length() - 1);
 				if (txt.equals(""))
 					txt = "0";

 				txtCalc.setText(txt);
 				txtCalc.setSelection(txt.length());
 			}
 		}
 	}

	private void handlePlusMinus() {
		if (!readyToClear) {
			String txt = txtCalc.getText().toString();
			if (!txt.equals("0")) {
				if (txt.charAt(0) == '-')
					txt = txt.substring(1, txt.length());
				else
					txt = "-" + txt;

				txtCalc.setText(txt);
				txtCalc.setSelection(txt.length());
			}
		}
	}
	//class for gesture
	class MyGestureDetector extends SimpleOnGestureListener
	{
	    @Override
		public boolean onFling(MotionEvent e1,MotionEvent e2,float velocityX,float velocityY)
		{
			Intent in1=new Intent(Regcalc.this,Scicalc.class);
			if(Math.abs(e1.getY()-e2.getY())>SWIPE_MAX_OFF_PATH)
			{
				return false;	
			}
	        // right to left swipe
	        if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
	        {
					startActivity(in1);
					Regcalc.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					
	        }
				// right to left swipe
	        else if(e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
	        {
					startActivity(in1);
					Regcalc.this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
					
	        }
	        return false;

		}
		 // It is necessary to return true from onDown for the onFling event to register
	    @Override
	    public boolean onDown(MotionEvent e) {
	        	return true;
	    }
	}
	
	//for option menu
//public boolean OncreateOptionsMenu(Menu menu)
//{ 
//	MenuInflater inflater=getMenuInflater();
//	inflater.inflate(R.menu.info, menu);
//	return true;
//}
//public boolean OnOptionsItemSelected(MenuItem item)
//{
//	switch(item.getItemId())
//	{
//	case R.id.info:
//		Intent rinfo = new Intent(Regcalc.this,Reginfo.class);
//		startActivity(rinfo);
//		break;
//	case R.id.scie:
//		Intent regtosci = new Intent(Regcalc.this,Scicalc.class);
//		startActivity(regtosci);
//		break;
//		
//	}
//	return true;
//	
//}
}
