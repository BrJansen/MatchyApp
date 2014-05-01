package com.objects.matchy;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

import com.soaps.matchy.SoapObjectAbstract;

/**
* This class contains all the getters and setters for each USER object property.
* Additionally, it parses each object property to it's corresponding type.
* @author Grand Tech Assembly 
* @version 0.9
*/

public class User extends SoapObjectAbstract implements Serializable {

	private static final long serialVersionUID = 1L;
	private String Email, Pass, Sex, BirthDay;
	private int ProfileId, Type;
	private Cv UserCv;
	private Company UserCompany;
	private Boolean MayLogin = false;

	private enum userFields {
		Email, Pass, Sex, BirthDay, ProfileId, Type, UserCv, UserCompany, MayLogin;
	}

	/**
	 * @return the object property.
	 * @param arg0 int
	 */
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return Email;
		case 1:
			return Sex;
		case 2:
			return ProfileId;
		case 3:
			return Type;
		case 4:
			return UserCv;
		case 5:
			return UserCompany;
		case 6:
			return MayLogin;
		case 7:
			return Pass;
		}
		return null;
	}

	/**
	 * @return int property count.
	 */
	
	@Override
	public int getPropertyCount() {
		return 8;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
		case 0:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Email";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Sex";
			break;
		case 2:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "ProfileId";
			break;
		case 3:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "Type";
			break;
		case 4:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "UserCv";
			break;
		case 5:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "UserCompany";
			break;
		case 6:
			info.type = PropertyInfo.BOOLEAN_CLASS;
			info.name = "MayLogin";
			break;
		case 7:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Pass";
			break;
		default:
			break;
		}
	}
	
	/**
	 * This method sets each property to a string.
	 * @param index
	 * @param value
	 */

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			Email = value.toString();
			break;
		case 1:
			Sex = value.toString();
			break;
		case 2:
			ProfileId = Integer.parseInt(value.toString());
			break;
		case 3:
			Type = Integer.parseInt(value.toString());
			break;
		case 4:
			UserCv = (Cv) value;
			break;
		case 5:
			UserCompany = (Company) value;
			break;
		case 6:
			MayLogin = Boolean.parseBoolean(value.toString());
			break;
		case 7:
			Pass = value.toString();
			break;
		default:
			break;
		}
	}
	
	/**
	 * This method returns the type class of a property.
	 * @return type class
	 * @param name String Name of the property as a String
	 */

	@Override
	public Class<?> getPropertyClass(String name) {
		userFields fieldName = userFields.valueOf(name);
		
		switch(fieldName){
		case Email:
			return String.class;
		case Pass:
			return String.class;
		/*case BirthDay:
			return String.class;*/
		case ProfileId:
			return Integer.class;
		case Type:
			return Integer.class;
		case UserCv:
			return Object.class;
		case UserCompany:
			return Object.class;
		case MayLogin:
			return Boolean.class;
		case Sex:
			return String.class;
		default:
			return null;
		}
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return Pass;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return Sex;
	}

	/**
	 * @return the birthDay
	 */
	public String getBirthDay() {
		return BirthDay;
	}

	/**
	 * @return the profileId
	 */
	public int getProfileId() {
		return ProfileId;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return Type;
	}

	/**
	 * @return the userCv
	 */
	public Cv getUserCv() {
		return UserCv;
	}

	/**
	 * @return the userCompany
	 */
	public Company getUserCompany() {
		return UserCompany;
	}

	/**
	 * @return the mayLogin
	 */
	public Boolean getMayLogin() {
		return MayLogin;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @param pass
	 *            the pass to set
	 */
	public void setPass(String pass) {
		Pass = pass;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		Sex = sex;
	}

	/**
	 * @param BirthDay
	 *            the birthDay to set
	 */
	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	/**
	 * @param profileId
	 *            the profileId to set
	 */
	public void setProfileId(Integer profileId) {
		ProfileId = (Integer) profileId;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		Type = (Integer) type;
	}

	/**
	 * @param userCv
	 *            the userCv to set
	 */
	public void setUserCv(Cv userCv) {
		UserCv = userCv;
	}

	/**
	 * @param userCompany
	 *            the userCompany to set
	 */
	public void setUserCompany(Company userCompany) {
		UserCompany = userCompany;
	}

	/**
	 * @param mayLogin
	 *            the mayLogin to set
	 */
	public void setMayLogin(Boolean mayLogin) {
		MayLogin = mayLogin;
	}
}
