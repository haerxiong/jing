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
public class ZTakeinEntity_ticheng implements java.io.Serializable {
	@Excel(name="团队",width=15)
	private String teamName;
	@Excel(name="销售姓名",width=15)
	private String saleName;
	@Excel(name="入职时间",width=15,format = "yyyy/MM/dd")
	private Date joinTime;
	@Excel(name="客户姓名",width=15)
	private String customName;
	@Excel(name="金额(万)",width=15)
	private BigDecimal amount;
	@Excel(name="期限(月)",width=15)
	private String timeLimit;
	@Excel(name="业绩(万)",width=15, mergeVertical=true)
	private String sum_amount;
	@Excel(name="提点",width=15)
	private String percentages;
	@Excel(name="总计",width=15, mergeVertical=true)
	private String sum_percentages;
	@Excel(name="团队合计(万)",width=15, mergeVertical=true)
	private String sum_amount_team;
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

	public String getSum_amount() {
		return sum_amount;
	}

	public void setSum_amount(String sum_amount) {
		this.sum_amount = sum_amount;
	}

	public String getPercentages() {
		return percentages;
	}

	public void setPercentages(String percentages) {
		this.percentages = percentages;
	}

	public String getSum_percentages() {
		return sum_percentages;
	}

	public void setSum_percentages(String sum_percentages) {
		this.sum_percentages = sum_percentages;
	}

	public String getSum_amount_team() {
		return sum_amount_team;
	}

	public void setSum_amount_team(String sum_amount_team) {
		this.sum_amount_team = sum_amount_team;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}