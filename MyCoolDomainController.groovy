import org.springframework.http.HttpStatus;
import grails.converters.JSON

class MyCoolDomainController {

    def index() {
        redirect action:"list"
    }
    def show() {
        render RESTControllerAssistant.renderSingle(MyCoolDomain, MyCoolDomain.get(params.id))
    }
    def list() {
        render RESTControllerAssistant.renderMultiple(MyCoolDomain, MyCoolDomain.list())
    }
    def delete() {
        MyCoolDomain.get(params.id).delete()
        response.status = HttpStatus.ACCEPTED
        render [:] as JSON
    }

    def update() {
        Map data = RESTControllerAssistant.extractSingle(MyCoolDomain, request.JSON)       
        def f = MyCoolDomain.get(params.id)

        f.properties = data

        if(f.validate() && f.save()) {
            response.status = HttpStatus.ACCEPTED.value
            redirect action:"show", id:f.id
        } else {
            render f.errors as JSON
        }
    }
    def save() {
        Map data = RESTControllerAssistant.extractSingle(MyCoolDomain, request.JSON)
        MyCoolDomain f = new MyCoolDomain()

        f.properties = data

        if(f.validate() && f.save()) {
            redirect action:"show", id:f.id
        } else {
            render f.errors as JSON
        }
    }
}