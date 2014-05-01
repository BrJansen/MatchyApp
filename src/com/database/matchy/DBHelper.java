package com.database.matchy;

import java.io.IOException;

import android.content.Context;
import android.util.Log;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.objects.matchy.DatabaseMatch;

public class DBHelper {

	protected static ObjectContainer database = null;
	private Context context;

	public DBHelper(Context ctx) {
		context = ctx;
	}

	/**
	 * Create, open and close the database
	 */
	public ObjectContainer db() {

		try {
			if (database == null || database.ext().isClosed()) {
				database = Db4oEmbedded.openFile(dbConfig(),
						db4oDBFullPath(context));
				// We first load the initial data from the database
				// ExercisesLoader.load(context, database);
			}

			return database;

		} catch (Exception ie) {
			Log.e(DBHelper.class.getName(), ie.toString());
			return null;
		}
	}

	/**
	 * Configure the behavior of the database (match, type and id columns)
	 * 
	 * @return configuration DB4O db config
	 */

	private EmbeddedConfiguration dbConfig() throws IOException {
		EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
		configuration.common().objectClass(DatabaseMatch.class).objectField("match")
				.indexed(true);
		configuration.common().objectClass(DatabaseMatch.class).cascadeOnUpdate(true);
		configuration.common().objectClass(DatabaseMatch.class).cascadeOnActivate(true);
		
		return configuration;
	}

	/**
	 * Returns the path for the database location
	 * 
	 * @return directory
	 */

	private String db4oDBFullPath(Context ctx) {
		return ctx.getDir("data", 0) + "/" + "matches.db4o";
	}

	/**
	 * Closes the database
	 * 
	 */

	public void close() {
		if (database != null)
			database.close();
	}
}
