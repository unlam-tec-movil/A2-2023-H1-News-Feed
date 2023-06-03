package ar.edu.unlam.mobile2.mediastackapi.data.mapper

import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.data.api.response.Data
import ar.edu.unlam.mobile2.mediastackapi.data.local.NewEntity


fun Data.toDomain(): New{
    return New(
        author = this.author,
        category = this.category,
        country = this.country,
        description = this.description,
        image = this.image,
        language = this.language,
        publishedAt = this.publishedAt,
        source = this.source,
        title = this.title,
        url = this.url
    )
}


fun New.toEntity(): NewEntity{
    return NewEntity(
        author = this.author,
        category = this.category,
        country = this.country,
        description = this.description,
        image = this.image,
        language = this.language,
        publishedAt = this.publishedAt,
        source = this.source,
        title = this.title,
        url = this.url
    )
}

fun NewEntity.toDomain(): New{
    return New(
        author = this.author,
        category = this.category,
        country = this.country,
        description = this.description,
        image = this.image,
        language = this.language,
        publishedAt = this.publishedAt,
        source = this.source,
        title = this.title,
        url = this.url
    )
}