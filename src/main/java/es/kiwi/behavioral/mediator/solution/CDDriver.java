package es.kiwi.behavioral.mediator.solution;

/**
 * 光驱类，一个同事类
 */
public class CDDriver extends Colleague{


    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    /**
     * 光驱读出来的数据
     */
    private String data = "";

    /**
     * 自身业务状态数据
     * 获取光驱读取出来的数据
     * @return 光驱读取出来的数据
     */
    public String getData() {
        return data;
    }

    /**
     * 业务方法，也是和中介者交互的方法
     * 读取光盘
     */
    public void readCD() {
        //逗号前是视频显示的数据，逗号后是声音
        this.data = "设计模式,值得好好研究";
        //通知主板，自己的状态发生了改变
        this.getMediator().changed(this);
    }
}
