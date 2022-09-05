package es.kiwi.structural.composite.solution.sample;

/**
 * 叶子对象，叶子对象不再包含其他子对象
 */
public class Leaf extends Component{
    /**
     * 示意方法，叶子对象可能有自己的功能方法
     */
    @Override
    public void someOperation() {
        //do something
    }
}
