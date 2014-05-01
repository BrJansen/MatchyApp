package com.screens.matchy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.asynctask.matchy.AsyncInterface;
import com.main.matchy.R;
import com.objects.matchy.User;

/**
 * This class creates main menu that is present on all screens (except login
 * screen).
 * 
 * @author Grand Tech Assembly
 * @version 1.0
 */

public class BuildNavigation extends AbstractActivity implements AsyncInterface {
	Context context;
	Activity activity;
	User user;

	private String FILE_NAME = "user.obj";

	public void createIntents() {
		context = RemoteApplicationAccess.getContext();
		activity = RemoteApplicationAccess.getActivity();

		getButton(R.id.homeButton, MainScreenUser.class);
		getButton(R.id.profileButton, ProfileScreen_User.class);
		getButton(R.id.matchButton, MatchScreen.class);
		getButton(R.id.logoutButton, LoginActivity.class);
	}

	private Button getButton(int buttonId, Class<?> className) {
		Button result;

		result = (Button) activity.findViewById(buttonId);
		result.setOnClickListener(onClick(className));
		return result;
	}

	public OnClickListener onClick(final Class<?> className) {
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (activity.getClass() != className) {
					Intent intent;
					if (className.equals(ProfileScreen_User.class)) {
						if (checkIdentity())
							intent = new Intent(context, ProfileScreen_Company.class);
						else
							intent = new Intent(context, className);
					} else if(className.equals(LoginActivity.class)){
						RemoteApplicationAccess.getContext().deleteFile(FILE_NAME);
						intent = new Intent(context, className);
					}
					else
						intent = new Intent(context, className);
					activity.startActivity(intent);
				}
			}
		};
	}

	@Override
	public void onBackgroundTaskCompleted(User user) {
		this.user = user;

	}

	@Override
	public void onBackgroundTaskCompleted(Boolean result) {
	}

}
