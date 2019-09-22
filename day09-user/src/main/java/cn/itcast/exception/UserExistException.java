package cn.itcast.exception;


/**
 * 1、继承 Exception是编译时异常， 希望上一层处理
 * 2、继承 RuntimeException是运行时异常，上一层可处理，也可不处理，
 */
public class UserExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserExistException() {
		super();
	}

	public UserExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserExistException(String arg0) {
		super(arg0);
	}

	public UserExistException(Throwable arg0) {
		super(arg0);
	}

	
	
	
}
