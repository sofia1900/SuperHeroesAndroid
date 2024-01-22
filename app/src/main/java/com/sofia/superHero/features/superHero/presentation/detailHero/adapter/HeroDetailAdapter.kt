package com.sofia.superHero.features.superHero.presentation.detailHero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sofia.myapplication.R
import com.sofia.superHero.features.superHero.domain.SuperHeroDetail

class HeroDetailAdapter : ListAdapter<SuperHeroDetail, HeroDetailViewHolder>(HeroDetailDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_super_hero_powerstart, parent, false)
        return HeroDetailViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: HeroDetailViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}