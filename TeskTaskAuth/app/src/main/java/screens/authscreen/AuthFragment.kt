package screens.authscreen

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tesktaskauth.R
import com.example.tesktaskauth.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint
import logindata
import passworddata
import retrofit.models.AuthRequestData



@AndroidEntryPoint
class AuthFragment : Fragment() {
private val viewmodel by viewModels<AuthViewModel>()
lateinit var binding : FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding =  FragmentAuthBinding.inflate(inflater)
       return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
viewmodel.checkVersionInitialization()
        viewmodel.versionstate.observe(viewLifecycleOwner){
            versionresponse->
           if(versionresponse.isSuccessful){
               binding.updateapp.visibility = VISIBLE
           }else{
               binding.versionistooold.visibility = VISIBLE
           }
        }
        binding.loginButton.setOnClickListener{
            if(binding.phoneedtext.length() == 0 || binding.passwordedtext.length() ==0){
                Toast.makeText(requireContext(),"Телефон або пароль  порожній, будь ласка, заповніть ці строки!",Toast.LENGTH_SHORT).show()
            }else{
                sendpostrequest(view)
            }
        }
    }

    private fun sendpostrequest(view: View) {
        val login = binding.phoneedtext.text.toString()
        val password = binding.passwordedtext.text.toString()
        if(login == logindata || password == passworddata){
            viewmodel.sendLoginAndpassdata(login, password)
        }else{
            Toast.makeText(requireContext(),"Данні введені не вірно",Toast.LENGTH_SHORT).show()
        }
        if(login != logindata || password != passworddata){
            Toast.makeText(requireContext(),"Телефон, або пароль не вірний",Toast.LENGTH_SHORT).show()
        }else{
            Navigation.findNavController(view).navigate(R.id.action_authFragment_to_homeFragment)
        }

    }

}