package com.sofia.superHero.features.superHero.presentation.detailHero.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sofia.superHero.features.superHero.domain.SuperHeroDetail

class HeroDetailDiffUtil : DiffUtil.ItemCallback<SuperHeroDetail>(){
    override fun areItemsTheSame(oldItem: SuperHeroDetail, newItem: SuperHeroDetail): Boolean {
        return oldItem.powerstat == newItem.powerstat
    }

    override fun areContentsTheSame(oldItem: SuperHeroDetail, newItem: SuperHeroDetail): Boolean {
        return oldItem == newItem
    }
}