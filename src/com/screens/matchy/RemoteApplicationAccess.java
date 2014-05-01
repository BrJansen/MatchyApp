package com.screens.matchy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/**
 * This class allows changes to views outside of activity classes.
 * 
 * @author Grand Tech Assembly
 */

public class RemoteApplicationAccess extends Application {

	private static Context mContext;
	private static Activity act;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
	}

	public static Context getContext() {
		return mContext;
	}
	
	public static void setActivity(Activity act) {
		RemoteApplicationAccess.act = act;
	}
	
	public static Activity getActivity(){
		return act;
	}
}