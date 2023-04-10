class SlackRepository : SlackAPI {
    private var message = ""

    override fun send(message: String) {
        this.message = message
    }

    override fun getMessage(): String {
        return this.message
    }
}