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
 * @Description: 销售表
 * @author onlineGenerator
 * @date 2018-11-02 09:27:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_sale", schema = "")
@SuppressWarnings("serial")
public class ZSaleEntity implements java.io.Serializable {
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
	@Excel(name="是否删除",width=15)
	private java.lang.String isDel;
	/**外键指向takein表*/
	@Excel(name="外键指向takein表",width=15)
	private java.lang.String takeinId;
	/**签单时间*/
	@Excel(name="签单时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date signTime;
	/**年化合计*/
	@Excel(name="年化合计",width=15)
	private java.math.BigDecimal yearTotal;
	/**合计*/
	@Excel(name="合计",width=15)
	private java.math.BigDecimal total;
	/**业绩年化*/
	@Excel(name="业绩年化",width=15)
	private java.math.BigDecimal performance;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String comment;
	
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
	 *@return: java.lang.String  外键指向takein表
	 */

	@Column(name ="TAKEIN_ID",nullable=true,length=36)
	public java.lang.String getTakeinId(){
		return this.takeinId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键指向takein表
	 */
	public void setTakeinId(java.lang.String takeinId){
		this.takeinId = takeinId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签单时间
	 */

	@Column(name ="SIGN_TIME",nullable=true,length=32)
	public java.util.Date getSignTime(){
		return this.signTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签单时间
	 */
	public void setSignTime(java.util.Date signTime){
		this.signTime = signTime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  年化合计
	 */

	@Column(name ="YEAR_TOTAL",nullable=true,length=32)
	public java.math.BigDecimal getYearTotal(){
		return this.yearTotal;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  年化合计
	 */
	public void setYearTotal(java.math.BigDecimal yearTotal){
		this.yearTotal = yearTotal;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  合计
	 */

	@Column(name ="TOTAL",nullable=true,length=32)
	public java.math.BigDecimal getTotal(){
		return this.total;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  合计
	 */
	public void setTotal(java.math.BigDecimal total){
		this.total = total;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  业绩年化
	 */

	@Column(name ="PERFORMANCE",nullable=true,length=32)
	public java.math.BigDecimal getPerformance(){
		return this.performance;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  业绩年化
	 */
	public void setPerformance(java.math.BigDecimal performance){
		this.performance = performance;
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
}