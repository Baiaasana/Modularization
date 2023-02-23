package com.example.modularization.ui.fragments.details

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import androidx.transition.TransitionInflater
import com.example.backend.data.UserModel
import com.example.modularization.R
import com.example.modularization.databinding.FragmentDetailsBinding
import com.example.modularization.ui.fragments.list.ListViewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: ListViewModel by navGraphViewModels(R.id.main_nav_graph) { ListViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        setUpTransition()
        return binding.root
    }

    private fun setUpTransition() {
        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.user = args.user
        listeners()
    }

    private fun listeners() = with(binding) {
        ivEdit.setOnClickListener {
            editInfo()
        }
        btnUpdate.setOnClickListener {
            updateInfo()
            setDisabled(
                etAge, etFirstName, etLastName, etUsername, button = btnUpdate, imageView = ivEdit
            )
        }
    }

    private fun editInfo() = with(binding) {
        btnUpdate.visibility = View.VISIBLE
        setEnabled(etAge, etFirstName, etLastName, etUsername, imageView = ivEdit)
    }

    private fun updateInfo() = with(binding) {
        viewModel.updateListItems(item = user!!.apply {
            username = etUsername.text.toString()
            firstName = etFirstName.text.toString()
            lastName = etLastName.text.toString()
            age = etAge.text.toString().toInt()
        })
    }

    private fun setEnabled(vararg editText: AppCompatEditText, imageView: AppCompatImageView) {
        for (i in editText) {
            i.isEnabled = true
            i.setTextColor(Color.parseColor("#ff0099cc"))
        }
        imageView.apply {
            setBackgroundColor(Color.parseColor("#ff0099cc"))
            setColorFilter(Color.parseColor("#FFFFFF"))
        }
    }

    private fun setDisabled(
        vararg editText: AppCompatEditText, button: AppCompatButton, imageView: AppCompatImageView
    ) {
        for (i in editText) {
            i.isEnabled = false
            i.setTextColor(Color.parseColor("#FF000000"))
        }
        imageView.apply {
            setBackgroundColor(Color.parseColor("#FFFFFF"))
            setColorFilter(Color.parseColor("#FF000000"))
        }
        button.visibility = View.INVISIBLE
    }
}