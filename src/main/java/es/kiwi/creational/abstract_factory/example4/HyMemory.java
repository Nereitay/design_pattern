package es.kiwi.creational.abstract_factory.example4;

/**
 * 现代内存的类
 */
public class HyMemory implements MemoryApi {
    /**
     * 示意方法，内存具有缓存数据的能力
     */
    @Override
    public void cacheData() {
        System.out.println("现在正在使用现代内存");
    }
}
