package es.kiwi.structural.proxy.example3;

/**
 * 定义用户数据对象的接口
 */
public interface UserModelApi {

    String getUserId();

    void setUserId(String userId);

    String getName();

    void setName(String name);

    String getDepId();

    void setDepId(String depId);

    String getSex();

    void setSex(String sex);
}
