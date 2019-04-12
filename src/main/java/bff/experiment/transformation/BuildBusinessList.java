package bff.experiment.transformation;

import bff.experiment.domain.gateway.GatewayBusiness;
import bff.experiment.domain.web.WebBusiness;
import io.reactivex.Flowable;

public class BuildBusinessList {

  public static Flowable<WebBusiness> transformBusinesses(Flowable<GatewayBusiness> gatewayBusinesses) {
    return gatewayBusinesses
        .map(BuildBusinessList::transformBusiness);
  }

  public static WebBusiness transformBusiness(GatewayBusiness gatewayBusiness) {
    return new WebBusiness(gatewayBusiness.getBusinessName(), gatewayBusiness.getId(), gatewayBusiness.getRegionCode());
  }
}
