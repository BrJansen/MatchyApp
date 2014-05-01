package com.soaps.matchy;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

/**
* This abstract class defines minimal methods needed for the object classes.
* @author Grand Tech Assembly 
* @version 0.9
*/

public abstract class SoapObjectAbstract implements KvmSerializable {
	public abstract Object getProperty(int arg0);
	public abstract int getPropertyCount();
	@SuppressWarnings("rawtypes")
	public abstract void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info);
	public abstract void setProperty(int index, Object value);
	public abstract Class<?> getPropertyClass(String name);
}
