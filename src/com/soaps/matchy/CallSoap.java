package com.soaps.matchy;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
* Within this abstract class, all standard SOAP call methods are predefined.
* Foregoes the need to create new SOAP call methods for each separate call to the back end.
* @author Grand Tech Assembly 
* @version 0.9
*/

public abstract class CallSoap {

	protected String _operation, _objectName;
	protected Object _object;

	protected static SoapObject _request;
	protected static SoapSerializationEnvelope _envelope;
	protected static HttpTransportSE _httpTransport;

	public CallSoap(String operation, String objectName)
	{
		this._operation = operation;
		
		init();
		CallSoap._request = new SoapObject(SoapConstants.TARGET_NAMESPACE, SoapConstants.OPERATION);
	}
	
	public CallSoap(String operation, String objectName, Object object) {
		this._operation = operation;
		this._objectName = objectName;
		this._object = object;

		init();
		CallSoap._request = new SoapObject(SoapConstants.TARGET_NAMESPACE, SoapConstants.OPERATION);
	}

	/**
	* This method initializes a connection.
	*/
	
	public void init() {
		SoapConstants.setOPERATION(this._operation);
		CallSoap._request = new SoapObject(SoapConstants.TARGET_NAMESPACE, SoapConstants.OPERATION);
		CallSoap._httpTransport = new HttpTransportSE(SoapConstants.ADDRESS);
		CallSoap._httpTransport.debug = true; 
	}

	/**
	* This method predefines object property name, value and type. Required to make SOAP call.
	*/
	
	public void newProperty() {
		PropertyInfo propInfo = new PropertyInfo();
		propInfo.setNamespace(SoapConstants.TARGET_NAMESPACE);
		propInfo.setName(this._objectName);
		propInfo.setValue(this._object);
		propInfo.setType(this._object.getClass());

		CallSoap._request.addProperty(propInfo);
	}
	
	public void newProperty(String[] names, Integer[] values) {
		for (int i = 0; i < names.length; i++)
		{
			PropertyInfo propInfo = new PropertyInfo();
			propInfo.setNamespace(SoapConstants.TARGET_NAMESPACE);
			propInfo.setName(names[i]);
			propInfo.setValue(values[i]);
			propInfo.setType(values[i].getClass());

			CallSoap._request.addProperty(propInfo);				
		}
	}
	
	/**
	* This method creates a standard SOAP envelope.
	*/

	public void buildEnvelope() {
		CallSoap._envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		CallSoap._envelope.dotNet = true;
		CallSoap._envelope.setAddAdornments(false);
		CallSoap._envelope.implicitTypes = true;
		CallSoap._envelope.setOutputSoapObject(CallSoap._request);
		

		if (_object != null){
			String newObject = Character.toUpperCase(this._objectName.charAt(0)) + this._objectName.substring(1);
			CallSoap._envelope.addMapping(SoapConstants.TARGET_NAMESPACE, newObject, this._object.getClass()); 
		}
		// Mapping to enable serialization.
	}

	public abstract Boolean returnBoolean();
	public abstract Object[] returnObject();
}