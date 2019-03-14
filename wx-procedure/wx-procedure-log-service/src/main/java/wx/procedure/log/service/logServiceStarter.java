package wx.procedure.log.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Author harry
 */
@SpringCloudApplication
public class logServiceStarter {
    public static void main(String[] args){
        SpringApplication.run(logServiceStarter.class,args);
    }
}
