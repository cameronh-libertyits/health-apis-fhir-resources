package gov.va.api.health.r4.api.bundle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Signature;
import gov.va.api.health.r4.api.elements.Meta;
import gov.va.api.health.r4.api.resources.Resource;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "https://hl7.org/fhir/R4/bundle.html")
public abstract class AbstractBundle<N extends AbstractEntry<?>> implements Resource {
  @NotBlank protected String resourceType;

  @Pattern(regexp = Fhir.ID)
  protected String id;

  @Valid protected Meta meta;

  @Pattern(regexp = Fhir.URI)
  protected String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  protected String language;

  @Valid protected Identifier identifier;

  @NotNull protected BundleType type;

  @Pattern(regexp = Fhir.INSTANT)
  protected String timestamp;

  @Pattern(regexp = Fhir.UNSIGNED_INT)
  protected String total;

  @Valid protected List<BundleLink> link;
  @Valid protected List<N> entry;
  @Valid protected Signature signature;

  @SuppressWarnings("unused")
  public enum BundleType {
    document,
    message,
    transaction,
    @JsonProperty("transaction-response")
    transaction_response,
    batch,
    @JsonProperty("batch-response")
    batch_response,
    history,
    searchset,
    collection
  }
}
