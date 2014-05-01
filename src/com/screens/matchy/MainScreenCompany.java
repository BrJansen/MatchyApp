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
 * This activity is the match screen.
 * 
 * @author Grand Tech Assembly
 */

public class MainScreenCompany extends AbstractActivity{

	/**
	 * Creates screen elements and sets button listeners.
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen_company);
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
						MainScreenCompany.this, MatchScreen.class, 0));
		profileButton.setOnClickListener(onClickListenerIntent
					.onClickIntent(MainScreenCompany.this,
							ProfileScreen_User.class, 0));
	}
	
	/**
	 * Fills match list with local database entries.
	 */
	
	private void fillMatchList() {
		
        ListView matchList = (ListView) findViewById(R.id.newMatches);
        matchList.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        		Intent i;
        		if (checkIdentity())
        			i = new Intent(MainScreenCompany.this, ProfileScreen_User.class);
        		else
        			i = new Intent(MainScreenCompany.this, DetailScreen.class);

        		i.putExtra("id", (int) arg3);
        		startActivity(i);
        	}
		});
        
        MatchProvider matchProvider = new MatchProvider(this);
		List<DatabaseMatch> matches = matchProvider.findMatchByUser(getUser());		
		MatchAdapter matchAdapter = new MatchAdapter(MainScreenCompany.this,
				matches);
		matchList.setAdapter(matchAdapter);
	}
	
	private void fillProfile(User user) {

		TextView profileName = (TextView) findViewById(R.id.profile_name);
		profileName.setText(user.getUserCompany().getCompanyName());

		TextView profileCity = (TextView) findViewById(R.id.profile_city);
		profileCity.setText(user.getUserCompany().getCompanyCity());

		TextView profileEmail = (TextView) findViewById(R.id.profile_email);
		profileEmail.setText(user.getUserCompany().getCompanyEmail());

		TextView profileTelephone = (TextView) findViewById(R.id.profile_telephone);
		profileTelephone.setText(user.getUserCompany().getCompanyTel());
	}
}
