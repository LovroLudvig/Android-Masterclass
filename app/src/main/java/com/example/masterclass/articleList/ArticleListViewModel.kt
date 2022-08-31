package com.example.masterclass.articleList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masterclass.articleList.repository.ArticleListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val homeRepository: ArticleListRepository,
) : ViewModel() {

    private val _state = MutableLiveData(ArticleListState())
    val state: LiveData<ArticleListState> = _state

    fun requestArticles() {
        viewModelScope.launch {
            // TODO remove this delay (This is only for demonstration to make loading longer)
            delay(2000)
            val articles = homeRepository.getArticles()
            _state.value = ArticleListState(
                isLoading = false,
                articles = articles
            )
        }
    }
}
