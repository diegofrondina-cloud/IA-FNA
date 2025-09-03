package com.uncledavecode.ai_rag.fna.dto;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
public interface FnaProductDTO {
    Long getId();
    Long getFnaId();
    Long getPofId();
    String getStatus();
    LocalDateTime getReviewSpectedDate();
    String getReviewSpectedDateString();
    Integer getIsDraFormNeeded();
    String getPodDisplayName();
    String getBookingType();
    LocalDateTime getSubmissionDate();
    String getSubmissionDateString();
    LocalDateTime getCompletedDate();
    String getCompletedDateString();
    String getDisbResponse();
    String getLfsResponse();
    String getTrsResponse();
    String getActResponse();
    String getFinOpsResponse();
    String getFinalDecision();
    String getDisbReturnReason();
    String getLfsReturnReason();
    String getTrsReturnReason();
    String getActReturnReason();
    String getFinOpsReturnReason();
    String getReturnReason();
    LocalDateTime getVersionLastUpdate();
    Long getVersion();
    //@Value("#{target.isActive != null ? T(java.lang.Character).valueOf('1').equals(target.isActive) : false}")
    Boolean getIsActive();
    String getProcessStep();
    String getValResponse();

   // @Value("#{target.isDisbResponseSubmitted != null ? T(java.lang.Character).valueOf('1').equals(target.isDisbResponseSubmitted) : false}")
    Boolean getIsDisbResponseSubmitted();
    //@Value("#{target.isLfsResponseSubmitted != null ? T(java.lang.Character).valueOf('1').equals(target.isLfsResponseSubmitted) : false}")
    Boolean getIsLfsResponseSubmitted();
   // @Value("#{target.isTrsResponseSubmitted != null ? T(java.lang.Character).valueOf('1').equals(target.isTrsResponseSubmitted) : false}")
    Boolean getIsTrsResponseSubmitted();
    //@Value("#{target.isActResponseSubmitted != null ? T(java.lang.Character).valueOf('1').equals(target.isActResponseSubmitted) : false}")
    Boolean getIsActResponseSubmitted();
   // @Value("#{target.isFinopsResponseSubmitted != null ? T(java.lang.Character).valueOf('1').equals(target.isFinopsResponseSubmitted) : false}")
    Boolean getIsFinopsResponseSubmitted();
   // @Value("#{target.isValResponseSubmitted != null ? T(java.lang.Character).valueOf('1').equals(target.isValResponseSubmitted) : false}")
    Boolean getIsValResponseSubmitted();
}
