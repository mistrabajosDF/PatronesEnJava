package P2_E4;

/*
Sistema de seguimiento de tareas, para las cuales se puede definir el nombre y comentarios. 
Las tareas atraviesan diferentes etapas: pending, in-progress, paused y finished. 
Cada tarea debe estar modelada mediante la clase ToDoItem con el siguiente protocolo:
public class ToDoItem 
public ToDoItem(String name)
public void start()
public void togglePause()
public void finish()
public Duration workedTime()
public void addComment(String comment)

Para generar o levantar un error debe utilizar la expresión throw new RuntimeException("Este es mi mensaje de error");
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
 private String name;
 private List<String> comments;
 private ToDoItemState state;
 private LocalDateTime startTime;
 private LocalDateTime endTime;

 public ToDoItem(String name) { 
	 //Crea la tarea con es estado pendiente por defecto
     this.name = name;
     this.comments = new ArrayList<>();
     this.state = new PendingState();
 }

 public void start() { 
	 //Para cambiar el estado se manda a si mismo al estado
     state.start(this);
 }

 public void togglePause() {
     state.togglePause(this);
 }

 public void finish() {
     state.finish(this);
 }

 public Duration workedTime() {
     return state.workedTime(this);
 }

 public void addComment(String comment) {
     state.addComment(this, comment);
 }

 void setState(ToDoItemState state) {
     this.state = state;
 }

 void setStartTime(LocalDateTime startTime) {
     this.startTime = startTime;
 }

 void setEndTime(LocalDateTime endTime) {
     this.endTime = endTime;
 }

 LocalDateTime getStartTime() {
     return startTime;
 }

 LocalDateTime getEndTime() {
     return endTime;
 }

 List<String> getComments() {
     return comments;
 }
 
 public void agregarComentario(String comentario) {
	 this.comments.add(comentario);
 }
 
}

