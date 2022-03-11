package fr.iim.mydummyapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeFragment : Fragment() {

    private lateinit var listener: HomeFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.editTextButton).setOnClickListener {
            val firstName = view.findViewById<EditText>(R.id.editTextFirstName).text.toString()

            listener.OnHelloClickListener(firstName)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is HomeFragmentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement HomeFragment.HomeFragmentListener")
        }
    }

    interface HomeFragmentListener {
        fun OnHelloClickListener(firstName: String)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}