package com.screens.matchy;

import com.objects.matchy.User;
import com.soaps.matchy.Streams;

/**
 * Abstract layer to extend methods across all activities. Replaces standard
 * Android extends Activity with extends AbstractActivity.
 * 
 */

public abstract class AbstractActivity extends android.app.Activity {

	private String FILE_NAME = "user.obj";

	/**
	 * Standard identity check method, implemented across multiple activities.
	 * 
	 * @return Boolean identity (false = user, true = company user)
	 */

	protected Boolean checkIdentity() {
		int Id;
		Boolean Identity;

		User user = getUser();
		Id = user.getUserCompany().getCompanyID();

		Identity = Id == 0 ? false : true;

		return Identity;
	}

	/**
	 * Standard object retrieval from local storage method, implemented across
	 * multiple activities.
	 * 
	 * @return User object
	 */
	
	public User getUser() {
		Streams streams = new Streams();
		User user = new User();
		user = streams.createInputStream(FILE_NAME);

		return user;
	}
}
