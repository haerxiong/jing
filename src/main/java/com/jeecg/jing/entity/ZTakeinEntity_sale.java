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
public class ZTakeinEntity_sale implements java.io.Serializable {
	@Excel(name="团队",width=15)
	private String teamName;
	@Excel(name="销售姓名",width=15)
	private String saleName;
	@Excel(name="入职时间",width=15,format = "yyyy/MM/dd")
	private Date joinTime;
	@Excel(name="签单时间",width=15,format = "yyyy/MM/dd")
	private Date signTime;
	@Excel(name="客户姓名",width=15)
	private String customName;
	@Excel(name="签单金额(万)",width=15)
	private BigDecimal amount;
	@Excel(name="合同期限(月)",width=15)
	private String timeLimit;
	@Excel(name="年化合计",width=15)
	private String year_result;
	@Excel(name="合计(万)",width=15, mergeVertical=true)
	private String sum_amount;
	@Excel(name="业绩年化",width=15, mergeVertical=true)
	private String sum_year;
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
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

	public String getYear_result() {
		return year_result;
	}

	public void setYear_result(String year_result) {
		this.year_result = year_result;
	}

	public String getSum_amount() {
		return sum_amount;
	}

	public void setSum_amount(String sum_amount) {
		this.sum_amount = sum_amount;
	}

	public String getSum_year() {
		return sum_year;
	}

	public void setSum_year(String sum_year) {
		this.sum_year = sum_year;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}