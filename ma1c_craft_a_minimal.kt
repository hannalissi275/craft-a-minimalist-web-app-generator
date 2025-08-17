import kotlinx.html.*
import kotlinx.html.stream.appendHTML

data class WebAppConfig(
    val title: String,
    val description: String,
    val stylesheet: String = "",
    val script: String = ""
)

fun generateWebApp(config: WebAppConfig): String {
    return buildString {
        appendHTML().html {
            head {
                title(config.title)
                meta("description", config.description)
                if (config.stylesheet.isNotBlank()) {
                    link(rel = "stylesheet", href = config.stylesheet)
                }
            }
            body {
                h1 { +"Welcome to ${config.title}" }
                if (config.script.isNotBlank()) {
                    script {
                        +config.script
                    }
                }
            }
        }
    }
}

fun main() {
    val config = WebAppConfig(
        title = "My Minimal Web App",
        description = "A simple web app generated with ma1c_craft_a_minimal"
    )
    val webApp = generateWebApp(config)
    println(webApp)
}