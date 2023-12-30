package es.kiwi.creational.abstract_factory.example5;

public class RdbDAOFactory extends DAOFactory{
    /**
     * 创建订单主记录对应的DAO对象
     *
     * @return 订单主记录对应的DAO对象
     */
    @Override
    public OrderMainDAO createOrderMainDAO() {
        return new RdbMainDAOImpl();
    }

    /**
     * 创建订单子记录对应的DAO对象
     *
     * @return 订单子记录对应的DAO对象
     */
    @Override
    public OrderDetailDAO createOrderDetailDAO() {
        return new RdbDetailDAOImpl();
    }
}
