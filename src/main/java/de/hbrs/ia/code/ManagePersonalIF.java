package de.hbrs.ia.code;

import de.hbrs.ia.model.SalesMan;

import java.util.List;

/**
 * Code lines are commented for suppressing compile errors.
 */
public interface ManagePersonalIF {
    public void createSalesMan( SalesMan record );

    //public void addPerformanceReord( EvaluationRecord record , int sid );

    public SalesMan readSalesMan(int sid );
    // public void deleteSalesMan(int sid);
    // public void updateSalesMan(SalesMan s);
    // public List<SalesMan> querySalesMan(String attribute , String key );
    public EvaluationRecord readEvaluationRecords( int sid );
    // public void deleteEvaluationRecords(int sid);
    // public EvaluationRecord updateEvaluationRecords(int sid);



}
