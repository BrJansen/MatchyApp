package com.soaps.matchy;

import java.lang.reflect.Method;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import android.widget.Toast;

import com.main.matchy.R;
import com.objects.matchy.Company;
import com.objects.matchy.Cv;
import com.objects.matchy.DetailJob;
import com.objects.matchy.EducationLevel;
import com.objects.matchy.Job;
import com.objects.matchy.Match;
import com.screens.matchy.RemoteApplicationAccess;

public class ConcreteMatch extends CallSoap {

	/**
	 * This class contains all the match methods to initiate the call to the
	 * back-end and verify login credentials.
	 * 
	 * @see CallSoap class
	 * @author Grand Tech Assembly
	 * @version 0.9
	 */

	@SuppressWarnings("unused")
	private int cvID, limit;
	private Match[] _match;
	private static int matchCount = 0;
	
	public ConcreteMatch(String operation, String[] objectNames, int cv_ID, int limit) {
		super(operation, "int");
		this.cvID = cv_ID;
		this.limit = limit;
		this._match = new Match[limit];
		
		Integer[] values = new Integer[] { cvID, limit };
		
		newProperty(objectNames, values);
		buildEnvelope();
	}

	/**
	 * This method initiates a call to the backend and returns a match object.
	 * Calls getAllProperties to get all properties from user object. Catches
	 * connection errors.
	 * 
	 * @return Boolean mayLogin
	 * @return null if connection could not be made
	 */

	@Override
	public Boolean returnBoolean() {
		return null;

	}

	@Override
	public Object[] returnObject() {
		try {
			CallSoap._httpTransport.call(SoapConstants.TARGET_NAMESPACE
					+ SoapConstants.OPERATION, CallSoap._envelope);
			SoapObject response = (SoapObject) CallSoap._envelope.getResponse();

			for(int i=0;i<this._match.length;i++){
				this._match[i] = new Match();
				SoapObject matchSoap = (SoapObject) response.getProperty(i);
				getAllProperties(matchSoap, this._match[i]);
				matchCount++;
			}
			matchCount = 0;

			return _match;
		} catch (Exception exception) {
			Toast.makeText(RemoteApplicationAccess.getContext(),
					R.string._errorConnection, Toast.LENGTH_LONG).show();
			return null;
		}
	}

	/**
	 * Gets all properties from the received user object and parses to correct
	 * object type.
	 * 
	 * @param SoapObject
	 *            response
	 * @param Object
	 *            object
	 */

	private void getAllProperties(SoapObject response, Object object) {
		int propertyCount = response.getPropertyCount();
		for (int i = 0; i < propertyCount; i++) {
			PropertyInfo propInfo = new PropertyInfo();
			
			response.getPropertyInfo(i, propInfo);
			Method method = null;
			Class<?> getCurrentClass = null;
			try {
				method = object.getClass().getMethod("getPropertyClass",
						String.class);
				getCurrentClass = (Class<?>) method.invoke(object,
						propInfo.name);
				if (getCurrentClass == Object.class)
					method = getClass().getMethod(
							"get" + propInfo.name.toString(), Object.class);
				else 
					method = object.getClass().getMethod(
							"set" + propInfo.name.toString(), getCurrentClass);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (getCurrentClass.equals(String.class))
					method.invoke(object, response.getProperty(i).toString());
				else if (getCurrentClass == Integer.class) {
					Integer integer = Integer.parseInt(response.getProperty(i)
							.toString());
					method.invoke(object, integer);
				} else if (getCurrentClass == Object.class)
					method.invoke(this, response.getProperty(i));
				else if (getCurrentClass == Boolean.class)
					method.invoke(object, Boolean.parseBoolean(response
							.getProperty(i).toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * The following methods get all sub objects from external user object and
	 * returns them to local user object.
	 */

	public Object getJob(Object responseProperty) {
		Job job = new Job();
		this._match[matchCount].setJob(job);

		SoapObject JobObject = (SoapObject) responseProperty;
		getAllProperties(JobObject, this._match[matchCount].getJob());

		return this._match[matchCount].getJob();
	}
	
	public Object getCompany(Object responseProperty) {
		Company company = new Company();
		this._match[matchCount].getJob().setCompany(company);

		SoapObject companyObject = (SoapObject) responseProperty;
		getAllProperties(companyObject, this._match[matchCount].getJob().getCompany());

		return this._match[matchCount].getJob().getCompany();
	}
	
	public Object getCv(Object responseProperty) {
		Cv cv = new Cv();
		this._match[matchCount].setCv(cv);

		SoapObject cvObject = (SoapObject) responseProperty;
		getAllProperties(cvObject, this._match[matchCount].getCv());

		return this._match[matchCount].getCv();
	}

	public Object getEducation(Object responseProperty) {
		EducationLevel education = new EducationLevel();
		this._match[matchCount].getJob().setEducation(education);

		SoapObject educationObject = (SoapObject) responseProperty;
		getAllProperties(educationObject, this._match[matchCount].getJob().getEducation());

		return this._match[matchCount].getJob().getEducation();
	}

	public Object getEducationLevel(Object responseProperty) {
		EducationLevel education = new EducationLevel();
		this._match[matchCount].getCv().setEducationLevel(education);

		SoapObject educationObject = (SoapObject) responseProperty;
		getAllProperties(educationObject, this._match[matchCount].getCv().getEducationLevel());

		return this._match[matchCount].getCv().getEducationLevel();
	}

	public Object getDetailJob(Object responseProperty) {
		DetailJob detailJob = new DetailJob();
		this._match[matchCount].getJob().setDetailJob(detailJob);

		SoapObject DetailJobObject = (SoapObject) responseProperty;
		getAllProperties(DetailJobObject, this._match[matchCount].getJob().getDetailJob());

		return this._match[matchCount].getJob().getDetailJob();
	}
}
