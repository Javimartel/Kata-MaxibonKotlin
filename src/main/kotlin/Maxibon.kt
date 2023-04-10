class Maxibon(private val slackAPI: SlackAPI, private var maxibons: Int = 10) {
    private val LIMIT: Int = 2
    private val INCREMENT: Int = 10

    init {
        this.maxibons = if (this.maxibons <= this.LIMIT) this.maxibons + this.INCREMENT else this.maxibons
    }

    fun takeMaxibon(developer: Developer) {
        this.maxibons -= if (this.maxibons < developer.maxibonsToTake) this.maxibons else developer.maxibonsToTake
        checkAmountOfMaxibonsAfterTakenBy(developer)
    }

    private fun checkAmountOfMaxibonsAfterTakenBy(developer: Developer) {
        if (this.maxibons <= this.LIMIT) {
            this.maxibons += this.INCREMENT
            this.slackAPI.send("Hi guys, I'm ${developer.name}. We need more maxibons!")
        }
    }

    fun getMaxibons(): Int {
        return this.maxibons
    }

    fun takeMaxibonInGroupOf(developers: List<Developer>) {
        developers.forEach{
            developer -> this.takeMaxibon(developer)
        }
    }

    fun getAPIMessage(): String {
        return this.slackAPI.getMessage()
    }
}
