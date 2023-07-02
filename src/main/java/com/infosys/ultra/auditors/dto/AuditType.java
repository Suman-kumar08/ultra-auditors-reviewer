package com.infosys.ultra.auditors.dto;

public enum AuditType {
	INTERNAL_AUDIT("INTERNAL AUDIT)"),
	EXTERNAL_AUDIT("EXTERNAL AUDIT"),
	TAX_AUDIT("TAX AUDIT"),
	FINANCIAL_AUDIT("FINANCIAL AUDIT"),
	OPERATIONAL_AUDIT("OPERATIONAL AUDIT"),
	INFORMATION_SYSTEM_AUDIT("INFORMATION SYSTEM AUDIT"),
	STATUTORY_AUDIT("STATUTORY AUDIT"),
	COMPLIANCE_AUDIT("COMPLIANCE AUDIT"),
	FORENSIC_AUDIT("FORENSIC AUDIT");
    private String auditType;
	AuditType(String auditType) {
		this.auditType=auditType;
	}
	public String getAuditType() {
        return this.auditType;
    }  
	
}
