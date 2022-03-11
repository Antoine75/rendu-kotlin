package fr.iim.mydummyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class HelloFragment : Fragment() {
    private var firstName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstName = it.getString(ARG_FIRST_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (firstName != null)
            view.findViewById<TextView>(R.id.fragHelloTxtView).text = getString(R.string.hello, firstName)
        else
            view.findViewById<TextView>(R.id.fragHelloTxtView).text = "No FirstName"
    }

    companion object {
        private const val ARG_FIRST_NAME = "firstName"

        @JvmStatic
        fun newInstance(firstName: String) =
            HelloFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_FIRST_NAME, firstName)
                }
            }
    }
}