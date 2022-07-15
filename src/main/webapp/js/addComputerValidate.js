function submitForm() {
    let resultCheck = true;
    let resultCheckComputerCode = checkComputerCode();
    if (!resultCheckComputerCode) { resultCheck = false; }
    return resultCheck;
}

function checkComputerCode() {
    var txt = $("#computerCode");
    var error = $("#computer_code_error");
    error.html("");
    txt.removeClass("is-valid").removeClass("is-invalid");
    var val = txt.val();
    var regex = /^(M)[0-9]{3}$/i
    if (!regex.test(val)) {
        error.html("Code must be Mxxx (x is number)");
        txt.addClass("is-invalid");
        return false;
    } else {
        txt.addClass("is-valid");
    }
    return true;
}