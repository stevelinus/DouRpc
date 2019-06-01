package com.xilidou.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T create(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), interfaceClass.getInterfaces(),
                new RpcInvoker<>(interfaceClass));
    }

}
