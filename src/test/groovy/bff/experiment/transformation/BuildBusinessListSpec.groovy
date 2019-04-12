package bff.experiment.transformation

import bff.experiment.domain.gateway.GatewayBusiness
import spock.lang.Specification


class BuildBusinessListSpec extends Specification {

  def "Transform a business into the BFF structure"() {
    given:
    GatewayBusiness gatewayBusiness = new GatewayBusiness();
    gatewayBusiness.setBusinessName("Lego Inc.")
    gatewayBusiness.setId(UUID.randomUUID())
    gatewayBusiness.setProductCode(12)
    gatewayBusiness.setRegionCode(43)
    gatewayBusiness.setSerialNumber("1209273")
    gatewayBusiness.setUserRole(98)

    when:
    def webBusiness = BuildBusinessList.transformBusiness(gatewayBusiness)

    then:
    webBusiness.businessName == gatewayBusiness.businessName
    webBusiness.id == gatewayBusiness.id
    webBusiness.region == String.valueOf(gatewayBusiness.regionCode)
  }

}
