import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TodoList {
    private static User[] users = new User[10];
    private static Integer userIndex = 0;
    public static void main(String[] args) throws Exception {
        createUsers();
        loadDataForUsers();
        loadSingleUser();
    }

    public static void loadDataForUsers() throws Exception {
        for (int i = 0; i < users.length; i++) {
            Boolean fileExists = false;
            if (users[i] != null && !users[i].getUsername().equals("")) {
                fileExists = checkIfFileExists(users[i].getUsername());
            }
            if (fileExists) {
                addGoalsFromFile(users[i]);
            }
        }
    }

    public static void createANewFile(String username) throws Exception {
        String userfile = username + ".csv";
        FileWriter f = new FileWriter(new File(userfile));
        f.write("");
        f.close();
    }

    public static void loadSingleUser() throws Exception {
        User currentUser;
        System.out.println("Enter Your Username To Load Your Todo List: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        int currentUserIndex = checkIfUserExists(username);
        if (currentUserIndex > -1) {
            currentUser = users[currentUserIndex];
            displayToDoList(currentUser);
        } else {
            addUser(username);
            createANewFile(username);
            currentUserIndex = checkIfUserExists(username);
            currentUser = users[currentUserIndex];
            displayToDoList(currentUser);
        }
    }

    public static void displayToDoList(User user) throws Exception {
        System.out.println("\n");
        System.out.println("Your Current ToDo List:");
        System.out.println(user.getToDoList().toString());

        System.out.println("\nWhat would you like to do ?"
            + " (New Users start by creating your fisrt Goal! :))");
        int nextTask = 0;
        Scanner sc = new Scanner(System.in);
        Boolean wrongTask = false;
        while (!wrongTask) {

            System.out.println("[1] Add A Goal");
            System.out.println("[2] Add A Task");
            System.out.println("[3] Update Task Status");
            System.out.println("[4] Save and Quit");

            try {
                nextTask = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Input Integer from 1-4!");
            }
            if (nextTask < 1 || nextTask > 4) {
                System.out.println("Input Integer from 1-4!");
            } else {
                wrongTask = true;
                createTask(nextTask, user);
            }
        }
    }

    public static void createTask(int nextTask, User user) throws Exception {
        if (nextTask == 1) {
            createNewGoal(user);
        } else if (nextTask == 2) {
            createNewTask(user);
        } else if (nextTask == 3) {
            updateTaskStatus(user);
        } else if (nextTask == 4) {
            saveAndQuit(user);
        }
    }

    public static void updateTaskStatus(User user) throws Exception {
        Goal[] goal = user.getToDoList().getGoals();
        System.out.println("Select the goal whose task status you want to"
            + " update. (Please enter the integer number next to it)");
        for (int i = 0; i < goal.length; i++) {
            if (goal[i] != null) {
                System.out.printf("[%d] %s \n", i, goal[i].getGoalName());
            }
        }
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Task[] task = goal[num].getTasks();
        System.out.println("Select the task whose status you want to update. "
            + "(Please enter the integer number next to it)");
        for (int i = 0; i < task.length; i++) {
            if (task[i] != null) {
                System.out.printf("[%d] %s \n", i, task[i].getName());
            }
        }
        Scanner s = new Scanner(System.in);
        int tnum = s.nextInt();
        Boolean status = task[tnum].getIsComplete();
        if (status) {
            System.out.println("Current Status is Complete.");
        } else {
            System.out.println("Current Status is In Complete");
        }
        System.out.println("Do you want to update it to: "
            + "\n[0] Completed \n[1] In Complete");
        Scanner ss = new Scanner(System.in);
        int snum = ss.nextInt();
        if (snum == 0) {
            task[tnum].setIsComplete(true);
        } else {
            task[tnum].setIsComplete(false);
        }
        displayToDoList(user);
    }

    public static void saveAndQuit(User user) throws Exception {
        System.out.printf("\nGood bye! Your Todo List"
            + " will be saved in %s.csv\n", user.getUsername());
        String username = user.getUsername();
        String userfile = username + ".csv";
        FileWriter f = new FileWriter(new File(userfile));
        String outWrite = user.getToDoList().getFilePrint();
        f.write(outWrite);
        f.close();
    }

    public static void createNewGoal(User user) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter in the Goal name: ");
        String goalName = sc.nextLine();
        Goal goal = new Goal();
        goal.setGoalName(goalName);
        user.getToDoList().addAGoal(goal);
        createNewTask(user);
    }

    public static void createNewTask(User user) throws Exception {
        Goal[] goal = user.getToDoList().getGoals();
        System.out.println("Select the goal to which you want to add the task: "
            + "(Please enter the integer number next to it)");
        for (int i = 0; i < goal.length; i++) {
            if (goal[i] != null) {
                System.out.printf("[%d] %s \n", i, goal[i].getGoalName());
            }
        }
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Scanner s = new Scanner(System.in);
        System.out.println("Task name: ");
        String tName = s.nextLine();
        System.out.println("Task Priority (from 0-10): ");
        String tPriority = s.nextLine();
        System.out.println("Task Due Date (MM/DD/YYYY hh:mm): ");
        String tDue = s.nextLine();
        Scanner a = new Scanner(System.in);
        System.out.println("Enter [1] for Completed or [2] for In Complete: ");
        int in = a.nextInt();
        Boolean tStatus = false;
        String status = "false";
        if (in == 1) {
            tStatus = true;
            status = "true";
        }
        Task task = new Task();
        task.setName(tName);
        task.setPriority(tPriority);
        task.setDueDate(tDue);
        task.setIsComplete(tStatus);
        goal[num].addATask(task);
        displayToDoList(user);
    }

    public static Integer checkIfUserExists(String username) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getUsername().equals(username)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void createUsers() {
        String csvFile = "users.csv";
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] userNames = line.split(",");
                for (int i = 0; i < userNames.length; i++) {
                    addUser(userNames[i].trim());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("users.csv file not provided in the directory.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void addGoalsFromFile(User user) {
        BufferedReader br = null;
        String line = "";
        String filename = user.getUsername() + ".csv";
        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {

                int goalNameIndex = line.indexOf(",");
                String goalName = line.substring(0, goalNameIndex);
                Goal goal = new Goal();
                goal.setGoalName(goalName);
                String taskString = line.substring(goalNameIndex + 1);
                String[] tasks = taskString.split(",");
                for (int i = 0; i < tasks.length; i++) {
                    String[] taskDetails = tasks[i].split("\\|");
                    Task task = new Task();
                    task.setName(taskDetails[0].trim());
                    task.setPriority(taskDetails[1].trim());
                    task.setDueDate(taskDetails[2].trim());
                    String ts = taskDetails[3].trim();
                    if (ts.equalsIgnoreCase("true")) {
                        task.setIsComplete(true);
                    } else {
                        task.setIsComplete(false);
                    }
                    goal.addATask(task);
                }
                user.getToDoList().addAGoal(goal);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void addUser(String username) {
        if (userIndex > users.length) {
            increaseUserMaximum();
        }
        User user = new User();
        user.setUsername(username);
        users[userIndex] = user;

        userIndex++;
    }

    public static void increaseUserMaximum() {
        users = Arrays.copyOf(users, users.length * 2);
    }

    public static Boolean checkIfFileExists(String filename) {
        filename = filename + ".csv";
        File f = new File(filename);
        if (f.exists() && !f.isDirectory()) {
            return true;
        }
        return false;
    }
}