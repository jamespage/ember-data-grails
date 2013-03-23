class UrlMappings {
  static mappings = {
    "/$controller"{
      action=[GET:"list", POST:"save"]
    }
    "/$controller/$id"{
      action=[GET:"show",  PUT:"update", DELETE:"delete"]
    }
  }
}