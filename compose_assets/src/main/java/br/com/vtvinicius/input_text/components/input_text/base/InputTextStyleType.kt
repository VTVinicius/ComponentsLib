enum class InputTextStyleType(val value: Int) {
    NOTHING(-1),
    CPF(0),
    PHONE(1),
    NAME(2),
    CEP(3),
    PASSWORD(4),
    EMAIL(5);

    var errorMessage: String = ""

    fun getErrorMessage(message: String) = when (value) {
        NOTHING.value -> ""
        CPF.value -> errorMessage = message
        PHONE.value -> errorMessage = message
        NAME.value -> errorMessage = message
        CEP.value -> errorMessage = message
        PASSWORD.value -> errorMessage = message
        EMAIL.value -> errorMessage = message
        else -> ""
    }


}