package com.example.lab3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.ui.theme.Lab3Theme

class MainActivity : ComponentActivity() {
    private var BlockRVArr: ArrayList<DataInterface> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recView: RecyclerView = findViewById(R.id.mRecyclerView)
        setUpBlockArray()
        val mAdapter: CustomAdapter = CustomAdapter(BlockRVArr)
        recView.adapter = mAdapter
        recView.layoutManager = LinearLayoutManager(this)
    }

    fun setUpBlockArray() {
        val userStrs = resources.getStringArray(R.array.mFirstStr)
        val groupStrs = resources.getStringArray(R.array.mSecondStr)
        for (i in userStrs.indices) {
            BlockRVArr.add(User(userStrs[i], groupStrs[i]))
        }
        //val adStr = resources.getStringArray(R.array.mADStr)
        for (i in groupStrs.indices) {
            BlockRVArr.add(Group(groupStrs[i]))
        }
        BlockRVArr.shuffle()
    }
}