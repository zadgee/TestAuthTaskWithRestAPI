package screens.catalogscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tesktaskauth.R
import com.example.tesktaskauth.databinding.FragmentCatalogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : Fragment() {
    lateinit var adapter:CatalogRecView
lateinit var binding : FragmentCatalogBinding
private val viewmodel by viewModels<CatalogViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CatalogRecView(requireContext())
        binding.brandlist.adapter = adapter
        binding.brandlist.layoutManager = LinearLayoutManager(context)
      viewmodel.initializebrandlist()
        viewmodel.brandstate.observe(viewLifecycleOwner){
            list->
            adapter.createbrandslist(listOf(list.body()!!.brands))
        }
    }
}