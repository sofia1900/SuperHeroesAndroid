package com.sofia.superHero.features.superHero.presentation.listHeroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.google.android.material.snackbar.Snackbar
import com.sofia.myapplication.R
import com.sofia.myapplication.databinding.FragmentHeroesListBinding
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.extensions.hide
import com.sofia.superHero.app.presentation.error.ErrorUiModel
import com.sofia.superHero.features.superHero.presentation.listHeroes.adapter.SuperHeroAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesListFragment : Fragment() {
    private var _binding: FragmentHeroesListBinding? = null
    private val binding get() = _binding!!
    private val heroAdapter = SuperHeroAdapter()
    private val viewModel by viewModels<HeroesListViewModel>()
    private lateinit var skeleton : Skeleton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        setupView()
        skeleton = binding.listHeroes.applySkeleton(R.layout.view_super_hero_item, 8)
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            listHeroes.layoutManager = LinearLayoutManager(
                this@HeroesListFragment.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            listHeroes.adapter = heroAdapter
            heroAdapter.setEvent { idHero ->
                findNavController().navigate(
                    HeroesListFragmentDirections.actionFromFragmentListToFragmentDetail(idHero)
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.loadListSuperHeroes()
    }

    private fun setupObserver() {
        val observer = Observer<HeroesListViewModel.UiState> {
            if (it.isLoading) {
                binding.errorView.hide()
                skeleton.showSkeleton()
            } else {
                skeleton.showOriginal()
                if (it.error != null) {
                    showError(it.error)
                } else {
                    binding.errorView.hide()
                    it.superHeroes?.apply {
                        heroAdapter.submitList(this)
                    }
                }
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun showError(error: ErrorUiModel) {
        binding.errorView.render(error)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}