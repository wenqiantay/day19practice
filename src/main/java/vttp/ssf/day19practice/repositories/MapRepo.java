package vttp.ssf.day19practice.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.day19practice.models.Task;
import vttp.ssf.day19practice.utils.Constant;

@Repository
public class MapRepo {
    
    @Autowired @Qualifier(Constant.template02)
    RedisTemplate<String, Object> redisTemplate;

    //day15-slide36
    public void createHash(String key, String hashKey, String value){
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    //day-15 slide 37
    public String get(String key, String hashKey) {
        Object objValue = redisTemplate.opsForHash().get(key, hashKey);

        return objValue.toString();
    }

    public void deleteHashKey(String key, String hashKey){
        redisTemplate.opsForHash().delete(key, hashKey);
    }

    public Boolean hasKeyExists(String key, String hashKey){
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    public List<Object> getValues(String key){
        List<Object> values = redisTemplate.opsForHash().values(key);
        
        return values;
    }

    public long size(String key){
        return redisTemplate.opsForHash().size(key);
    }

    public void insertTask(Task task){
        
        HashOperations<String, String, Object> hashOps = redisTemplate.opsForHash();

       Map<String, Object> values = new HashMap<>();
       values.put("name", task.getName());
       values.put("description", task.getDescription());
       values.put("dueDate", task.getDueDate().toString());
       values.put("priority", task.getPriority());
       values.put("status", task.getStatus());
       values.put("createddate", task.getCreateAt().toString());
       values.put("updateddate", task.getUpdateAt().toString());
       hashOps.putAll(task.getId(), values);

    }
}

