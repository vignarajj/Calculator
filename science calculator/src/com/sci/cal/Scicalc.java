package com.sci.cal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
//import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Scicalc extends Activity implements OnCheckedChangeListener
{
	AdView adview;
	EditText txtCalc=null;
 	ImageButton btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,
 	       btnNine,btnPlus,btnMinus,btnMultiply,btnDivide,btnEquals,btnC,btnDecimal,
 	       btnsin,btnsinh,btnasin,btncos,btncosh,btnacos,btntan,btntanh,btnatan,
 	       btnSqrRoot,btnPM,btne,btnlog,btnpi,btnexp,btn1x,btnin,btnpow,btnx1,btnx2,btnx3,btnbs;
 
 	private RadioGroup btnrg;
 	private double num = 0;
 	private int operator = 1; 
 	
 	private boolean readyToClear = false;
 	private boolean hasChanged = false;
 	
 	//for gesture
 	private GestureDetector gestureDetector;
 	private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
 	
 	/** Called when the activity is first created. */
 	//@Override
 	public void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.scientificcalc);
 		//for ad
 		 LinearLayout lay=(LinearLayout)findViewById(R.id.lay1);
	        adview =new AdView(Scicalc.this, AdSize.BANNER, "a14f6187339eab5");
	        lay.addView(adview);
	      // AdRequest request = new AdRequest();
//	        request.setTesting(true);
           adview.loadAd(new AdRequest());
	      
           //for gesture
	        gestureDetector=new GestureDetector(new MyGestureDetector());
	        View gesturefling=(View)findViewById(R.id.sci);
	        gesturefling.setOnTouchListener(new View.OnTouchListener() {
						
	        	public boolean onTouch(View v, MotionEvent event) {
	                if (gestureDetector.onTouchEvent(event)) {
	                    return true;
	                }
	                return false;
	            }
			});
	        
	        
 		       btnrg=(RadioGroup)findViewById(R.id.rg1);
	    		//btndeg.setChecked(true);
	    		
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
	    		
	    		btnsin = (ImageButton) findViewById(R.id.sin);
	    		btnsinh = (ImageButton) findViewById(R.id.sinh);
	    		btnasin = (ImageButton) findViewById(R.id.asin);
	    		
	    		btncos = (ImageButton) findViewById(R.id.cos);
	    		btncosh = (ImageButton) findViewById(R.id.cosh);
	    		btnacos = (ImageButton) findViewById(R.id.acos);
	    		
	    		btntan = (ImageButton) findViewById(R.id.tan);
	    		btntanh = (ImageButton) findViewById(R.id.tanh);
	    		btnatan = (ImageButton) findViewById(R.id.atan);
	    		
	    		
	    		btnSqrRoot = (ImageButton) findViewById(R.id.btnSqrRoot);
	    		btnPM = (ImageButton) findViewById(R.id.btnPM);
	    		btnlog=(ImageButton)findViewById(R.id.log);
	    		btne=(ImageButton)findViewById(R.id.e);
	    		btnexp=(ImageButton)findViewById(R.id.exp);
	    		btnpi=(ImageButton)findViewById(R.id.pi);
	    		btnpow=(ImageButton)findViewById(R.id.pow);
	    		btn1x=(ImageButton)findViewById(R.id.onex);
	    		btnin=(ImageButton)findViewById(R.id.In);
	    			    		
	    		btnbs=(ImageButton)findViewById(R.id.bs);
	    		btnx1=(ImageButton)findViewById(R.id.x1);
	    		btnx2=(ImageButton)findViewById(R.id.x2);
	    		btnx3=(ImageButton)findViewById(R.id.x3);
	    		
	            btnrg.setOnCheckedChangeListener(this);
	    		
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
	    		btnSqrRoot.setOnClickListener(new OnClickListener() {
	    			public void onClick(View v) {
	    				setValue(Double.toString(Math.sqrt(Double.parseDouble(txtCalc.getText().toString()))));
	    			}
	    		});
	    		btnlog.setOnClickListener(new OnClickListener() {
	    			public void onClick(View v) {
	    				setValue(String.valueOf(Math.log10(Double.valueOf(txtCalc.getText().toString()))));
	    			}
	    		});
	    		btn1x.setOnClickListener(new OnClickListener() {
	    			public void onClick(View v) {
	    				setValue(String.valueOf(1.0/Double.valueOf(txtCalc.getText().toString())));
	    	    	}
	    		});
	    		btnpi.setOnClickListener(new OnClickListener() {
	    			public void onClick(View v) {
	    			    setValue(String.valueOf(Math.PI));
	    			}
	    	   });
	    		btnexp.setOnClickListener(new OnClickListener() {
	    			public void onClick(View v) {
	    				setValue(Double.toString(Math.exp(Double.parseDouble(txtCalc.getText().toString()))));
	    			}
	    	   });
	    	   btnin.setOnClickListener(new OnClickListener() {
	    			public void onClick(View v) {
	    				setValue(Double.toString(Math.log(Double.parseDouble(txtCalc
	    						.getText().toString()))));
	    			}
	    	});
	    		
	    		btne.setOnClickListener(new OnClickListener() {
	    			public void onClick(View v) {
	    				
	    				setValue(String.valueOf(Math.E));
	    			}
	    		});
	    		btnpow.setOnClickListener(new OnClickListener() {
	    			public void onClick(View v) {

	    				handleEquals(5);
	    			}
	    	});
	    		
	    		btnx1.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						double j=Double.parseDouble(txtCalc.getText().toString());
						if(j>=68)
						{
							Toast.makeText(Scicalc.this, "enter value below 68", Toast.LENGTH_SHORT).show();
						}
						else
						{
						double var1=1; 
						for (double i = 1; i <= Double.parseDouble(txtCalc.getText().toString()); i++) 
						{ 
						var1 = var1 * i; 
						} 
						setValue(String.valueOf(var1)); 
						return;
						}
					}
				});
	    		
	    		btnx2.setOnClickListener(new OnClickListener() {
	    			
	    			public void onClick(View v) {
	    				// TODO Auto-generated method stub
	    				setValue(Double.toString(Math.pow(Double.valueOf(txtCalc.getText().toString()), 2)));
	    		}
	    		});
	    		
	    		btnx3.setOnClickListener(new OnClickListener() {
	    			
	    			public void onClick(View v) {
	    				// TODO Auto-generated method stub
	    				setValue(Double.toString(Math.pow(Double.valueOf(txtCalc.getText().toString()), 3)));
	    			}
	    		});
	    		
	    		btnbs.setOnClickListener(new OnClickListener() {
	    			
	    			public void onClick(View v) {
	    				// TODO Auto-generated method stub
	    				handleBackspace();
	    			}	
	    		});
	    	
	    		txtCalc.setOnKeyListener(new OnKeyListener() {
	    			public boolean onKey(View v, int i, android.view.KeyEvent e) {
	    				if (e.getAction() == KeyEvent.ACTION_DOWN) {
	    					int keyCode = e.getKeyCode();

	    					// txtCalc.append("["+Integer.toString(keyCode)+"]");

	    					switch (keyCode) {
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
	    						
	    						//for pow
	    					case KeyEvent.KEYCODE_POWER:
	    						handleEquals(5);
	    						break;
                         
	    					case KeyEvent.KEYCODE_BACK:
	    						finish();
	    						break;
	    					case KeyEvent.KEYCODE_MENU:
	    						Intent me=new Intent(Scicalc.this,dlgtt.class);
	    						startActivity(me);
	    						return true;
	    						default:
	    					}
	    				}

	    				return true;
	    			}
	    		});

 		reset();
 	}

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
 			case 5:
 				num=Math.pow(num,Double.parseDouble(txtCalc.getText().toString()));
 				break;
 				default:			
 			}

 			String txt = Double.toString(num);
 			txtCalc.setText(txt);
 			txtCalc.setSelection(txt.length());
 			hasChanged = false;
 			readyToClear=false;
 			
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
 			String txt1 = txtCalc.getText().toString();
 			if (txt1.length() > 0) {
 				txt1 = txt1.substring(0, txt1.length() - 1);
 				if (txt1.equals(""))
 					txt1 = "0";

 				txtCalc.setText(txt1);
 				txtCalc.setSelection(txt1.length());
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
 	private void reset() {
 		num = 0;
 		txtCalc.setText("0");
 		txtCalc.setSelection(1);
 		operator = 1;
 	}

 	public void onCheckedChanged(RadioGroup group, int checked) {
 		// TODO Auto-generated method stub
 		//int getid=group.getCheckedRadioButtonId();
 		//RadioButton rbtn=(RadioButton)findViewById(getid);
 		switch(checked)
 		{
 		case R.id.deg1:
 		
 		btnsin.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 	setValue(String.valueOf(Math.sin(Double.valueOf(Math.PI/180)*(Double.valueOf(txtCalc.getText().toString())))));
         }
 		});
 		btnsinh.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {	
 				setValue(String.valueOf(Math.sinh(Double.valueOf(Math.PI/180)*(Double.valueOf(txtCalc.getText().toString())))));
 		  }
 		});
 		btnasin.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 				setValue(String.valueOf(Math.asin(Double.valueOf(txtCalc.getText().toString()))*180/Math.PI ));
 		  }
 		});
 		
 		btncos.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 	            setValue(String.valueOf(Math.cos(Double.valueOf(Math.PI/180)*(Double.valueOf(txtCalc.getText().toString())))));
         }
 		});
 		btncosh.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {	
 				setValue(String.valueOf(Math.cosh(Double.valueOf(Math.PI/180)*(Double.valueOf(txtCalc.getText().toString())))));
 		  }
 		});
 		btnacos.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 				setValue(String.valueOf(Math.acos(Double.valueOf(txtCalc.getText().toString()))*180/Math.PI ));

 		  }
 		});
 		btntan.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 	            setValue(String.valueOf(Math.tan(Double.valueOf(Math.PI/180)*(Double.valueOf(txtCalc.getText().toString())))));
         }
 		});
 		btntanh.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {	
 				setValue(String.valueOf(Math.tanh(Double.valueOf(Math.PI/180)*(Double.valueOf(txtCalc.getText().toString())))));
 		  }
 		});
 		btnatan.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 				setValue(String.valueOf(Math.atan(Double.valueOf(txtCalc.getText().toString()))*180/Math.PI ));
 		  }
 		});

 		break;
 		case R.id.rad1:
 			
 			btnsin.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {
                      setValue(String.valueOf(Math.sin(Double.valueOf(txtCalc.getText().toString()))));
 	        }
 			});
 			btnsinh.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {	
 					 setValue(String.valueOf(Math.sinh(Double.valueOf(txtCalc.getText().toString()))));
 			  }
 			});
 			btnasin.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {
 					 setValue(String.valueOf(Math.asin(Double.valueOf(txtCalc.getText().toString()))));
 			  }
 		   });
 			
 			btncos.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {
                      setValue(String.valueOf(Math.cos(Double.valueOf(txtCalc.getText().toString()))));
 	        }
 			});
 			
 			btncosh.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {	
 					 setValue(String.valueOf(Math.cosh(Double.valueOf(txtCalc.getText().toString()))));
 			  }
 			});
 			btnacos.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {
 					 setValue(String.valueOf(Math.acos(Double.valueOf(txtCalc.getText().toString()))));
 			  }
 		   });
 			btntan.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {
                      setValue(String.valueOf(Math.tan(Double.valueOf(txtCalc.getText().toString()))));
 	        }
 			});
 			
 			btntanh.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {	
 					 setValue(String.valueOf(Math.tanh(Double.valueOf(txtCalc.getText().toString()))));
 			  }
 			});
 			btnatan.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {
 					 setValue(String.valueOf(Math.atan(Double.valueOf(txtCalc.getText().toString()))));
 			  }
 		   });
 			
 			break;
 			default:
 	   }
 		
 	}	

//class for gesture
class MyGestureDetector extends SimpleOnGestureListener
{
    
	public boolean onFling(MotionEvent e1,MotionEvent e2,float velocityX,float velocityY)
	{
		Intent in=new Intent(Scicalc.this,Regcalc.class);
		if(Math.abs(e1.getY()-e2.getY())>SWIPE_MAX_OFF_PATH)
		{
			return false;	
		}
        // right to left swipe
        if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
        {
				startActivity(in);
				Scicalc.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
				
        }
			// right to left swipe
        else if(e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
        {
				startActivity(in);
				Scicalc.this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
				
        }
        return false;

	}
	 // It is necessary to return true from onDown for the onFling event to register
    @Override
    public boolean onDown(MotionEvent e) {
        	return true;
    }
}
}