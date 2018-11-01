package com.jeecg.jing.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 客户信息
 * @author onlineGenerator
 * @date 2018-11-01 09:53:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_takein", schema = "")
@SuppressWarnings("serial")
public class ZTakeinEntity implements java.io.Serializable {
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
	/**是否删除*/
	private java.lang.String isDel;
	/**合同编号*/
	@Excel(name="合同编号",width=15)
	private java.lang.String contract;
	/**收据编号*/
	@Excel(name="收据编号",width=15)
	private java.lang.String receipt;
	/**销售姓名*/
	@Excel(name="销售姓名",width=15)
	private java.lang.String saleName;
	/**客户姓名*/
	@Excel(name="客户姓名",width=15)
	private java.lang.String customName;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String idCard;
	/**入金时间*/
	@Excel(name="入金时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date takeinTime;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.math.BigDecimal amount;
	/**期限*/
	@Excel(name="期限",width=15)
	private java.lang.Integer timeLimit;
	/**利率*/
	@Excel(name="利率",width=15)
	private java.math.BigDecimal rate;
	/**电话*/
	@Excel(name="电话",width=15)
	private java.lang.String phone;
	/**汇款账号*/
	@Excel(name="汇款账号",width=15)
	private java.lang.String bankAccount;
	/**到期时间*/
	@Excel(name="到期时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date endTime;
	/**出金时间*/
	@Excel(name="出金时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date outTime;
	/**投资时间*/
	@Excel(name="投资时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date investTime;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String comment;
	/**状态*/
	@Excel(name="状态",width=15, dicCode = "takein")
	private java.lang.String status;

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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否删除
	 */

	@Column(name ="IS_DEL",nullable=true,length=32)
	public java.lang.String getIsDel(){
		return this.isDel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否删除
	 */
	public void setIsDel(java.lang.String isDel){
		this.isDel = isDel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号
	 */

	@Column(name ="CONTRACT",nullable=true,length=64)
	public java.lang.String getContract(){
		return this.contract;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同编号
	 */
	public void setContract(java.lang.String contract){
		this.contract = contract;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收据编号
	 */

	@Column(name ="RECEIPT",nullable=true,length=64)
	public java.lang.String getReceipt(){
		return this.receipt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收据编号
	 */
	public void setReceipt(java.lang.String receipt){
		this.receipt = receipt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售姓名
	 */

	@Column(name ="SALE_NAME",nullable=true,length=64)
	public java.lang.String getSaleName(){
		return this.saleName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售姓名
	 */
	public void setSaleName(java.lang.String saleName){
		this.saleName = saleName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户姓名
	 */

	@Column(name ="CUSTOM_NAME",nullable=true,length=64)
	public java.lang.String getCustomName(){
		return this.customName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setCustomName(java.lang.String customName){
		this.customName = customName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="ID_CARD",nullable=true,length=32)
	public java.lang.String getIdCard(){
		return this.idCard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdCard(java.lang.String idCard){
		this.idCard = idCard;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入金时间
	 */

	@Column(name ="TAKEIN_TIME",nullable=true,length=32)
	public java.util.Date getTakeinTime(){
		return this.takeinTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入金时间
	 */
	public void setTakeinTime(java.util.Date takeinTime){
		this.takeinTime = takeinTime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  金额
	 */

	@Column(name ="AMOUNT",nullable=true,length=32)
	public java.math.BigDecimal getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  金额
	 */
	public void setAmount(java.math.BigDecimal amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  期限
	 */

	@Column(name ="TIME_LIMIT",nullable=true,length=32)
	public java.lang.Integer getTimeLimit(){
		return this.timeLimit;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  期限
	 */
	public void setTimeLimit(java.lang.Integer timeLimit){
		this.timeLimit = timeLimit;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  利率
	 */

	@Column(name ="RATE",nullable=true,length=32)
	public java.math.BigDecimal getRate(){
		return this.rate;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  利率
	 */
	public void setRate(java.math.BigDecimal rate){
		this.rate = rate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */

	@Column(name ="PHONE",nullable=true,length=32)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  汇款账号
	 */

	@Column(name ="BANK_ACCOUNT",nullable=true,length=32)
	public java.lang.String getBankAccount(){
		return this.bankAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  汇款账号
	 */
	public void setBankAccount(java.lang.String bankAccount){
		this.bankAccount = bankAccount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  到期时间
	 */

	@Column(name ="END_TIME",nullable=true,length=32)
	public java.util.Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  到期时间
	 */
	public void setEndTime(java.util.Date endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="COMMENT",nullable=true,length=256)
	public java.lang.String getComment(){
		return this.comment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setComment(java.lang.String comment){
		this.comment = comment;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="STATUS",nullable=true,length=32)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}

	@Column(name ="OUT_TIME",nullable=true,length=32)
	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	@Column(name ="INVEST_TIME",nullable=true,length=32)
	public Date getInvestTime() {
		return investTime;
	}

	public void setInvestTime(Date investTime) {
		this.investTime = investTime;
	}
}