package br.com.vtvinicius.input_text.utils

class Validation {

    fun validateCPF(cpf: String): Boolean {
        if (cpf.length != 11) return false
        val numbers = cpf.replace("\\D".toRegex(), "")
        val dv1 = numbers[9].toString().toInt()
        val dv2 = numbers[10].toString().toInt()
        var soma = 0
        var resto = 0
        for (i in 0..8) {
            soma += numbers[i].toString().toInt() * (10 - i)
        }
        resto = 11 - (soma % 11)
        if (resto > 9) resto = 0
        if (resto != dv1) return false
        soma = 0
        for (i in 0..9) {
            soma += numbers[i].toString().toInt() * (11 - i)
        }
        resto = 11 - (soma % 11)
        if (resto > 9) resto = 0
        if (resto != dv2) return false
        return true
    }

    fun validateName(name: String): Boolean {
        return name.matches(RegexEnum.NAME.value)
    }

    fun validatePhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.matches(RegexEnum.PHONE_NUMBER.value)
    }

    fun validateEmail(email: String): Boolean {
        return email.matches(RegexEnum.EMAIL.value)
    }

    fun validateStrongPassword(password: String): Boolean {
        return password.matches(RegexEnum.STRONG_PASSWORD.value)
    }
    fun validateNumberPassword(password: String): Boolean {
        return password.matches(RegexEnum.NUMBERS.value)
    }

}