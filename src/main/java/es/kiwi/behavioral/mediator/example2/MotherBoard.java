package es.kiwi.behavioral.mediator.example2;

/**
 * 主板类，实现中介者接口
 */
public class MotherBoard implements Mediator {
    /**
     * 需要知道要交互的同事类——光驱类
     */
    private CDDriver cdDriver;
    /**
     * 需要知道要交互的同事类——CPU类
     */
    private CPU cpu;
    /**
     * 需要知道要交互的同事类——显卡类
     */
    private VideoCard videoCard;
    /**
     * 需要知道要交互的同事类——声卡类
     */
    private SoundCard soundCard;

    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    /**
     * 同事对象在自身改变的时候来通知中介者的方法，
     * 让中介者去负责相应的与其他同事对象的交互
     *
     * @param colleague 同事对象自身，好让中介者对象通过对象实例
     *                  去获取同事对象的状态
     */
    @Override
    public void changed(Colleague colleague) {
        if (colleague == cdDriver) {
            //表示光驱读取数据了
            this.opeCDDriverReadData((CDDriver) colleague);
        } else if (colleague == cpu) {
            //表示CPU处理完了
            this.opeCPU((CPU) colleague);
        }
    }

    /**
     * 处理光驱读取数据过后与其他对象的交互
     * @param cd 光驱同事对象
     */
    private void opeCDDriverReadData(CDDriver cd) {
        //1：先获取光驱读取的数据
        String data = cd.getData();
        //2：把这些数据传递给CPU进行处理
        this.cpu.executeData(data);
    }

    /**
     * 处理CPU处理完数据后与其他对象的交互
     * @param cpu CPU同事类
     */
    private void opeCPU(CPU cpu) {
        //1：先获取CPU处理过后的数据
        String videoData = cpu.getVideoData();
        String soundData = cpu.getSoundData();
        //2：把这些数据传递给显卡和声卡展示出来
        this.videoCard.showData(videoData);
        this.soundCard.soundData(soundData);
    }
}
