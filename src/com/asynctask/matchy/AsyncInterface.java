package com.asynctask.matchy;

import com.objects.matchy.User;

/**
 * Provides standard methods for implementation in activities.
 * 
 */

public interface AsyncInterface {
	public void onBackgroundTaskCompleted(User user);
	public void onBackgroundTaskCompleted(Boolean result);
}
