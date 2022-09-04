package es.kiwi.Behavioral.state.extension.state_maintenance;


/**
 * 封装一个投票状态行为
 */
public interface VoteState {

    /**
     * 处理状态对应的行为
     * @param user 投票人
     * @param voteItem 投票项
     * @param voteManager 投票上下文，用来在实现状态对应的功能处理的时候，可以回调上下文的数据
     */
    void vote(String user, String voteItem, VoteManager voteManager);


}
