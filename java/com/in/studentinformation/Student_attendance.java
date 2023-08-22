package com.in.studentinformation;

public class Student_attendance {
	private String ROLLNO;
	private float june;
	private float july;
	private float aug;
	private float sep;
	private float oct;
	private float nov;
	private float dec;
	private float jan;
	private float feb;
	private float mar;
	private float apr;
	public Student_attendance(String rOLLNO, float june, float july, float aug, float sep, float oct, float nov,
			float dec, float jan, float feb, float mar, float apr) {
		super();
		ROLLNO = rOLLNO;
		this.june = june;
		this.july = july;
		this.aug = aug;
		this.sep = sep;
		this.oct = oct;
		this.nov = nov;
		this.dec = dec;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
		this.apr = apr;
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
	public float getJune() {
		return june;
	}
	public void setJune(float june) {
		this.june = june;
	}
	public float getJuly() {
		return july;
	}
	public void setJuly(float july) {
		this.july = july;
	}
	public float getAug() {
		return aug;
	}
	public void setAug(float aug) {
		this.aug = aug;
	}
	public float getSep() {
		return sep;
	}
	public void setSep(float sep) {
		this.sep = sep;
	}
	public float getOct() {
		return oct;
	}
	public void setOct(float oct) {
		this.oct = oct;
	}
	public float getNov() {
		return nov;
	}
	public void setNov(float nov) {
		this.nov = nov;
	}
	public float getDec() {
		return dec;
	}
	public void setDec(float dec) {
		this.dec = dec;
	}
	public float getJan() {
		return jan;
	}
	public void setJan(float jan) {
		this.jan = jan;
	}
	public float getFeb() {
		return feb;
	}
	public void setFeb(float feb) {
		this.feb = feb;
	}
	public float getMar() {
		return mar;
	}
	public void setMar(float mar) {
		this.mar = mar;
	}
	public float getApr() {
		return apr;
	}
	public void setApr(float apr) {
		this.apr = apr;
	}
	

	
}
