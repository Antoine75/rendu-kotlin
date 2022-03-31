package fr.iim.mydummyapplication


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import fr.iim.mydummyapplication.databinding.FragmentHelloBinding


class HelloFragment : Fragment() {
    private var email: String? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

            email = it.getString(ARG_FIRST_NAME)
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentHelloBinding.inflate(layoutInflater)

        bind.MapButton.setOnClickListener{
            val intent = Intent(this@HelloFragment.requireContext(), MapsActivity::class.java )
            startActivity(intent)
        }

        return bind.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        if (email != null)
            view.findViewById<TextView>(R.id.fragHelloTxtView).text = getString(R.string.hello, email)
        else
            view.findViewById<TextView>(R.id.fragHelloTxtView).text = "No Email"
    }

    companion object {
        private const val ARG_FIRST_NAME = "email"

        @JvmStatic
        fun newInstance(email: String) =
            HelloFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_FIRST_NAME, email)
                }
            }
    }
}