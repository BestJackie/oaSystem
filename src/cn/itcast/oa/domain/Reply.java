package cn.itcast.oa.domain;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class Reply extends Article {
    private Topic topic;//所属主题

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
