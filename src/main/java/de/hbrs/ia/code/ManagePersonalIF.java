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

    // public List<SalesMan> querySalesMan(String attribute , String key );

    // public EvaluationRecord readEvaluationRecords( int sid );

}
