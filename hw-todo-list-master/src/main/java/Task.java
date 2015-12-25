public class Task {

    private String name = "";
    private String priority = "";
    private String dueDate = "";
    private Boolean isComplete = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String toFile() {
        String complete = "";
        if (isComplete) {
            complete = "true";
        } else {
            complete = "false";
        }
        String fileString = ",   " + name + " | " + priority
            + " | " + dueDate + " | " + complete;
        return fileString;
    }

    @Override
    public String toString() {
        String complete = "";
        if (isComplete) {
            complete = "Completed";
        } else {
            complete = "In Complete";
        }

        String pString = "";
        if (Double.parseDouble(priority.trim()) >= 0
            && Double.parseDouble(priority.trim()) <= 4) {
            pString += "Low Priority";
        } else if (Double.parseDouble(priority.trim()) >= 5
            && Double.parseDouble(priority.trim()) <= 6) {
            pString += "Medium Priority";
        } else if (Double.parseDouble(priority.trim()) > 6) {
            pString += "High Priority";
        } else {
            pString += "Please enter Priority between 0-10";
        }
        String taskString = "\n \t - " + name + " - " + pString + " - "
            + " due " + dueDate + " - " + complete;
        return taskString;
    }
}
