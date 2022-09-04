package es.kiwi.Behavioral.command.extension.revocable;

/**
 * 运算类，真正实现加减法运算
 */
public class Operation implements OperationApi {
    /**
     * 记录运算的结果
     */
    private int result;

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public void add(int num) {

        //实现加法功能
        result += num;
    }

    @Override
    public void subtract(int num) {
        // 实现减法功能
        result -= num;

    }
}
