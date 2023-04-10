interface SlackAPI {
    fun send(message: String)
    fun getMessage(): String
}