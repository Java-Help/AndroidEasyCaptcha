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
import com.rogerlemmonapps.captcha.TextCaptcha;


public class TextActivity extends Activity {
	
    ImageView ivTextCaptcha;
	Button btnTextRefresh, btnCheck;;
	RadioGroup radioGroup;
	EditText etAnswer;
	
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
		
		etAnswer = (EditText) findViewById(R.id.etAnswer);
		ivTextCaptcha = (ImageView) findViewById(R.id.ivTextCaptcha);
		btnTextRefresh = (Button) findViewById(R.id.btnTextRefresh);
		btnCheck = (Button) findViewById(R.id.btnCheck);
		radioGroup = (RadioGroup) findViewById(R.id.rgGroup);
		
		
		btnTextRefresh.setOnClickListener(onClick);
		btnCheck.setOnClickListener(onClick);
		
		showCaptcha(TextCaptcha.TextOptions.NUMBERS_AND_LETTERS);
    }
	
	OnClickListener onClick = new OnClickListener(){

		@Override
		public void onClick(View v) {
			switch(v.getId()){
				
				case R.id.btnTextRefresh:
					
					int radioButtonID = radioGroup.getCheckedRadioButtonId();
					
					if (radioButtonID == R.id.rdText1){
						showCaptcha(TextCaptcha.TextOptions.UPPERCASE_ONLY);
					} else if (radioButtonID == R.id.rdText2){
						showCaptcha(TextCaptcha.TextOptions.LOWERCASE_ONLY);
					}else if (radioButtonID == R.id.rdText3){
						showCaptcha(TextCaptcha.TextOptions.NUMBERS_ONLY);
					} else if (radioButtonID == R.id.rdText4){
						showCaptcha(TextCaptcha.TextOptions.LETTERS_ONLY);
					} else if (radioButtonID == R.id.rdText5){
						showCaptcha(TextCaptcha.TextOptions.NUMBERS_AND_LETTERS);
					}
					
				break;
				
				case R.id.btnCheck:
					Captcha c = (Captcha) ivTextCaptcha.getTag();
					
					if (c.checkAnswer(etAnswer.getText().toString())){
						Toast.makeText(TextActivity.this, "Правильно", Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(TextActivity.this, "Не правильно", Toast.LENGTH_SHORT).show();
					}
				break;
			}
		}
	};
	
	private void showCaptcha(TextCaptcha.TextOptions type){
		Captcha c = new TextCaptcha(5, type); 
		ivTextCaptcha.setImageBitmap(c.getImage());
		ivTextCaptcha.setTag(c);
	}
}
