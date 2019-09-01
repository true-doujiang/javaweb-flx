package cn.itcast.exception;

/**
 * 作者: 尤欢欢
 * 日期： 2017年10月29日 下午4:51:30
 * 描述：
 */
public class StudentNotExitException extends Exception {

	public StudentNotExitException() {
		// TODO Auto-generated constructor stub
	}

	public StudentNotExitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StudentNotExitException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotExitException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotExitException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
