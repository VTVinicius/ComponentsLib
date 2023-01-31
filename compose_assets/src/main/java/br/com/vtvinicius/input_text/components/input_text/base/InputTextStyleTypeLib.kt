package br.com.vtvinicius.input_text.components.input_text.base

enum class InputTextStyleTypeLib(val value: Int) {
    NOTHING(-1),
    CPF(0),
    PHONE(1),
    NAME(2),
    CEP(3),
    PASSWORD(4),
    EMAIL(5),
    CNPJ(6),
    DATE(7);

    var errorMessage: String = ""

    fun getErrorMessage(message: String) = when (value) {
        NOTHING.value -> ""
        CPF.value -> errorMessage = message
        PHONE.value -> errorMessage = message
        NAME.value -> errorMessage = message
        CEP.value -> errorMessage = message
        PASSWORD.value -> errorMessage = message
        EMAIL.value -> errorMessage = message
        CNPJ.value -> errorMessage = message
        DATE.value -> errorMessage = message
        else -> ""
    }


}