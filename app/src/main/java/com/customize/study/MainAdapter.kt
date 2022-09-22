package com.customize.study

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class MainAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_show) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.textView, item)
    }
}