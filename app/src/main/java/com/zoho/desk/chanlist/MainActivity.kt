package com.zoho.desk.chanlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Chan List"

        flex_box_recycler_view.apply {
            //layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = FlexboxLayoutManager(this@MainActivity).apply {
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.SPACE_AROUND
                flexWrap = FlexWrap.WRAP
            }
            adapter = ViewAdapter(initViewItemDtoList())
        }
    }

    private fun initViewItemDtoList(): List<ViewAdapter.ViewItem> {
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
