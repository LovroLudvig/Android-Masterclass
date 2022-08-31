package com.example.masterclass.articleList.repository

import com.example.masterclass.core.networking.ApiService
import com.example.masterclass.articleList.model.Article
import javax.inject.Inject

class ArticleListRepository @Inject constructor(
    private val apiService: ApiService,
) {

    suspend fun getArticles(): List<Article> {
        return try {
            apiService.getArticles().items?.map { articleResource ->
                articleResource.toArticle()
            } ?: emptyList()
        } catch (exception: Exception) {
            emptyList()
        }
    }
}
