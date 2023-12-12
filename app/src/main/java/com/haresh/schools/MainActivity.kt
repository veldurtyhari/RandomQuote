package com.haresh.schools

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.haresh.schools.databinding.ActivityMainBinding
import com.haresh.schools.models.School
import com.haresh.schools.viewmodels.MainViewModel
import com.haresh.schools.viewmodels.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel


   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


       binding.rvPostsLis.layoutManager = LinearLayoutManager(this)
       binding.rvPostsLis.setLayoutManager(binding.rvPostsLis.layoutManager);
       binding.rvPostsLis.setHasFixedSize(true);
       val adapter = PostsAdapter(this)
       binding.rvPostsLis.adapter = adapter
       adapter.notifyDataSetChanged()


       val repository = (application as QuoteApplication).quoteRepository
       mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
       mainViewModel.quotes.observe(this, Observer { list -> list?.let {

           adapter.updateList(it)
            

           //Toast.makeText(this@MainActivity, it.size.toString(), Toast.LENGTH_SHORT).show()
       } })


   }



}

