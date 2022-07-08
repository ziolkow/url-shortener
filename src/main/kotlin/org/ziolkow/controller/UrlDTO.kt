package org.ziolkow.controller

import java.util.UUID

data class UrlDTO (
    val id : UUID?,
    val urlLong : String,
    val urlShort : String?
)
