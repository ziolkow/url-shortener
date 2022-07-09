package org.ziolkow.dto

import java.util.*

data class UrlDTO (
    val id : UUID?,
    val urlLong : String,
    val urlShort : String?
)
