package com.sofia.superHero.features.superHero.presentation.listHeroes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sofia.myapplication.databinding.ViewSuperHeroItemBinding
import com.sofia.superHero.app.extensions.setUrl
import com.sofia.superHero.features.superHero.domain.SuperHero

class SuperHeroViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var binding: ViewSuperHeroItemBinding
    fun bind(model: SuperHero, onClick: (String) -> Unit) {
        binding = ViewSuperHeroItemBinding.bind(view)
        binding.apply {
            imageHero.setUrl(model.image)
            labelName.text = model.name
            labelFullName.text = model.fullName
            labelOccupation.text = model.occupation
            vectorChevron.setOnClickListener {
                onClick(model.id)
            }
        }
    }
}