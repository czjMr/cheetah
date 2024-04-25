package com.cheetah.design.code;

import java.math.BigDecimal;

public class TransPartnerDTO {

    private static final long serialVersionUID = -6309129434731051194L;

    private String partnerRole;

    private String memberNo;

    private Integer memberNoType;

    private String feeCode;

    private BigDecimal amount;

    public String getPartnerRole() {
        return partnerRole;
    }

    /**
     * @param partnerRole 参与方角色
     * @occurs required
     */
    public void setPartnerRole(String partnerRole) {
        this.partnerRole = partnerRole;
    }

    public String getMemberNo() {
        return memberNo;
    }

    /**
     * @param memberNo 参与方会员号
     * @occurs required
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

	public Integer getMemberNoType() {
		return memberNoType;
	}

	/**
	 * @param memberNoType 参与方会员类型
	 * @occurs required
	 */
	public void setMemberNoType(Integer memberNoType) {
		this.memberNoType = memberNoType;
	}

	public String getFeeCode() {
        return feeCode;
    }

    /**
     * @param feeCode 费项码值（无需指定费项金额时不传）
     * @occurs optional
     */
    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount 参与方金额（无需指定费项金额时不传）
     * @occurs optional
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
