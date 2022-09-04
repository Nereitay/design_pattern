package es.kiwi.Behavioral.template_method.mosh;

public class GenerateReportTask1 extends Task{


   /* public GenerateReportTask1(AuditTrail auditTrail) {
        super(auditTrail);
    }
*/
    @Override
    protected void doExecute() {
        System.out.println("Generate Report");
    }
}
