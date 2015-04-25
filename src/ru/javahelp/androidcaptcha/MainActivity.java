package ru.javahelp.androidcaptcha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnTextCaptcha, btnMathCaptcha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnTextCaptcha = (Button) findViewById(R.id.btnTextCaptcha);
		btnMathCaptcha = (Button) findViewById(R.id.btnMathCaptcha);
		
		btnTextCaptcha.setOnClickListener(onClick);
		btnMathCaptcha.setOnClickListener(onClick);
		
	}

	OnClickListener onClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			Intent intent;
			
			switch (v.getId()) {

			case R.id.btnTextCaptcha:
				intent = new Intent(MainActivity.this, TextActivity.class);
				startActivity(intent);
			break;

			case R.id.btnMathCaptcha:
				intent = new Intent(MainActivity.this, MathActivity.class);
				startActivity(intent);
			break;
			}

		}

	};

}
