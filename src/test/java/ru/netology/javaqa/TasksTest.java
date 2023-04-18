package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TasksTest {

    @Test
    public void ShouldFindMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean trueExpected = true;
        boolean trueActual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(trueExpected, trueActual);

        boolean falseExpected = false;
        boolean falseActual = simpleTask.matches("Поговорить с родителями");
        Assertions.assertEquals(falseExpected, falseActual);
    }

    @Test
    public void shouldFindMatchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean trueExpected = true;
        boolean trueActual = epic.matches("Яйца");
        Assertions.assertEquals(trueExpected, trueActual);

        boolean falseExpected = false;
        boolean falseActual = epic.matches("Сигареты");
        Assertions.assertEquals(falseExpected, falseActual);
    }

    @Test
    public void shouldFindMatchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean trueExpected = true;
        boolean trueActual = meeting.matches("Во вторник после обеда");
        Assertions.assertEquals(trueExpected, trueActual);

        boolean falseExpected = false;
        boolean falseActual = meeting.matches("Послезавтра");
        Assertions.assertEquals(falseExpected, falseActual);
    }
}
