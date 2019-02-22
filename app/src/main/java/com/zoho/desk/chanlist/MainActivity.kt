package com.zoho.desk.chanlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.helper.ItemTouchHelper




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Chan List"

        flex_box_recycler_view.apply {
            //layoutManager = LinearLayoutManager(this@MainActivity)
            /*layoutManager = FlexboxLayoutManager(this@MainActivity).apply {
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.SPACE_AROUND
                flexWrap = FlexWrap.WRAP
            }*/
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            val viewAdapter = ViewAdapter(initViewItemDtoList())
            adapter = viewAdapter
            val callback = SimpleItemTouchHelperCallback(viewAdapter)
            val touchHelper = ItemTouchHelper(callback)
            touchHelper.attachToRecyclerView(this)
        }
    }

    private fun initViewItemDtoList(): ArrayList<ViewAdapter.ViewItem> {
        val ret = ArrayList<ViewAdapter.ViewItem>()
        val items = arrayOf("adadfaf", "aldkjfklajdflkadlskfklasjfklasfdklsfd", "adfadfsfdsa", "lakdjflkjadlfkjlasdflasdfjl", "lkasdlkjflaksjdflkadslfklkasjd",
            "adadfaf", "aldkjfklajdflkadlskfklasjfklasfdklsfd", "lakdjflkjadlfkjlasdflasdfjl", "adfadfsfdsa", "lkasdlkjflaksjdflkadslfklkasjd", "adfadfsfdsa", "adfadfsfdsa")
        for (i in 1..10) {
            val itemDto = ViewAdapter.ViewItem(0, "Item-$i : ${items[i-1]}")
            ret.add(itemDto)
        }
        return ret
    }
}
