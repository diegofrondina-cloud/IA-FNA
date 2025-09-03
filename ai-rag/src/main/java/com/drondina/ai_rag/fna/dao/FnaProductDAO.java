package com.drondina.ai_rag.fna.dao;

import com.drondina.ai_rag.fna.dto.FnaProductDTOImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FnaProductDAO {

    private final JdbcClient jdbcClient;

    public FnaProductDAO(@Qualifier("oracleDataSource") DataSource oracleDataSource) {
        this.jdbcClient = JdbcClient.create(oracleDataSource);
    }

    private static final String FNA_PRODUCT_QUERY =
            "SELECT  " +
                    "fpr.id AS id, " +
                    "fpr.fna_id AS fnaId, " +
                    "fpr.pof_id AS pofId, " +
                    "fpr.status AS status, " +
                    "fpr.DRA_FORM_NEEDED AS isDraFormNeeded, " +
                    "fpr.RETURN_REASON AS returnReason, " +
                    "fpr.DISB_RETURN_REASON AS disbReturnReason, " +
                    "fpr.LFS_RETURN_REASON AS lfsReturnReason, " +
                    "fpr.TRS_RETURN_REASON AS trsReturnReason, " +
                    "fpr.ACT_RETURN_REASON AS actReturnReason, " +
                    "fpr.FINOPS_RETURN_REASON AS finopsReturnReason, " +
                    "fpr.VAL_RETURN_REASON AS valReturnReason, " +
                    "TRUNC(TO_TIMESTAMP_TZ(fpr.REVIEW_SPECT_DATE,'DD-MON-YY HH.MI.SS.FF9 AM TZR'),'DD') AS reviewSpectedDate, " +
                    "TRUNC(TO_TIMESTAMP_TZ(fpr.SUBMISSION_DATE,'DD-MON-YY HH.MI.SS.FF9 AM TZR'),'DD') AS submissionDate, " +
                    "TRUNC(TO_TIMESTAMP_TZ(fpr.COMPLETED_DATE,'DD-MON-YY HH.MI.SS.FF9 AM TZR'),'DD') AS completedDate, " +
                    "TO_CHAR(TRUNC(TO_TIMESTAMP_TZ(fpr.REVIEW_SPECT_DATE,'DD-MON-YY HH.MI.SS.FF9 AM TZR'),'DD'),'DD-Mon-YYYY') AS reviewSpectedDateString, " +
                    "TO_CHAR(TRUNC(TO_TIMESTAMP_TZ(fpr.SUBMISSION_DATE,'DD-MON-YY HH.MI.SS.FF9 AM TZR'),'DD'),'DD-Mon-YYYY') AS submissionDateString, " +
                    "TO_CHAR(TRUNC(TO_TIMESTAMP_TZ(fpr.COMPLETED_DATE,'DD-MON-YY HH.MI.SS.FF9 AM TZR'),'DD'),'DD-Mon-YYYY') AS completedDateString, " +
                    "fpr.FINAL_DECISION AS finalDecision, " +
                    "fpr.VERSION_LAST_UPDATED AS versionLastUpdate, " +
                    "fpr.VERSION_ACTIVE AS isActive, " +
                    "fpr.VERSION AS version, " +
                    "fpr.PROCESS_STEP AS processStep, " +
                    "fpr.DISB_RESPONSE_SUBMITTED_FLAG AS isDisbResponseSubmitted, " +
                    "fpr.LFS_RESPONSE_SUBMITTED_FLAG AS isLfsResponseSubmitted, " +
                    "fpr.TRS_RESPONSE_SUBMITTED_FLAG AS isTrsResponseSubmitted, " +
                    "fpr.ACT_RESPONSE_SUBMITTED_FLAG AS isActResponseSubmitted, " +
                    "fpr.VAL_RESPONSE_SUBMITTED_FLAG AS isValResponseSubmitted, " +
                    "fpr.FINOPS_RESPONSE_SUBMITTED_FLAG AS isFinopsResponseSubmitted ";

    private static final String FNA_PRODUCT_APPEND_RESPONSES_QUERY =
            ", fpr.DISB_RESPONSE AS disbResponse, " +
                    "fpr.LFS_RESPONSE AS lfsResponse, " +
                    "fpr.TRS_RESPONSE AS trsResponse, " +
                    "fpr.FINOPS_DECISION AS finOpsResponse, " +
                    "fpr.VAL_RESPONSE AS valResponse, " +
                    "fpr.ACT_RESPONSE AS actResponse, " +
                    "pod.DISPLAY_NAME AS podDisplayName, " +
                    "pfa.MANAGING_ENTITY_CODE_PV2 AS bookingType ";

    // ================== MÉTODOS ==================

    public List<FnaProductDTOImpl> findAllByFnaId(Long fnaId, Long pofId) {
        String sql = FNA_PRODUCT_QUERY + FNA_PRODUCT_APPEND_RESPONSES_QUERY +
                " FROM FNA_PRODUCT_FPR fpr " +
                " JOIN PRODUCT_OFFERING_POF pof ON pof.ID = fpr.POF_ID " +
                " JOIN PRODUCT_OFFERING_DEFS_POD pod ON pod.ID = pof.POD_ID " +
                " JOIN P_FUNDING_ACCOUNT_PFA pfa ON pfa.POF_ID = pof.ID " +
                " WHERE fpr.fna_id = :fnaId AND fpr.pof_id = :pofId " +
                " ORDER BY fpr.version ASC";

        return jdbcClient.sql(sql)
                .param("fnaId", fnaId)
                .param("pofId", pofId)
                .query(FnaProductDTOImpl.class)
                .list();
    }

    public List<FnaProductDTOImpl> findAllByFnaIdRestrictedView(Long fnaId, Long pofId) {
        String sql = FNA_PRODUCT_QUERY +
                " FROM FNA_PRODUCT_FPR fpr " +
                " WHERE fpr.fna_id = :fnaId AND fpr.pof_id = :pofId " +
                " ORDER BY fpr.version ASC";

        return jdbcClient.sql(sql)
                .param("fnaId", fnaId)
                .param("pofId", pofId)
                .query(FnaProductDTOImpl.class)
                .list();
    }

    public FnaProductDTOImpl findByProductId(Long fnaProductId) {
        String sql = FNA_PRODUCT_QUERY + FNA_PRODUCT_APPEND_RESPONSES_QUERY +
                " FROM FNA_PRODUCT_FPR fpr " +
                " JOIN PRODUCT_OFFERING_POF pof ON pof.ID = fpr.POF_ID " +
                " JOIN PRODUCT_OFFERING_DEFS_POD pod ON pod.ID = pof.POD_ID " +
                " JOIN P_FUNDING_ACCOUNT_PFA pfa ON pfa.POF_ID = pof.ID " +
                " WHERE fpr.id = :fnaProductId";

        return jdbcClient.sql(sql)
                .param("fnaProductId", fnaProductId)
                .query(FnaProductDTOImpl.class)
                .single();
    }
}
