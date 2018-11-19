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
public class ZTakeinEntity_ri implements java.io.Serializable {
	@Excel(name="签单日期",width=15,format = "yyyy/MM/dd")
	private Date signTime;
	@Excel(name="客户姓名",width=15)
	private String customName;
	@Excel(name="入金时间",width=15,format = "yyyy/MM/dd")
	private Date takeinTime;
	@Excel(name="金额",width=15)
	private BigDecimal amount;
	@Excel(name="到期时间",width=15,format = "yyyy/MM/dd")
	private Date endTime;
	@Excel(name="付款方式",width=15)
	private String payType;
	@Excel(name="备注",width=15)
	private String comment;

	// 到期日，即到期时间的Day字段
	@Excel(name="到期日",width=15)
	private java.lang.String endDay;

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
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

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}