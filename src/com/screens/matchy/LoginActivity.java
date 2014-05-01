package com.screens.matchy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asynctask.matchy.AsyncInterface;
import com.asynctask.matchy.LoginAsync;
import com.main.matchy.R;
import com.objects.matchy.User;

/**
 * This activity is the login screen.
 * 
 * @author Grand Tech Assembly
 */

public class LoginActivity extends AbstractActivity implements AsyncInterface {

	private EditText userName, password;

	/**
	 * Creates screen elements and sets button listeners.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		RemoteApplicationAccess.setActivity(this);

		Button loginButton = (Button) findViewById(R.id.login);
		loginButton.setOnClickListener(onClick());
	}

	/**
	 * Creates button listeners and checks if email (username) is a valid email.
	 */

	public OnClickListener onClick() {
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				userName = (EditText) findViewById(R.id.userNameInsert);
				password = (EditText) findViewById(R.id.passwordInsert);
				String email = userName.getText().toString();
				String pass = password.getText().toString();
				if (emailValidation(email)) {
					User user = new User();
					user.setEmail(email);
					user.setPass(pass);
					LoginAsync task = new LoginAsync(
							(AsyncInterface) RemoteApplicationAccess
									.getActivity());
					task.execute(user);
				} else {
					Toast.makeText(getApplicationContext(),
							R.string._falseEmail, Toast.LENGTH_LONG).show();
				}
			}
		};
	}

	/**
	 * If back button is pressed, returns to previous activity and moves this
	 * acticity to the back.
	 */

	@Override
	public void onBackPressed() {
		moveTaskToBack(true);
	}

	/**
	 * AsyncTask method to verify login. If passed, start main screen activity.
	 * 
	 * @see LoginAsync class
	 */

	public void onBackgroundTaskCompleted(Boolean result) {
		try {
			if (result && checkIdentity()) {
				Intent userIntent = new Intent(LoginActivity.this,
						MainScreenCompany.class);
				startActivity(userIntent);
				finish();
			} else if (result && !checkIdentity()) {
				Intent companyIntent = new Intent(LoginActivity.this,
						MainScreenUser.class);
				startActivity(companyIntent);
				finish();
			} else if (!result) {
				Toast.makeText(getApplicationContext(), R.string._falseLogin,
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception ex) {
			Toast.makeText(RemoteApplicationAccess.getContext(),
					R.string._errorConnection, Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onBackgroundTaskCompleted(User user) {
	}

	public final static boolean emailValidation(CharSequence target) {
		if (target == null) {
			return false;
		} else {
			return android.util.Patterns.EMAIL_ADDRESS.matcher(target)
					.matches();
		}
	}
}
