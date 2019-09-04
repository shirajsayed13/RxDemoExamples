package com.shirajsayed.rxdemoexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shirajsayed.rxdemoexamples.ui.GitHubRepoActivity
import com.shirajsayed.rxdemoexamples.ui.GitHubUserActivity
import com.shirajsayed.rxdemoexamples.ui.GitHubUserStartWithSActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gitHubUserButton.setOnClickListener {
            startActivity<GitHubUserActivity>()
        }

        gitHubUserStartWithSButton.setOnClickListener {
            startActivity<GitHubUserStartWithSActivity>()
        }

        myGitHubRepoButton.setOnClickListener {
            startActivity<GitHubRepoActivity>()
        }
    }
}
