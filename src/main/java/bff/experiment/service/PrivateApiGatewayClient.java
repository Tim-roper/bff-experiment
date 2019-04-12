package bff.experiment.service;

import bff.experiment.domain.gateway.GatewayBusiness;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client(PrivateApiGatewayConfiguration.GATEWAY_API_URL)
@Header(name="x-myobapi-requestid", value="foo")
@Header(name="Authorization", value="Bearer Baz")
public interface PrivateApiGatewayClient {

  @Get("/businesses")
  Flowable<GatewayBusiness> fetchBusinesses();
}

