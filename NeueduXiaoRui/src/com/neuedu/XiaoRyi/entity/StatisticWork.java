package com.neuedu.XiaoRyi.entity;

/**
 * 统计实体
 * 实到/迟到/早退/缺勤/请假 
 * @author Administrator
 *
 */
public class StatisticWork {
	
	/**
	 * 员工工号
	 */
	private Long empno;
	
	/**
	 * 应到
	 */
	private Integer needwork;
	
	/**
	 * 实到
	 */
	private Integer realitywork;
	
	/**
	 * 迟到
	 */
	private Integer latework;
	
	/**
	 * 早退
	 */
	private Integer earlywork;
	
	/**
	 * 缺勤
	 */
	private Integer absencework;
	
	/**
	 * 请假
	 */
	private Integer askleavework;

	public StatisticWork() {
		super();
	}

	public Integer getRealitywork() {
		return realitywork;
	}

	public void setRealitywork(Integer realitywork) {
		this.realitywork = realitywork;
	}

	public Integer getLatework() {
		return latework;
	}

	public void setLatework(Integer latework) {
		this.latework = latework;
	}

	public Integer getEarlywork() {
		return earlywork;
	}

	public void setEarlywork(Integer earlywork) {
		this.earlywork = earlywork;
	}

	public Integer getAbsencework() {
		return absencework;
	}

	public void setAbsencework(Integer absencework) {
		this.absencework = absencework;
	}

	public Integer getAskleavework() {
		return askleavework;
	}

	public void setAskleavework(Integer askleavework) {
		this.askleavework = askleavework;
	}

	public Long getEmpno() {
		return empno;
	}

	public void setEmpno(Long empno) {
		this.empno = empno;
	}

	public Integer getNeedwork() {
		return needwork;
	}

	public void setNeedwork(Integer needwork) {
		this.needwork = needwork;
	}

	
	
	
}
