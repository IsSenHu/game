package com.qdhh.game.tianming;


import com.qdhh.game.ProtocstuffUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HuSen
 * create on 2020/3/12 9:56 上午
 */
@Slf4j
public abstract class BaseDataManager {

    private int port;
    private String hostName;
    private int dataBase;
    private String password;
    protected StringRedisTemplate redisTemplate;

    public BaseDataManager(int port, String hostName, int dataBase, String password) {
        this.port = port;
        this.hostName = hostName;
        this.dataBase = dataBase;
        this.password = password;
    }

    private void initStringRedisTemplate() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setDatabase(this.dataBase);
        configuration.setHostName(this.hostName);
        configuration.setPort(this.port);
        configuration.setPassword(this.password);
        RedisConnectionFactory connectionFactory = new JedisConnectionFactory(configuration);

        this.redisTemplate = new StringRedisTemplate(connectionFactory);
    }

    /**
     * 查询单个数据
     *
     * @param dataType 数据Class对象
     * @param <T>      数据的类型
     * @return 数据
     */
    public <T> T query(Class<T> dataType) {
        if (this.redisTemplate == null) {
            this.initStringRedisTemplate();
        }
        String val = redisTemplate.opsForValue().get(dataKey(dataType));
        log.info("queried:{}", val);
        try {
            if (StringUtils.hasText(val)) {
                return ProtocstuffUtils.byte2Bean(stringToBytes(val), dataType);
            }
        } catch (Exception e) {
            log.error("querying occur error.", e);
        }
        return null;
    }

    /**
     * 查询数据列表
     *
     * @param dataType 数据类的对象
     * @param <T>      数据的类型
     * @return 数据列表
     */
    public <T> List<T> queryItems(Class<T> dataType) {
        if (this.redisTemplate == null) {
            this.initStringRedisTemplate();
        }
        HashOperations<String, String, String> hash = redisTemplate.opsForHash();
        List<String> values = hash.values(dataKey(dataType));
        log.info("queried items:{}", values);
        try {
            return values.stream().map(val -> ProtocstuffUtils.byte2Bean(stringToBytes(val), dataType)).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("querying items occur error.", e);
        }
        return new ArrayList<>(0);
    }

    protected abstract String dataKey(Class<?> dataType);

    private byte[] stringToBytes(String string) {
        return string.getBytes(StandardCharsets.ISO_8859_1);
    }

    protected static String typeKey(Class<?> dataType) {
        return dataType.getSimpleName();
    }
}
