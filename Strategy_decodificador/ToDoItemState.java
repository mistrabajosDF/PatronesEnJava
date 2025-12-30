package P2_E4;

import java.time.Duration;

public abstract class ToDoItemState {
	public abstract void start(ToDoItem item);
	public abstract void togglePause(ToDoItem item);
	public abstract void finish(ToDoItem item);
	public abstract Duration workedTime(ToDoItem item);
    public void addComment(ToDoItem item, String comment) {
    	item.agregarComentario(comment);
    };
}
