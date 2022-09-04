package es.kiwi.Behavioral.state.extension.database;


import java.util.HashMap;
import java.util.Map;

/**
 * 投票管理
 */
public class VoteManager {

    private Map<String, String> mapVote = new HashMap<>();

    private Map<String, Integer> mapVoteCount = new HashMap<>();

   // private Map<String, VoteState> mapState = new HashMap<>();
    VoteState state = null;

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    public Map<String, Integer> getMapVoteCount() {
        return mapVoteCount;
    }

    /*public Map<String, VoteState> getMapState() {
        return mapState;
    }*/

    public void vote (String user, String voteItem) throws IllegalAccessException, InstantiationException,
            ClassNotFoundException {
        Integer oldVoteCount = mapVoteCount.get(user);
        if (oldVoteCount == null)
            oldVoteCount = 0;
        oldVoteCount ++;

        mapVoteCount.put(user, oldVoteCount);

        // 直接从数据库获取该用户对应的而下一个状态的状态编码
        //VoteState state = mapState.get(user);
        String stateId = "直接从数据库获取这个状态编码";
        /*if (stateId == null || stateId.trim().length() == 0) {
            //如果没有值，说明还没有投过票，就初始化一个正常投票状态
            state = new NormalVoteState();
        } else if ("重复投票".equals(stateId)) {
            state = new RepeatVoteState();
        } else if ("恶意投票".equals(stateId)) {

        } else if ("黑名单".equals(stateId)) {

        }*/

        //开始根据状态编码去获取相应的类， 可以通过配置文件，也可以直接在数据库中记录状态编码和对应的状态处理类
        String className = "根据状态编码去获取相应的类";
        //使用反射创建对象实例，简单示意一下
        Class<?>  c = Class.forName(className);
        state = (VoteState) c.newInstance();

        /*
        还有一种情况是直接把“转移”记录到数据库中
         */

        // 然后转调状态对象来进行操作
        state.vote(user, voteItem, this);
    }
}
