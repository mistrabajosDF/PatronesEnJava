package P2_E4;

import java.time.Duration;

public class FinishedState extends ToDoItemState {
 @Override
 public void start(ToDoItem item) {
     // No hace nada
 }

 @Override
 public void togglePause(ToDoItem item) {
     throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
 }

 @Override
 public void finish(ToDoItem item) {
     // No hace nada
 }

 @Override
 public Duration workedTime(ToDoItem item) {
     return Duration.between(item.getStartTime(), item.getEndTime());
 }

 @Override
 public void addComment(ToDoItem item, String comment) {
	 throw new RuntimeException("Ya no debería poder comentar");
 }
}
