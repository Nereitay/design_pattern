package es.kiwi.behavioral.observer.extension.push_model;


public class NewsPaper extends Subject{

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        //内容有了，说明又出报纸了，那就通知所有的读者
        notifyReaders(content);
    }
}
