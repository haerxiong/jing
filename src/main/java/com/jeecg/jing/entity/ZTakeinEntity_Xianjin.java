package com.jeecg.jing.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: 客户信息
 * @author onlineGenerator
 * @date 2018-11-01 09:53:32
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class ZTakeinEntity_Xianjin implements java.io.Serializable {
	@Excel(name="客户姓名",width=15)
	private String customName;
	@Excel(name="入金时间",width=15,format = "yyyy/MM/dd")
	private Date takeinTime;
	@Excel(name="电话",width=15)
	private String phone;
	@Excel(name="汇款账号",width=15)
	private String bankAccount;
	@Excel(name="到期时间",width=15,format = "yyyy/MM/dd")
	private Date endTime;
	@Excel(name="合计金额",width=15)
	private String interest;
	@Excel(name="客户签字",width=15)
	private String customSign;
	@Excel(name="备注",width=15)
	private String comment;

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public Date getTakeinTime() {
		return takeinTime;
	}

	public void setTakeinTime(Date takeinTime) {
		this.takeinTime = takeinTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getCustomSign() {
		return customSign;
	}

	public void setCustomSign(String customSign) {
		this.customSign = customSign;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}