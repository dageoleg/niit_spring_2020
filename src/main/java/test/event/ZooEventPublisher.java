package test.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class ZooEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publishEvent() {
        ZooEvent zooEvent = new ZooEvent(this, "message");
        publisher.publishEvent(zooEvent);
    }

}
