package jp.cstudio.api;

@javax.annotation.Generated(
		value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen"
	, date = "2021-02-23T12:47:42.698Z[GMT]")
public class NotFoundException extends ApiException {
	private int code;

	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
