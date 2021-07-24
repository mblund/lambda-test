class MySuite extends munit.FunSuite {
  test("hello") {
    val request = RequestEvent(
      "",
      None,
      "",
      RequestContext(
        "",
        "",
        "",
        "",
        "",
        "",
        RequestIdentity(
          None,
          None, None, None, None, None, None, None, None, None
        ),
        None,
        ""
      ),
      None,
      None,
      None,
      None,
      "",
      true
    )
    val json = RequestEvent.fromJsonSafe("{}")
  }

  test("1"){
    val response = LambdaResponse("",Map.empty,"",true)
    val jsonString = response.toJson
  }
}