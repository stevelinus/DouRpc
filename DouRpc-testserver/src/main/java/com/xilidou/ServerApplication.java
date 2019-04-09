package com.xilidou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.xilidou.netty.TcpService;

/**
 * @author Zhengxin
 */
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(ServerApplication.class);
		TcpService tcpService = context.getBean(TcpService.class);
		tcpService.start();
	}

}
