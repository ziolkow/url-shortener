package org.ziolkow.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import org.slf4j.LoggerFactory
import org.ziolkow.service.UrlManagementService
import java.net.URI
import java.net.URISyntaxException

interface RedirectController {

    @Get("/{urlShort}")
    fun redirect(@PathVariable("urlShort") urlShort: String) : HttpResponse<String>
}

@Controller("/v1/redirect")
class RedirectControllerControllerImpl (
    ) : RedirectController {

    private val logger = LoggerFactory.getLogger(UrlManagementControllerImpl::class.java)

    @Throws(URISyntaxException::class)
    override fun redirect(urlShort: String): HttpResponse<String> {
        val location = URI("https://www.google.com/?client=safari")
        return HttpResponse.redirect(location)
    }

}
