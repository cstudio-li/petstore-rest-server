package jp.cstudio.api;

@javax.annotation.Generated(
		value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen"
	, date = "2021-02-23T12:47:42.698Z[GMT]")
public class ApiException extends Exception {
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
