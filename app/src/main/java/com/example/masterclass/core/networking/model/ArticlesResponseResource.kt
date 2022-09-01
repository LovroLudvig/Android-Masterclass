package com.example.masterclass.core.networking.model

import com.example.masterclass.articleList.model.Article
import com.squareup.moshi.Json

data class ArticlesResultResource(
    @field:Json(name = "articles") val items: List<ArticleResource>?,
)

data class ArticleResource(
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "description") val description: String?,
) {

    fun toArticle(): Article {
        return Article(
            title = this.title.orEmpty(),
            description = this.description.orEmpty(),
        )
    }
}
