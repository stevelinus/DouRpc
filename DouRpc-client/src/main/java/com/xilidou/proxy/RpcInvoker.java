package com.xilidou.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

import com.xilidou.Transporters;
import com.xilidou.entity.RpcRequest;

public class RpcInvoker<T> implements InvocationHandler {

	private Class<T> clz;

	public Class<T> getClz() {
		return clz;
	}

	public RpcInvoker(Class<T> clz) {
		this.clz = clz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		RpcRequest request = new RpcRequest();

		String requestId = UUID.randomUUID().toString();

		String className = method.getDeclaringClass().getName();
		String methodName = method.getName();
		Class<?>[] parameterTypes = method.getParameterTypes();

		request.setRequestId(requestId);
		request.setClassName(className);
		request.setMethodName(methodName);
		request.setParameterTypes(parameterTypes);
		request.setParameters(args);
		return Transporters.send(request).getResult();
	}

}
