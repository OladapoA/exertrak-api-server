package com.awoniyitechnologies.exertrakapiserver.media;

import java.sql.Timestamp;

public class RoutineResource {

    private Long routine_id;
    private Long user_id;
    private Boolean is_public;
    private String name;
    private String description;
    private Timestamp created_at;
    private Integer no_of_exercises;

    public RoutineResource() {}

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    public Long getRoutine_id() { return routine_id; }
    public void setRoutine_id(Long routine_id) { this.routine_id = routine_id; }

    public Boolean getIs_public() { return is_public; }
    public void setIs_public(Boolean is_public) { this.is_public = is_public; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Timestamp getCreated_at() { return created_at; }
    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }
    
    public Integer getNo_of_exercises() { return no_of_exercises; }
    public void setNo_of_exercises(Integer no_of_exercises) { this.no_of_exercises = no_of_exercises; }


}
