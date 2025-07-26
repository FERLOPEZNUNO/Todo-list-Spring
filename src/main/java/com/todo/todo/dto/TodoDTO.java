package com.todo.todo.dto;

public class TodoDTO {
    private Long id;
    private String title;
    private boolean completed;
    private Long userId;

    public TodoDTO() {}

    public TodoDTO(Long id, String title, boolean completed, Long userId) {
        this.id=id;
        this.title=title;
        this.completed=completed;
        this.userId=userId;

    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title= title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed=completed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId=userId;
    }


    public static TodoDTO fromEntity(com.todo.todo.modelos.Todo todo) {
        return new TodoDTO(todo.getId(), todo.getTitle(), todo.getCompleted(), todo.getUser().getId());
    }
}
