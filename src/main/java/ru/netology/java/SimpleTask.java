package ru.netology.java;


public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        boolean result = title.toLowerCase().contains(query.toLowerCase()); // регистронезависимый поиск
        System.out.println("SimpleTask: '" + title + "' содержит '" + query + "'? -> " + result);
        return result;
    }


}
