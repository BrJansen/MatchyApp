package com.soaps.matchy;

import java.lang.reflect.Method;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import android.widget.Toast;

import com.main.matchy.R;
import com.objects.matchy.Company;
import com.objects.matchy.Cv;
import com.objects.matchy.EducationLevel;
import com.objects.matchy.Source;
import com.objects.matchy.User;
import com.screens.matchy.RemoteApplicationAccess;

public class ConcreteLogin extends CallSoap {

	/**
	 * This class contains all the login methods to initiate the call to the
	 * back-end and verify login credentials.
	 * 
	 * @see CallSoap class
	 * @author Grand Tech Assembly
	 * @version 0.9
	 */

	protected User _user;
	private String FILE_NAME = "user.obj";

	public ConcreteLogin(String operation, String objectName, User user) {
		super(operation, objectName, user);
		this._user = user;

		newProperty();
		buildEnvelope();
	}

	/**
	 * This method initiates a call to the backend and returns a true or false
	 * to verify credentials. Calls getAllProperties to get all properties from
	 * user object. Calls createOutputStream to save object. Catches connection
	 * errors.
	 * 
	 * @return Boolean mayLogin
	 * @return null if connection could not be made
	 */

	@Override
	public Boolean returnBoolean() {
		try {
			CallSoap._httpTransport.call(SoapConstants.TARGET_NAMESPACE
					+ SoapConstants.OPERATION, CallSoap._envelope);
			SoapObject response = (SoapObject) CallSoap._envelope.getResponse();

			getAllProperties(response, this._user);
			Streams streams = new Streams();
			streams.createOutputStream(FILE_NAME, this._user);
			
			return this._user.getMayLogin();
		} catch (Exception exception) {
			Toast.makeText(RemoteApplicationAccess.getContext(),
					R.string._errorConnection, Toast.LENGTH_LONG).show();
			return null;
		}
	}

	@Override
	public Object[] returnObject() {
		return null;
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

	public Object getUserCv(Object responseProperty) {
		Cv cv = new Cv();
		this._user.setUserCv(cv);

		SoapObject CvObject = (SoapObject) responseProperty;
		getAllProperties(CvObject, this._user.getUserCv());

		return this._user.getUserCv();
	}

	public Object getEducationLevel(Object responseProperty) {
		EducationLevel el = new EducationLevel();
		this._user.getUserCv().setEducationLevel(el);

		SoapObject CvObject = (SoapObject) responseProperty;
		getAllProperties(CvObject, this._user.getUserCv().getEducationLevel());

		return this._user.getUserCv().getEducationLevel();
	}

	public Object getSource(Object responseProperty) {
		Source source = new Source();
		this._user.getUserCv().setSource(source);

		SoapObject CvObject = (SoapObject) responseProperty;
		getAllProperties(CvObject, this._user.getUserCv().getSource());

		return this._user.getUserCv().getSource();
	}

	public Object getUserCompany(Object responseProperty) {
		Company company = new Company();
		this._user.setUserCompany(company);

		SoapObject companyObject = (SoapObject) responseProperty;
		getAllProperties(companyObject, this._user.getUserCompany());

		return this._user.getUserCompany();
	}
}
