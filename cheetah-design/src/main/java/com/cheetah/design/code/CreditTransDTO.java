package com.cheetah.design.code;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 信贷交易记账
 * @mqConsumer gmcf-ctc-credit-trans-topic
 */
public class CreditTransDTO {

	private static final long serialVersionUID = 7510746512148668643L;

	private String trackingNo;

	private String transCode;

	private String memberNo;

	private String loanNo;

	private String bizOrderNo;

	private String bizSysCode;

	private String productCode;

	private String businessGroupCode;

	private String capitalCode;

	private String biddingNo;

	private BigDecimal totalAmount;

	private String currency;

	private Date businessDate;

	private Date accountingDate;

	private Date accBizDate;

	private Integer ageAccount;

	private Integer preAgeAccount;

	private Boolean isOffBalance = false;

	private String owningBranch ;

	private List<TransPartnerDTO> partners;

	/**应付日期*/
	private Date originBusinessDate;

	public Date getOriginBusinessDate() {
		return originBusinessDate;
	}

	public void setOriginBusinessDate(Date originBusinessDate) {
		this.originBusinessDate = originBusinessDate;
	}

	public String getTrackingNo() {
		return trackingNo;
	}

	/**
	 * @param trackingNo 追踪编号
	 * @occurs required
	 */
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}


	public String getOwningBranch() {
		return owningBranch;
	}

	public void setOwningBranch(String owningBranch) {
		this.owningBranch = owningBranch;
	}

	public String getTransCode() {
		return transCode;
	}

	/**
	 * @param transCode 交易码
	 * @occurs required
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * @param memberNo 会员号
	 * @occurs required
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getLoanNo() {
		return loanNo;
	}

	/**
	 * @param loanNo 通用贷款单
	 * @occurs required
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getBizOrderNo() {
		return bizOrderNo;
	}

	/**
	 * @param bizOrderNo 业务订单号
	 * @occurs required
	 */
	public void setBizOrderNo(String bizOrderNo) {
		this.bizOrderNo = bizOrderNo;
	}

	public String getBizSysCode() {
		return bizSysCode;
	}

	/**
	 * @param bizSysCode 业务系统编号
	 * @occurs required
	 */
	public void setBizSysCode(String bizSysCode) {
		this.bizSysCode = bizSysCode;
	}

	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode 产品编码
	 * @occurs required
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCapitalCode() {
		return capitalCode;
	}

	/**
	 * @param businessGroupCode 产品组，业务线
	 * @occurs required
	 */
	public void setBusinessGroupCode(String businessGroupCode) {
		this.businessGroupCode = businessGroupCode;
	}

	public String getBusinessGroupCode() {
		return businessGroupCode;
	}

	/**
	 * @param capitalCode 资方编码
	 * @occurs required
	 */
	public void setCapitalCode(String capitalCode) {
		this.capitalCode = capitalCode;
	}

	public String getBiddingNo() {
		return biddingNo;
	}

	/**
	 * @param biddingNo 标的编号
	 * @occurs required
	 */
	public void setBiddingNo(String biddingNo) {
		this.biddingNo = biddingNo;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount 交易总金额
	 * @occurs required
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency 币种
	 * @occurs required
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getBusinessDate() {
		return businessDate;
	}

	/**
	 * @param businessDate 业务发生日期
	 * @occurs required
	 */
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}

	public Date getAccountingDate() {
		return accountingDate;
	}

	/**
	 * @param accountingDate 记账日期
	 * @occurs required
	 */
	public void setAccountingDate(Date accountingDate) {
		this.accountingDate = accountingDate;
	}

	public Date getAccBizDate() {
		return accBizDate;
	}

	/**
	 * @param accBizDate 会计业务日期(可以为空)
	 * @occurs required
	 */
	public void setAccBizDate(Date accBizDate) {
		this.accBizDate = accBizDate;
	}

	public Integer getAgeAccount() {
		return ageAccount;
	}

	/**
	 * @param ageAccount 当前账龄
	 * @occurs required
	 */
	public void setAgeAccount(Integer ageAccount) {
		this.ageAccount = ageAccount;
	}

	public Integer getPreAgeAccount() {
		return preAgeAccount;
	}

	/**
	 * @param preAgeAccount 上一账龄
	 * @occurs required
	 */
	public void setPreAgeAccount(Integer preAgeAccount) {
		this.preAgeAccount = preAgeAccount;
	}

	public List<TransPartnerDTO> getPartners() {
		return partners;
	}

	/**
	 * @param partners 交易参与方
	 * @occurs required
	 */
	public void setPartners(List<TransPartnerDTO> partners) {
		this.partners = partners;
	}

	public Boolean getIsOffBalance() {
		return isOffBalance;
	}

	/**
	 * 是否表外
	 * @param isOffBalance
	 */
	public void setIsOffBalance(Boolean isOffBalance) {
		this.isOffBalance = isOffBalance;
	}
}
