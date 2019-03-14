package wx.procedure.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Author harry
 */
@SpringCloudApplication
public class serviceStarter {
    public static void main(String[] args){
        SpringApplication.run(serviceStarter.class,args);
    }
}
