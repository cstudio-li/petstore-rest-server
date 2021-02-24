package jp.cstudio.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jp.cstudio.api.factories.PetsApiServiceFactory;
import jp.cstudio.model.Error;
import jp.cstudio.model.Pet;
import jp.cstudio.model.Pets;

import javax.servlet.ServletConfig;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@Path("/pets")
@javax.annotation.Generated(
		value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen"
	, date = "2021-02-23T12:47:42.698Z[GMT]")
public class PetsApi {
	private final PetsApiService delegate;

	public PetsApi(@Context ServletConfig servletContext) {
		PetsApiService delegate = null;

		if (servletContext != null) {
			String implClass = servletContext.getInitParameter("PetsApi.implementation");
			if (implClass != null && !"".equals(implClass.trim())) {
				try {
					delegate = (PetsApiService) Class.forName(implClass).newInstance();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		if (delegate == null) {
			delegate = PetsApiServiceFactory.getPetsApi();
		}

		this.delegate = delegate;
	}

	@POST
	@Produces({"application/json"})
	@Operation(summary = "ペットを登録", description = "", tags = {"pets"})
	@ApiResponses(
			value = {
				@ApiResponse(responseCode = "201", description = "ペット登録成功（返却なし）"),
				@ApiResponse(responseCode = "500", description = "予期せぬエラー",
						content = @Content(schema = @Schema(implementation = Error.class))
				)
			})
	public Response createPets(@Context SecurityContext securityContext) throws NotFoundException {
		return delegate.createPets(securityContext);
	}

	@GET
	@Produces({"application/json"})
	@Operation(summary = "ペットの一覧を取得", description = "", tags = {"pets"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "ページ毎のペット一覧",
					content = @Content(schema = @Schema(implementation = Pets.class))
			),
			@ApiResponse(responseCode = "500", description = "予期せぬエラー",
					content = @Content(schema = @Schema(implementation = Error.class))
			)
	})
	public Response listPets(
			@Parameter(in = ParameterIn.QUERY, description = "一度取得するペットの数（最大100）")
			@QueryParam("limit") Integer limit,
			@Context SecurityContext securityContext) throws NotFoundException {
		return delegate.listPets(limit, securityContext);
	}

	@GET
	@Path("/{petId}")
	@Produces({"application/json"})
	@Operation(summary = "指定のペットの情報を取得", description = "", tags = {"pets"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "リクエスト有効時のレスポンス",
					content = @Content(schema = @Schema(implementation = Pet.class))
			),
			@ApiResponse(responseCode = "500", description = "予期せぬエラー",
					content = @Content(schema = @Schema(implementation = Error.class))
			)
	})
	public Response showPetById(
			@Parameter(in = ParameterIn.PATH, description = "ペットIDによる情報取得", required = true)
			@PathParam("petId") String petId,
			@Context SecurityContext securityContext
	) throws NotFoundException {
		return delegate.showPetById(petId, securityContext);
	}
}
