package org.ziolkow.domain

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import org.ziolkow.controller.UrlDTO
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Url {

    @Id
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "url_short", nullable = false, unique = true)
    open var urlShort: String = ""

    @Column(name = "url_long", nullable = false)
    var urlLong: String = ""

    fun toUrlDTO(): UrlDTO {
        return UrlDTO(
            id = id,
            urlLong = urlLong,
            urlShort = urlShort
        )
    }

    companion object {
        fun fromUrlDTO(urlDTO: UrlDTO): Url {
            val url = Url()
            url.id = UUID.randomUUID()
            url.urlShort = UUID.randomUUID().toString().substring(1..5)
            url.urlLong = urlDTO.urlLong
            return url
        }
    }

}


@Repository
interface UrlRepository : JpaRepository<Url,UUID> {
    fun findByUrlShort(urlShort: String): Url
}
