package com.weixf.test.logging;

public class TestLogHandler2 extends TestLogHandler {

    @Override
    public void logContent(String content) {
        getLogger().info("[Forest] [Test2] " + content);
    }
}
