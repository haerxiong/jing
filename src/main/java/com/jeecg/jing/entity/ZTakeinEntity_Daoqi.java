package com.jeecg.jing.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Entity;
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
public class ZTakeinEntity_Daoqi implements java.io.Serializable {
	@Excel(name="合同编号",width=15)
	private String contract;
	@Excel(name="收据编号",width=15)
	private String receipt;
	@Excel(name="销售姓名",width=15)
	private String saleName;
	@Excel(name="客户姓名",width=15)
	private String customName;
	@Excel(name="入金时间",width=15,format = "yyyy/MM/dd")
	private Date takeinTime;
	@Excel(name="金额",width=15)
	private BigDecimal amount;
	@Excel(name="期限",width=15)
	private String timeLimit;
	@Excel(name="利率",width=15)
	private BigDecimal rate;
	@Excel(name="电话",width=15)
	private String phone;
	@Excel(name="汇款账号",width=15)
	private String bankAccount;
	@Excel(name="到期时间",width=15,format = "yyyy/MM/dd")
	private Date endTime;
	@Excel(name="备注",width=15)
	private String comment;
	@Excel(name="出金时间",width=15,format = "yyyy/MM/dd")
	private java.util.Date outTime;

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
}