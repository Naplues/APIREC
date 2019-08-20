
public class Main1 {

    public void method() throws IOException {
        Set<TaskResult> results= new HashSet<>();
        for(Task t: tasks) {
            t.execute();
            results.add(t.getResult());
        }

    }
}