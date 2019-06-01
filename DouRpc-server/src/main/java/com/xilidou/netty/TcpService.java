package com.xilidou.netty;

import java.net.InetSocketAddress;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import lombok.Data;

/**
 * @author Zhengxin
 */

@Data
@Component
public class TcpService {

	private final ServerBootstrap serverBootstrap;

	private final InetSocketAddress tcpPort;

	public TcpService(ServerBootstrap serverBootstrap, InetSocketAddress inetSocketAddress) {
		this.serverBootstrap = serverBootstrap;
		this.tcpPort = inetSocketAddress;
	}

	private Channel serverChannel;

	public void start() throws InterruptedException {
		serverChannel = serverBootstrap.bind(tcpPort).sync().channel().closeFuture().channel();
	}

	@PreDestroy
	public void stop() {
		if (serverChannel != null) {
			serverChannel.close();
			serverChannel.parent().close();
		}
	}

}
