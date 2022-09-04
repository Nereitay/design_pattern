package es.kiwi.Behavioral.command.extension.revocable;

/**
 *命令接口,声明执行的操作，支持可撤销操作
 * 补偿式（反操作式）
 */
public interface Command {
    /**
     * 执行命令对应的操作
     */
    void execute();

    /**
     * 执行撤销命令对应的操作
     */
    void undo();
}
