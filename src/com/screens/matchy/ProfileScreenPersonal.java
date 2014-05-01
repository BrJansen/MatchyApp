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

public class ProfileScreenPersonal extends Activity implements AsyncInterface {

	private String FILE_NAME = "user.obj";
	Boolean identity;
	private int id;

	/**
	 * Creates screen elements and sets button listeners.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_screen_personal);
		RemoteApplicationAccess.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createInnerScrolls();


		OnClickListenerIntent onClickListenerIntent = new OnClickListenerIntent();
		Button NavButton = (Button) findViewById(R.id.profNavHome);
		
		if(getIntent().getExtras()!= null){
			id = (int) getIntent().getExtras().getInt("id");
			fillProfileFromMatch();
		} else {
			id = 0;
			UserAsync task = new UserAsync(this);
			task.execute(new String[] { FILE_NAME });
		}
		
		NavButton.setOnClickListener(onClickListenerIntent.onClickIntent(
				ProfileScreenPersonal.this, ProfileScreen_User.class, id));
	}

	/**
	 * The right side of the profile description. Fills textviews with
	 * properties from user object.
	 */

	private void fillProfile(User user) {

		TextView profileInterests = (TextView) findViewById(R.id.profile_personal);
		String Interests = user.getUserCv().getPersonal().replaceAll("<br />", "");
		profileInterests.setText(Interests);
		
		TextView profilePersonal = (TextView) findViewById(R.id.profile_interests);
		String Personal = user.getUserCv().getInterests()
				.replaceAll("<br />", "");
		profilePersonal.setText(Personal);

	}

	public void onBackgroundTaskCompleted(User user) {
		fillProfile(user);
	}
	
	private void fillProfileFromMatch() {
		MatchProvider matchProvider = new MatchProvider(
				RemoteApplicationAccess.getContext());
		DatabaseMatch match = matchProvider.findMatchById(id, "cv");
		
		TextView profileInterests = (TextView) findViewById(R.id.profile_personal);
		String Interests = match.getMatch().getCv().getPersonal().replaceAll("<br />", "");
		profileInterests.setText(Interests);
		
		TextView profilePersonal = (TextView) findViewById(R.id.profile_interests);
		String Personal = match.getMatch().getCv().getInterests()
				.replaceAll("<br />", "");
		profilePersonal.setText(Personal);
	}

	@Override
	public void onBackgroundTaskCompleted(Boolean result) {
	}

	private void createInnerScrolls() {

		TextView personal = (TextView) findViewById(R.id.profile_personal);
		TextView interests = (TextView) findViewById(R.id.profile_interests);

		personal.setMovementMethod(new ScrollingMovementMethod());
		interests.setMovementMethod(new ScrollingMovementMethod());

	}

}