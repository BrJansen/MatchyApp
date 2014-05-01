package com.screens.matchy;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.adapter.matchy.MatchAdapter;
import com.database.matchy.MatchProvider;
import com.main.matchy.R;
import com.objects.matchy.DatabaseMatch;
import com.objects.matchy.User;

/**
 * This activity is the main screen.
 * 
 * @author Grand Tech Assembly
 */

public class MainScreenUser extends AbstractActivity{

	/**
	 * This method creates screen elements and sets button listeners.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen_user);
		RemoteApplicationAccess.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();

		fillMatchList();
		fillProfile(getUser());

		OnClickListenerIntent onClickListenerIntent = new OnClickListenerIntent();
		Button seeMatchesButton = (Button) findViewById(R.id.seeMatchesButton);
		Button profileButton = (Button) findViewById(R.id.profileButton);
		seeMatchesButton
				.setOnClickListener(onClickListenerIntent.onClickIntent(
						MainScreenUser.this, MatchScreen.class, 0));
		profileButton.setOnClickListener(onClickListenerIntent
					.onClickIntent(MainScreenUser.this,
							ProfileScreen_User.class, 0));
	}

	protected void fillMatchList() {

		ListView matchList = (ListView) findViewById(R.id.newMatches);
		matchList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent i;
				if (checkIdentity())
					i = new Intent(MainScreenUser.this,
							ProfileScreen_User.class);
				else
					i = new Intent(MainScreenUser.this, DetailScreen.class);

				i.putExtra("id", (int) arg3);
				startActivity(i);
			}
		});

		MatchProvider matchProvider = new MatchProvider(this);
		List<DatabaseMatch> matches = matchProvider.findMatchByUser(getUser());
		MatchAdapter matchAdapter = new MatchAdapter(this, matches);
		matchList.setAdapter(matchAdapter);
	}

	private void fillProfile(User user) {

		TextView profileName = (TextView) findViewById(R.id.profile_name);
		profileName.setText(user.getUserCv().getName());

		TextView profileAge = (TextView) findViewById(R.id.profile_age);
		profileAge.setText(Integer.toString(user.getUserCv().getAge()));

		TextView profileSex = (TextView) findViewById(R.id.profile_sex);
		profileSex.setText(user.getUserCv().getSex());
	}

}