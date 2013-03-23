class UrlMappings {
  static mappings = {
    "/$controller"{
      action=[GET:"list", POST:"save"]
      rest  =true
    }
    "/$controller/$id"{
      action=[GET:"show",  PUT:"update", DELETE:"delete"]
      rest  =true
    }
  }
}