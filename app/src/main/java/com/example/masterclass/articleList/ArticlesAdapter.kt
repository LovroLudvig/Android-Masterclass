package com.example.masterclass.articleList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.masterclass.articleList.model.Article
import com.example.masterclass.databinding.ArticleItemBinding

class ArticlesAdapter(
    private val articles: List<Article>,
) : RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    var onClick: (Article) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val binding = ArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ArticlesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.onBind(articles[position], onClick)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticlesViewHolder(
        private val binding: ArticleItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(article: Article, onClick: (Article) -> Unit) {
            with(binding) {
                title.text = article.title
                description.text = article.description
                root.setOnClickListener { onClick(article) }
            }
        }
    }
}
