package jp.cstudio.api.factories;

import jp.cstudio.api.PetsApiService;
import jp.cstudio.api.impl.PetsApiServiceImpl;

@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen"
  , date = "2021-02-23T12:47:42.698Z[GMT]")
public class PetsApiServiceFactory {
	private final static PetsApiService service = new PetsApiServiceImpl();

	public static PetsApiService getPetsApi() {
		return service;
	}
}
