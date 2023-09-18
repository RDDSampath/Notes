package com.sathruwan.notes.ui.baseinterface

import android.view.View
import com.sathruwan.notes.model.Notes

interface OnClickListener {
    fun onItemClickListener(item: Notes)
    fun onLongItemClickListener(item:Notes,view : View,position: Int) : Boolean
//    fun onItemStateChanged(key: Long, selected: Boolean)
}