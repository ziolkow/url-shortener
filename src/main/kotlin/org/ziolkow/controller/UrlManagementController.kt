package org.ziolkow.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.swagger.v3.oas.annotations.parameters.RequestBody
import org.slf4j.LoggerFactory
import org.ziolkow.dto.UrlDTO
import org.ziolkow.service.UrlManagementService
import java.util.UUID

interface UrlManagementController {

    @Post("/")
    fun addUrl(@RequestBody urlDTO: UrlDTO): UrlDTO?

    @Get("/{id}")
    fun getUrl(@PathVariable("id") id: UUID): UrlDTO?
}

@Controller("/v1/urls")
class UrlManagementControllerImpl (
    private val urlManagementService : UrlManagementService
    ) : UrlManagementController {

    private val logger = LoggerFactory.getLogger(UrlManagementControllerImpl::class.java)

    override fun addUrl(urlDTO: UrlDTO): UrlDTO? {
        logger.info("Adding an url $urlDTO")
        return urlManagementService.addUrl(urlDTO)
    }

    override fun getUrl(id: UUID): UrlDTO? {
        logger.info("Searching for url: $id")
        return urlManagementService.getUrl(id)
    }

}
