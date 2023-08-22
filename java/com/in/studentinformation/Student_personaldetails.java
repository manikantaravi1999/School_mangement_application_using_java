package com.in.studentinformation;

import java.util.Date;

public class Student_personaldetails {
	private String FuLLNAME;

	private String CLASS;
	private String ROLLNO;
	private String PASSWORD;
	private String DOB;
	private String GENDER;
	private String EMAIL;
	private String MOBILE;
	private String ADDRESS;

	/*
	 * getters and setters
	 */
	public String getFuLLNAME() {
		return FuLLNAME;
	}

	public void setFuLLNAME(String fuLLNAME) {
		FuLLNAME = fuLLNAME;
	}

	public String getCLASS() {
		return CLASS;
	}

	public void setCLASS(String cLASS) {
		CLASS = cLASS;
	}


	public String getROLLNO() {
		return ROLLNO;
	}

	public void setROLLNO(String rOLLNO) {
		ROLLNO = rOLLNO;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getDOB() {
		return DOB;
	}

	

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getMOBILE() {
		return MOBILE;
	}

	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public Student_personaldetails(String fuLLNAME, String cLASS, String rOLLNO, String pASSWORD, String dob2,
			String gENDER, String eMAIL, String mOBILE, String aDDRESS) {
		super();
		FuLLNAME = fuLLNAME;
		CLASS = cLASS;
		ROLLNO = rOLLNO;
		PASSWORD = pASSWORD;
		DOB = dob2;
		GENDER = gENDER;
		EMAIL = eMAIL;
		MOBILE = mOBILE;
		ADDRESS = aDDRESS;
	}

	

	
	
}
