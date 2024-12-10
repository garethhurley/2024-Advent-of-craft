package workshop;

import java.util.ArrayList;
import java.util.List;

public class ElfWorkshop {
    private List<String> taskList;

    public ElfWorkshop() {
        this.taskList = new ArrayList<>();
    }

    //FIXME: against the "first class collection" principal. Should not expose the internal collection.
    //       see https://williamdurand.fr/2013/06/03/object-calisthenics/
    public List<String> getTaskList() {
        return taskList;
    }

    public void addTask(String task) {
        // TODO: Create an immutable Task object that cannot be null or empty
        if (task != null && !task.isEmpty()) {
            taskList.add(task);  //FIXME: should throw a RuntimeException to prevent null values
        }
    }

    public String completeTask() {
        if (!taskList.isEmpty()) {
            return taskList.remove(0);
        }
        return null;
    }
}