package P2_E4;

import java.time.Duration;

public class PendingState extends ToDoItemState {
 
     public PendingState() {
     }
     
	 @Override
	 public void start(ToDoItem item) { //recibe la tarea
	     item.setState(new InProgressState()); //crea el nuevo estado y la tarea lo pone como estado
	     item.setStartTime(java.time.LocalDateTime.now());
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
	     throw new RuntimeException("El objeto ToDoItem no ha sido iniciado aún");
	 }
}
