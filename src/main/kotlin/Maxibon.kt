class Maxibon {
    private var maxibons = 10

    fun takeMaxibon(developer: String) {
        if(developer === "Pedro") {
            this.maxibons -= 3
        }
        if(developer === "Fran") {
            this.maxibons -= 1
        }
    }

    fun getMaxibons(): Int {
        return this.maxibons
    }
}
