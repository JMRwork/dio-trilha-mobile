package br.com.igorbag.githubsearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.adapter.RepositoryAdapter.ViewHolder
import br.com.igorbag.githubsearch.R

class RepositoryAdapter(val repositories: List<Repository>, val onClickShare: (String) -> Unit, val onCLickText: (String) -> Unit): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.shareView.setOnClickListener {
            onClickShare(repositories[position].htmlUrl)
        }
        holder.textView.text = repositories[position].name
        holder.textView.setOnClickListener {
            onCLickText(repositories[position].htmlUrl)
        }
    }

    override fun getItemCount(): Int {
        return repositories.count()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val shareView : ImageView
        val textView : TextView

        init {
            shareView = view.findViewById(R.id.iv_share)
            textView = view.findViewById(R.id.tv_nome_repository)
        }
    }
}
