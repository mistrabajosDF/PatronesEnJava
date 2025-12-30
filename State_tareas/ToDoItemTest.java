package P2_E4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class ToDoItemTest {
 
 private ToDoItem task;

 @BeforeEach
 void setUp() {
     task = new ToDoItem("Test Task");
 }

 @Test
 void testStartFromPending() {
     task.start();
     assertDoesNotThrow(() -> task.addComment("En progreso"));
 }

 @Test
 void testTogglePauseFromInProgress() {
     task.start();
     task.togglePause(); // De in-progress a paused
     assertDoesNotThrow(() -> task.addComment("Pausado"));
 }

 @Test
 void testTogglePauseFromPausedToInProgress() {
     task.start();
     task.togglePause(); // a paused
     task.togglePause(); // de nuevo a in-progress
     assertDoesNotThrow(() -> task.addComment("Retomado"));
 }

 @Test
 void testFinishFromInProgress() {
     task.start();
     task.finish();
     assertThrows(RuntimeException.class, () -> task.addComment("Ya no debería poder comentar"));
 }

 @Test
 void testFinishFromPaused() {
     task.start();
     task.togglePause();
     task.finish();
     assertThrows(RuntimeException.class, () -> task.addComment("Comentario después de terminar"));
 }

 @Test
 void testWorkedTimeWithoutStarting() {
     Exception exception = assertThrows(RuntimeException.class, () -> task.workedTime());
     assertEquals("El objeto ToDoItem no ha sido iniciado aún", exception.getMessage());
 }

 @Test
 void testTogglePauseErrorInPending() {
     Exception exception = assertThrows(RuntimeException.class, () -> task.togglePause());
     assertEquals("El objeto ToDoItem no se encuentra en pause o in-progress", exception.getMessage());
 }

 @Test
 void testTogglePauseErrorInFinished() {
     task.start();
     task.finish();
     Exception exception = assertThrows(RuntimeException.class, () -> task.togglePause());
     assertEquals("El objeto ToDoItem no se encuentra en pause o in-progress", exception.getMessage());
 }

 @Test
 void testWorkedTimeCalculatesCorrectly() throws InterruptedException {
     task.start();
     Thread.sleep(1000); // 1 segundo de trabajo
     Duration worked = task.workedTime();
     assertTrue(worked.toMillis() >= 1000); // Aproximadamente 1 segundo o más
 }

 @Test
 void testWorkedTimeAfterFinish() throws InterruptedException {
     task.start();
     Thread.sleep(1000);
     task.finish();
     Duration worked1 = task.workedTime();
     Thread.sleep(1000);
     Duration worked2 = task.workedTime();
     assertEquals(worked1.getSeconds(), worked2.getSeconds()); // No debería aumentar más después de finish
 }
}
