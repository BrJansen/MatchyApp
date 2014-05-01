package com.asynctask.matchy;

import android.app.Activity;

import com.objects.matchy.User;

/**
 * Concrete implementation of Async_Abstract to fill education properties in
 * profile screen outside of main UI thread.
 * 
 * @author Grand Tech Assembly
 */

public class UserAsync extends Async_Abstract {

	AsyncInterface caller;
	Activity activity;

	public UserAsync(AsyncInterface caller) {
        this.caller = caller;
        try{
        this.activity = (Activity) caller;
        } catch(Exception e){};
    }

	protected void onPostExecute(User result) {
		caller.onBackgroundTaskCompleted(result);
	}
}