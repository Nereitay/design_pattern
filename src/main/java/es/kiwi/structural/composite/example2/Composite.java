package es.kiwi.structural.composite.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合对象，通常需要存储子对象，定义有子部件的部件行为，
 * 并实现在Component里面定义的与子部件有关的操作
 */
public class Composite extends Component {
    /**
     * 用来存储组合对象中包含的子组件对象
     */
    private List<Component> childComponents;


    /**
     * 示意方法，通常在里面需要实现递归的调用
     */
    @Override
    public void someOperation() {
        if (childComponents != null) {
            for (Component c : childComponents) {
                //递归的进行子组件相应方法的调用
                c.someOperation();
            }
        }
    }

    /**
     * 向组合对象中加入组件对象
     *
     * @param child 被加入组合对象中的组件对象
     */
    @Override
    public void addChild(Component child) {
        //延迟初始化
        if (childComponents == null) {
            childComponents = new ArrayList<Component>();
        }
        childComponents.add(child);
    }

    /**
     * 从组合对象中移出某个组件对象
     *
     * @param child 被移出的组件对象
     */
    @Override
    public void removeChild(Component child) {
        if (childComponents != null) {
            childComponents.remove(child);
        }
    }

    /**
     * 返回某个索引对应的组件对象
     *
     * @param index 需要获取的组件对象的索引，索引从0开始
     * @return 索引对应的组件对象
     */
    @Override
    public Component getChildren(int index) {
        if (childComponents != null) {
            if (index >= 0 && index < childComponents.size()) {
                return childComponents.get(index);
            }
        }
        return null;
    }
}
