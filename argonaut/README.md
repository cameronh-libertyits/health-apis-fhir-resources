# Argonaut

All models required to build Argonaut resources and datatypes are housed here.
This includes Java models for all Argonaut supported resources (below).
Argonaut resources use DSTU2 datatypes - accessed here with a dependency to DSTU2 module.
Also includes the appropriate tests for each Java model.

Because validation logic is shared among all FHIR versions, it has been pulled out into its own module.

Current Supported Resources:
  * Allergy Intolerance
  * Condition
  * Diagnostic Report
  * Immunization
  * Medication
  * Medication Order
  * Medication Statement
  * Observation
  * Patient
  * Procedure

