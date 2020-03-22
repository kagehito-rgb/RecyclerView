package com.example.multityperecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.multityperecyclerview.multiRecyclerView.MultiRecyclerViewFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.maincontainer, MultiRecyclerViewFragment())
        transaction.commit()
    }
}
