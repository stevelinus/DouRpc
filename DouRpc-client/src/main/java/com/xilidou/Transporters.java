package com.xilidou;

import com.xilidou.entity.RpcRequest;
import com.xilidou.entity.RpcResponse;
import com.xilidou.netty.NettyClient;

public class Transporters {

    public static RpcResponse send(RpcRequest request) {
        NettyClient nettyClient = new NettyClient("127.0.0.1", 9000);
        nettyClient.connect(nettyClient.getInetSocketAddress());
        return nettyClient.send(request);
    }

}
