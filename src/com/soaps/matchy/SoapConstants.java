package com.soaps.matchy;

/**
* This class contains all the static Strings needed to create SOAP object.
* @author Grand Tech Assembly 
*/

public class SoapConstants {
	/**
	 * SOAP request information
	 */
	protected static String OPERATION;
	protected static String TARGET_NAMESPACE = "http://145.24.222.183/";
	protected static String ADDRESS = "http://145.24.222.183/MatchyBackEnd/MatchyService.asmx?wsdl";
	
	/**
	 * @param oPERATIONLOGIN String
	 */
	public static void setOPERATION(String oPERATION) {
		OPERATION = oPERATION;
	}
}
