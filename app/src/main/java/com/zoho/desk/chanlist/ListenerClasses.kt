package com.zoho.desk.chanlist

/**
 * Created by chandra-1765$ on 22/02/19$.
 */

interface ItemTouchHelperAdapter {

    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean

    fun onItemDismiss(position: Int)
}