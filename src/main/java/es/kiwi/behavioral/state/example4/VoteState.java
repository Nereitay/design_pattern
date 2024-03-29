package es.kiwi.behavioral.state.example4;


/**
 * <p>在状态的处理类中进行 状态的维护和转换控制</p>
 * 封装一个投票状态相关的行为
 */
public interface VoteState {
    /**
     * 处理状态对应的行为
     *
     * @param user        投票人
     * @param voteItem    投票项
     * @param voteManager 投票上下文，用来在实现状态对应的功能处理的时候，
     *                    可以回调上下文的数据
     */
    void vote(String user, String voteItem, VoteManager voteManager);
}
