package es.kiwi.Behavioral.template_method.mosh;

public abstract class Task {
    
    private AuditTrail auditTrail;

    /**
     * 加上后子类就不需要重写有参构造方法
     */
    public Task() {
        auditTrail = new AuditTrail();
    }

    public Task(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }
    
    public void execute() {
        auditTrail.record();
        
        doExecute();
    }

    protected abstract void doExecute();
}
