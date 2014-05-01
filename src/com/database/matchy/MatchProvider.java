package com.database.matchy;

import java.util.List;

import android.content.Context;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.objects.matchy.DatabaseMatch;
import com.objects.matchy.Match;
import com.objects.matchy.User;

/**
 * This class contains all actions based on retrieving, storing and finding
 * database entries.
 * 
 */
public class MatchProvider extends DBHelper {
	public final static String TAG = "MatchProvider";
	private static MatchProvider provider = null;

	public MatchProvider(Context ctx) {
		super(ctx);
	}

	/**
	 * Returns an instance of provider.
	 * 
	 * @param ctx
	 * @return provider
	 */

	public static MatchProvider getInstance(Context ctx) {
		if (provider == null)
			provider = new MatchProvider(ctx);
		return provider;
	}

	/**
	 * This method is used to store the received objects in the database.
	 * 
	 * @param match
	 * @param type
	 * @param id
	 */
	public void store(Match match, String type, int id) {
		DatabaseMatch dbMatch = new DatabaseMatch();
		dbMatch.setMatch(match);
		dbMatch.setType(type);
		dbMatch.setId(id);
		final ObjectSet<DatabaseMatch> result = database
				.queryByExample(dbMatch);
		if (result.size() == 0)
			db().store(dbMatch);
	}

	/**
	 * This database deletes the specified match object.
	 * 
	 * @param match
	 */
	public void delete(DatabaseMatch match) {
		db().delete(match);
	}

	/**
	 * This method finds and returns all match objects.
	 * 
	 * @return List Database match list.
	 */
	public List<DatabaseMatch> findAll() {
		return db().query(DatabaseMatch.class);
	}
	
	/**
	 * Finds all matches for a logged in user (non-company).
	 * 
	 * @param user
	 * @return List Database match list
	 */

	public List<DatabaseMatch> findMatchByUser(final User user) {
		List<DatabaseMatch> matchList = db().query(
				new Predicate<DatabaseMatch>() {

					private static final long serialVersionUID = 1L;

					public boolean match(DatabaseMatch dbMatch) {
						String type = "";
						int id;
						if (user.getUserCv().getCvID() != 0) {
							type = "cv";
							id = user.getUserCv().getCvID();
						} else {
							type = "company";
							id = user.getUserCompany().getCompanyID();
						}
						return dbMatch.getType().equals(type)
								&& dbMatch.getId() == id;
					}
				});
		return matchList;
	}
	
	/**
	 * 
	 * @param id
	 * @param type
	 * @return
	 */

	public DatabaseMatch findMatchById(final int id, final String type) {
		List<DatabaseMatch> matchList = db().query(
				new Predicate<DatabaseMatch>() {

					private static final long serialVersionUID = 1L;

					public boolean match(DatabaseMatch dbMatch) {
						return (dbMatch.getMatch().getCv().getCvID() == id && type
								.equals("cv"))
								|| (dbMatch.getMatch().getJob().getJobID() == id && type
										.equals("job"));
					}
				});
		return matchList.get(0);
	}
}
