package screens.homescreen
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tesktaskauth.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var adapter:HomeRecView
    lateinit var binding : FragmentHomeBinding
    private val viewmodel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
viewmodel.realizeuserrepository()
        viewmodel.stateuser.observe(viewLifecycleOwner){
            resp->
            if(resp.isSuccessful){
                binding.userlayout.visibility = VISIBLE
            }
        }
        adapter = HomeRecView(requireContext(),view)
        binding.recviewmenu.layoutManager = LinearLayoutManager(context)
        binding.recviewmenu.adapter = adapter
        viewmodel.realizemenurepository()
        viewmodel.statemenu.observe(viewLifecycleOwner){
          list->
           adapter.setlist(listOf(list.body()!!.items))
        }
    }

}