package com.shirajsayed.rxdemoexamples.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.shirajsayed.rxdemoexamples.R
import com.shirajsayed.rxdemoexamples.api.RetrofitClient
import com.shirajsayed.rxdemoexamples.model.githubresponse.GitHubUserSince
import com.shirajsayed.rxdemoexamples.utility.SetUpLayoutManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_github.*

class GitHubUserStartWithSActivity : AppCompatActivity() {

    private lateinit var mGitHubUserAdapter: GitHubUserAdapter
    private val mGitHubUserList = ArrayList<GitHubUserSince>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)

        SetUpLayoutManager.verticalLinearLayout(applicationContext, gitHubRecyclerView)

        mGitHubUserAdapter = GitHubUserAdapter(mGitHubUserList)
        gitHubRecyclerView.adapter = mGitHubUserAdapter

        val userObservable = getUserObservable()
        val userObserver = getUserObserver()

        userObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { githubUser ->
                githubUser.toObservable()
            }
            .filter {
                it.login.toLowerCase().startsWith("s")
            }
            .toList()
            .subscribe(userObserver)
    }

    private fun getUserObservable(): Observable<List<GitHubUserSince>> {
        return RetrofitClient.gitHubMethods().getGitHubUserObservable(135)
    }

    private fun getUserObserver(): DisposableSingleObserver<List<GitHubUserSince>> {
        return object : DisposableSingleObserver<List<GitHubUserSince>>() {
            override fun onError(e: Throwable) {
                Log.i("onError", e.toString())
            }

            override fun onSuccess(gitHubUserSinceList: List<GitHubUserSince>) {
                mGitHubUserList.clear()
                mGitHubUserList.addAll(gitHubUserSinceList)
                mGitHubUserAdapter.notifyDataSetChanged()
            }
        }
    }
}