class TestK<out Fruit>:Any() {
    private var fruit: Fruit? = null
    fun getString(): String {
        return ""
    }

    fun getS(): Fruit? {
        return fruit
    }

    fun getSList(): List<Fruit> {
        return arrayListOf()
    }
}