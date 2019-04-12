package bff.experiment.service;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;

@ConfigurationProperties(PrivateApiGatewayConfiguration.PREFIX)
@Requires(property = PrivateApiGatewayConfiguration.PREFIX)
public class PrivateApiGatewayConfiguration {

  public static final String PREFIX = "gateway";
  public static final String GATEWAY_API_URL = "http://localhost:8082";

}

