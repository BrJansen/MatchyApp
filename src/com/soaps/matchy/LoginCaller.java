package com.soaps.matchy;

import android.widget.Toast;

import com.main.matchy.R;
import com.objects.matchy.User;
import com.screens.matchy.RemoteApplicationAccess;

/**
 * This class initiates the call to the back-end for login purposes.
 * 
 *
 */
public class LoginCaller extends Thread {
	public ConcreteLogin callLogin;
	private User _user;

	public LoginCaller(User user) {
		this._user = user;
	}

	public boolean makeCall() {
		//Looper.prepare();

		try {
			callLogin = new ConcreteLogin("Login2", "user", this._user);
			
			return callLogin.returnBoolean();
		} catch (Exception ex) {
			RemoteApplicationAccess.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast.makeText(RemoteApplicationAccess.getContext(), R.string._errorConnection, Toast.LENGTH_LONG).show();
				}
			});
		}
		return false;
	}
}