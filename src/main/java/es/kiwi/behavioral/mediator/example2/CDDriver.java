package es.kiwi.behavioral.mediator.example2;

/**
 * 光驱类，一个同事类
 */
public class CDDriver extends Colleague {
    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    /*自身的业务数据*/
    /**
     * 光驱读取出来的数据
     */
    private String data = "";

    /**
     * 获取光驱读取出来的数据
     *
     * @return 光驱读取出来的数据
     */
    public String getData() {
        return this.data;
    }

    /*业务方法，也是和中介者交互的方法*/

    /**
     * 读取光盘
     */
    public void readCD() {
        //逗号前是视频显示的数据，逗号后是声音
        this.data = "Hello,Mediator!";
        //通知主板，自己的状态发生了改变
        this.getMediator().changed(this);
    }
}
