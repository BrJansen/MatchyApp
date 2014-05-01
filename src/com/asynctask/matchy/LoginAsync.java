package com.asynctask.matchy;

import android.app.Activity;
import android.os.AsyncTask;

import com.objects.matchy.User;
import com.soaps.matchy.LoginCaller;
import com.soaps.matchy.MatchCaller;

/**
 * AsyncTask to make call to back end outside of main UI thread.
 * 
 * @author Grand Tech Assembly
 */

public class LoginAsync extends AsyncTask<User, Void, Boolean>{

	AsyncInterface caller;
	Activity activity;
	
	public LoginAsync(AsyncInterface caller) {
        this.caller = caller;
        this.activity = (Activity) caller;
    }
	
	/**
	 * Background task to make call to back end.
	 */
    
	@Override
	protected Boolean doInBackground(User... params) {
		try {
			LoginCaller caller = new LoginCaller(params[0]);
			caller.join();
			caller.start();
			boolean mayLogin = caller.makeCall();
			
			if(mayLogin){
				MatchCaller matchCall = new MatchCaller(params[0].getUserCv().getCvID(), params[0].getUserCompany().getCompanyID(), 10);
				matchCall.join();
				matchCall.start();
				matchCall.makeCall();
			}
			
			return mayLogin;
			
		} catch (InterruptedException e) {
			return false;
		}
	}
	
	protected void onPostExecute(Boolean result) {
        caller.onBackgroundTaskCompleted(result);
    }
}
