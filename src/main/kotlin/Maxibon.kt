class Maxibon {
    private var maxibons = 10

    fun takeMaxibon(developer: String) {
        when (developer) {
            "Pedro" -> this.maxibons -= 3
            "Fran" -> this.maxibons -= 1
            "Sergio" -> this.maxibons -= 2
        }
    }

    fun getMaxibons(): Int {
        return this.maxibons
    }
}
