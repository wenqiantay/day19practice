package vttp.ssf.day19practice.models;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.cglib.core.Local;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Task {

    @NotEmpty(message = "Required")
    @Size(max = 50)
    private String id;

    @NotEmpty(message = "Required")
    @Size(min = 10, max = 50 )
    private String name;

    @Size(max = 255)
    private String description;

    @FutureOrPresent
    private Date dueDate;

 
    private String priority;
    private String status;
    private Date createAt;
    private Date updateAt;
   

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public Date getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", description=" + description + ", dueDate=" + dueDate
                + ", priority=" + priority + ", status=" + status + ", createAt=" + createAt + ", updateAt=" + updateAt
                + "]";
    }


    //Make a method to make todo to Jsonobject
    // public JsonObject toJson() throws ParseException{
        
    //     JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
    //     return objectBuilder.add("id", this.id)
    //                 .add("name", this.name)
    //                 .add("description", this.description)
    //                 .add("due_date", toEpochmilliseconds(this.dueDate).toString())
    //                 .add("priority", this.priority)
    //                 .add("status", this.status)
    //                 .add("create_at", toEpochmilliseconds(this.createAt).toString())
    //                 .add("update_at", toEpochmilliseconds(this.updateAt).toString())
    //                 .build();

    // }
   

    

}
