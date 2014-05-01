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
 * This activity is the THIRD PAGE profile screen. Contains only work experience
 * profile data.
 * 
 * @author Grand Tech Assembly
 */

public class ProfileScreen_Work extends Activity implements AsyncInterface{
	private String FILE_NAME = "user.obj";

	private TextView profileInfo;
	private int id;

	/**
	 * Creates screen elements and sets button listeners.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_work_screen);
		RemoteApplicationAccess.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createInnerScrolls();
		
		OnClickListenerIntent onClickListenerIntent = new OnClickListenerIntent();
		Button workNavButton = (Button) findViewById(R.id.persNav);

		if(getIntent().getExtras()!= null){
			id = (int) getIntent().getExtras().getInt("id");
			fillProfileFromMatch();
		} else {
			id = 0;
			UserAsync task = new UserAsync(this);
			task.execute(new String[] { FILE_NAME });
		}
		
		workNavButton.setOnClickListener(onClickListenerIntent.onClickIntent(
				ProfileScreen_Work.this, ProfileScreenPersonal.class, id));
	}

	/**
	 * Creates scroll element within existing view.
	 */

	private void createInnerScrolls() {
		profileInfo = (TextView) findViewById(R.id.profile_education);
		profileInfo.setMovementMethod(new ScrollingMovementMethod());
	}

	/**
	 * Fills view with education properties from user object and formats the
	 * data.
	 * 
	 * @param User user Local user object
	 */

	private void fillProfile(User user) {

		TextView profileEducation = (TextView) findViewById(R.id.profile_education);
		String profileWorkInfo = user.getUserCv().getWorkExperience()
				.replaceAll("<br />", "");
		profileWorkInfo = profileWorkInfo.trim().replaceAll("\t+", " ");
		profileWorkInfo = profileWorkInfo.trim().replaceAll(" +", " ");
		profileEducation.setText(profileWorkInfo);
	}

	private void fillProfileFromMatch() {
		MatchProvider matchProvider = new MatchProvider(
				RemoteApplicationAccess.getContext());
		DatabaseMatch match = matchProvider.findMatchById(id, "cv");
		
		TextView profileEducation = (TextView) findViewById(R.id.profile_education);
		String profileWorkInfo = match.getMatch().getCv().getWorkExperience()
				.replaceAll("<br />", "");
		profileWorkInfo = profileWorkInfo.trim().replaceAll("\t+", " ");
		profileWorkInfo = profileWorkInfo.trim().replaceAll(" +", " ");
		profileEducation.setText(profileWorkInfo);
	}

	public void onBackgroundTaskCompleted(User user) {
		fillProfile(user);
	}

	@Override
	public void onBackgroundTaskCompleted(Boolean result) {}
}
