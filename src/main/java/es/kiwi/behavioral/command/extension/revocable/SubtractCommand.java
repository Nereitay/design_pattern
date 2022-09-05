package es.kiwi.behavioral.command.extension.revocable;

public class SubtractCommand implements Command{
    /**
     * 持有具体执行计算的对象
     */
    private OperationApi operation = null;

    /**
     * 操作的数据，也就是要加上的数据
     */
    private int opeNum;


    @Override
    public void execute() {
        //转调接收者去执行功能，这个命令式做减法
        this.operation.subtract(opeNum);
    }

    @Override
    public void undo() {
        //转调接收者去真正执行功能
        //命令本身是做减法，那么撤销的时候就是做加法
        this.operation.add(opeNum);

    }

    /**
     * 构造方法。传入具体执行计算的对象
     * @param operation 具体执行计算的对象
     * @param opeNum 要加上的数据
     */
    public SubtractCommand(OperationApi operation, int opeNum) {
        this.operation = operation;
        this.opeNum = opeNum;
    }
}
