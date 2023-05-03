package com.AlvaroyRaul.PcPiezas;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import java.util.Collections;

@EnableCaching
//@EnableHazelcastHttpSession
@SpringBootApplication
public class PcPiezasApplication {

    private static final Log LOG = LogFactory.getLog(PcPiezasApplication.class);

    public static void main(String[] args) throws Exception {
		SpringApplication.run(PcPiezasApplication.class, args);

	}

    @Bean
    public CacheManager cacheManager() {
        LOG.info("Activating cache...");
        return new ConcurrentMapCacheManager("usuarios");
    }
/*
    @Bean
    public Config config() {

        Config config = new Config();

        JoinConfig joinConfig = config.getNetworkConfig().getJoin();

        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));

        return config;
    }*/

}
