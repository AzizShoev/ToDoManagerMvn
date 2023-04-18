package ru.netology.javaqa;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // массив из подзадач
    }

    public String[] getSubTask() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtasks : subtasks){
            if (subtasks.contains(query)) {
                return true;
            }
        }
        return false;
    }
}