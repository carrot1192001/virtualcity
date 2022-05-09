package com.youku.atm.cacher.test;

import java.io.Serializable;

public class MLunbo1 implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int castId1;
	private int lun;
	private int totalLun;
	public int getCastId1() {
		return castId1;
	}
	public void setCastId(int castId1) {
		this.castId1 = castId1;
	}
	public int getLun() {
		return lun;
	}
	public void setLun(int lun) {
		this.lun = lun;
	}
	public int getTotalLun() {
		return totalLun;
	}
	public void setTotalLun(int totalLun) {
		this.totalLun = totalLun;
	}

	
}