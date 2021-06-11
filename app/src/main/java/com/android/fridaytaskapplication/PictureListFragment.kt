package com.android.fridaytaskapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.fridaytaskapplication.callback.RecyclerViewCallback
import com.android.fridaytaskapplication.databinding.FragmentPictureListBinding
import com.android.fridaytaskapplication.model.Picture

class PictureListFragment : Fragment() {
    private val viewModel: PictureListViewModel by viewModels()


    private lateinit var binding: FragmentPictureListBinding
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPictureListBinding.inflate(
            inflater, container, false
        )
        viewModel.init()
        init()
        return binding.root
    }

    private fun init() {
        adapter = RecyclerViewAdapter(object : RecyclerViewCallback{
            override fun onUpdateClick(picture: Picture) {
                findNavController().navigate(R.id.action_pictureListFragment_to_addPictureFragment,
                    bundleOf("picture" to picture))
            }

            override fun onDeleteClick(picture: Picture) {
                viewModel.deletePicture(picture)
            }

        })
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        viewModel.readData()
        setListener()
        observe()
    }

    private fun observe() {
        viewModel.readAllData.observe(viewLifecycleOwner,{
            adapter.setData(it)
            })
    }

    private fun setListener(){
        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.action_pictureListFragment_to_addPictureFragment)
        }
    }
//    private fun addUser(){
//        val title = arguments?.getString("title")
//        val description = arguments?.getString("description")
//        val photoUrl= arguments?.getString("photoUrl")
//        val picture = Picture(title,description,photoUrl)
//        if(!description.isNullOrEmpty() and !photoUrl.isNullOrEmpty() and !title.isNullOrEmpty()){
//            viewModel.addPicture(picture)
//        }
//    }




}