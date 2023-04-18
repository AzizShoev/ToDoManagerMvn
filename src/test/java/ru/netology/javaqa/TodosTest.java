package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        int idExpected = 555;
        int idActual = meeting.getId();
        Assertions.assertEquals(idExpected, idActual);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);

        expected = new Task[]{simpleTask};
        actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);

        expected = new Task[]{meeting};
        actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);

        expected = new Task[]{meeting};
        actual = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected, actual);

        expected = new Task[]{meeting};
        actual = todos.search("Во вторник после обеда");
        Assertions.assertArrayEquals(expected, actual);

        expected = new Task[0];
        actual = todos.search("бананы");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetIdFromClass() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Assertions.assertEquals(5, simpleTask.getId());
        Assertions.assertEquals(55, epic.getId());
        Assertions.assertEquals(555, meeting.getId());

    }
}