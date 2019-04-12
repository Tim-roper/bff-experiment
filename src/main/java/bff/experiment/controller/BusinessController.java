package bff.experiment.controller;

import bff.experiment.domain.web.WebBusiness;
import bff.experiment.service.PrivateApiGatewayClient;
import bff.experiment.transformation.BuildBusinessList;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

@Controller("/business")
public class BusinessController {

  private final PrivateApiGatewayClient gatewayClient;

  public BusinessController(PrivateApiGatewayClient gatewayClient) {
    this.gatewayClient = gatewayClient;
  }

  @Get(uri = "/load_business_list", produces = MediaType.APPLICATION_JSON_STREAM)
  Flowable<WebBusiness> loadBusinessList() {
    return BuildBusinessList.transformBusinesses(gatewayClient.fetchBusinesses());
  }
}

