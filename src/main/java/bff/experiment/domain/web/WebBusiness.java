package bff.experiment.domain.web;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class WebBusiness {
  private String businessName;
  private UUID id;
  private String region;

  public WebBusiness(String businessName, UUID id, int region) {
    this.businessName = businessName;
    this.id = id;
    this.region = String.valueOf(region);
  }
}
