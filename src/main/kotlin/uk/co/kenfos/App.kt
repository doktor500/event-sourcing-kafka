package uk.co.kenfos

class App {
    val main: String
        get() {
            return "OK"
        }
}

fun main(args: Array<String>) {
    println(App().main)
}
