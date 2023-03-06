package io.swagger.modelo;



public class Respuesta {

	String success;
	String msg;
	
	
	
	public Respuesta(String success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	
}
