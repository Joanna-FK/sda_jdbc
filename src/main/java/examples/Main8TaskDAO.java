package examples;


import examples.dao.TaskDAO;
import examples.model.Task;

import java.sql.SQLException;


public class Main8TaskDAO {
    public static void main(String[] args) {
        try (TaskDAO taskDAO = new TaskDAO()) {
            taskDAO.create(new Task(1L, "pierwsze zadanie", 43));
            taskDAO.create(new Task(2L, "drugie zadanie", 44));
            taskDAO.create(new Task(3L, "trzecie zadanie", 45));

            taskDAO.readAll().forEach(System.out::println);
            taskDAO.read(3L).ifPresent(System.out::println);

            taskDAO.update(new Task(3L, "czwarte zadanie", 46));
            taskDAO.read(3L).ifPresent(System.out::println);
            System.out.println("zaktualizowano 3 task");

            taskDAO.readAllForUser("Mikolaj").forEach(System.out::println);
            System.out.println("wszystlke taski Mikolaja: ");

            taskDAO.delete(2L);
            taskDAO.readAll().forEach(System.out::println);
            System.out.println("usunieto 2 task");



        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
