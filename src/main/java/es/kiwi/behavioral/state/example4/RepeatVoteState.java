package es.kiwi.behavioral.state.example4;


public class RepeatVoteState implements VoteState {
    /**
     * 处理状态对应的行为
     *
     * @param user        投票人
     * @param voteItem    投票项
     * @param voteManager 投票上下文，用来在实现状态对应的功能处理的时候，
     *                    可以回调上下文的数据
     */
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //重复投票
        //暂时不做处理
        System.out.println("请不要重复投票");

        //重复投票完成，维护下一个状态，重复投票到5次，就算恶意投票了
        //注意这里是判断大于等于4，因为这里设置的是下一个状态
        //下一个操作次数就是5了，就应该算是恶意投票了
        if(voteManager.getMapVoteCount().get(user) >= 4){
            voteManager.getMapState().put(user, new SpiteVoteState());
        }
    }
}
