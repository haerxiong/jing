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
public class ZTakeinEntity_Huizong implements java.io.Serializable {
	@Excel(name="销售姓名",width=15)
	private String saleName;
	@Excel(name="客户量",width=15, mergeVertical=true)
	private String count;
	@Excel(name="客户姓名",width=15)
	private String customName;
	@Excel(name="身份证号",width=15)
	private String idCard;
	@Excel(name="汇款账号",width=15)
	private String bankAccount;
	@Excel(name="电话",width=15)
	private String phone;
	@Excel(name="备注",width=15)
	private String comment;
	@Excel(name="金额",width=15)
	private java.math.BigDecimal amount;
	@Excel(name="利率",width=15)
	private BigDecimal rate;
	@Excel(name="投资时间",width=15,format = "yyyy/MM/dd")
	private Date investTime;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getInvestTime() {
		return investTime;
	}

	public void setInvestTime(Date investTime) {
		this.investTime = investTime;
	}
}