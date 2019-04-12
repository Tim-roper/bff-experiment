package bff.experiment.domain.gateway;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class GatewayBusiness {
  @JsonAlias("BusinessName")
  private String businessName;
  @JsonAlias("Id")
  private UUID id;
  @JsonAlias("ProductCode")
  private int productCode;
  @JsonAlias("RegionCode")
  private int regionCode;
  @JsonAlias("SerialNumber")
  private String serialNumber;
  @JsonAlias("UserRole")
  private int userRole;
}
