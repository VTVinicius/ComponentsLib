package br.com.vtvinicius.input_text.utils

import androidx.compose.ui.graphics.drawscope.Stroke
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Validation {

    fun isValidCNPJ(value: String): Boolean {
        val cnpj = value
        return validateCNPJLength(cnpj) && validateCNPJRepeatedNumbers(cnpj)
                && validateCNPJVerificationDigit(true, cnpj)
                && validateCNPJVerificationDigit(false, cnpj)
    }

    private fun validateCNPJLength(cnpj: String) = cnpj.length == 14
    private fun validateCNPJRepeatedNumbers(cnpj: String): Boolean {
        return (0..9)
            .map { it.toString().repeat(14) }
            .map { cnpj == it }
            .all { !it }
    }

    private fun validateCNPJVerificationDigit(firstDigit: Boolean, cnpj: String): Boolean {
        val startPos = when (firstDigit) {
            true -> 11
            else -> 12
        }
        val weightOffset = when (firstDigit) {
            true -> 0
            false -> 1
        }
        val sum = (startPos downTo 0).fold(0) { acc, pos ->
            val weight = 2 + ((11 + weightOffset - pos) % 8)
            val num = cnpj[pos].toString().toInt()
            val sum = acc + (num * weight)
            sum
        }
        val result = sum % 11
        val expectedDigit = when (result) {
            0, 1 -> 0
            else -> 11 - result
        }

        val actualDigit = cnpj[startPos + 1].toString().toInt()

        return expectedDigit == actualDigit
    }

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

    fun isValidDate(date: String): Boolean {
        val dateFormat = SimpleDateFormat("ddMMyyyy", Locale.getDefault())
        dateFormat.isLenient = false
        return try {
            val dateObj = dateFormat.parse(date)
            dateObj.before(Date())
        } catch (e: ParseException) {
            false
        }
    }

}