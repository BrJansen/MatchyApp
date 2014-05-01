package com.screens.matchy;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import com.asynctask.matchy.AsyncInterface;
import com.asynctask.matchy.UserAsync;
import com.database.matchy.MatchProvider;
import com.main.matchy.R;
import com.objects.matchy.DatabaseMatch;
import com.objects.matchy.User;

/**
 * This activity is the FIRST PAGE profile screen. Contains only basic profile
 * data.
 * 
 * @author Grand Tech Assembly
 */

public class ProfileScreen_Edu extends Activity implements AsyncInterface{
	private String FILE_NAME = "user.obj";
	private int id;
	private TextView profileInfo;

	/**
	 * Creates screen elements and sets button listeners.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_edu_screen);
		RemoteApplicationAccess.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createInnerScrolls();

		OnClickListenerIntent onClickListenerIntent = new OnClickListenerIntent();
		Button workNavButton = (Button) findViewById(R.id.workNav);
		
		if(getIntent().getExtras()!= null) {
			id = (int) getIntent().getExtras().getInt("id");
			fillProfileFromMatch();
		} else {
			id = 0;
			UserAsync task = new UserAsync(this);
			task.execute(new String[] { FILE_NAME });
		}
		workNavButton.setOnClickListener(onClickListenerIntent.onClickIntent(
				ProfileScreen_Edu.this, ProfileScreen_Work.class, id));
	}

	/**
	 * Creates scroll element within existing view.
	 */

	private void createInnerScrolls() {
		profileInfo = (TextView) findViewById(R.id.profile_education);
		profileInfo.setMovementMethod(new ScrollingMovementMethod());
	}

	/**
	 * The right side of the profile description. Fills textviews with
	 * properties from user object.
	 */

	private void fillProfile(User user) {

		TextView profileEducation = (TextView) findViewById(R.id.profile_education);
		String profileEducationInfo = user.getUserCv().getEducationHistory()
				.replaceAll("<br />", "");
		profileEducationInfo = profileEducationInfo.trim().replaceAll("\t+",
				" ");
		profileEducationInfo = profileEducationInfo.trim()
				.replaceAll(" +", " ");
		profileEducation.setText(profileEducationInfo);
	}
	
	private void fillProfileFromMatch() {
		MatchProvider matchProvider = new MatchProvider(RemoteApplicationAccess.getContext());
		DatabaseMatch match = matchProvider.findMatchById(id, "cv");	
		
		TextView profileEducation = (TextView) findViewById(R.id.profile_education);
		String profileEducationInfo = match.getMatch().getCv().getEducationHistory()
				.replaceAll("<br />", "");
		profileEducationInfo = profileEducationInfo.trim().replaceAll("\t+",
				" ");
		profileEducationInfo = profileEducationInfo.trim()
				.replaceAll(" +", " ");
		profileEducation.setText(profileEducationInfo);		
	}


	public void onBackgroundTaskCompleted(User user) {
		fillProfile(user);
	}

	@Override
	public void onBackgroundTaskCompleted(Boolean result) {}
}
