import java.text.SimpleDateFormat
import java.util.*

class HashPassword {
    companion object {
        private var pattern = listOf("1357924680", "2468013579", "0864297531", "9753108642", "0918273645")
        private var keyPattern0 = mutableListOf<Int>()
        private var keyPattern1 = mutableListOf<Int>()
        private var charPassword = mutableListOf<String>()

        private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

        public fun genPassword(mmyy: String): String {
            var password = ""
            if (mmyy.length == 4) {
                keyPattern0.clear()
                keyPattern1.clear()
                charPassword.clear()

                var numRandom = 0
                for (loop in 1..2) {
                    numRandom = (0..9999).random()
                    while (true) {
                        numRandom /= 4
                        if (numRandom < 10) {
                            keyPattern0.add(keyPattern0.count(), numRandom)
                            break
                        }
                    }
                }

                var keyMod = 0
                for (keyChar in keyPattern0) {
                    if (keyChar >= 5) {
                        keyMod = keyChar.mod(5)
                    }
                    keyPattern1.add(keyPattern1.count(), keyMod)
                }

                var keySwap = 0
                for (chr in mmyy) {
                    var fmt = pattern[(keyPattern1[keySwap])]
                    charPassword.add(charPassword.count(), fmt.indexOf(chr).toString())
                    if (keySwap == 0) {
                        keySwap++
                    } else {
                        keySwap--
                    }
                }
                password = keyPattern0.joinToString("") + charPassword.joinToString("")
            }
            return password
        }

        public fun getIsValid(password: String, mmyy: String = ""): Boolean {
            val num: String = "0123456789"
            if (password.length == 6) {
                for (chr in password) {
                    if (num.contains("")) {
                        keyPattern0.clear()
                        keyPattern1.clear()
                        charPassword.clear()

                        val keyPattern = password.substring(0, 2)
                        val keyPassword = password.substring(2, 6)
                        for (keyChr in keyPattern) {
                            var value = keyChr.toString().toInt()
                            keyPattern0.add(keyPattern0.count(),value)
                        }

                        var keyMod = 0
                        for (keyChr in keyPattern0) {
                            if (keyChr.toInt() >= 5) {
                                keyMod = keyChr.mod(5)
                            }
                            keyPattern1.add(keyPattern1.count(), keyMod)
                        }

                        var keySwap = 0
                        for (chr in keyPassword) {
                            var fmt = pattern[(keyPattern1[keySwap])]
                            var value =  fmt[chr.toString().toInt()].toString()
                            charPassword.add(charPassword.count(),value)
                            if (keySwap == 0) {
                                keySwap++
                            } else {
                                keySwap--
                            }
                        }
                    }
                }

                var mmyy_ = mmyy
                if (mmyy_.isNullOrEmpty()) {
                    val date = Date()
                    val format = SimpleDateFormat("MMyy", Locale.ENGLISH)
                    mmyy_ = format.format(date).toString()
                }
                val password = charPassword.joinToString("")
                if (password==mmyy_) {
                    return true
                }
                println(password)

            }
            return false
        }

    }
}