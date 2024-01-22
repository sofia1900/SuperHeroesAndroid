package com.sofia.superHero.features.superHero.presentation.detailHero.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sofia.myapplication.databinding.ViewSuperHeroPowerstartBinding
import com.sofia.superHero.app.extensions.setUrl
import com.sofia.superHero.features.superHero.domain.SuperHeroDetail

class HeroDetailViewHolder (val view : View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding : ViewSuperHeroPowerstartBinding

    fun bind (model : SuperHeroDetail) {
        binding = ViewSuperHeroPowerstartBinding.bind(view)
        binding.apply {
            imagePower.setUrl(model.image)
            labelNamePower.text = model.powerstat
            labelPoints.text = model.points
        }
    }
}