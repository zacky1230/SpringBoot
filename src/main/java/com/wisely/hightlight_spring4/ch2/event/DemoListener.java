package com.wisely.hightlight_spring4.ch2.event;

import org.springframework.context.ApplicationListener;

public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();

        System.out.println("我(bean-demoListener) 接收到了 bean-demoPublisher " +
                "发布的消息：" + msg);
    }
}
