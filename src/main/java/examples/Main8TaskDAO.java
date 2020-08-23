package examples;


import examples.dao.TaskDAO;
import examples.model.Task;

import java.sql.SQLException;



public class Main8TaskDAO {
    public static void main(String[] args) {
        try(TaskDAO taskDAO = new TaskDAO()){
        taskDAO.create(new Task(1L, "pierwsze zadanie", 43));
        taskDAO.create(new Task(2L, "drugie zadanie", 44));
        taskDAO.create(new Task(3L, "trzecie zadanie", 45 ));

        //taskDAO.readAll().forEach (System.out::println);


    }catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
