package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindMultipleTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить молоко");
        Epic epic = new Epic(2, new String[]{"Молоко", "Хлеб"});
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Разработка", "2025-02-26");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic}; // Две задачи с "Молоко"
        Task[] actual = todos.search("Молоко");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSingleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить молоко");
        Epic epic = new Epic(2, new String[]{"Молоко", "Хлеб"});
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Разработка", "2025-02-26");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting}; // Только одна задача содержит "проект"
        Task[] actual = todos.search("проект");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить молоко");
        Epic epic = new Epic(2, new String[]{"Молоко", "Хлеб"});
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Разработка", "2025-02-26");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {}; // Ничего не должно найтись
        Task[] actual = todos.search("Космос"); // Поиск по слову, которого нет

        Assertions.assertArrayEquals(expected, actual);
    }

}
