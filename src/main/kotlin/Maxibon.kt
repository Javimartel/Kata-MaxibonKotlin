class Maxibon(private val slackAPI: SlackAPI) {
    private var maxibons = 10

    fun takeMaxibon(developer: String) {
        when (developer) {
            "Pedro" -> this.maxibons -= 3
            "Fran", "Jorge" -> this.maxibons -= 1
            "Sergio" -> this.maxibons -= 2
        }
        checkAmountOfMaxibonsAfterTakenBy(developer)
    }

    private fun checkAmountOfMaxibonsAfterTakenBy(developer: String) {
        if (this.maxibons <= 2) {
            this.maxibons += 10
            this.slackAPI.send("Hi guys, I'm $developer. We need more maxibons!")
        }
    }

    fun getMaxibons(): Int {
        return this.maxibons
    }

    fun takeMaxibonInGroupOf(developers: List<String>) {
        developers.forEach{
            developer -> this.takeMaxibon(developer)
        }
    }

    fun getAPIMessage(): String {
        return this.slackAPI.getMessage()
    }
}
