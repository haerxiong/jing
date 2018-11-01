package com.jeecg.jing.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
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
@Entity
@SuppressWarnings("serial")
public class ZTakeinTotalEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	private Date createDate;
	/**更新人名称*/
	private String updateName;
	/**更新人登录名称*/
	private String updateBy;
	/**更新日期*/
	private Date updateDate;
	/**是否删除*/
	@Excel(name="是否删除",width=15)
	private String isDel;
	/**销售姓名*/
	@Excel(name="销售姓名",width=15)
	private String saleName;
	/**客户姓名*/
	@Excel(name="客户姓名",width=15)
	private String customName;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private String idCard;
	/**利率*/
	@Excel(name="利率",width=15)
	private BigDecimal rate;
	/**电话*/
	@Excel(name="电话",width=15)
	private String phone;
	/**汇款账号*/
	@Excel(name="汇款账号",width=15)
	private String bankAccount;
	/**到期时间*/
	@Excel(name="投资时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	/**备注*/
	@Excel(name="备注",width=15)
	private String comment;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否删除
	 */

	@Column(name ="IS_DEL",nullable=true,length=32)
	public String getIsDel(){
		return this.isDel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否删除
	 */
	public void setIsDel(String isDel){
		this.isDel = isDel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售姓名
	 */

	@Column(name ="SALE_NAME",nullable=true,length=64)
	public String getSaleName(){
		return this.saleName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售姓名
	 */
	public void setSaleName(String saleName){
		this.saleName = saleName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户姓名
	 */

	@Column(name ="CUSTOM_NAME",nullable=true,length=64)
	public String getCustomName(){
		return this.customName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setCustomName(String customName){
		this.customName = customName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="ID_CARD",nullable=true,length=32)
	public String getIdCard(){
		return this.idCard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdCard(String idCard){
		this.idCard = idCard;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  利率
	 */

	@Column(name ="RATE",nullable=true,length=32)
	public BigDecimal getRate(){
		return this.rate;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  利率
	 */
	public void setRate(BigDecimal rate){
		this.rate = rate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */

	@Column(name ="PHONE",nullable=true,length=32)
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  汇款账号
	 */

	@Column(name ="BANK_ACCOUNT",nullable=true,length=32)
	public String getBankAccount(){
		return this.bankAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  汇款账号
	 */
	public void setBankAccount(String bankAccount){
		this.bankAccount = bankAccount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  到期时间
	 */

	@Column(name ="END_TIME",nullable=true,length=32)
	public Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  到期时间
	 */
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="COMMENT",nullable=true,length=256)
	public String getComment(){
		return this.comment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setComment(String comment){
		this.comment = comment;
	}
}