package com.shirajsayed.rxdemoexamples.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shirajsayed.rxdemoexamples.R
import com.shirajsayed.rxdemoexamples.model.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoAdapter(private val mContext: Context, private val mRepoList: List<Repo>) :
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): RepoAdapter.RepoViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_repo, viewGroup, false)

        return RepoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepoAdapter.RepoViewHolder, position: Int) {
        val repo = getItem(position)

        holder.repoNameTextView.text = "Repo Name: ${repo.repoName}"
        if (repo.topContributor == "") {
            holder.topContributorTextView.text = "Null"
        } else {
            holder.topContributorTextView.text = "Top Contributor: ${repo.topContributor}"
        }
    }

    override fun getItemCount(): Int {
        return mRepoList.size
    }

    fun getItem(position: Int): Repo {
        return mRepoList[position]
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repoNameTextView: TextView = itemView.repoNameTextView
        val topContributorTextView: TextView = itemView.topContributorTextView
    }
}
