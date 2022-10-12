//@Preview
//@Composable
//fun InputTextPreview() {
//
//    Column(
//        verticalArrangement = Arrangement.SpaceEvenly,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(32.dp)
//            .verticalScroll(state = rememberScrollState())
//
//    ) {
//
//        CepInputText(state = InputTextState.OUTLINE, onSearch = {})
//        CPFInputText(state = InputTextState.GRAY, onSearch = {})
//        EmailInputText {}
//        NameInputText(state = InputTextState.OUTLINE, onSearch = {})
//        PasswordInputText(onSearch = {})
//        PhoneInputText {}
//        BasicInputText(
//            maxLength = 100,
//            hint = "Basico",
//            state = InputTextState.OUTLINE,
//            onSearch = {})
//        OnlyLettersInputText(
//            maxLength = 100,
//            hint = "Apenas Letras",
//            state = InputTextState.GRAY,
//            onSearch = {})
//        OnlyNumbersInputText(maxLength = 100, hint = "Apenas Numeros", onSearch = {})
//    }
//}