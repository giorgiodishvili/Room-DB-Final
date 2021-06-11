package com.android.fridaytaskapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.fridaytaskapplication.databinding.FragmentAddPictureBinding
import com.android.fridaytaskapplication.databinding.FragmentPictureListBinding
import com.android.fridaytaskapplication.model.Picture

class AddPictureFragment : Fragment() {
    private lateinit var binding: FragmentAddPictureBinding
    private lateinit var viewModel: PictureListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddPictureBinding.inflate(
            inflater, container, false
        )
        viewModel = ViewModelProvider(requireActivity()).get(PictureListViewModel::class.java)
        viewModel.init()
        init()
        return binding.root
    }

    private fun init() {
        binding.btnSave.setOnClickListener{
            val title = binding.title.text.toString().trim()
            val description = binding.tvDescription.text.toString().trim()
            val photoUrl = binding.picture.text.toString().trim()

            if(title.length in 5..30){
                Toast.makeText(requireContext(),"Length Should be between 5 and 30",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(description.length in 32..300){
                Toast.makeText(requireContext(),"Length Should be between 32 and 300",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val picture1: Picture? = arguments?.get("picture") as Picture?
            if(picture1 != null){
                viewModel.updatePicture(Picture(picture1.id,title,description,photoUrl))
            }else{
                viewModel.addPicture( Picture(title,description,photoUrl))
            }
            findNavController().navigateUp()
        }
    }


}