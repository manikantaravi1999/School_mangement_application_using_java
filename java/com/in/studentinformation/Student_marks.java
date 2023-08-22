package com.in.studentinformation;

public class Student_marks {
	private String ROLLNO;
	private float TELUGU;
	private float ENGLISH;
	private float HINDI;
	private float MATHS;
	private float SCIENCE;
	private float SOCIAL;
	public Student_marks(String rOLLNO, float tELUGU, float eNGLISH, float hINDI, float mATHS, float sCIENCE,
			float sOCIAL) {
		super();
		ROLLNO = rOLLNO;
		TELUGU = tELUGU;
		ENGLISH = eNGLISH;
		HINDI = hINDI;
		MATHS = mATHS;
		SCIENCE = sCIENCE;
		SOCIAL = sOCIAL;
	}

	

	/*
	 * getters and setters
	 */
	public String getROLLNO() {
		return ROLLNO;
	}

	public void setROLLNO(String rOLLNO) {
		ROLLNO = rOLLNO;
	}

	public float getTELUGU() {
		return TELUGU;
	}

	public void setTELUGU(float tELUGU) {
		TELUGU = tELUGU;
	}

	public float getENGLISH() {
		return ENGLISH;
	}

	public void setENGLISH(float eNGLISH) {
		ENGLISH = eNGLISH;
	}

	public float getHINDI() {
		return HINDI;
	}

	public void setHINDI(float hINDI) {
		HINDI = hINDI;
	}

	public float getMATHS() {
		return MATHS;
	}

	public void setMATHS(float mATHS) {
		MATHS = mATHS;
	}

	public float getSCIENCE() {
		return SCIENCE;
	}

	public void setSCIENCE(float sCIENCE) {
		SCIENCE = sCIENCE;
	}

	public float getSOCIAL() {
		return SOCIAL;
	}

	public void setSOCIAL(float sOCIAL) {
		SOCIAL = sOCIAL;
	}

}
