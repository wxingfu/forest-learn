package com.weixf.test.binding;

import com.dtflys.forest.annotation.BindingVar;
import com.dtflys.forest.http.ForestRequest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("address")
@SpringBootTest(classes = TestBinding.class)
@ComponentScan(basePackages = "com.weixf.test.binding")
@EnableAutoConfiguration
public class TestBinding {

    public final static String EXPECTED = "{\"status\": \"ok\"}";

    @Rule
    public MockWebServer server = new MockWebServer();

    @Resource
    private BindingVarClient bindingVarClient;

    @BindingVar("port")
    public int getPort() {
        return server.getPort();
    }

    @Test
    public void testBindingVar() {
        server.enqueue(new MockResponse().setBody(EXPECTED));
        ForestRequest<String> request = bindingVarClient.testBindingVar();
        assertThat(request.getPort()).isEqualTo(server.getPort());
    }

}
