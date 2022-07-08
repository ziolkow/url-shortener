package org.ziolkow.service

import jakarta.inject.Singleton
import org.ziolkow.controller.UrlDTO
import org.ziolkow.domain.Url
import org.ziolkow.domain.UrlRepository
import java.util.UUID
import javax.transaction.Transactional

interface UrlManagementService {

    fun addUrl(urlDTO: UrlDTO) : UrlDTO

    fun getUrl(id : UUID) : UrlDTO

}

@Singleton
open class UrlManagementServiceImpl(
    private val urlRepository : UrlRepository
) : UrlManagementService {

    @Transactional
    override fun addUrl(urlDTO: UrlDTO): UrlDTO {
        val newUrl = urlRepository.save(Url.fromUrlDTO(urlDTO))
        return newUrl.toUrlDTO()
    }

    override fun getUrl(id: UUID): UrlDTO {
        return urlRepository.findById(id).get().toUrlDTO()
    }

}
