package wx.procedure.service.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author admin
 */
@Configuration
public class HttpMessageConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public HttpMessageConverters converters() {
		return new HttpMessageConverters(new FastJsonHttpMessageConverter());
	}
}
