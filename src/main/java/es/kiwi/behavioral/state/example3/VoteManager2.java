package es.kiwi.behavioral.state.example3;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>添加新功能和修改已有功能后需要修改上下文</p>
 * 投票管理
 */
public class VoteManager2 {
    /**
     * 持有状态处理对象
     */
    private VoteState state;

    /**
     * 记录用户投票的结果,Map<String,String>对应Map<用户名称,投票的选项>
     */
    private Map<String, String> mapVote = new HashMap<>();
    /**
     * 记录用户投票次数,Map<String,Integer>对应Map<用户名称,投票的次数>
     */
    private Map<String, Integer> mapVoteCount = new HashMap<>();

    /**
     * 获取记录用户投票结果的Map
     *
     * @return 记录用户投票结果的Map
     */
    public Map<String, String> getMapVote() {
        return mapVote;
    }

    /**
     * 投票
     *
     * @param user     投票人，为了简单，就是用户名称
     * @param voteItem 投票的选项
     */
    public void vote(String user, String voteItem) {
        //1：先为该用户增加投票的次数
        //先从记录中取出已有的投票次数
        Integer oldVoteCount = mapVoteCount.get(user);
        if (oldVoteCount == null) {
            oldVoteCount = 0;
        }
        oldVoteCount = oldVoteCount + 1;
        mapVoteCount.put(user, oldVoteCount);

        //2：判断该用户投票的类型，就相当于是判断对应的状态
        //到底是正常投票、重复投票、恶意投票还是上黑名单的状态
        if (oldVoteCount == 1) {
            state = new NormalVoteState2(); /*已有功能修改*/
        } else if (oldVoteCount > 1 && oldVoteCount < 5) {
            state = new RepeatVoteState();
        } else if (oldVoteCount >= 5 && oldVoteCount < 8) {
            state = new SpiteVoteState();
        } else if (oldVoteCount >= 8 && oldVoteCount < 10) {/*添加的新功能*/
            state = new BlackWarnVoteState();
        } else if (oldVoteCount > 10) {
            state = new BlackVoteState();
        }

        //然后转调状态对象来进行相应的操作
//        state.vote(user, voteItem, this);
    }

    /*
    * 问题：并没有完全遵循OCP原则
    * */

}
