package me.weldnor.securechat.repository;

import me.weldnor.securechat.entity.Message;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepositoryCustom {

    final MongoTemplate mongoTemplate;

    public MessageRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Message> getMessagesByKeys(String key1, String key2) {
        Query query = new Query(new Criteria().orOperator(
                Criteria.where("from").is(key1).and("to").is(key2),
                Criteria.where("from").is(key2).and("to").is(key1)
        ));
        return mongoTemplate.find(query, Message.class);
    }
}
