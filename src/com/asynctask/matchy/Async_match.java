package com.asynctask.matchy;

import android.app.Activity;

import com.objects.matchy.User;

/**
 * Concrete implementation of Async_Abstract to fill fetch match properties in
 * profile screen outside of main UI thread.
 * 
 * @author Grand Tech Assembly
 */

public class Async_match extends Async_Abstract {

	AsyncInterface caller;
	Activity activity;

	public Async_match(AsyncInterface caller) {
		this.caller = caller;
		this.activity = (Activity) caller;
	}

	protected void onPostExecute(User result) {
		caller.onBackgroundTaskCompleted(result);
	}
}
