package com.xilidou.netty;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;

public class ChannelRepository {

	private Map<String, Channel> channelCacheMap = new ConcurrentHashMap<>();

	public ChannelRepository put(String key, Channel channel) {
		channelCacheMap.put(key, channel);
		return this;
	}

	public Channel get(String key) {
		return channelCacheMap.get(key);
	}

	public void remove(String key) {
		this.channelCacheMap.remove(key);
	}

	public int size() {
		return channelCacheMap.size();
	}

}
