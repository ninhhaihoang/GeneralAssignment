function submitForm() {
    let resultCheck = true;
    let resultCheckServiceCode = checkServiceCode();
    if (!resultCheckServiceCode) { resultCheck = false; }
    let resultCheckPrice = checkPrice();
    if (!resultCheckPrice) { resultCheck = false; }
    return resultCheck;
}

function checkServiceCode() {
    var txt = $("#serviceCode");
    var error = $("#service_code_error");
    error.html("");
    txt.removeClass("is-valid").removeClass("is-invalid");
    var val = txt.val();
    var regex = /^(DV)[0-9]{5}$/i
    if (!regex.test(val)) {
        error.html("Code must be DVxxxxx (x is number)");
        txt.addClass("is-invalid");
        return false;
    } else {
        txt.addClass("is-valid");
    }
    return true;
}

function checkPrice() {
    var txt = $("#price");
    var error = $("#price_error");
    error.html("");
    txt.removeClass("is-valid").removeClass("is-invalid");
    var val = txt.val();
    var regex = /^[1-9]{1,1}[0-9]*?$/i
    if (!regex.test(val)) {
        error.html("Price must be positive number");
        txt.addClass("is-invalid");
        return false;
    } else {
        txt.addClass("is-valid");
    }
    return true;
}