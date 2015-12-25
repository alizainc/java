public class List {
    private Goal[] goals = new Goal[10];
    private Integer currentIndex = 0;

    public Goal[] getGoals() {
        return goals;
    }

    public void addAGoal(Goal goal) {
        goals[currentIndex] = goal;
        currentIndex++;
    }

    public String getFilePrint() {
        String toString = "";
        for (int i = 0; i < goals.length; i++) {
            if (goals[i] != null) {
                String taskString = getFileString(goals[i]);
                toString += goals[i].getGoalName() + taskString;
                toString += "\n";
            }
        }
        return toString;
    }

    public String getFileString(Goal goal) {
        Task[] tasks = goal.getTasks();
        String taskString = "";
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                taskString += tasks[i].toFile();
            }
        }
        return taskString;
    }

    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < goals.length; i++) {
            if (goals[i] != null) {
                String taskString = getTaskString(goals[i]);
                toString += goals[i].getGoalName() + ":\t"
                    + goals[i].getGoalStatus() + taskString;
                toString += "\n";
            }
        }
        return toString;
    }

    public String getTaskString(Goal goal) {
        Task[] tasks = goal.getTasks();
        String taskString = "";
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                taskString += tasks[i].toString();
            }
        }
        return taskString;
    }

}
