package com.example.modularization.ui.fragments.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.backend.data.UserModel
import com.example.modularization.App
import com.example.modularization.R
import com.example.modularization.adapter.UserAdapter
import com.example.modularization.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val userAdapter: UserAdapter = UserAdapter()

//    private val viewModel: ListViewModel by viewModels { ListViewModel.Factory }
    private val viewModel: ListViewModel by navGraphViewModels(R.id.main_nav_graph) { ListViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList()
        init()
        listeners()
    }

    private fun listeners() {
        userAdapter.onItemClickListener = { item, bindingItem ->
            navigateFromRecycler(item, bindingItem.ivUser)
        }
    }

    private fun navigateFromRecycler(user: UserModel, view: View) {
        val extras = FragmentNavigatorExtras(view to "image_to")
        findNavController().navigate(
            directions = ListFragmentDirections.actionListFragmentToDetailsFragment(
                user
            ), navigatorExtras = extras
        )
    }

    private fun init() {
        initRecycler()
    }

    private fun initRecycler() {

        binding.rvUsers.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = userAdapter

            postponeEnterTransition()
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
        userAdapter.submitList(viewModel.list.value)
    }
}