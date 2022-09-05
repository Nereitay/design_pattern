package es.kiwi.behavioral.observer.extension.enhanced;

/**
 * 具体的水质检测对象
 */
public class WaterQuality extends WaterQualitySubject{
    /**
     * 污染级别，0表示正常，1表示轻度污染，2表示重度污染，3表示高度污染
     */
    private int polluteLevel = 0;

    /**
     *通知相应的观察者对象
     */
    @Override
    public void notifyWatchers() {
        //循环所有注册的观察者
        observers.forEach(w -> {
            //开始根据污染级别判断是否需要通知，由这里总控
            if (this.polluteLevel >= 0) {
                //通知监测员做记录
                if ("监测人员".equals(w.getJob()))
                    w.update(this);
            }

            if (this.polluteLevel >= 1) {
                //通知预警人员
                if ("预警人员".equals(w.getJob()))
                    w.update(this);
            }

            if (this.polluteLevel >= 2) {
                //通知监测部门领导
                if ("监测部门领导".equals(w.getJob()))
                    w.update(this);
            }
            /*
            这里用的是组合逻辑，不能是else if, 用else if逻辑就出问题了。
            另外一个要注意每个判断polluteLevel都是用的">=",而不是“==”
             */

        });
    }

    /**
     * 获取水质污染的级别
     * @return 水质污染级别
     */
    @Override
    public int getPolluteLevel() {
        return this.polluteLevel;
    }

    /**
     * 当检测水质情况后，设置谁知污染的级别
     * @param polluteLevel 水质污染的级别
     */
    public void setPolluteLevel(int polluteLevel) {
        this.polluteLevel = polluteLevel;
        //通知相应的观察者
        this.notifyWatchers();
    }
}
