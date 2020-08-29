package zw.co.guava.studentkit.ui.main.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import zw.co.guava.studentkit.R
import zw.co.guava.studentkit.ui.composeTheme.StudentKitTheme

class ModulesFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_modules, container, false).apply {
            findViewById<ComposeView>(R.id.modulesComposeView).setContent {
                StudentKitTheme() {
                    Text(text = "ModulesView in Compose")
                }
            }
        }
    }
}