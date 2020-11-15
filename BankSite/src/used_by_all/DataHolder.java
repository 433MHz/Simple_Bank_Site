package used_by_all;

public class DataHolder {
private String message;
private boolean isDone;

public void set(String message, boolean isDone){
	this.message = message;
	this.isDone = isDone;
}

public String getMessage() {
	return message;
}

public boolean getIsDone() {
	return isDone;
}
}
