package es.kiwi.behavioral.state.example5;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>在状态的处理类中进行 状态的维护和转换控制</p>
 * 投票管理
 */
public class VoteManager {

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
     * 获取记录每个用户对应的投票次数的Map
     *
     * @return 记录每个用户对应的投票次数的Map
     */
    public Map<String, Integer> getMapVoteCount() {
        return mapVoteCount;
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

        /*直接从数据库获取该用户当前对应的状态编码*/
        VoteState state = null;
        //2：直接从数据库获取该用户对应的下一个状态的状态编码
        String stateId = "从数据库中获取这个状态编码";
        //开始根据状态编码来创建需用的状态对象
        if (stateId == null || stateId.trim().length() == 0) {
            //如果没有值，说明还没有投过票，就初始化一个正常投票状态
            state = new NormalVoteState();
        } else if ("重复投票".equals(stateId)) {
            state = new RepeatVoteState();
        } else if ("恶意投票".equals(stateId)) {
            state = new SpiteVoteState();
        } else if ("黑名单".equals(stateId)) {
            state = new BlackVoteState();
        }

        /*通过配置文件里配置状态编码和对应的状态处理类*/
        /*// 根据状态编码去获取相应的类
        String className = "根据状态编码去获取相应的类";
        // 使用反射创建对象实例，简单示意一下
        try {
            Class c = Class.forName(className);
            state = (VoteState) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        //3: 然后转调状态对象来进行相应的操作
        state.vote(user, voteItem, this);
    }

}
