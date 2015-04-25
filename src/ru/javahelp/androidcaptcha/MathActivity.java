package ru.javahelp.androidcaptcha;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.rogerlemmonapps.captcha.Captcha;
import com.rogerlemmonapps.captcha.MathCaptcha;


public class MathActivity extends Activity {
	
    ImageView ivMathCaptcha;
	Button btnMathRefresh, btnCheck;;
	RadioGroup radioGroup;
	EditText etAnswer;
	
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math);
		
		etAnswer = (EditText) findViewById(R.id.etAnswer);
		ivMathCaptcha = (ImageView) findViewById(R.id.ivMathCaptcha);
		btnMathRefresh = (Button) findViewById(R.id.btnMathRefresh);
		btnCheck = (Button) findViewById(R.id.btnCheck);
		radioGroup = (RadioGroup) findViewById(R.id.rgGroup);
		
		
		btnMathRefresh.setOnClickListener(onClick);
		btnCheck.setOnClickListener(onClick);
		
		showCaptcha(MathCaptcha.MathOptions.PLUS_MINUS);
    }
	
	OnClickListener onClick = new OnClickListener(){

		@Override
		public void onClick(View v) {
			switch(v.getId()){
				
				case R.id.btnMathRefresh:
					
					int radioButtonID = radioGroup.getCheckedRadioButtonId();
					
					if (radioButtonID == R.id.rdMath1){
						showCaptcha(MathCaptcha.MathOptions.PLUS_MINUS);
					} else if (radioButtonID == R.id.rdMath2){
						showCaptcha(MathCaptcha.MathOptions.PLUS_MINUS_MULTIPLY);
					}
					
				break;
				
				case R.id.btnCheck:
					Captcha c = (Captcha) ivMathCaptcha.getTag();
					
					if (c.checkAnswer(etAnswer.getText().toString())){
						Toast.makeText(MathActivity.this, "Правильно", Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(MathActivity.this, "Не правильно", Toast.LENGTH_SHORT).show();
					}
				break;
			}
		}
	};
	
	private void showCaptcha(MathCaptcha.MathOptions type){
		Captcha c = new MathCaptcha(300, 100, type); 
		ivMathCaptcha.setImageBitmap(c.getImage());
		ivMathCaptcha.setTag(c);
	}
}
