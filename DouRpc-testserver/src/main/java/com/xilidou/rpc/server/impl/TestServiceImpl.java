package com.xilidou.rpc.server.impl;

import org.springframework.stereotype.Service;

import com.xilidou.api.IHelloService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestServiceImpl implements IHelloService {

	@Override
	public String sayHi(String name) {
		log.info(name);
		return "Hello " + name;
	}
}
