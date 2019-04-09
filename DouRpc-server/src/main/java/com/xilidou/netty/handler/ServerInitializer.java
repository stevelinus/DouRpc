package com.xilidou.netty.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xilidou.coder.RpcDecoder;
import com.xilidou.coder.RpcEncoder;
import com.xilidou.entity.RpcRequest;
import com.xilidou.entity.RpcResponse;
import com.xilidou.serialization.JsonSerialization;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author Zhengxin
 */
@Component
public class ServerInitializer extends ChannelInitializer<SocketChannel> {

	@Autowired
	private ServerHandler serverHandler;

	@Override
	protected void initChannel(SocketChannel ch) {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4));
		pipeline.addLast(new RpcEncoder(RpcResponse.class, new JsonSerialization()));
		pipeline.addLast(new RpcDecoder(RpcRequest.class, new JsonSerialization()));
		pipeline.addLast(serverHandler);
	}

}
