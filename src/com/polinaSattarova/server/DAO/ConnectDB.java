package com.polinaSattarova.server.DAO;

import java.sql.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConnectDB {
    public static final String jdbcDriver = "com.microsoft.jdbc.sqlserver.sqlserverdriver";
    public static final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=TaskManagement;";
    public static final String userName = "admin";
    public static final String password = "admin";

    static Connection connection = null;

    private void connectToDb() {

        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName(com.microsoft.sqlserver.jdbc.SQLServerDriver.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            disconnectFromDb();
        }
    }

    private void disconnectFromDb() {
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        connection = null;
    }

    public ConnectDB() {
        connectToDb();
    }

    public void close() {
        disconnectFromDb();
    }

    public static ArrayList<InstanceProject> selectAllProjects() {
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Project");

            ResultSet rs = pstmt.executeQuery();
            ArrayList<InstanceProject> instanceProjects = new ArrayList<InstanceProject>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String shortName = rs.getString(3);
                String description = rs.getString(4);
                instanceProjects.add(new InstanceProject(id, fullName, shortName, description));

            }
            return instanceProjects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static void editNewProject(InstanceProject project) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Project (fullName, shortName, description) VALUES (?,?,?)");

            pstmt.setString(1, project.getFullName());
            pstmt.setString(2, project.getShortName());
            pstmt.setString(3, project.getDescription());

            try {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void updateProject(InstanceProject project) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Project SET fullName = ?, shortName = ?, description = ? WHERE Id = ?");

            pstmt.setString(1, project.getFullName());
            pstmt.setString(2, project.getShortName());
            pstmt.setString(3, project.getDescription());
            pstmt.setInt(4, project.getId());

            try {
                pstmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteProject(InstanceProject project) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Project WHERE Id = ?");
            pstmt.setInt(1, project.getId());
            try {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteDeveloper(InstanceDeveloper developer) {

        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Developer WHERE Id = ?");
            pstmt.setInt(1, developer.getId());
            try {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<InstanceDeveloper> selectAllDevelopers() {
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Developer");

            ResultSet rs = pstmt.executeQuery();
            ArrayList<InstanceDeveloper> instanceDeveloper = new ArrayList<InstanceDeveloper>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String middleName = rs.getString(4);
                String position = rs.getString(5);
                instanceDeveloper.add(new InstanceDeveloper(id, lastName, firstName, middleName, position));
            }
            return instanceDeveloper;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void editNewDeveloper(InstanceDeveloper developer) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Developer (lastName, firstName, middleName, position) VALUES (?,?,?,?)");

            pstmt.setString(1, developer.getLastName());
            pstmt.setString(2, developer.getFirstName());
            pstmt.setString(3, developer.getMiddleName());
            pstmt.setString(4, developer.getPosition());

            try {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void updateDeveloper(InstanceDeveloper developer) {
        try {

            PreparedStatement pstmt = connection.prepareStatement("UPDATE Developer SET lastName = ?, firstName = ?, middleName = ?, position = ? WHERE Id = ?");

            pstmt.setString(1, developer.getLastName());
            pstmt.setString(2, developer.getFirstName());
            pstmt.setString(3, developer.getMiddleName());
            pstmt.setString(4, developer.getPosition());
            pstmt.setInt(5, developer.getId());

            try {
                pstmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<InstanceTask> selectAllTasks() {
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Task");

            ResultSet rs = pstmt.executeQuery();
            ArrayList<InstanceTask> instanceTask = new ArrayList<InstanceTask>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Integer timeForWork = rs.getInt(3);
                Date startData =  rs.getDate(4);
                Date endData =  rs.getDate(5);
                String status = rs.getString(6);

                PreparedStatement pstmtP = connection.prepareStatement("SELECT fullName FROM Project WHERE id = (SELECT id_project FROM TaskInProject WHERE id_task = ?)");
                pstmtP.setInt(1,id);
                ResultSet rsP = pstmtP.executeQuery();
                rsP.next();
                String project = rsP.getString(1);


                PreparedStatement pstmtD = connection.prepareStatement("SELECT firstName, lastName FROM Developer WHERE id = (SELECT id_employee FROM DeveloperAndTask WHERE id_task = ?)");
                pstmtD.setInt(1,id);
                ResultSet rsD = pstmtD.executeQuery();
                rsD.next();
                String developer = rsD.getString(1)+ " " +rsD.getString(2);


                instanceTask.add(new InstanceTask(id, project, name, timeForWork, startData, endData, status, developer));

            }
            return instanceTask;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void editNewTask(InstanceTask task) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Task (name, timeForWork, startDate, endDate, status) VALUES (?,?,?,?,?)");

            pstmt.setString(1, task.getName());
            pstmt.setInt(2, task.getTimeForWork());
            pstmt.setDate(3, task.getStartDate());
            pstmt.setDate(4, task.getEndDate());
            pstmt.setString(5, task.getState());

            try {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateTask(InstanceTask task) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Task SET name = ?, timeForWork = ?, startDate = ?, endDate = ?, status = ? WHERE Id = ?");

            pstmt.setString(1, task.getName());
            pstmt.setInt(2, task.getTimeForWork());
            pstmt.setDate(3, task.getStartDate());
            pstmt.setDate(4, task.getEndDate());
            pstmt.setString(5, task.getState());
            pstmt.setInt(6, task.getId());

            PreparedStatement pstmt1 = connection.prepareStatement("UPDATE TaskInProject SET id_project = (\n" +
                    "SELECT Id FROM Project WHERE fullName = ?) WHERE id_task = ?");

            pstmt1.setString(1, task.getProject());
            pstmt1.setInt(2, task.getId());

            try {
                pstmt.execute();
                pstmt1.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteTask(InstanceTask task) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Task WHERE Id = ?");
            pstmt.setInt(1, task.getId());

            try {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<String[]> selectShortDevelopersList() {
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT lastName, firstName FROM Developer");

            ResultSet rs = pstmt.executeQuery();
            ArrayList<String[]> developersList = new ArrayList<String[]>();
            while (rs.next()) {
                String lastName = rs.getString(1);
                String firstName = rs.getString(2);
                String[] str = new String[]{lastName, firstName};
                developersList.add(str);
            }
            return developersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<String> selectShortProjectsList() {
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT shortName FROM Project");

            ResultSet rs = pstmt.executeQuery();
            ArrayList<String> projectsList = new ArrayList<String>();
            while (rs.next()) {
                String shortName = rs.getString(1);
                projectsList.add(shortName);
            }
            return projectsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws Exception {
        ConnectDB myDbTest = new ConnectDB();

        List<InstanceTask> listik = myDbTest.selectAllTasks();
       for (InstanceTask t: listik )
       {
        System.out.println(t.getId() + " "+t.getName().toString()+" "+t.getDeveloper().toString()+" "+t.getProject());
       }

        myDbTest.close();

    }
}
