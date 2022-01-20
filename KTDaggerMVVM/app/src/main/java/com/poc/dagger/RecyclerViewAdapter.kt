package com.poc.dagger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.poc.dagger.model.RecyclerData
import kotlinx.android.synthetic.main.rv_list_items.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var mDataList: List<RecyclerData>? = null

    fun setUpdatedData(mDataList: List<RecyclerData>) {
        this.mDataList = mDataList
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mImgAvatar = view.img_Avatar
        val mTitle = view.txt_Title
        val mDescription = view.txt_Description

        fun bind(data: RecyclerData) {
            mTitle.setText(data.name)
            mDescription.setText(data.description)

            Glide.with(mImgAvatar)
                .load(data.owner?.avatarURL)
                .apply(RequestOptions.centerCropTransform()) // apply Image view changes
                .into(mImgAvatar)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_list_items, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mDataList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (mDataList == null) return 0
        else return mDataList?.size!!
    }
}