package com.example.test.es;

import com.example.test.domian.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program: springboot
 * @description:
 * @author: JiZeng
 * @create: 2019-01-24 14:47
 **/
public interface EsRepository extends ElasticsearchRepository <User, Long>{
}
