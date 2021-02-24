package jp.cstudio.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen"
  , date = "2021-02-23T12:47:42.698Z[GMT]")
public abstract class PetsApiService {
	public abstract Response createPets(SecurityContext securityContext) throws NotFoundException;

	public abstract Response listPets(Integer limit, SecurityContext securityContext)
			throws NotFoundException;

	public abstract Response showPetById(String petId, SecurityContext securityContext)
			throws NotFoundException;
}
