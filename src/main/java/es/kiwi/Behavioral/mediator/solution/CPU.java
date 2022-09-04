package es.kiwi.Behavioral.mediator.solution;

/**
 * CPU类，一个同事类
 */
public class CPU extends Colleague{



    public CPU(Mediator mediator) {
        super(mediator);
    }

    /**
     * 分解出来的视频数据
     */
    private String videoData = "";

    /**
     * 分解出来的声音数据
     */
    private String soundData = "";

    /**
     * 获取分解出来的视频数据
     * @return 分解出来的视频数据
     */
    public String getVideoData() {
        return videoData;
    }

    /**
     * 获取分解出来的声音数据
     * @return 分解出来的声音数据
     */
    public String getSoundData() {
        return soundData;
    }

    /**
     * 业务方法，也是和中介者交互的方法
     * 处理数据，把数据分成音频和视频数据
     * @param data 被处理的数据
     */
    public void executeData(String data) {
        //把数据分开，逗号前书视频显示的数据，逗号后是声音
        String[] ss = data.split(",");
        this.videoData = ss[0];
        this.soundData = ss[1];
        //通知主板，CPU的共工作完成
        this.getMediator().changed(this);
    }
}
