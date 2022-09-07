package es.kiwi.creational.abstract_factory.extension.scalable;

/**
 * 现代内存的类
 */
public class HyMemory implements MemoryApi{
    @Override
    public void cacheData() {
        System.out.println("现在正在使用现代内存");
    }
}
