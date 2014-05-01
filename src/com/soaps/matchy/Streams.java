package com.soaps.matchy;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;

import com.objects.matchy.User;
import com.screens.matchy.RemoteApplicationAccess;

/**
* This creates input and output streams to save object locally.
* @author Grand Tech Assembly 
* @version 0.9
*/

public class Streams {
	
	/** 
	 * Method creates input stream (reads file).
	 * @return userClass Object.
	 * @param String fileName
	 */
	
	public User createInputStream(String fileName){
		FileInputStream fis;
		User userClass = null;
		try {
			fis = RemoteApplicationAccess.getContext().openFileInput(fileName);
			ObjectInputStream is = new ObjectInputStream(fis);
			userClass = (User) is.readObject();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userClass;
	}
	
	/**
	 * Method creates output stream (saves file).
	 * @param String fileName
	 * @param User _user
	 */
	
	public void createOutputStream(String fileName, User _user){
		ObjectOutputStream os;
		try {
			RemoteApplicationAccess.getContext();
			FileOutputStream fos = RemoteApplicationAccess.getContext().openFileOutput(fileName, Context.MODE_PRIVATE);
			os = new ObjectOutputStream(fos);
			os.writeObject(_user);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
