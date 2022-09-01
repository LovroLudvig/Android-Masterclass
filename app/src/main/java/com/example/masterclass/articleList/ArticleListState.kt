package com.example.masterclass.articleList

import com.example.masterclass.articleList.model.Article

data class ArticleListState(
    val isLoading: Boolean = true,
    val articles: List<Article> = emptyList(),
)
