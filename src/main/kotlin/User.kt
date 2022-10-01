class User(name: String) {
    val name: String = name
    val isValidName: Boolean
        get() = name != ""
    var favoriteFood: String = ""
        set(value) {
            field = if (value == "") {
                "apple"
            } else {
                value
            }
        }
}