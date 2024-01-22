package com.sofia.superHero.features.superHero.presentation.detailHero.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sofia.superHero.features.superHero.domain.SuperHeroPower

class HeroDetailDiffUtil : DiffUtil.ItemCallback<SuperHeroPower>(){
    override fun areItemsTheSame(oldItem: SuperHeroPower, newItem: SuperHeroPower): Boolean {
        return oldItem.powerstat == newItem.powerstat
    }

    override fun areContentsTheSame(oldItem: SuperHeroPower, newItem: SuperHeroPower): Boolean {
        return oldItem == newItem
    }
}