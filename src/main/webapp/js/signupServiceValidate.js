function submitForm() {
    let resultCheck = true;
    let resultCheckNumber = checkNumber();
    if (!resultCheckNumber) { resultCheck = false; }
    return resultCheck;
}

function checkNumber() {
    var txt = $("#number");
    var error = $("#number_error");
    error.html("");
    txt.removeClass("is-valid").removeClass("is-invalid");
    var val = txt.val();
    var regex = /^[1-9]{1,1}[0-9]*?$/i
    if (!regex.test(val)) {
        error.html("Number must be positive number");
        txt.addClass("is-invalid");
        return false;
    } else {
        txt.addClass("is-valid");
    }
    return true;
}