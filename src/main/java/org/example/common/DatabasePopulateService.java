package org.example.common;

import org.example.entities.Client;
import org.example.entities.Project;
import org.example.entities.ProjectWorker;
import org.example.entities.Worker;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DatabasePopulateService {
    public static void fillWorkerTableWithData() {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO worker (id, name, birthday, level, salary)\n" +
                    "VALUES (?, ?, ?, ?, ?)");
            List<Worker> workers = Arrays.asList(
                    new Worker(1, "Ivan", LocalDate.parse("1980-06-23"),  "Junior", 1000),
                    new Worker(2, "Karl", LocalDate.parse("1901-01-01"), "Senior", 50000),
                    new Worker(3, "John", LocalDate.parse("1985-01-10"), "Trainee", 100),
                    new Worker(4, "Shane", LocalDate.parse("1965-08-31"), "Middle", 2500),
                    new Worker(5, "Lena", LocalDate.parse("1993-12-10"), "Trainee", 895),
                    new Worker(6, "Alex", LocalDate.parse("1981-07-22"),  "Senior", 7000),
                    new Worker(7, "Kate", LocalDate.parse("1978-05-09"), "Middle", 3255),
                    new Worker(8, "Nik", LocalDate.parse("1990-11-11"), "Junior", 3100),
                    new Worker(9, "Anna", LocalDate.parse("1950-10-04"), "Senior", 9500),
                    new Worker(10, "Andrew", LocalDate.parse("1985-09-10"), "Junior", 2476)
            );
            for (int i = 0; i < workers.size(); i++) {
                preparedStatement.setInt(1, workers.get(i).getId());
                preparedStatement.setString(2, workers.get(i).getName());
                preparedStatement.setString(3, workers.get(i).getBirthday().toString());
                preparedStatement.setString(4, workers.get(i).getLevel());
                preparedStatement.setInt(5, workers.get(i).getSalary());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void fillClientTableWithData() {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client (id, name) VALUES (?, ?)");
            List<Client> clients = Arrays.asList(
                    new Client(1, "Luck Besson"),
                    new Client(2, "Jennifer Lopez"),
                    new Client(3, "Kate Blanchett"),
                    new Client(4, "Tom Hanks"),
                    new Client(5, "Jorge Martin"));

            for (int i = 0; i < clients.size(); i++) {
                preparedStatement.setInt(1, clients.get(i).getId());
                preparedStatement.setString(2, clients.get(i).getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void fillProjectTableWithData() {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO project (id, client_id, start_date, finish_date)\n" +
                    "VALUES (?, ?, ?, ?)");
            List<Project> projects = Arrays.asList(
                    new Project(1, 5, LocalDate.parse("2018-01-01"),  LocalDate.parse("2018-02-01")),
                    new Project(2, 3, LocalDate.parse("2000-07-01"),  LocalDate.parse("2001-03-01")),
                    new Project(3, 3, LocalDate.parse("2020-01-10"),  LocalDate.parse("2020-04-10")),
                    new Project(4, 4, LocalDate.parse("2005-08-31"),  LocalDate.parse("2005-11-30")),
                    new Project(5, 3, LocalDate.parse("2007-12-15"),  LocalDate.parse("2008-06-15")),
                    new Project(6, 2, LocalDate.parse("2012-07-22"),  LocalDate.parse("2020-10-25")),
                    new Project(7, 2, LocalDate.parse("1998-05-09"),  LocalDate.parse("1998-10-09")),
                    new Project(8, 2, LocalDate.parse("2019-11-11"),  LocalDate.parse("2022-12-31")),
                    new Project(9, 1, LocalDate.parse("2022-01-10"),  LocalDate.parse("2023-01-10")),
                    new Project(10, 5, LocalDate.parse("2017-12-01"),  LocalDate.parse("2018-02-01")));

            for (int i = 0; i < projects.size(); i++) {
                preparedStatement.setInt(1, projects.get(i).getId());
                preparedStatement.setInt(2, projects.get(i).getClientId());
                preparedStatement.setString(3, projects.get(i).getStartDate().toString());
                preparedStatement.setString(4, projects.get(i).getFinishDate().toString());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void fillProjectWorkerTableWithData() {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO project_worker (project_id, worker_id)\n" +
                    "VALUES (?, ?)");
            List<ProjectWorker> list = Arrays.asList(
                    new ProjectWorker(1, 1),
                    new ProjectWorker(1, 2),
            new ProjectWorker(1, 8),
            new ProjectWorker(2, 10),
            new ProjectWorker(3, 2),
            new ProjectWorker(3, 7),
            new ProjectWorker(3, 9),
            new ProjectWorker(4, 5),
            new ProjectWorker(5, 1),
            new ProjectWorker(6, 2),
            new ProjectWorker(6, 4),
            new ProjectWorker(6, 6),
            new ProjectWorker(7, 8),
            new ProjectWorker(7, 10),
            new ProjectWorker(8, 8),
            new ProjectWorker(8, 2),
            new ProjectWorker(8, 5),
            new ProjectWorker(8, 9),
            new ProjectWorker(9, 6),
            new ProjectWorker(9, 1),
            new ProjectWorker(10, 4),
            new ProjectWorker(10, 2)
            );
            for (int i = 0; i < list.size(); i++) {
                preparedStatement.setInt(1, list.get(i).getProject_id());
                preparedStatement.setInt(2, list.get(i).getWorker_id());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
