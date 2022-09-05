package es.kiwi.behavioral.template_method.mosh;

public class TransferMoneyTask1 extends Task{
/*
    public TransferMoneyTask1(AuditTrail auditTrail) {
        super(auditTrail);
    }*/

    @Override
    protected void doExecute() {
        System.out.println("Transfer Money");
    }
}
