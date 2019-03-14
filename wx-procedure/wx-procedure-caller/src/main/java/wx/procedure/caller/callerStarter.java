package wx.procedure.caller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class callerStarter {
    public static void main(String[] args) {
        SpringApplication.run(callerStarter.class, args);
    }


}