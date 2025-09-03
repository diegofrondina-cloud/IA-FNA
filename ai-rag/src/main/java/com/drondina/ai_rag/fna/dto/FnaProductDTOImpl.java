package com.drondina.ai_rag.fna.dto;

import java.time.LocalDateTime;

public class FnaProductDTOImpl implements FnaProductDTO {
    
    private Long id;
    private Long fnaId;
    private Long pofId;
    private String status;
    private LocalDateTime reviewSpectedDate;
    private String reviewSpectedDateString;
    private Integer isDraFormNeeded;
    private String podDisplayName;
    private String bookingType;
    private LocalDateTime submissionDate;
    private String submissionDateString;
    private LocalDateTime completedDate;
    private String completedDateString;
    private String disbResponse;
    private String lfsResponse;
    private String trsResponse;
    private String actResponse;
    private String finOpsResponse;
    private String finalDecision;
    private String disbReturnReason;
    private String lfsReturnReason;
    private String trsReturnReason;
    private String actReturnReason;
    private String finOpsReturnReason;
    private String returnReason;
    private LocalDateTime versionLastUpdate;
    private Long version;
    private Boolean isActive;
    private String processStep;
    private String valResponse;
    private Boolean isDisbResponseSubmitted;
    private Boolean isLfsResponseSubmitted;
    private Boolean isTrsResponseSubmitted;
    private Boolean isActResponseSubmitted;
    private Boolean isFinopsResponseSubmitted;
    private Boolean isValResponseSubmitted;

    // Constructor por defecto
    public FnaProductDTOImpl() {}

    // Getters
    @Override
    public Long getId() { return id; }
    
    @Override
    public Long getFnaId() { return fnaId; }
    
    @Override
    public Long getPofId() { return pofId; }
    
    @Override
    public String getStatus() { return status; }
    
    @Override
    public LocalDateTime getReviewSpectedDate() { return reviewSpectedDate; }
    
    @Override
    public String getReviewSpectedDateString() { return reviewSpectedDateString; }
    
    @Override
    public Integer getIsDraFormNeeded() { return isDraFormNeeded; }
    
    @Override
    public String getPodDisplayName() { return podDisplayName; }
    
    @Override
    public String getBookingType() { return bookingType; }
    
    @Override
    public LocalDateTime getSubmissionDate() { return submissionDate; }
    
    @Override
    public String getSubmissionDateString() { return submissionDateString; }
    
    @Override
    public LocalDateTime getCompletedDate() { return completedDate; }
    
    @Override
    public String getCompletedDateString() { return completedDateString; }
    
    @Override
    public String getDisbResponse() { return disbResponse; }
    
    @Override
    public String getLfsResponse() { return lfsResponse; }
    
    @Override
    public String getTrsResponse() { return trsResponse; }
    
    @Override
    public String getActResponse() { return actResponse; }
    
    @Override
    public String getFinOpsResponse() { return finOpsResponse; }
    
    @Override
    public String getFinalDecision() { return finalDecision; }
    
    @Override
    public String getDisbReturnReason() { return disbReturnReason; }
    
    @Override
    public String getLfsReturnReason() { return lfsReturnReason; }
    
    @Override
    public String getTrsReturnReason() { return trsReturnReason; }
    
    @Override
    public String getActReturnReason() { return actReturnReason; }
    
    @Override
    public String getFinOpsReturnReason() { return finOpsReturnReason; }
    
    @Override
    public String getReturnReason() { return returnReason; }
    
    @Override
    public LocalDateTime getVersionLastUpdate() { return versionLastUpdate; }
    
    @Override
    public Long getVersion() { return version; }
    
    @Override
    public Boolean getIsActive() { return isActive; }
    
    @Override
    public String getProcessStep() { return processStep; }
    
    @Override
    public String getValResponse() { return valResponse; }
    
    @Override
    public Boolean getIsDisbResponseSubmitted() { return isDisbResponseSubmitted; }
    
    @Override
    public Boolean getIsLfsResponseSubmitted() { return isLfsResponseSubmitted; }
    
    @Override
    public Boolean getIsTrsResponseSubmitted() { return isTrsResponseSubmitted; }
    
    @Override
    public Boolean getIsActResponseSubmitted() { return isActResponseSubmitted; }
    
    @Override
    public Boolean getIsFinopsResponseSubmitted() { return isFinopsResponseSubmitted; }
    
    @Override
    public Boolean getIsValResponseSubmitted() { return isValResponseSubmitted; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setFnaId(Long fnaId) { this.fnaId = fnaId; }
    public void setPofId(Long pofId) { this.pofId = pofId; }
    public void setStatus(String status) { this.status = status; }
    public void setReviewSpectedDate(LocalDateTime reviewSpectedDate) { this.reviewSpectedDate = reviewSpectedDate; }
    public void setReviewSpectedDateString(String reviewSpectedDateString) { this.reviewSpectedDateString = reviewSpectedDateString; }
    public void setIsDraFormNeeded(Integer isDraFormNeeded) { this.isDraFormNeeded = isDraFormNeeded; }
    public void setPodDisplayName(String podDisplayName) { this.podDisplayName = podDisplayName; }
    public void setBookingType(String bookingType) { this.bookingType = bookingType; }
    public void setSubmissionDate(LocalDateTime submissionDate) { this.submissionDate = submissionDate; }
    public void setSubmissionDateString(String submissionDateString) { this.submissionDateString = submissionDateString; }
    public void setCompletedDate(LocalDateTime completedDate) { this.completedDate = completedDate; }
    public void setCompletedDateString(String completedDateString) { this.completedDateString = completedDateString; }
    public void setDisbResponse(String disbResponse) { this.disbResponse = disbResponse; }
    public void setLfsResponse(String lfsResponse) { this.lfsResponse = lfsResponse; }
    public void setTrsResponse(String trsResponse) { this.trsResponse = trsResponse; }
    public void setActResponse(String actResponse) { this.actResponse = actResponse; }
    public void setFinOpsResponse(String finOpsResponse) { this.finOpsResponse = finOpsResponse; }
    public void setFinalDecision(String finalDecision) { this.finalDecision = finalDecision; }
    public void setDisbReturnReason(String disbReturnReason) { this.disbReturnReason = disbReturnReason; }
    public void setLfsReturnReason(String lfsReturnReason) { this.lfsReturnReason = lfsReturnReason; }
    public void setTrsReturnReason(String trsReturnReason) { this.trsReturnReason = trsReturnReason; }
    public void setActReturnReason(String actReturnReason) { this.actReturnReason = actReturnReason; }
    public void setFinOpsReturnReason(String finOpsReturnReason) { this.finOpsReturnReason = finOpsReturnReason; }
    public void setReturnReason(String returnReason) { this.returnReason = returnReason; }
    public void setVersionLastUpdate(LocalDateTime versionLastUpdate) { this.versionLastUpdate = versionLastUpdate; }
    public void setVersion(Long version) { this.version = version; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public void setProcessStep(String processStep) { this.processStep = processStep; }
    public void setValResponse(String valResponse) { this.valResponse = valResponse; }
    public void setIsDisbResponseSubmitted(Boolean isDisbResponseSubmitted) { this.isDisbResponseSubmitted = isDisbResponseSubmitted; }
    public void setIsLfsResponseSubmitted(Boolean isLfsResponseSubmitted) { this.isLfsResponseSubmitted = isLfsResponseSubmitted; }
    public void setIsTrsResponseSubmitted(Boolean isTrsResponseSubmitted) { this.isTrsResponseSubmitted = isTrsResponseSubmitted; }
    public void setIsActResponseSubmitted(Boolean isActResponseSubmitted) { this.isActResponseSubmitted = isActResponseSubmitted; }
    public void setIsFinopsResponseSubmitted(Boolean isFinopsResponseSubmitted) { this.isFinopsResponseSubmitted = isFinopsResponseSubmitted; }
    public void setIsValResponseSubmitted(Boolean isValResponseSubmitted) { this.isValResponseSubmitted = isValResponseSubmitted; }
}
