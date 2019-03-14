package wx.procedure.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Author harry
 */
@SpringCloudApplication
public class userServiceStarter {
    public static void main(String[] args){
        SpringApplication.run(userServiceStarter.class,args);
    }
}
