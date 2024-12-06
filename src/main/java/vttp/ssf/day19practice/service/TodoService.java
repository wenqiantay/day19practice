package vttp.ssf.day19practice.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.ssf.day19practice.models.Task;
import vttp.ssf.day19practice.repositories.DataRepo;


@Service
public class TodoService {

    @Autowired
    DataRepo dataRepo;

    //converting to Epochmilliseconds
    public Date toEpochmilliseconds(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd/MM/YYYY");
        Date dateFormatted = sdf.parse(date);
        long epochMilliseconds = dateFormatted.getTime();
        Date newDate = new Date(epochMilliseconds);

        return newDate;
    }


    //read file and store into redis
    public void readJsonFile() throws FileNotFoundException{

         //Read the text file and parse into a String
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/todos.json"));
        String json = "";


        try {
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while(line != null){
                sb.append(line);
                // sb.append("\n");
                line = reader.readLine();
            }
            json = sb.toString();

            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonArray todoArray = jsonReader.readArray();
            for(int i = 0; i < todoArray.size(); i++){
                JsonObject obj = todoArray.getJsonObject(i);

                //hset todo id task
                dataRepo.createHash("todo", obj.getString("id"), obj.toString());
    
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Task> getTaskList() throws ParseException{

        List<Task> taskList = new ArrayList<>();

        String payload = dataRepo.getTaskList().toString();

        try {
            
       
        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonArray taskArray = reader.readArray();

        for (int i = 0; i < taskArray.size() - 1; i++) {
            JsonObject task = taskArray.getJsonObject(i);
            String id = task.getString("id");
            String name = task.getString("name");
            String description = task.getString("description");
            String strDueDate = task.getString("due_date");
            String priority = task.getString("priority_level");
            String taskStatus = task.getString("status");
            String created = task.getString("created_at");
            String updated = task.getString("updated_at");

            Task newTask = new Task();
            newTask.setId(id);
            newTask.setName(name);
            newTask.setDescription(description);
            newTask.setDueDate(toEpochmilliseconds(strDueDate));
            newTask.setPriority(priority);
            newTask.setStatus(taskStatus);
            newTask.setCreateAt(toEpochmilliseconds(created));
            newTask.setUpdateAt(toEpochmilliseconds(updated));

            taskList.add(newTask);
        
        }  
        } catch (Exception e) {
           e.printStackTrace();
        }

        return taskList;
    }


}

        

    
        
    
    
    

