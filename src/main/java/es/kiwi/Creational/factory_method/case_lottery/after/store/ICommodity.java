package es.kiwi.Creational.factory_method.case_lottery.after.store;

import java.util.Map;

public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
