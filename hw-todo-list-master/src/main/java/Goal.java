public class Goal {
    private String goalName = "";
    private Task[] tasks = new Task[10]; //Pre defined no more than 10 tasks
    private Integer currentIndex = 0;
    private Boolean status = false;

    public String getGoalStatus() {
        String stringStatus = "In Complete";
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                if (tasks[i].getIsComplete()) {
                    status = true;
                    stringStatus = "Completed";
                } else {
                    status = false;
                    stringStatus = "In Complete";
                }
            }
        }
        return stringStatus;
    }

    public void setGoalStatus(Boolean s) {
        status = s;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void addATask(Task task) {
        tasks[currentIndex] = task;
        currentIndex++;
    }

    @Override
    public String toString() {
        return getGoalName();
    }
}