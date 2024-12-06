package vttp.ssf.day19practice.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.day19practice.models.Task;
import vttp.ssf.day19practice.utils.Constant;


@Repository
public class DataRepo {

    @Autowired @Qualifier(Constant.template01)
    RedisTemplate<String,String> redisTemplate;

    // public Optional<Task> getTaskList(String id){
    //     HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
    //     Map<String, String> task = hashOps.entries(id);

    //     if(task.isEmpty()){
    //         return Optional.empty();
    //     }
        
    //     Task result = new Task();
    //     result.setId(task.get("id"));
    //     result.setName(task.get("name"));
    //     result.setDescription(task.get("description"));
    //     result.setStrDueDate(task.get("due_date"));
    //     result.setPriority(task.get("priority"));
    //     result.setStatus(task.get("status"));
    //     result.setStrCreateAt(task.get("create_at"));
    //     result.setStrUpdateAt(task.get("update_at"));
        
    //     //continue to THINK PLS I THINK SOMETHING IS WRONG HERE I SWEAR


    //     return Optional.of(result);
    // }

    //hset id name <taskname>
    // public void insertTask(Task task){
    //     HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
    //     Map<String, String> taskMap = new HashMap<>();
    //     taskMap.put("name", task.getName());
    //     taskMap.put("description", task.getDescription());
    //     taskMap.put("duedate", task.getDueDate().toString());
    //     taskMap.put("priority", task.getPriority());
    //     taskMap.put("status", task.getStatus());
    //     taskMap.put("created_at", task.getCreateAt().toString());
    //     taskMap.put("update_at", task.getUpdateAt().toString());
    //     hashOps.putAll(task.getId(), taskMap);
        
    // }

    //hset todo id taskvalue
    public void createHash(String key, String hashKey, String value){
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    //hvals todo 
    public List<Task> getTaskList(){

        HashOperations<String, String, Task> hashOps = redisTemplate.opsForHash();
        
        return new ArrayList<>(hashOps.values("todo"));

    }

    //reference the contact list repo on chuk github 

    }

    

