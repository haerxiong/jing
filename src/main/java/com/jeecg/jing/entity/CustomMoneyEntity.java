package com.jeecg.jing.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 客户资金
 * @author onlineGenerator
 * @date 2018-10-29 14:28:05
 * @version V1.0   
 *
 */
@Entity
@Table(name = "custom_money", schema = "")
@SuppressWarnings("serial")
public class CustomMoneyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**投资时间*/
	@Excel(name="投资时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date investmentTime;
	/**客户量*/
	@Excel(name="客户量",width=15)
	private java.lang.String customeNum;
	/**序号*/
	@Excel(name="序号",width=15)
	private java.lang.String zindex;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.String amount;

	private ZTakeinEntity takeinId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAKEIN_ID", referencedColumnName = "id")
	public ZTakeinEntity getTakeinId() {
		return takeinId;
	}

	public void setTakeinId(ZTakeinEntity takeinId) {
		this.takeinId = takeinId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  投资时间
	 */

	@Column(name ="INVESTMENT_TIME",nullable=true,length=32)
	public java.util.Date getInvestmentTime(){
		return this.investmentTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  投资时间
	 */
	public void setInvestmentTime(java.util.Date investmentTime){
		this.investmentTime = investmentTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户量
	 */

	@Column(name ="CUSTOME_NUM",nullable=true,length=32)
	public java.lang.String getCustomeNum(){
		return this.customeNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户量
	 */
	public void setCustomeNum(java.lang.String customeNum){
		this.customeNum = customeNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  序号
	 */

	@Column(name ="ZINDEX",nullable=true,length=32)
	public java.lang.String getZindex(){
		return this.zindex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  序号
	 */
	public void setZindex(java.lang.String zindex){
		this.zindex = zindex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  金额
	 */

	@Column(name ="AMOUNT",nullable=true,length=32)
	public java.lang.String getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  金额
	 */
	public void setAmount(java.lang.String amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外键
	 */

}