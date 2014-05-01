package com.screens.matchy;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.adapter.matchy.MatchAdapter;
import com.asynctask.matchy.AsyncInterface;
import com.database.matchy.MatchProvider;
import com.main.matchy.R;
import com.objects.matchy.DatabaseMatch;
import com.objects.matchy.User;
import com.soaps.matchy.Streams;

/**
 * This activity is the match screen.
 * 
 * @author Grand Tech Assembly
 */

public class MatchScreen extends Activity implements AsyncInterface, OnItemClickListener{

	private String FILE_NAME = "user.obj";
	@SuppressWarnings("unused")
	private User currentUser;
	/**
	 * Creates screen elements and sets button listeners.
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_screen);
		RemoteApplicationAccess.setActivity(this);
		
		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		fillMatchList();
	}
	
	/**
	 * Fills match list with local database entries.
	 */
	
	private void fillMatchList() {
		Streams streams = new Streams();
		User user = new User();
		user = streams.createInputStream(FILE_NAME);
		
        ListView matchList = (ListView) findViewById(R.id.matchesList);
        matchList.setOnItemClickListener(this);
        
        MatchProvider matchProvider = new MatchProvider(this);
		List<DatabaseMatch> matches = matchProvider.findMatchByUser(user);		
		MatchAdapter matchAdapter = new MatchAdapter(MatchScreen.this,
				matches);
		matchList.setAdapter(matchAdapter);
	}

	@Override
	public void onBackgroundTaskCompleted(User user) {
		currentUser = user;
	}

	@Override
	public void onBackgroundTaskCompleted(Boolean result) {}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent i = new Intent(MatchScreen.this, DetailScreen.class);
		startActivity(i);
	}
}
