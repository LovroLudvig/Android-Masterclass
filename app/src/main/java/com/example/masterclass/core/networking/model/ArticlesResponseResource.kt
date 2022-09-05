package com.example.masterclass.core.networking.model

import com.example.masterclass.articleList.model.Article
import com.squareup.moshi.Json

data class ArticlesResultResource(
    @field:Json(name = "articles") val items: List<ArticleResource>?,
)

data class ArticleResource(
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "urlToImage") val imageUrl: String?,
) {

    fun toArticle(): Article {
        return Article(
            title = title.orEmpty(),
            description = description.orEmpty(),
            imageUrl = imageUrl.orEmpty(),
        )
    }
}
