package com.sofia.superHero.features.superHero.presentation.detailHero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.sofia.myapplication.R
import com.sofia.myapplication.databinding.FragmentHeroDetailBinding
import com.sofia.superHero.app.extensions.hide
import com.sofia.superHero.app.extensions.setUrl
import com.sofia.superHero.app.presentation.error.ErrorUiModel
import com.sofia.superHero.features.superHero.domain.SuperHero
import com.sofia.superHero.features.superHero.domain.SuperHeroDetail
import com.sofia.superHero.features.superHero.presentation.detailHero.adapter.HeroDetailAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Error

@AndroidEntryPoint
class HeroDetailFragment : Fragment() {
    private var _binding: FragmentHeroDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HeroDetailViewModel>()
    private val detailAdapter = HeroDetailAdapter()
    private val args: HeroDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroDetailBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView () {
        binding.apply {
            powerstarts.layoutManager = LinearLayoutManager(
                this@HeroDetailFragment.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            powerstarts.adapter = detailAdapter

            toolbarDetail.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.loadDetails(args.heroId)
    }

    private fun setupObserver () {
        val observer = Observer<HeroDetailViewModel.UiState>{
            if (it.isLoading){
                binding.errorView.hide()
                showLoading()
            }else{
                hideLoading()
                if (it.error != null){
                    showError(it.error)
                }else {
                    binding.errorView.hide()
                    if (it.superHero != null)  bindData(it.superHero)
                }
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun showError(error: ErrorUiModel){
        binding.errorView.render(error)
    }

    private fun showLoading (){
        binding.skeletonLayout.showSkeleton()
    }

    private fun hideLoading(){
        binding.skeletonLayout.showOriginal()
    }

    private fun bindData(superHero : SuperHero){

        val detailSuperHero : MutableList<SuperHeroDetail> = mutableListOf()

        binding.apply {
            imageHero.setUrl(superHero.image)
            labelName.text = superHero.name
            labelFullName.text = superHero.fullName
            labelAligment.text = superHero.alignment.toUpperCase()
            if(labelAligment.text == "BAD") labelAligment.setTextColor(resources.getColor(R.color.md_theme_light_error))
            toolbarDetail.title = superHero.name;

        }

        detailSuperHero.add(SuperHeroDetail(getString(R.string.label_powerstat_inteligencia), superHero.intelligence, superHero.image))
        detailSuperHero.add(SuperHeroDetail(getString(R.string.label_powerstat_fortaleza), superHero.strength, superHero.image))
        detailSuperHero.add(SuperHeroDetail(getString(R.string.label_powerstat_velocidad), superHero.speed, superHero.image))
        detailSuperHero.add(SuperHeroDetail(getString(R.string.label_powerstat_durabilidad), superHero.durability, superHero.image))
        detailSuperHero.add(SuperHeroDetail(getString(R.string.label_powerstat_fuerza), superHero.power, superHero.image))
        detailSuperHero.add(SuperHeroDetail(getString(R.string.label_powerstat_combate), superHero.combat, superHero.image))

        detailAdapter.submitList(detailSuperHero)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}