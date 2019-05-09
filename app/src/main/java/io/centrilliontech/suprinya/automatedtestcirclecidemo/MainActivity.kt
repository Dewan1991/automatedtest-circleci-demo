package io.centrilliontech.suprinya.automatedtestcirclecidemo

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import io.centrilliontech.suprinya.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var adapter: ShoesAdapter
    //lateinit var viewModel: MainViewModel

    private val adapter: ShoesAdapter by lazy {
        ShoesAdapter(this)
    }

    private val viewModel: MainViewModel  by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val shoesShelfObserver =
            Observer<ShoesShelfContainer> { value ->
                value?.let { displayShoes(value) }
            }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = "World"
        txtPrint.text = "Hello $name"

        initButton()
        initRecyclerView()
        observeData()
    }

    private fun initLoad() {
        viewModel.initLoad()
    }

    private fun observeData() {
        viewModel.getShoesShelf().observe(this, shoesShelfObserver)
    }

    private fun initButton() {
        btnGet.setOnClickListener {
            initLoad()
        }
    }

    private fun initRecyclerView() {
        val rv = findViewById<RecyclerView>(R.id.rcvShoes)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv.adapter = adapter
    }


    private fun displayShoes(shoesShelfContainer: ShoesShelfContainer) {
        txtPrint.text = getString(R.string.shoes_shelf)
        adapter.setItems(shoesShelfContainer)
    }
}

