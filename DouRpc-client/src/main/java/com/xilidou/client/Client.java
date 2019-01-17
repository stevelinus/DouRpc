package com.xilidou.client;

import java.net.InetSocketAddress;

import com.xilidou.entity.RpcRequest;
import com.xilidou.entity.RpcResponse;

public interface Client {

	RpcResponse send(RpcRequest request);

	void connect(InetSocketAddress inetSocketAddress);

	InetSocketAddress getInetSocketAddress();

	void close();

}
