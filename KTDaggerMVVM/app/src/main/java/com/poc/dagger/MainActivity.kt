package com.poc.dagger

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.poc.dagger.model.RecyclerDataList
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var rvAdapter: RecyclerViewAdapter
private lateinit var mViewModelMain: MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView() {
        rv_Data.layoutManager = LinearLayoutManager(this)
        rvAdapter = RecyclerViewAdapter()
        rv_Data.adapter = rvAdapter

    }

    private fun initViewModel() {

        mViewModelMain = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mViewModelMain.getLivaDataObserve().observe(this, object: Observer<RecyclerDataList>{
            override fun onChanged(t: RecyclerDataList?) {
                if(t!=null){
                    rvAdapter.setUpdatedData(t.items)
                    rvAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity, "Error!!! Fetching data", Toast.LENGTH_SHORT).show()
                }
            }
        })
        mViewModelMain.makeAPICall()
    }

}