package com.example.masterclass.articleList

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.masterclass.databinding.ActivityArticleListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleListBinding
    private val viewModel: ArticleListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()
        viewModel.requestArticles()
    }

    private fun observeViewModel() {
        viewModel.state.observe(this) { state -> render(state) }
    }

    private fun render(state: ArticleListState) {
        binding.loadingView.visibility = if (state.isLoading) View.VISIBLE else View.GONE
        binding.recyclerView.apply {
            adapter = ArticlesAdapter(state.articles).apply {
                onClick = { clickedArticle ->
                    showMessage("Article click: ${clickedArticle.title}")
                }
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
