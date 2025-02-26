package ru.netology.java;


public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            boolean subtasks = subtask.contains(query);
            System.out.println("Epic: подзадача '" + subtask + "' содержит '" + query + "'? -> " + subtasks);
            if (subtasks) {
                return true;
            }
        }
        return false;
    }
}
