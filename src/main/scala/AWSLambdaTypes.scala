import play.api.libs.json.{Json, OWrites}

case class RequestIdentity(
  apiKey: Option[String],
  userArn: Option[String],
  cognitoAuthenticationType: Option[String],
  caller: Option[String],
  userAgent: Option[String],
  user: Option[String],
  cognitoIdentityPoolId: Option[String],
  cognitoAuthenticationProvider: Option[String],
  sourceIp: Option[String],
  accountId: Option[String],
)

case class RequestContext(
  resourceId: String,
  apiId: String,
  resourcePath: String,
  httpMethod: String,
  accountId: String,
  stage: String,
  identity: RequestIdentity,
  extendedRequestId: Option[String],
  path: String
)

// The request returned from the next-event url
case class RequestEvent(
  httpMethod: String,
  body: Option[String],
  resource: String,
  requestContext: RequestContext,
  queryStringParameters: Option[Map[String, String]],
  headers: Option[Map[String, String]],
  pathParameters: Option[Map[String, String]],
  stageVariables: Option[Map[String, String]],
  path: String,
  isBase64Encoded: Boolean
)

object RequestEvent {
  import play.api.libs.json._

  private implicit val requestIdentityReads: Reads[RequestIdentity] = Json.reads[RequestIdentity]
  private implicit val requestContextReads: Reads[RequestContext] = Json.reads[RequestContext]
  private implicit val requestEventReads: Reads[RequestEvent] = Json.reads[RequestEvent]

  def fromJsonSafe(s: String): Option[RequestEvent] = {
    val json = Json.parse(s)
    Json.fromJson[RequestEvent](json).asOpt
  }

}

// The response written to the response url by the function
case class LambdaResponse(
  statusCode: String,
  headers: Map[String, String],
  body: String,
  isBase64Encoded: Boolean = false
) {

  private implicit val requestIdentityReads: OWrites[LambdaResponse] = Json.writes[LambdaResponse]

  def toJson: String = Json.toJson(this).toString()
}



