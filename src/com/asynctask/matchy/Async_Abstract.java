package com.asynctask.matchy;

import android.os.AsyncTask;

import com.objects.matchy.User;
import com.soaps.matchy.Streams;

/**
 * Abstact class to predefine methods needed by AsyncTask classes.
 * 
 * @author Grand Tech Assembly
 */

public abstract class Async_Abstract extends AsyncTask<String, Void, User>{
    
	/**
	 * Background task to read object from local file.
	 */
	
	@Override
	protected User doInBackground(String... params) {
		Streams streams = new Streams();
		User user = new User();
		user = streams.createInputStream(params[0]);
		
		return user;
	}
	
	protected abstract void onPostExecute(User result);

}
