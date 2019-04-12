package bff.experiment.controller

import bff.experiment.domain.gateway.GatewayBusiness
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxStreamingHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.reactivex.Flowable
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class BusinessControllerSpec extends Specification {
  @Shared
  @AutoCleanup
  EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

  @Shared
  @AutoCleanup
  RxStreamingHttpClient client = embeddedServer.applicationContext.createBean(RxStreamingHttpClient, embeddedServer.getURL())

  @Shared
  List<String> expectedProfileNames = ['businessName', 'id', 'region']

  def "Can fetch Web Businesses"() {
    when:
    HttpRequest request = HttpRequest.GET('/business/load_business_list')

    Flowable<GatewayBusiness> webBusinessesStream = client.jsonStream(request, GatewayBusiness)
    List<GatewayBusiness> webBusinesses = webBusinessesStream.blockingIterable().toList()

    then: //todo this is failing because can't deref the fields.
    for (String name : expectedProfileNames) {
      assert webBusinesses*.name.contains(name)
    }
  }
}
