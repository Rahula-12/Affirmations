package com.example.affirmations

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity(), onItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset,this)
        recyclerView.setHasFixedSize(true)
    }

    override fun showToast(@StringRes affirmation: Int) {
        Toast.makeText(this,affirmation,Toast.LENGTH_SHORT).show()
    }
}
interface onItemClicked{
    fun showToast(@StringRes affirmation: Int)
}