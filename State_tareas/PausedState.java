package P2_E4;

import java.time.Duration;
import java.time.LocalDateTime;

public class PausedState extends ToDoItemState {
 @Override
 public void start(ToDoItem item) {
     // No hace nada
 }

 @Override
 public void togglePause(ToDoItem item) {
     item.setState(new InProgressState());
 }

 @Override
 public void finish(ToDoItem item) {
     item.setState(new FinishedState());
     item.setEndTime(LocalDateTime.now());
 }

 @Override
 public Duration workedTime(ToDoItem item) {
     LocalDateTime now = LocalDateTime.now();
     return Duration.between(item.getStartTime(), now);
 }

}

