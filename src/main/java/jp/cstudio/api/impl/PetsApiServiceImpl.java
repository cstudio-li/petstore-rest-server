package jp.cstudio.api.impl;

import jp.cstudio.api.ApiResponseMessage;
import jp.cstudio.api.NotFoundException;
import jp.cstudio.api.PetsApiService;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import jp.cstudio.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen"
  , date = "2021-02-23T12:47:42.698Z[GMT]")
public class PetsApiServiceImpl extends PetsApiService {
  Logger logger = LoggerFactory.getLogger("PetsApiServiceImpl");

	@Override
  public Response createPets(SecurityContext securityContext) throws NotFoundException {
    logger.info("[START] ペット登録");
		// do some magic!
    logger.info("[E N D] ペット登録");
		return Response.created(null).build();
	}

	@Override
  public Response listPets(Integer limit, SecurityContext securityContext) throws NotFoundException {
    logger.info("[START] ペット一覧取得");
    int petsNum = 10;   // init
    if(limit >= 0){
        petsNum = limit;
    }

    List petList = new ArrayList<Pet>();
    for(int i = 0; i < petsNum; i++){
      Pet tempPet = new Pet();
      tempPet.setId((long) (i+1));
      tempPet.setName(String.format("pet %05d", i+1));
      tempPet.setTag(String.format("tag %05d", i+1));

			petList.add(tempPet);
    }

    String xnextHeader = new String("x-next");

    logger.info("[E N D] ペット一覧取得");
		return Response.ok()
        .header("x-next", xnextHeader)
        .entity(petList)
        .build();
	}

	@Override
  public Response showPetById(String petId, SecurityContext securityContext) throws NotFoundException {
    logger.info("[START] ペット詳細");
      // do some magic!
		Pet tempPet = new Pet();
		tempPet.setId(Long.parseLong(petId));
		tempPet.setName(petId);
		tempPet.setTag("tag " + petId);

    logger.info("[E N D] ペット詳細");
		return Response.ok().entity(tempPet).build();
	}
}
